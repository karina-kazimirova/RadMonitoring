package by.webstudia.radmonitoring.start.fragments.fragmentsVM;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;

import by.webstudia.radmonitoring.base.BaseViewModel;
import by.webstudia.radmonitoring.cityList.CityListActivity;
import by.webstudia.radmonitoring.cityPage.CityPageActivity;
import by.webstudia.radmonitoring.map.MapsActivity;

/**
 * Created by Sve on 14.09.2017.
 */

public class MapCityFragmentsVM implements BaseViewModel {


    Activity activity;

    public MapCityFragmentsVM(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void init() {

    }

    @Override
    public void release() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void pause() {

    }

    public void onMapButtonClick(){
        Log.e("KKK", "Click");

        // переходим на активити
        Intent intent = new Intent(activity.getApplicationContext(), MapsActivity.class);
        activity.startActivity(intent);
    }



}
