package by.webstudia.radmonitoring.start;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import by.webstudia.radmonitoring.start.MainActivity;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by Sve on 12.08.2017.
 */

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
