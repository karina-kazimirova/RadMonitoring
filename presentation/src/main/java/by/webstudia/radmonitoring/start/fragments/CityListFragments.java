package by.webstudia.radmonitoring.start.fragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import by.webstudia.radmonitoring.R;
import by.webstudia.radmonitoring.base.BaseFragment;
import by.webstudia.radmonitoring.databinding.FragmentCityListBinding;
import by.webstudia.radmonitoring.start.fragments.fragmentsVM.CityListFragmentsVM;


public class CityListFragments extends BaseFragment {

    public CityListFragments() { }

    FragmentCityListBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_city_list, container, false);
        View view = binding.getRoot();

        final CityListFragmentsVM viewModel = new CityListFragmentsVM(getActivity());
        this.viewModel = viewModel;

        binding.setViewModel(viewModel);


        binding.seekBar.setMax(70);
        binding.seekBar.setProgress(10);

        binding.seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                float value= (float) (progress / 100.0);
                viewModel.seekbarValue.set(String.valueOf((value)+"\n"));
                viewModel.result.set(getSeekValue(seekBar.getProgress()));

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


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
    public void onDetach() {
        super.onDetach();

    }

    public String getSeekValue(int v){
        String result="";

        if(v<40){
            result = "Нормальный";
        }
        else if(v>40 && v<70){
            result = "Повышенный";
        }
        else if(v>=70){
            result = "Опасный";
        }

        return result;
    }


}

