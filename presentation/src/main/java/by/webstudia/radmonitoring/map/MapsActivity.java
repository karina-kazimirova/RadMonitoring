package by.webstudia.radmonitoring.map;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.MenuItem;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.ui.IconGenerator;
import java.util.ArrayList;
import java.util.List;
import by.webstudia.radmonitoring.R;
import by.webstudia.radmonitoring.domain.entity.CityModel;
import by.webstudia.radmonitoring.domain.interaction.GetCityListUseCase;
import io.reactivex.observers.DisposableObserver;
import static android.graphics.Typeface.BOLD;
import static android.graphics.Typeface.ITALIC;
import static android.text.Spanned.SPAN_EXCLUSIVE_EXCLUSIVE;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static final String TAG = MapsActivity.class.getSimpleName();


    private LatLngBounds BELARUS = new LatLngBounds(
            new LatLng(53.402130, 23.702853), new LatLng(53.475915, 32.790424));

    private GetCityListUseCase useCase = new GetCityListUseCase();
    List<CityModel> list = new ArrayList<>();
    Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);


        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_hyb:
                                mMap.setMapType(GoogleMap.MAP_TYPE_TERRAIN);

                                break;
                            case R.id.action_land:
                                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);

                                break;
                            case R.id.action_norm:
                                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

                                break;
                        }
                        return false;
                    }
                });


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

           try {
            // Customise the styling of the base map using a JSON object defined
            // in a raw resource file.
            boolean success = googleMap.setMapStyle(
                    MapStyleOptions.loadRawResourceStyle(
                            this, R.raw.style_json));

            if (!success) {
                Log.e(TAG, "Style parsing failed.");
            }
        } catch (Resources.NotFoundException e) {
            Log.e(TAG, "Can't find style. Error: ", e);
        }




        final  IconGenerator iconFactory= new IconGenerator(this);

        iconFactory.setRotation(0);
        iconFactory.setContentRotation(90);

        useCase.execute(null, new DisposableObserver<List<CityModel>>() {

            @Override
            public void onNext(List<CityModel> cityModels) {
                list.addAll(cityModels);

                for(int i=0; i<list.size(); i++){
                    iconFactory.setStyle(indexToColor(list.get(i).getIndexMZ()));
                    addIcon(iconFactory, makeCharSequence(list.get(i).getName(), list.get(i).getIndex()),
                            new LatLng(Double.parseDouble(list.get(i).getLat()), Double.parseDouble(list.get(i).getLng())));

                }
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

       /* mMap.addPolyline(new PolylineOptions().geodesic(true)
                .add(new LatLng(-33.866, 151.195))
                .add(new LatLng(-18.142, 178.431))
                .add(new LatLng(21.291, -157.821))
                .add(new LatLng(37.423, -122.091))
        );*/


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(BELARUS.getCenter(), 5));
    }



    private void addIcon(IconGenerator iconFactory, CharSequence text, LatLng position) {
        MarkerOptions markerOptions = new MarkerOptions().
                icon(BitmapDescriptorFactory.fromBitmap(iconFactory.makeIcon(text))).
                position(position).
                anchor(iconFactory.getAnchorU(), iconFactory.getAnchorV());

        mMap.addMarker(markerOptions);
    }

    private CharSequence makeCharSequence(String prefix, String suffix) {
        String sequence = prefix +" " + suffix;
        SpannableStringBuilder ssb = new SpannableStringBuilder(sequence);
        ssb.setSpan(new StyleSpan(ITALIC), 0, prefix.length(), SPAN_EXCLUSIVE_EXCLUSIVE);
        ssb.setSpan(new StyleSpan(BOLD), prefix.length(), sequence.length(), SPAN_EXCLUSIVE_EXCLUSIVE);
        return ssb;
    }

    private static int indexToColor(double index) {
        if (index < 0.2) {
            return IconGenerator.STYLE_GREEN;
        } else if (index < 0.5) {
            return IconGenerator.STYLE_ORANGE;
        } else {
            return IconGenerator.STYLE_RED;
        }
    }




}
