package by.webstudia.radmonitoring.domain.interaction;

import by.webstudia.radmonitoring.data.entity.CityData;
import by.webstudia.radmonitoring.data.net.RestService;
import by.webstudia.radmonitoring.domain.entity.CityModel;
import by.webstudia.radmonitoring.domain.interaction.base.UseCase;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

public class GetCityUseCase extends UseCase<String, CityModel>{


        @Override
        protected Observable<CityModel> buildUseCase(final String s) {
            return RestService.getInstance().getCity(s)

                    .map(new Function<CityData, CityModel>() {
                        @Override
                        public CityModel apply(@NonNull CityData citylist) throws Exception {

                            CityData cityData = new CityData();

                            CityModel cityModel = new CityModel();
                            cityModel.setName(cityData.getName());
                            cityModel.setIndexMZ(cityData.getIndexMZ());
                            cityModel.setIndex(cityData.getIndex());
                            cityModel.setLat(cityData.getLat());
                            cityModel.setLng(cityData.getLng());

                            return cityModel;
                        }
                    });
        }



    }

