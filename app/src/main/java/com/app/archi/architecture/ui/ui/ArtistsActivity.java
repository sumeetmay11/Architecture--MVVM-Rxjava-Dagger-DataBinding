package com.app.archi.architecture.ui.ui;

import android.arch.lifecycle.ViewModel;
import android.os.Bundle;

public class ArtistsActivity extends BaseClassActivity {
    @Override
    void injectDependency() {

    }

    @Override
    ViewModel getViewModel() {
        return null;
    }

    @Override
    int getLayoutId() {
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected int getBindingVariable() {
        return 0;
    }


}
