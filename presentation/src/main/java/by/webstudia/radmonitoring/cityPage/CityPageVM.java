package by.webstudia.radmonitoring.cityPage;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import by.webstudia.radmonitoring.base.BaseViewModel;
import by.webstudia.radmonitoring.cityList.CityListActivity;
import by.webstudia.radmonitoring.map.MapsActivity;

public class CityPageVM implements BaseViewModel {

    Activity activity;
    public ObservableField<String> name = new ObservableField<>("Минск");
    public ObservableField<String> index = new ObservableField<>("0.11");
    public ObservableInt seekbarValue = new ObservableInt();


    public CityPageVM(Activity activity) {
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


    public void onSuperButtonClick(){

        Intent intent = new Intent(activity.getApplicationContext(), CityListActivity.class);
        activity.startActivity(intent);
    }

    public void onMapButtonClick(){

        Intent intent = new Intent(activity.getApplicationContext(), MapsActivity.class);
        activity.startActivity(intent);
    }
}
