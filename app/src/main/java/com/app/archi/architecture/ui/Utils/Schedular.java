package com.app.archi.architecture.ui.Utils;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class Schedular implements  SchedularProvider{
    @Override
    public Scheduler getIo() {
        return Schedulers.io();
    }

    @Override
    public Scheduler getUi() {
        return AndroidSchedulers.mainThread();
    }

    @Override
    public Scheduler getComputation() {
        return  Schedulers.computation();
    }
}
