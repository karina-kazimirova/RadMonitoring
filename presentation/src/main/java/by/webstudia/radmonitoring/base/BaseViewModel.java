package by.webstudia.radmonitoring.base;

import android.app.Dialog;

/**
 * Created by Sve on 09.08.2017.
 */

public interface BaseViewModel {

    // определяем общие для всех активити

    public void init();
    public void release();
    public void resume();
    public void pause();


}
