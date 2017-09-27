package by.webstudia.radmonitoring.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BaseFragment extends Fragment {



    protected BaseViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewModel.init();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
   public void onResume() {
        super.onResume();
        viewModel.resume();
    }

    @Override
    public void onPause() {
        super.onPause();
        viewModel.pause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        viewModel.release();
    }
}