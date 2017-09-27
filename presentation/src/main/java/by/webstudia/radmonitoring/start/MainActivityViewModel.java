package by.webstudia.radmonitoring.start;

import android.app.Activity;
import android.content.Context;
import android.databinding.ObservableDouble;
import android.databinding.ObservableField;
import android.util.Log;

import by.webstudia.radmonitoring.base.BaseViewModel;
import by.webstudia.radmonitoring.domain.entity.CityModel;
import by.webstudia.radmonitoring.domain.entity.CityId;
import by.webstudia.radmonitoring.domain.interaction.CityUseCase;

import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;


/**
 * Created by Sve on 14.08.2017.
 */

public class MainActivityViewModel implements BaseViewModel {


    public Activity activity;

    public MainActivityViewModel(Activity activity) {
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


}
