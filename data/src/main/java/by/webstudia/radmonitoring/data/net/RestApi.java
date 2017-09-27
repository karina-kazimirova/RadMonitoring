package by.webstudia.radmonitoring.data.net;


import java.util.List;
import by.webstudia.radmonitoring.data.entity.CityData;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RestApi {

    @GET("data/city")
    Observable<List<CityData>> getCities();


    @GET("data/city/{name}")
    Observable<CityData> getCity(@Path("name") String name);

}
