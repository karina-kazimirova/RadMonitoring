package by.webstudia.radmonitoring.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Sve on 09.08.2017.
 */

abstract public class BaseToolbarActivity extends AppCompatActivity {

    // Должна знать когда Activity открыта, когда закрыта и тд

    // Уведомления чтобы все активити отправляли свое состояние
    protected BaseViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel.init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        viewModel.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        viewModel.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        viewModel.release();
    }
}
