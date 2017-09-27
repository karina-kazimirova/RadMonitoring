package by.webstudia.radmonitoring.base.di;


import android.content.Context;

import com.google.gson.Gson;

import javax.inject.Singleton;

import by.webstudia.radmonitoring.domain.interaction.GetCityListUseCase;
import dagger.Module;
import dagger.Provides;


/**
 * Created by Sve on 11.09.2017.
 */
@Module
public class AppModule {

    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    public Context provideContext() {
        return context;
    }



}
