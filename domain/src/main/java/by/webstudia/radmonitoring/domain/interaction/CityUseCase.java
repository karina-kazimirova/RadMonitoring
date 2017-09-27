package by.webstudia.radmonitoring.domain.interaction;

import java.util.List;

import by.webstudia.radmonitoring.data.entity.CityData;
import by.webstudia.radmonitoring.data.net.RestService;
import by.webstudia.radmonitoring.domain.entity.CityModel;
import by.webstudia.radmonitoring.domain.entity.CityId;
import by.webstudia.radmonitoring.domain.interaction.base.UseCase;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * Created by Sve on 14.08.2017.
 */

public class CityUseCase extends UseCase<String, CityModel> {
    @Override
    protected Observable<CityModel> buildUseCase(final String s) {

        return RestService.getInstance().getCities()
                .map(new Function<List<CityData>, CityModel>() {
                    @Override
                    public CityModel apply(@NonNull List<CityData> cityData) throws Exception {

                        CityData city=null;

                        for(int i = 0; i<cityData.size(); i++){
                            if (cityData.get(i).getName().equals(s)) {
                                city = cityData.get(i);
                            }
                        }

                        CityModel cityModel = new CityModel();
                        cityModel.setName(city.getName());
                        cityModel.setIndex(city.getIndex());
                        cityModel.setIndexMZ(city.getIndexMZ());
                        cityModel.setLat(city.getLat());
                        cityModel.setLng(city.getLng());


                        return cityModel;
                    }
                });
    }


    }

