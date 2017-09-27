package by.webstudia.radmonitoring.start;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import by.webstudia.radmonitoring.R;
import by.webstudia.radmonitoring.start.fragments.CityFragments;
import by.webstudia.radmonitoring.start.fragments.CityListFragments;
import by.webstudia.radmonitoring.start.fragments.MapCityFragment;


public class PagerAdapter extends FragmentStatePagerAdapter {

    private Context context;

    public PagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }



    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new CityFragments();
        } else if (position == 1){
            return new CityListFragments();
        } else if (position == 2){
            return new MapCityFragment();
        } else {
            return new CityFragments();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        switch (position) {
            case 0:

            case 1:

            case 2:

            default:
                return null;
        }
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }


}
