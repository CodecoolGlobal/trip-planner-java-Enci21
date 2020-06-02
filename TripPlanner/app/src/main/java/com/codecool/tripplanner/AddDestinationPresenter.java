package com.codecool.tripplanner;

import android.app.Application;

import com.codecool.tripplanner.roomdatabase.DestinationRepository;
import com.codecool.tripplanner.roomdatabase.entity.Destination;

public class AddDestinationPresenter<V extends AddDestinationView> implements BasePresenter<V> {

    private DestinationRepository repo;
    V view;
    
    public AddDestinationPresenter(Application app){
        this.repo = new DestinationRepository(app);
    }

    public void insert(Destination destination){
        repo.insert(destination);
        view.displayToast();
    }

    @Override
    public void subscribe(V view) {
        this.view = view;
    }

    @Override
    public void unsubscribe() {
        view = null;
    }
}
