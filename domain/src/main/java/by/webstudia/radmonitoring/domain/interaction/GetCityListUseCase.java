package by.webstudia.radmonitoring.domain.interaction;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import by.webstudia.radmonitoring.data.entity.CityData;
import by.webstudia.radmonitoring.data.net.RestService;
import by.webstudia.radmonitoring.domain.entity.CityModel;
import by.webstudia.radmonitoring.domain.interaction.base.UseCase;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;
import io.realm.Realm;
import io.realm.RealmResults;


/**
 * Created by Sve on 21.08.2017.
 */
public class GetCityListUseCase extends UseCase<Void, List<CityModel>> {
 private Realm realm;


    @Override
    protected Observable<List<CityModel>> buildUseCase(Void v) {

       //RealmResults<CityData> cityDataRealmResults = realm.where(CityData.class).findAll();
       // CityData cityData = cityDataRealmResults.get(0);
       //Log.d("SSS", String.valueOf(cityData));


        return RestService.getInstance().getCities()
                .map(new Function<List<CityData>, List<CityModel>>() {
            @Override
            public List<CityModel> apply(@NonNull List<CityData> cities) throws Exception {
                List<CityModel> list = new ArrayList<>();
                for(CityData city: cities) {
                    list.add(convert(city));
                }


                return list;
            }
        });
    }

    private CityModel convert(CityData dataModel) {
        CityModel cityModel = new CityModel();
        cityModel.setName(dataModel.getName());
        cityModel.setIndexMZ(dataModel.getIndexMZ());
        cityModel.setIndex(dataModel.getIndex());
        cityModel.setLat(dataModel.getLat());
        cityModel.setLng(dataModel.getLng());


        return cityModel;
    }


}
