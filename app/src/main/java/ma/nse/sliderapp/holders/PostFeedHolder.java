package ma.nse.sliderapp.holders;

import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ma.nse.sliderapp.R;

/**
 * Created by admin on 16/07/2016.
 */
public class PostFeedHolder extends RecyclerView.ViewHolder {

    private ViewPager imageViewPager;
    private ImageView backgroundImage;
    private TextView title;
    private TextView description;
    private TextView negativeReactions;
    private TextView positiveReactions;

    public PostFeedHolder(View itemView) {
        super(itemView);
//        backgroundImage = (ImageView)itemView.findViewById(R.id.post_background_image);
        title = (TextView)itemView.findViewById(R.id.view_feed_title);
        imageViewPager = (ViewPager)itemView.findViewById(R.id.view_feed_image_pager);
//        description = (TextView)itemView.findViewById(R.id.post_description);
//        negativeReactions = (TextView)itemView.findViewById(R.id.post_negative_reactions);
//        positiveReactions = (TextView)itemView.findViewById(R.id.post_negative_reactions);
    }

    public ViewPager getImageViewPager() {
        return imageViewPager;
    }

    public void setImageViewPager(ViewPager imageViewPager) {
        this.imageViewPager = imageViewPager;
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public ImageView getBackgroundImage() {
        return backgroundImage;
    }

    public void setBackgroundImage(ImageView backgroundImage) {
        this.backgroundImage = backgroundImage;
    }

    public TextView getPositiveReactions() {
        return positiveReactions;
    }

    public void setPositiveReactions(TextView positiveReactions) {
        this.positiveReactions = positiveReactions;
    }

    public TextView getNegativeReactions() {
        return negativeReactions;
    }

    public void setNegativeReactions(TextView negativeReactions) {
        this.negativeReactions = negativeReactions;
    }

    public TextView getDescription() {
        return description;
    }

    public void setDescription(TextView description) {
        this.description = description;
    }
}
