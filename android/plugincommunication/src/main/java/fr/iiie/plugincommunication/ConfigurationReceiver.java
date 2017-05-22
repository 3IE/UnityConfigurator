package fr.iiie.plugincommunication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by arnaud.lemettre on 10/02/2017.
 *
 */
public class ConfigurationReceiver extends BroadcastReceiver {
    private static ConfigurationReceiver instance;
    public static String text = "";

    @Override
    public void onReceive(Context context, Intent intent) {
        String sentIntent = intent.getStringExtra(Intent.EXTRA_TEXT);

        if (sentIntent != null){
            text = sentIntent;

        }
    }

    public static void createInstance(){
        if (instance == null){
            instance = new ConfigurationReceiver();
        }
    }
}

