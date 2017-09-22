package cn.liusiqian.greendaodemo;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * Créé par liusiqian 17/9/22.
 */

public class GreenDaoApplication extends Application
{
    private static GreenDaoApplication instance;

    @Override
    public void onCreate()
    {
        super.onCreate();
        instance = this;
        Stetho.initializeWithDefaults(this);
    }

    public static GreenDaoApplication getInstance() {
        return instance;
    }
}
