package by.webstudia.radmonitoring.data.entity;

import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.Required;

/**
 * Created by Sve on 14.08.2017.
 */

public class CityData extends RealmObject implements DataModel {

    @Required
    @SerializedName("name")
    private String name;

    @SerializedName("indexMZ")
    private double indexMZ;

    @SerializedName("index")
    private String index;

    @SerializedName("lat")
    private String lat;

    @SerializedName("lng")
    private String lng;

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getIndexMZ() {
        return indexMZ;
    }

    public void setIndexMZ(double indexMZ) {
        this.indexMZ = indexMZ;
    }

}
