package com.codecool.tripplanner.roomdatabase;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.codecool.tripplanner.roomdatabase.entity.Destination;
import com.codecool.tripplanner.roomdatabase.dao.DestinationDao;
import com.codecool.tripplanner.roomdatabase.database.DestinationDatabase;

import java.util.List;

public class DestinationRepository {

    private DestinationDao destinationDao;

    public DestinationRepository(Application app) {
        DestinationDatabase db = DestinationDatabase.getDatabase(app);
        this.destinationDao = db.destinationDao();
    }

    public List<Destination> getAllDestination() {
        return destinationDao.getAllDestination();
    }

    public Destination getDestination(Long id) {
        return destinationDao.getDestination(id);
    }

    public void updateDestination(Destination destination) {
        destinationDao.updateDestination(destination);
    }

    public void insert(Destination destination) {
        DestinationDatabase.databaseWriteExecutor.execute(() -> {
            destinationDao.addDestination(destination);
        });
    }
}
