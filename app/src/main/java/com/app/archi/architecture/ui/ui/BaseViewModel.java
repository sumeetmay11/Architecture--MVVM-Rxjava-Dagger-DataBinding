package com.app.archi.architecture.ui.ui;

import android.arch.lifecycle.ViewModel;

import com.app.archi.architecture.ui.Utils.SchedularProvider;
import com.app.archi.architecture.ui.data.DataManager;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BaseViewModel extends ViewModel {
    final DataManager dataManager;
    CompositeDisposable compositeDisposable;
    SchedularProvider schedularProvider;

    public BaseViewModel(DataManager dataManager,SchedularProvider schedularProvider)
    {
        this.dataManager=dataManager;
        this.schedularProvider=schedularProvider;
        compositeDisposable=new CompositeDisposable();
    }

    @Override
    public void onCleared() {
      compositeDisposable.clear();
    }

}
