package com.codecool.tripplanner.roomdatabase.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;


@Entity(tableName = "destinations")
public class Destination {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "ID")
    @NonNull
    private Long id;

    @NonNull
    private String title;

    @NonNull
    private double longitude;

    @NonNull
    private double latitude;

    @NonNull
    private String urlPicture;

    public Destination(@NonNull String title, double longitude, double latitude, @NonNull String urlPicture) {
        this.title = title;
        this.longitude = longitude;
        this.latitude = latitude;
        this.urlPicture = urlPicture;
    }

    public void setId(@NonNull Long id) {
        this.id = id;
    }

    @NonNull
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getUrlPicture() {
        return urlPicture;
    }
}
