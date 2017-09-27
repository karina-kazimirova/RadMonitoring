package by.webstudia.radmonitoring.start.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import by.webstudia.radmonitoring.R;
import by.webstudia.radmonitoring.base.BaseFragment;
import by.webstudia.radmonitoring.databinding.FragmentMapCityBinding;
import by.webstudia.radmonitoring.start.fragments.fragmentsVM.MapCityFragmentsVM;

/**
 * Created by Sve on 14.09.2017.
 */

public class MapCityFragment extends BaseFragment {

    public MapCityFragment() { }

    FragmentMapCityBinding binding;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_map_city, container, false);
        View view = binding.getRoot();

        MapCityFragmentsVM viewModel = new MapCityFragmentsVM(getActivity());
        this.viewModel = viewModel;

        binding.setViewModel(viewModel);

        return view;
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }


}

