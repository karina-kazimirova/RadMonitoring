package by.webstudia.radmonitoring.start.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import by.webstudia.radmonitoring.R;
import by.webstudia.radmonitoring.base.BaseFragment;
import by.webstudia.radmonitoring.databinding.FragmentCityBinding;
import by.webstudia.radmonitoring.start.fragments.fragmentsVM.CityFragmentsVM;



public class CityFragments extends BaseFragment  {


    public CityFragments() { }

    FragmentCityBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_city, container, false);
        View view = binding.getRoot();

        final CityFragmentsVM viewModel = new CityFragmentsVM(getActivity());
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

    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    public void onPause() {
        super.onPause();

    }


}

