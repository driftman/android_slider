package ma.nse.sliderapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ma.nse.sliderapp.R;
import ma.nse.sliderapp.adapters.MyRecyclerViewAdapter;
import ma.nse.sliderapp.beans.Placeholder;
import ma.nse.sliderapp.beans.PostDetail;
import ma.nse.sliderapp.beans.PostFeed;

/**
 * Created by admin on 14/07/2016.
 */
public class FeedFragment extends Fragment{

    public final static String TAG = "FeedFragment";

    protected RecyclerView recyclerViewFeed;
    protected List<Object> items;
    protected MyRecyclerViewAdapter myRecyclerViewAdapter;

    public FeedFragment() {
        super();
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initItems();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_feed, container, false);
        rootView.setTag(TAG);

        recyclerViewFeed = (RecyclerView)rootView.findViewById(R.id.recycler_view_feed);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        myRecyclerViewAdapter = new MyRecyclerViewAdapter(items);
        recyclerViewFeed.setLayoutManager(layoutManager);
        recyclerViewFeed.setAdapter(myRecyclerViewAdapter);
        recyclerViewFeed.setHasFixedSize(true);
        return rootView;
    }

    private void initItems() {
        items = new ArrayList<Object>();

        PostDetail postDetail = new PostDetail();
        postDetail.setTitle("POST DETAIL !");

        PostFeed postFeed = new PostFeed();
        postFeed.setTitle("Accident mortel à Meknès");
        PostFeed postFeed2 = new PostFeed();
        postFeed2.setTitle("Nouvelle Startup Meknassi");
        PostFeed postFeed3 = new PostFeed();
        postFeed3.setTitle("Corruption BALADIYA HAMRIA");

        Placeholder placeholder = new Placeholder();
        placeholder.setTitle("PLACE HOLDER !");

        items.add(postFeed);
        items.add(postFeed2);
        items.add(postFeed3);

    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
