package by.webstudia.radmonitoring.cityList;

import android.app.Activity;
import android.databinding.ObservableField;
import android.util.Log;
import java.util.List;

import javax.inject.Inject;

import by.webstudia.radmonitoring.MyApplication;
import by.webstudia.radmonitoring.base.BaseViewModel;
import by.webstudia.radmonitoring.domain.entity.CityModel;
import by.webstudia.radmonitoring.domain.interaction.GetCityListUseCase;
import io.reactivex.observers.DisposableObserver;


public class CityListVM implements BaseViewModel {

    public enum STATE {PROGRESS, DATA}
    public ObservableField<STATE> state = new ObservableField<>(STATE.PROGRESS);
    public CityAdapter adapter = new CityAdapter();



    public Activity activity;

    public CityListVM(Activity activity) {
        this.activity = activity;
    }

    private GetCityListUseCase useCase = new GetCityListUseCase();



    @Override
    public void init() {
    }

    @Override
    public void release() {
    }

    @Override
    public void resume() {

        useCase.execute(null, new DisposableObserver<List<CityModel>>(){

            @Override
            public void onNext(List<CityModel> cityModels) {
                adapter.setItems(cityModels);
                state.set(STATE.DATA);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });

    }

    @Override
    public void pause() {
        useCase.dispose();

    }



}
