package ma.nse.sliderapp;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import ma.nse.sliderapp.adapters.SliderPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private final String TAG = "MAIN_ACTIVITY";
    int currentPosition;
    int sliderViews[];
    int activeDotColors[];
    int inactiveDotColors[];
    PreferenceManager preferenceManager;
    ViewPager viewPager;
    Button btnNext;
    Button btnSkip;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main);
        // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        if(Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        changeStatusBarColor();

        currentPosition = 0;

        sliderViews = new int[] {
                R.layout.slide_1,
                R.layout.slide_2,
                R.layout.slide_3,
                R.layout.slide_4

        };

        // active and non active dot colors
        inactiveDotColors = getResources().getIntArray(R.array.array_dot_inactive);
        activeDotColors = getResources().getIntArray(R.array.array_dot_active);

        btnNext = (Button)findViewById(R.id.btn_next);
        btnSkip = (Button)findViewById(R.id.btn_skip);
        linearLayout = (LinearLayout)findViewById(R.id.slider_dots);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NearbyActivity.class);
                startActivity(intent);
            }
        });

        preferenceManager = new PreferenceManager(this);
        viewPager = (ViewPager)findViewById(R.id.slider);
        SliderPagerAdapter sliderPagerAdapter = new SliderPagerAdapter(this, sliderViews);
        viewPager.setAdapter(sliderPagerAdapter);
        updateDots();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPosition = position;
                // check if last slide
                // next will be got it
                if(position == sliderViews.length - 1) {
                    btnNext.setText(getResources().getText(R.string.start));
                    btnSkip.setVisibility(View.INVISIBLE);
                } else {
                    btnSkip.setVisibility(View.VISIBLE);
                    btnNext.setText(getResources().getText(R.string.next));
                }
                updateDots();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }

    private void updateDots() {
        linearLayout.removeAllViews();
        for(int i = 0 ; i < sliderViews.length ; i++) {
            TextView textView = new TextView(this);
            textView.setText(Html.fromHtml("&#8226;"));
            textView.setTextSize(30);
            if(i == currentPosition) {
                textView.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            } else {
                textView.setTextColor(getResources().getColor(R.color.dot_inactive));
            }
            linearLayout.addView(textView);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
