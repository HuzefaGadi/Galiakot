package com.huzefagadi.rashida.galiakot;

/**
 * Created by Rashida on 15/06/15.
 */
import android.content.Intent;
import android.os.Parcelable;

import com.parse.Parse;
import com.parse.ParseInstallation;

public class Application extends android.app.Application {

    public Application() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize the Parse SDK.
        Parse.initialize(this, "gbnERpoeUAXYMq3087T7esF9rO5h6MUtuxBZQHm7", "gjWuDy3elSnBMEXOmIY0JCP00wht3Ugc76B6XbFL");
        ParseInstallation.getCurrentInstallation().saveInBackground();
        // Specify an Activity to handle all pushes by default.
       // PushService.setDefaultPushCallback(this, MainActivity.class);
        createShortCut();
    }

    public void createShortCut(){
        Intent shortcutintent = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        shortcutintent.putExtra("duplicate", false);
        shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getString(R.string.app_name));
        Parcelable icon = Intent.ShortcutIconResource.fromContext(getApplicationContext(), R.mipmap.ic_launcher);
        shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);
        shortcutintent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(getApplicationContext(), MainActivity.class));
        sendBroadcast(shortcutintent);
    }
}
