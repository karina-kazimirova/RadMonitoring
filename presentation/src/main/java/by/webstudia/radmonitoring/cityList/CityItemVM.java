package by.webstudia.radmonitoring.cityList;

import android.databinding.ObservableDouble;
import android.databinding.ObservableField;
import android.graphics.Color;
import android.util.Log;
import by.webstudia.radmonitoring.base.BaseItemViewModel;
import by.webstudia.radmonitoring.domain.entity.CityModel;



public class CityItemVM extends BaseItemViewModel<CityModel> {

    public ObservableField<String> name = new ObservableField<>("");
    public ObservableDouble indexMZ = new ObservableDouble();
    public  ObservableField<String> index = new ObservableField<>();
    public ObservableField<Integer> color = new ObservableField<>();



    @Override
    public void setItem(CityModel item, int position) {

        name.set(item.getName());
        indexMZ.set(item.getIndexMZ());
        index.set(item.getIndex());

        setColor(item.getIndexMZ());
    }

    public void setColor(double d){

        int s = 0;

        if(d<0.4){
            s = Color.parseColor("#01ff9a");
        }
        else if(d>0.4 && d<0.7){
            s = Color.parseColor("#f8d25c");
        }else{
            s = Color.parseColor("#ee609c");
        }

       color.set(s);
    }


}