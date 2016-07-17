package ma.nse.sliderapp.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import ma.nse.sliderapp.beans.Placeholder;
import ma.nse.sliderapp.beans.Post;
import ma.nse.sliderapp.beans.PostDetail;
import ma.nse.sliderapp.beans.PostFeed;
import ma.nse.sliderapp.R;
import ma.nse.sliderapp.holders.PlaceholderHolder;
import ma.nse.sliderapp.holders.PostDetailHolder;
import ma.nse.sliderapp.holders.PostFeedHolder;

/**
 * Created by admin on 14/07/2016.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public  final static String TAG = "MyRecyclerViewAdapter";
    public final static Integer NONE = -1;
    public final static Integer POST_FEED = 0;
    public final static Integer POST_DETAIL = 1;
    private Context context;
    private List<Object> items;

    public MyRecyclerViewAdapter(List<Object> items) {
        Log.d(TAG, "Items length: " + String.valueOf(items.size()));
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) {
        Log.d(TAG, "position :" + String.valueOf(position));
        Object item = items.get(position);
        Integer viewType = getTypeFromItem(item);
        Log.d(TAG, "View type: " + String.valueOf(viewType));
        return viewType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        if(viewType != NONE) {
            if(viewType == POST_FEED) {
                view = inflater.inflate(R.layout.view_post_feed, parent, false);
                return new PostFeedHolder(view);
            } else if(viewType == POST_DETAIL) {
                view = inflater.inflate(R.layout.view_post_detail, parent, false);
                return new PostDetailHolder(view);
            }
        }
        view = inflater.inflate(R.layout.view_place_holder, parent, false);
        return new PlaceholderHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Object item = items.get(position);
        bindObjectToView(item, holder);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private Integer getTypeFromItem(Object item) {
        if(item instanceof Post) {
            if(item instanceof PostFeed) {
                return POST_FEED;
            } else if(item instanceof PostDetail) {
                return POST_DETAIL;
            }
        }
        return NONE;
    }

    private void bindObjectToView(Object item, RecyclerView.ViewHolder holder) {
        Integer objectType = getTypeFromItem(item);
        if(objectType == POST_DETAIL) {
            bindPostDetailToView(holder, item);
            Log.d(TAG, "bindPostDetailToView: " + String.valueOf(objectType));
        } else if(objectType == POST_FEED) {
            bindPostFeedToView(holder, item);
            Log.d(TAG, "bindPostFeedToView: " + String.valueOf(objectType));
        } else {
            bindPlaceholderToView(holder, item);
            Log.d(TAG, "bindPlaceholderToView: " + String.valueOf(objectType));
        }
    }

    private void bindPostDetailToView(RecyclerView.ViewHolder holder, Object item) {
        PostDetailHolder postDetailHolder = (PostDetailHolder)holder;
        PostDetail postDetail = (PostDetail)item;
        postDetailHolder.getTitle().setText(postDetail.getTitle());
    }

    private void bindPostFeedToView(RecyclerView.ViewHolder holder, Object item) {
        PostFeedHolder postFeedHolder = (PostFeedHolder)holder;
        PostFeed postFeed = (PostFeed)item;
        postFeedHolder.getTitle().setText(postFeed.getTitle());
        MyImagePagerAdapter imagePagerAdapter = new MyImagePagerAdapter(4);
        int sliderViews[] = new int[] {
                R.layout.slide_1,
                R.layout.slide_1,
                R.layout.slide_1

        };
        SliderPagerAdapter sliderPagerAdapter = new SliderPagerAdapter(context, sliderViews);
        ViewPager imagePager = postFeedHolder.getImageViewPager();
        if(imagePager == null) {
            Log.d(TAG, "View pager is null !");
        } else {
            imagePager.setAdapter(sliderPagerAdapter);
        }
    }

    private void bindPlaceholderToView(RecyclerView.ViewHolder holder, Object item) {
        PlaceholderHolder placeholderHolder = (PlaceholderHolder)holder;
        Placeholder placeholder = (Placeholder)item;
        placeholderHolder.getTitle().setText(placeholder.getTitle());
    }

}
