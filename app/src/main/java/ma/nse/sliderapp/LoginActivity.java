package ma.nse.sliderapp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.ContentResolver;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    // Firebase reference
    FirebaseAuth mFirebaseAuth;
    FirebaseAuth.AuthStateListener mFirebaseAuthStateListener;


    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private ProgressBar mProgressView;
    private Button mLoginFormView;
    private Button mLoginFormView2;
    private TextView mLoginStatus;


    @Override
    protected void onStart() {
        super.onStart();
        mFirebaseAuth.addAuthStateListener(mFirebaseAuthStateListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(mFirebaseAuthStateListener != null) {
            mFirebaseAuth.removeAuthStateListener(mFirebaseAuthStateListener);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Getting the FirebaseAuth shared ref
        mFirebaseAuth = FirebaseAuth.getInstance();
        mFirebaseAuthStateListener = new FirebaseAuth.AuthStateListener() {

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user == null) {
                    Toast.makeText(getApplicationContext(),
                            "You have been disconnected", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Successfully connected UID: " + user.getEmail()
                            , Toast.LENGTH_SHORT).show();
                }
            }
        };

        // Linking the vie to their references
        mEmailView = (EditText)findViewById(R.id.login_email);
        mPasswordView = (EditText)findViewById(R.id.login_password);
        mLoginFormView = (Button)findViewById(R.id.login_button);
        mLoginFormView2 = (Button)findViewById(R.id.login_button2);
        mProgressView = (ProgressBar)findViewById(R.id.login_progress);
        mLoginStatus = (TextView)findViewById(R.id.login_status);

        mLoginFormView2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressView.setVisibility(View.VISIBLE);
                final String email = mEmailView.getText().toString().trim();
                final String password = mPasswordView.getText().toString().trim();
                if(email.length() <= 0 || password.length() <= 0) {
                    Toast.makeText(getApplicationContext(),
                            "Fill in the right data", Toast.LENGTH_SHORT).show();
                    mProgressView.setVisibility(View.GONE);
                } else {
                    mFirebaseAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    mProgressView.setVisibility(View.GONE);
                                    if(task.isSuccessful()) {
                                        mLoginStatus.setText("Successfully connected !");
                                    } else {
                                        mLoginStatus
                                                .setText("Error while sign in to " +
                                                        "Firebase (Username : " + email + ", Password: " +
                                                        password + " : \n" +
                                                        task.getException().getMessage());
                                    }
                                }
                            });
                }
            }
        });

        mLoginFormView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressView.setVisibility(View.VISIBLE);
                final String email = mEmailView.getText().toString().trim();
                final String password = mPasswordView.getText().toString().trim();
                if(email.length() <= 0 || password.length() <= 0) {
                    Toast.makeText(getApplicationContext(),
                            "Fill in the right data", Toast.LENGTH_SHORT).show();
                    mProgressView.setVisibility(View.GONE);
                } else {
                    mFirebaseAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    mProgressView.setVisibility(View.GONE);
                                    if(task.isSuccessful()) {
                                        mLoginStatus.setText("Successfully connected !");
                                    } else {
                                        mLoginStatus
                                                .setText("Error while sign in to " +
                                                        "Firebase (Username : " + email + ", Password: " +
                                                        password + " : \n" +
                                                        task.getException().getMessage());
                                    }
                                }
                            });
                }
            }
        });

    }





}

