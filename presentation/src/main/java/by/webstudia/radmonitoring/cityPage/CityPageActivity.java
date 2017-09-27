package by.webstudia.radmonitoring.cityPage;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;
import android.view.MenuItem;
import android.widget.SeekBar;

import by.webstudia.radmonitoring.R;
import by.webstudia.radmonitoring.base.BaseActivity;
import by.webstudia.radmonitoring.cityList.CityListActivity;
import by.webstudia.radmonitoring.databinding.ActivityCityPageBinding;
import by.webstudia.radmonitoring.info.InfoActivity;
import by.webstudia.radmonitoring.map.MapsActivity;


public class CityPageActivity extends BaseActivity {

    Intent intent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        CityPageVM viewModel = new CityPageVM(this);
        this.viewModel = viewModel;


        ActivityCityPageBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_city_page);

        binding.setViewModel(viewModel);

        Intent in = getIntent();

        viewModel.name.set(in.getStringExtra("itemName"));
        viewModel.index.set(in.getStringExtra("itemMz"));

        double d = Double.parseDouble(in.getStringExtra("itemMz")) * 100;
        viewModel.seekbarValue.set((int) d);

        binding.seekBar.setMax(100);
        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_info:
                                intent = new Intent(CityPageActivity.this, InfoActivity.class);
                                startActivity(intent);


                                break;
                            case R.id.action_city:
                                intent = new Intent(CityPageActivity.this, CityListActivity.class);
                                startActivity(intent);


                                break;
                            case R.id.action_map:
                                intent = new Intent(CityPageActivity.this, MapsActivity.class);
                                startActivity(intent);

                                break;
                        }
                        return false;
                    }
                });


        super.onCreate(savedInstanceState);

    }


}
