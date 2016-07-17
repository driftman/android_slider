package ma.nse.sliderapp.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.gms.maps.model.LatLng;

import ma.nse.sliderapp.R;

/**
 * Created by admin on 15/07/2016.
 */
public class NearByFragment extends Fragment {
    public static String TAG = "NearbyFragment";

    private Button button1;
    private Button button2;
    private LinearLayout groupButtons;
    private View view;



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated !");
        Fragment fragment = getFragmentById(R.id.map_fragment);
        if(fragment == null) {
            Log.d(TAG, "onViewCreated => mapFragment null");
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            MyGoogleMapFragment myGoogleMapFragment =
                    MyGoogleMapFragment.newInstance(new LatLng(33, 2), new View[]{null});
            transaction.add(R.id.map_fragment, myGoogleMapFragment);
            transaction.commit();
            getChildFragmentManager().executePendingTransactions();
        }
        else {
            Log.d(TAG, "onViewCreated => mapFragment not null");
        }
        Log.d(TAG, "onViewCreated done!");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume !");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        if(view == null) {
            Log.d(TAG, "found that the view is null");
            Log.d(TAG, "checking if map fragment bound ...");
            Log.d(TAG, "=> " + getFragmentById(R.id.map_fragment) == null ? "false" : "true");
            view = inflater.inflate(R.layout.activity_nearby, container, false);
        }
        return view;
    }

    @Override
    public void onDetach() {
        Log.d(TAG, "onDetach");
        super.onDetach();
    }

    @Override
    public void onDestroyView() {
        Log.d(TAG, "onDestroyView");
        super.onDestroyView();
        Fragment fragment = getFragmentById(R.id.map_fragment);
        try {
            if(fragment != null) {
                Log.d(TAG, "onDestroyView => mapFragment not null");
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.remove(fragment);
                transaction.commitAllowingStateLoss();
            } else {
                Log.d(TAG, "onDestroyView => mapFragment null");
            }
        } catch(Exception e) {
            Log.d(TAG, e.getMessage());
        }
        view = null;
        Log.d(TAG, "onDestroyView,  view == null");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy()");
        super.onDestroy();
    }

    @Override
    public void onStop() {
        Log.d(TAG, "onStop()");
        super.onStop();
    }

    private Fragment getFragmentById(int id) {
        FragmentManager fragmentManager = getChildFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(id);
        if(fragment != null) {
            return fragment;
        }
        return null;
    }
}
