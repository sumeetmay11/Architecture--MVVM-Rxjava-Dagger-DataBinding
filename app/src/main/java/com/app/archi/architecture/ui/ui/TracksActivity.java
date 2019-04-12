package com.app.archi.architecture.ui.ui;

import android.arch.lifecycle.ViewModel;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.app.archi.architecture.BR;
import com.app.archi.architecture.R;
import com.app.archi.architecture.databinding.ActivityTracksBinding;
import com.app.archi.architecture.ui.Architecture;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import timber.log.Timber;

public class TracksActivity extends BaseClassActivity {

    ActivityTracksBinding activityTracksBinding;

    @Inject
    Gson gson;

    @Inject
    Picasso picasso;

    @Override
    void injectDependency() {
         ((Architecture)getApplication()).get().getAppComponent().injectThis(this);
    }

    @Override
    ViewModel getViewModel() {
       return new TracksViewModel(dataManager,schedularProvider);
    }

    @Override
    int getLayoutId() {
        return R.layout.activity_tracks;
    }

    RecyclerView recyclerView;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         initViews();

        Timber.i("Request Tracks Data");
        activityTracksBinding.getVm().getTracksData().observe(this, tracks -> {
            try {
                adapter.refreshList();
            }catch (Exception e)
            {
                Timber.e(e);
            }
        });
        activityTracksBinding.getVm().subscribeTracks();





    }

    private void initViews() {
        activityTracksBinding=(ActivityTracksBinding) mViewDataBinding;
        recyclerView=activityTracksBinding.rv;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter=new ListAdapter( activityTracksBinding.getVm().getTracksData().getValue(),R.layout.list_item,picasso);
        recyclerView.setAdapter(adapter);


    }

    @Override
    protected int getBindingVariable() {
        return BR.vm;
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
