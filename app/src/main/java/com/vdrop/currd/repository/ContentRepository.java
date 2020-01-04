package com.vdrop.currd.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.vdrop.currd.db.ContentDAO;
import com.vdrop.currd.db.ContentRoomDataBase;
import com.vdrop.currd.models.DetailsModel;

import java.util.List;

public class ContentRepository {

    private ContentDAO contentDAO;
    private LiveData<List<DetailsModel>> mList;

    public ContentRepository(Application application) {
        ContentRoomDataBase dataBase = ContentRoomDataBase.getDataBase(application);
        contentDAO = dataBase.contentDAO();
        mList = contentDAO.displayItems();
    }


    //display all item
    public LiveData<List<DetailsModel>> getAllItems() {
        return mList;
    }


    //localdb
    public void insertData(final DetailsModel model) {
        ContentRoomDataBase.databaseWrite.execute(() ->   //Runable method
                contentDAO.insert(model));
    }

    public void upateData(final DetailsModel model) {
        ContentRoomDataBase.databaseWrite.execute(() ->   //Runable method
                contentDAO.update(model));
    }

    public void deleteAll(DetailsModel model) {
        ContentRoomDataBase.databaseWrite.execute(() ->
                contentDAO.deleteItem(model.getId()));
    }

    public void deleteData(int id) {
        ContentRoomDataBase.databaseWrite.execute(() ->
                contentDAO.deleteItem(id));
    }

    public LiveData<DetailsModel> getParticularItem(int id) {
               return contentDAO.getParticularItem(id);
    }
}
