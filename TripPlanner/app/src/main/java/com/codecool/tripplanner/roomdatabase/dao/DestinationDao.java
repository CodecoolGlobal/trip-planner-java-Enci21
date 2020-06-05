package com.codecool.tripplanner.roomdatabase.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.codecool.tripplanner.roomdatabase.entity.Destination;

import java.util.List;

@Dao
public interface DestinationDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void addDestination(Destination destination);

    @Update
    void updateDestination(Destination destination);

    @Query("SELECT * FROM destinations ORDER BY title ASC")
    List<Destination> getAllDestination();

    @Query("SELECT * FROM destinations WHERE id = :destId")
    Destination getDestination(Long destId);
}
