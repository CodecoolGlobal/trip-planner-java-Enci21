package com.codecool.tripplanner;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.codecool.tripplanner.roomdatabase.entity.Destination;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MapScreenActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap googleMap;
    String destinationTitle;
    double latitude;
    double longitude;

    @BindView(R.id.mapDestTitle)
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_screen);
        ButterKnife.bind(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Intent intent = getIntent();
        destinationTitle = intent.getStringExtra(DestinationListAdapter.EXTRA_DEST_TITLE);
        latitude = intent.getDoubleExtra(DestinationListAdapter.EXTRA_DEST_LAT, 0);
        longitude = intent.getDoubleExtra(DestinationListAdapter.EXTRA_DEST_LONG, 0);
        title.setText(destinationTitle);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        LatLng dest = new LatLng(latitude, longitude);
        googleMap.addMarker(new MarkerOptions().position(dest).title(destinationTitle));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(dest));
    }
}
