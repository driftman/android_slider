package ma.nse.sliderapp.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * Created by admin on 13/07/2016.
 */
public class SliderPagerAdapter extends PagerAdapter {

    private Context context;
    private int sliderViews[];

    public SliderPagerAdapter(Context context, int[] sliderViews) {
        this.context = context;
        this.sliderViews = sliderViews;
    }
    @Override
    public int getCount() {
        return sliderViews.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View)object;
        container.removeView(view);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = (LayoutInflater)context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(sliderViews[position], container, false);
        container.addView(view);
        return view;
    }
}
