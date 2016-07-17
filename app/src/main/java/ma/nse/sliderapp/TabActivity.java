package ma.nse.sliderapp;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import ma.nse.sliderapp.adapters.MyFragmentPagerManager;
import ma.nse.sliderapp.fragments.ChatFragment;
import ma.nse.sliderapp.fragments.FeedFragment;
import ma.nse.sliderapp.fragments.NearByFragment;

public class TabActivity extends AppCompatActivity {

    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab_view);

        // setting the toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // initializing the view pager and tab layout
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.tabs_pager);

        MyFragmentPagerManager pagerAdapter = new
                MyFragmentPagerManager(getSupportFragmentManager());
        pagerAdapter.addFragment(new FeedFragment(), "Feed");
        pagerAdapter.addFragment(new ChatFragment(), "Chat");
        pagerAdapter.addFragment(new NearByFragment(), "Nearby");

        viewPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(viewPager);
    }



}
