package ma.nse.sliderapp.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ma.nse.sliderapp.adapters.MyRecyclerViewAdapter;
import ma.nse.sliderapp.R;
import ma.nse.sliderapp.beans.ChatPreview;

/**
 * Created by admin on 14/07/2016.
 */
public class ChatFragment extends Fragment {

    final List<ChatPreview> previews = new ArrayList<ChatPreview>();

    public ChatFragment() {
        super();
    }

    @Override
    public void onInflate(Context context, AttributeSet attrs, Bundle savedInstanceState) {
        super.onInflate(context, attrs, savedInstanceState);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_chat_list, container, false);
        return rootView;
    }

    private void dumpData() {
        this.previews.add(new ChatPreview("John DOE", "Hello it has been a while ...", "Stay in touch", null));
        this.previews.add(new ChatPreview("Jane DOE", "Wanna do some GoKart ?", "Having fun", null));
        this.previews.add(new ChatPreview("Mr. Dupont", "Are you still available for this evening ?", "Business shit", null));
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
