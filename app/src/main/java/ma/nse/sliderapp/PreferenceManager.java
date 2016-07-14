package ma.nse.sliderapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by admin on 13/07/2016.
 */
public class PreferenceManager {

    public final static String PREF_NAME = "SLIDER_GOOD_TIME";
    public final static String APP_FIRST_TIME_LAUNCHED = "APP_FIRST_TIME_LAUNCHED";

    private final int PREF_MODE = 0;

    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public PreferenceManager(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREF_NAME, PREF_MODE);
        editor = sharedPreferences.edit();
    }

    private void setFirstTimeLaunch(Boolean firstTimeLaunch) {
        editor.putBoolean(APP_FIRST_TIME_LAUNCHED, firstTimeLaunch);
        editor.commit();
    }

    private Boolean isFirstTimeLaunch() {
        return sharedPreferences.getBoolean(APP_FIRST_TIME_LAUNCHED, true);
    }

}
