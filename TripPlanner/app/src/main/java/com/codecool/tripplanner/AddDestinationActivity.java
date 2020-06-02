package com.codecool.tripplanner;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.codecool.tripplanner.roomdatabase.entity.Destination;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddDestinationActivity extends AppCompatActivity implements AddDestinationView{
    @BindView(R.id.titleEditText)
    EditText titleEditText;

    @BindView(R.id.longitude)
    EditText longitudeEditText;

    @BindView(R.id.latitude)
    EditText latitudeEditText;

    @BindView(R.id.imgUrl)
    EditText imgUrlEditText;

    @BindView(R.id.addButton)
    Button button;

    AddDestinationPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_destination);
        ButterKnife.bind(this);

        presenter = new AddDestinationPresenter(getApplication());
        presenter.subscribe(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.insert(new Destination(
                        titleEditText.getText().toString(),
                        Double.parseDouble(longitudeEditText.getText().toString()) ,
                        Double.parseDouble(latitudeEditText.getText().toString()),
                        imgUrlEditText.getText().toString()));
            }
        });
    }

    @Override
    public void displayToast(){ //átnevezni
        Toast.makeText(this, "Thanks for the new destination!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() { }

    @Override
    public void hideLoading() { }
}
