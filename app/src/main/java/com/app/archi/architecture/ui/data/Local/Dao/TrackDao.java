package com.app.archi.architecture.ui.data.Local.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.app.archi.architecture.ui.data.Model.Track;

import java.util.List;

@Dao
public abstract class TrackDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract boolean insertTrack(Track... track);

    @Query("SELECT * FROM Track where name LIKE :trackName")
    public abstract List<Track> getTracks(String trackName);

}
