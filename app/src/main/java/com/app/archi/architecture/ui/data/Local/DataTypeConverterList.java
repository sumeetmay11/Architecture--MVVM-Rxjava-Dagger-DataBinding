package com.app.archi.architecture.ui.data.Local;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

class DataTypeConverterList<T> {
    Gson gson=new Gson();
    @TypeConverter
    public String getStringFromList(List<T> list)
    {
        return gson.toJson(list);
    }

    @TypeConverter
    public List<T> getListFromString(String list)
    {
      return gson.fromJson(list,new  TypeToken<List<T>>(){}.getType());
    }
}
