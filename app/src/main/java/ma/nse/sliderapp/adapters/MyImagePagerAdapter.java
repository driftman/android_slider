package ma.nse.sliderapp.adapters;

import android.graphics.BitmapFactory;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.zip.Inflater;

import ma.nse.sliderapp.R;

/**
 * Created by admin on 16/07/2016.
 */
public class MyImagePagerAdapter extends PagerAdapter{

    private Integer size;

    public MyImagePagerAdapter(Integer size) {
        this.size = size;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imageView = new ImageView(container.getContext());
        TextView textView = new TextView(container.getContext());
        LinearLayout.LayoutParams params = new LinearLayout.
                LayoutParams(300,
                ViewGroup.LayoutParams.MATCH_PARENT);
        params.setMargins(0, 0, 0, 0);
        imageView.setLayoutParams(params);
        imageView.setImageResource(R.drawable.ic_friendship);

        textView.setText("TEXT");
        textView.setTextSize(50);
        container.addView(textView);
        return container;
    }

    @Override
    public int getCount() {
        return size;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == (View)object;
    }
}
