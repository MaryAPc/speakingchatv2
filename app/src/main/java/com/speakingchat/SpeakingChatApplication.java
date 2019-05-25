package com.speakingchat;

import android.app.Application;

import com.speakingchat.di.AppComponent;
import com.speakingchat.di.DaggerAppComponent;
import com.speakingchat.di.module.AppContextModule;
import com.speakingchat.di.module.PreferencesModule;

public class SpeakingChatApplication extends Application {

    private static AppComponent sAppComponent;
    public static SpeakingChatApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        //Fabric.with(this, new Crashlytics());
        sInstance = this;

        sAppComponent = DaggerAppComponent.builder()
                .appContextModule(new AppContextModule(this))
                .preferencesModule(new PreferencesModule())
                .build();
    }

    public static SpeakingChatApplication getInstance() {
        return sInstance;
    }

    public static AppComponent getAppComponent() {
        return sAppComponent;
    }
}