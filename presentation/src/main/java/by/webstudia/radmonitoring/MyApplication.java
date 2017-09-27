package by.webstudia.radmonitoring;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

import by.webstudia.radmonitoring.base.di.AppComponent;
import by.webstudia.radmonitoring.base.di.AppModule;
import by.webstudia.radmonitoring.base.di.DaggerAppComponent;
import io.realm.Realm;

/**
 * Created by Sve on 31.07.2017.
 */

public class MyApplication extends Application {

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
        Realm.init(this);

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }
}
