package by.webstudia.radmonitoring.cityList;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import by.webstudia.radmonitoring.R;
import by.webstudia.radmonitoring.base.BaseActivity;
import by.webstudia.radmonitoring.databinding.ActivityListCityPageBinding;

public class CityListActivity extends BaseActivity {



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        CityListVM viewModel = new CityListVM(this);
        this.viewModel = viewModel;


        ActivityListCityPageBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_list_city_page);

        binding.setViewModel(viewModel);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));

        binding.recyclerView.setAdapter(viewModel.adapter);

        super.onCreate(savedInstanceState);


    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}
