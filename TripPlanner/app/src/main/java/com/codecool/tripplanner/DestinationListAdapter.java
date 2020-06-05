package com.codecool.tripplanner;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codecool.tripplanner.roomdatabase.entity.Destination;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DestinationListAdapter extends RecyclerView.Adapter<DestinationListAdapter.DestinationViewHolder> {

    private List<Destination> destinations;
    public static final String EXTRA_DEST_TITLE = "com.codecool.tripplanner.destTitle";
    public static final String EXTRA_DEST_LAT = "com.codecool.tripplanner.destLat";
    public static final String EXTRA_DEST_LONG = "com.codecool.tripplanner.destLong";


    public DestinationListAdapter(List<Destination> destinations) {
        this.destinations = destinations;
    }

    @NonNull
    @Override
    public DestinationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.destination_item, parent, false);
        return new DestinationViewHolder(itemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull DestinationViewHolder holder, int position) {
        Destination current = destinations.get(position);
        holder.destinationTitle.setText(current.getTitle());
        holder.latitude = current.getLatitude();
        holder.longitude = current.getLongitude();
        Picasso.get().load(Uri.parse(current.getUrlPicture())).placeholder(R.drawable.placeholder_image).into(holder.destinationImage);
    }

    @Override
    public int getItemCount() {
        return destinations.size();
    }

    static class DestinationViewHolder extends RecyclerView.ViewHolder {

        final TextView destinationTitle;
        final ImageView destinationImage;
        final Button seeDetailsButton;
        final DestinationListAdapter adapter;
        double latitude;
        double longitude;


        public DestinationViewHolder(@NonNull View itemView, DestinationListAdapter adapter) {
            super(itemView);
            destinationTitle = itemView.findViewById(R.id.destination);
            destinationImage = itemView.findViewById(R.id.destiantionImg);
            seeDetailsButton = itemView.findViewById(R.id.seeDetails);
            seeDetailsButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(itemView.getContext(), MapScreenActivity.class);
                    intent.putExtra(EXTRA_DEST_TITLE, destinationTitle.getText());
                    intent.putExtra(EXTRA_DEST_LAT, latitude);
                    intent.putExtra(EXTRA_DEST_LONG, longitude);
                    itemView.getContext().startActivity(intent);
                }
            });

            this.adapter = adapter;
        }
    }
}
