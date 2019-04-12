package com.app.archi.architecture.ui.ui;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableField;

import com.app.archi.architecture.ui.Utils.SchedularProvider;
import com.app.archi.architecture.ui.data.DataManager;
import com.app.archi.architecture.ui.data.Model.Track;
import com.app.archi.architecture.ui.data.Model.Tracks;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import timber.log.Timber;

/**
 * Contains Business logic for gettting tracks
 */
public class TracksViewModel extends BaseViewModel{
   private ObservableField<String> showError=new ObservableField<>();
    private MutableLiveData<List<Track>> tracksData=new MutableLiveData<>();
    private ObservableField<String> text=new ObservableField<>();



    TracksViewModel(DataManager dataManager, SchedularProvider schedularProvider){
        super(dataManager,schedularProvider);
        tracksData.setValue(new ArrayList<Track>());
    }

    void subscribeTracks()
    {
        showLoader();
        Disposable disposable=dataManager.getLatestTracks()
                .subscribeOn(schedularProvider.getIo())
                .observeOn(schedularProvider.getUi())
                .subscribe((tracks, throwable) -> {
                    Timber.i("Request Tracks Received %s", tracks);

                    if(tracks!=null)
                    {
                        tracksData.getValue().addAll(tracks.getTrack());
                        tracksData.setValue( tracksData.getValue());
                    }  else
                    {
                        text.set(throwable.getLocalizedMessage());
                    }
                });
      compositeDisposable.add(disposable);
    }

    private void showLoader() {
        text.set("Please Wait");
    }

    public ObservableField<String> getShowError() {
        return showError;
    }

    public MutableLiveData<List<Track>> getTracksData() {
        return tracksData;
    }

    public ObservableField<String> getText() {
        return text;
    }

    public void click()
    {
      subscribeTracks();
    }


    public void search(String s) {
        Disposable  disposable=Single.concat(getFilterObservable(s),dataManager.searchAnything(s))
                .subscribeOn(schedularProvider.getIo())
                .observeOn(schedularProvider.getUi())
                .subscribe(tracks->tracksData.setValue(tracks.getTrack()),throwable -> {});
        compositeDisposable.add(disposable);
    }

    public Single<Tracks> getFilterObservable(String s) {
       return Observable.fromIterable(Objects.requireNonNull(tracksData.getValue())).
                filter(track->track.getName().equalsIgnoreCase(s))
               .toList().map(tracks ->{ Tracks t=new Tracks();
                                       t.setTrack(tracks);
                                       return t;});

    }
}
