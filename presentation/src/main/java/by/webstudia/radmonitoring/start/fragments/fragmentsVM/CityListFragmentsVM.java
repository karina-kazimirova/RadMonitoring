package by.webstudia.radmonitoring.start.fragments.fragmentsVM;

import android.app.Activity;
import android.content.Intent;
import android.databinding.ObservableDouble;
import android.databinding.ObservableField;
import by.webstudia.radmonitoring.base.BaseViewModel;
import by.webstudia.radmonitoring.info.InfoActivity;


public class CityListFragmentsVM implements BaseViewModel {


    Activity activity;

    public CityListFragmentsVM(Activity activity) {
        this.activity = activity;
    }
    public ObservableField<String> seekbarValue = new ObservableField<>("0.10");
    public ObservableField<String> result = new ObservableField<>();
    public ObservableField<String> name = new ObservableField<>("JJJJ");
    public ObservableDouble indexMZ = new ObservableDouble();


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

        Intent intent = new Intent(activity.getApplicationContext(), InfoActivity.class);
        activity.startActivity(intent);
    }


}
