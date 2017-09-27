package by.webstudia.radmonitoring.start.fragments.fragmentsVM;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.databinding.ObservableField;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import by.webstudia.radmonitoring.base.BaseViewModel;
import by.webstudia.radmonitoring.cityPage.CityPageActivity;
import by.webstudia.radmonitoring.domain.entity.CityModel;
import by.webstudia.radmonitoring.domain.interaction.CityUseCase;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;


public class CityFragmentsVM implements BaseViewModel {


    Activity activity;
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> indexMZ = new ObservableField<>();

    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);

    private String cityName="";
    private String index = "";

    SharedPreferences preferences;
    private static final String SHARED_PREF_CITY_NAME = "PREF_CITY_NAME";
    private static final String KEY_CITYNAME = "KEY_CITYNAME";

    private CityUseCase useCase = new CityUseCase();

    public String getCityName() {
        return cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public CityFragmentsVM(Activity activity) {
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
        preferences = activity.getSharedPreferences(SHARED_PREF_CITY_NAME, Context.MODE_PRIVATE);
        String city = preferences.getString(KEY_CITYNAME, null);
        if(city !=null){
            changeCity(city);

        }else{
            changeCity("Минск");
        }

    }

    @Override
    public void pause() {
        preferences.edit()
                .putString(KEY_CITYNAME, cityName)
                .apply();

    }

    public void onSuperButtonClick(){

        Intent intent = new Intent(activity.getApplicationContext(), CityPageActivity.class);

        intent.putExtra("itemName", cityName);
        intent.putExtra("itemMz", index);
        activity.startActivity(intent);
    }

    public void changeCity(String cityNames){
        useCase.execute(cityNames, new DisposableObserver<CityModel>() {
            @Override
            public void onNext(@NonNull CityModel cityModel) {
                name.set(cityModel.getName());
                indexMZ.set(cityModel.getIndex());
                index = cityModel.getIndex();
                cityName = cityModel.getName();
                state.set(STATE.DATA);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.e("AAA", "error = ", e);

            }


            @Override
            public void onComplete() {

            }
        });
    }

    public void onClick(){

        final String[] cities ={"Бобруйск", "Брагин", "Браслав", "Брест", "Гомель", "Гродно", "Минск",  "Могилев", "Полоцк", "Слуцк"};

        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Выберите город из списка");
        builder.setItems(cities, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {

                cityName = cities[item];
                changeCity(cities[item]);


            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }





}
