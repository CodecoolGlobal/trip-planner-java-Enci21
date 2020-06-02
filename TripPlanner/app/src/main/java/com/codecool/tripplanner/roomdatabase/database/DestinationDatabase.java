package com.codecool.tripplanner.roomdatabase.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.codecool.tripplanner.roomdatabase.dao.DestinationDao;
import com.codecool.tripplanner.roomdatabase.entity.Destination;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Destination.class}, version = 3, exportSchema = false)
public abstract class DestinationDatabase extends RoomDatabase {

    public abstract DestinationDao destinationDao();

    private static volatile DestinationDatabase INSTANCE;
    private static final int NUM_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUM_OF_THREADS);

    public static DestinationDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (Database.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DestinationDatabase.class, "destination_db")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
