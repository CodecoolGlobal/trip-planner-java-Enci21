package com.codecool.tripplanner;

public interface BasePresenter <V extends BaseView>{

    void subscribe(V view);

    void unsubscribe();
}
