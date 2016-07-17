package ma.nse.sliderapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by admin on 14/07/2016.
 */
public class MyGoogleMapFragment extends SupportMapFragment {

    public static String TAG = "MyGoogleMapFragment";
    private View view;
    private LatLng position;
    private GoogleMap googleMap;
    // i used in some ux purposes
    // let some views invisible
    // until the map is ready and then
    // make them visible to the end user
    private View views[];

    public static MyGoogleMapFragment newInstance(LatLng position, View views[]) {
        MyGoogleMapFragment myGoogleMapFragment = new MyGoogleMapFragment();
        myGoogleMapFragment.position = position;
        myGoogleMapFragment.views = views;
        return myGoogleMapFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(view == null) {
            view = super.onCreateView(inflater, container, savedInstanceState);
            if(googleMap == null) {
                initMap();
            }
        }
        return view;
    }

    public void initMap() {
        getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap map) {
                Log.d(TAG, "MAP READY");
                Log.d(TAG, "TRYING TO MAKE THE BUTTON GROUP VISIBLE");
                for (View view : views) {
                    if(view != null) {
                        view.setVisibility(View.VISIBLE);
                    }
                }
                googleMap = map;
                UiSettings settings = googleMap.getUiSettings();
                settings.setAllGesturesEnabled(true);
                settings.setMyLocationButtonEnabled(true);
                settings.setZoomControlsEnabled(true);
                settings.setMapToolbarEnabled(true);
                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(position, 16);
                googleMap.moveCamera(cameraUpdate);
            }
        });
    }

    public MyGoogleMapFragment() {
        super();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(TAG, "onViewCreated() !");
        String verdict = view == null ? "null" : "not null";
        Log.d(TAG, "view is : " + verdict);
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }



}
