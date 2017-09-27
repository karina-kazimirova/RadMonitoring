package by.webstudia.radmonitoring.start;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.ViewPager;
import by.webstudia.radmonitoring.R;
import by.webstudia.radmonitoring.base.BaseFragmentActivity;
import by.webstudia.radmonitoring.databinding.ActivityMainsBinding;



public class MainActivity extends BaseFragmentActivity {
    private LocationManager locationManager;
    SharedPreferences preferences;
    private static final String SHARED_PREF_NAME = "PREF_NAME";
    private static final String KEY_LATITUDE = "KEY_LATITUDE";
    private static final String KEY_LONGITUDE = "KEY_LONGTITUDE";
    String longit;
    String latit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        // создаем модель для этой активити
        MainActivityViewModel viewModel = new MainActivityViewModel(this);
        this.viewModel = viewModel;

        ActivityMainsBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mains);
        binding.setViewModel(viewModel);
        setContentView(R.layout.activity_mains);
        super.onCreate(savedInstanceState);


        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(new PagerAdapter(this, getSupportFragmentManager()));


        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(pager);

        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(1).setIcon(R.drawable.icon_i);
            tabLayout.getTabAt(0).setIcon(R.drawable.icon_map);
            tabLayout.getTabAt(2).setIcon(R.drawable.icon_flag);
            tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        }


        preferences = getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000 * 10, 10, locationListener);
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000 * 10, 10, locationListener);


   }

    @Override
    protected void onResume() {
        super.onResume();
        longit = preferences.getString(KEY_LONGITUDE, null);
        latit = preferences.getString(KEY_LATITUDE, null);
    }

    @Override
    protected void onPause() {
        super.onPause();
        locationManager.removeUpdates(locationListener);
    }

    private LocationListener locationListener = new LocationListener() {

        @Override
        public void onLocationChanged(Location location) {

            preferences.edit()
                    .putString(KEY_LATITUDE, String.valueOf(location.getLatitude()))
                    .putString(KEY_LONGITUDE, String.valueOf(location.getLongitude()))
                    .apply();
        }

        @Override
        public void onProviderDisabled(String provider) {

        }

        @Override
        public void onProviderEnabled(String provider) {

        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }
    };









}






