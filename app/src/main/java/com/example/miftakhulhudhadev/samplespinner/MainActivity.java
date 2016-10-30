package com.example.miftakhulhudhadev.samplespinner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by miftakhulhudhadev on 28/10/16.
 */

public class MainActivity extends AppCompatActivity {

    private Spinner spinStartPosition, spinDestination;
    private Button btnShow;
    private TextView textDescription;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        spinStartPosition = (Spinner) findViewById(R.id.spin_start_position);
        spinDestination= (Spinner) findViewById(R.id.spin_destination);
        btnShow = (Button) findViewById(R.id.btn_show);
        textDescription = (TextView) findViewById(R.id.text_description);

        final ArrayAdapter<CharSequence> startPositionAdapter = ArrayAdapter.createFromResource(this, R.array.array_location, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> destinationAdapter = ArrayAdapter.createFromResource(this, R.array.array_location_destination, android.R.layout.simple_spinner_item);

        spinStartPosition.setAdapter(startPositionAdapter);
        spinDestination.setAdapter(destinationAdapter);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String startPosition = spinStartPosition.getSelectedItem().toString();
                String destination = spinDestination.getSelectedItem().toString();


                //condition when value of startPosition is "Jakarta" and destination is "Rembang"
                if (startPosition.equalsIgnoreCase("Jakarta") && destination.equalsIgnoreCase("Rembang")){
                    textDescription.setText("good destination \n" +
                            "description : posisi awal anda adalah "+startPosition+" dan tujuan anda adalah "+destination);

                //condition when value of startPosition is "Bandung" and destination is "Semarang"
                }else if (startPosition.equalsIgnoreCase("Bandung") && destination.equalsIgnoreCase("Semarang")){
                    textDescription.setText("destination okey \n" +
                            "description : posisi awal anda adalah "+ startPosition + "dan tujuan anda adalah "+destination);

                //other condition
                }else {
                    textDescription.setText("description : posisi awal anda " + startPosition + " dan tujuan anda " + destination);
                }

            }
        });

    }
}

