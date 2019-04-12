package com.app.archi.architecture.ui.ui;

import android.arch.lifecycle.ViewModel;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.app.archi.architecture.ui.Utils.SchedularProvider;
import com.app.archi.architecture.ui.data.DataManager;

import javax.inject.Inject;

public abstract class BaseClassActivity extends AppCompatActivity {

    ViewModel mViewModel;
    ViewDataBinding mViewDataBinding;

    @Inject
    DataManager dataManager;
    @Inject
    SchedularProvider schedularProvider;


    abstract void injectDependency();
    abstract ViewModel getViewModel();
    abstract int getLayoutId();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependency();
        bindViewModel();

    }

    protected  void bindViewModel(){
        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId());
        this.mViewModel = mViewModel == null ? getViewModel() : mViewModel;
        mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
        mViewDataBinding.executePendingBindings();
    }

    protected abstract int getBindingVariable();
}
