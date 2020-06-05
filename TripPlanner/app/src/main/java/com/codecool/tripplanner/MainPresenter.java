package com.codecool.tripplanner;

import android.app.Application;
import android.os.AsyncTask;
import android.os.Handler;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.codecool.tripplanner.roomdatabase.DestinationRepository;
import com.codecool.tripplanner.roomdatabase.entity.Destination;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class MainPresenter<V extends MainView> implements BasePresenter<V> {

    private DestinationRepository repository;
    private V view;

    public MainPresenter(@NonNull Application app) {
        this.repository = new DestinationRepository(app);
        new GetAllTask().execute();
    }

    @Override
    public void subscribe(V view) {
        this.view = view;
    }

    @Override
    public void unsubscribe() {
        view = null;
    }

    class GetAllTask extends AsyncTask<Void, Void, List<Destination>> {

        @Override
        protected List<Destination> doInBackground(Void... voids) {
            return repository.getAllDestination();
        }

        @Override
        protected void onPostExecute(List<Destination> destinations) {
            view.showLoading();
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    view.showDestinations(destinations);
                    view.emptyDatabaseMessageShow();
                }
            }, 2000);
        }
    }
}
