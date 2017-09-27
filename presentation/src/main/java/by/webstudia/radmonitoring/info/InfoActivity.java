package by.webstudia.radmonitoring.info;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.view.MenuItem;
import by.webstudia.radmonitoring.R;
import by.webstudia.radmonitoring.base.BaseActivity;
import by.webstudia.radmonitoring.cityList.CityListActivity;
import by.webstudia.radmonitoring.databinding.ActivityInfoBinding;
import by.webstudia.radmonitoring.map.MapsActivity;


public class InfoActivity extends BaseActivity {


    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        // создаем модель для этой активити
        InfoActivityViewModel viewModel = new InfoActivityViewModel(this);
        this.viewModel = viewModel;

        ActivityInfoBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_info);

        binding.setViewModel(viewModel);


       BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_info:
                                intent = new Intent(InfoActivity.this, InfoActivity.class);
                                startActivity(intent);


                                break;
                            case R.id.action_city:
                                intent = new Intent(InfoActivity.this, CityListActivity.class);
                                startActivity(intent);


                                break;
                            case R.id.action_map:
                                intent = new Intent(InfoActivity.this, MapsActivity.class);
                                startActivity(intent);

                                break;
                        }
                        return false;
                    }
                });


          super.onCreate(savedInstanceState);
    }

}
