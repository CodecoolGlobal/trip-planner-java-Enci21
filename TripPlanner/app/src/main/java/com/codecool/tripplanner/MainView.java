package com.codecool.tripplanner;

import com.codecool.tripplanner.roomdatabase.entity.Destination;

import java.util.List;

public interface MainView extends BaseView {

        void showDestinations(List<Destination> destinations);
        void emptyDatabaseMessageShow();

}
