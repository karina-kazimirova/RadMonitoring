package by.webstudia.radmonitoring.cityList;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import by.webstudia.radmonitoring.base.BaseAdapter;
import by.webstudia.radmonitoring.domain.entity.CityModel;


public class CityAdapter extends BaseAdapter<CityModel, CityItemVM> {

    @Override
    public CityItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CityItemVM itemViewModel = new CityItemVM();
        return CityItemViewHolder.create(LayoutInflater.from(parent.getContext()),
                parent, itemViewModel);
    }



}
