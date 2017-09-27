package by.webstudia.radmonitoring.data.net;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import by.webstudia.radmonitoring.data.entity.CityData;
import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmModel;
import io.realm.RealmResults;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sve on 16.08.2017.
 */

public class RestService {


    // Singletone
    private static final RestService instance = new RestService();

    private RestApi restApi;
    private Realm realm;

    private RestService() {
        init();
    }
    public static RestService getInstance() {
        return instance;
    }


    private void init() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.backendless.com/6BB5100A-5553-D5DF-FF32-55F432BA9900/E946DC08-504F-F5D3-FF78-205E27946000/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient).build();

        restApi = retrofit.create(RestApi.class);
        //realm = Realm.getDefaultInstance();

       // realm.beginTransaction();
       // realm.insertOrUpdate((Collection<? extends RealmModel>) restApi.getCities());
       // realm.commitTransaction();

    }



    public Observable<List<CityData>> getCities() {
        return restApi.getCities();
    }
    public Observable<CityData> getCity(String name) {
        return restApi.getCity(name);
    }





}