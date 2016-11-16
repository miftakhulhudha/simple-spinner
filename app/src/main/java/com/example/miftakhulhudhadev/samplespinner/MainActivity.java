package com.example.miftakhulhudhadev.samplespinner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.miftakhulhudhadev.samplespinner.entity.City;
import com.example.miftakhulhudhadev.samplespinner.entity.Country;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miftakhulhudhadev on 28/10/16.
 */

public class MainActivity extends AppCompatActivity {

    private Spinner spinStartPosition, spinDestination;
    private TextView textDescription;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        spinStartPosition = (Spinner) findViewById(R.id.spin_start_position);
        spinDestination= (Spinner) findViewById(R.id.spin_destination);
        textDescription = (TextView) findViewById(R.id.text_description);

        final ArrayAdapter<Country> startPositionAdapter = new ArrayAdapter<Country>(this, android.R.layout.simple_spinner_item, countryList());
        final ArrayAdapter<City> destinationAdapter = new ArrayAdapter<City>(this, android.R.layout.simple_spinner_item, cityList());

        spinStartPosition.setAdapter(startPositionAdapter);
        spinDestination.setAdapter(destinationAdapter);


        spinStartPosition.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                // update destination adapter
                final ArrayAdapter<City> destinationAdapter = new ArrayAdapter<City>(MainActivity.this, android.R.layout.simple_spinner_item, cityListByCountry(spinStartPosition.getSelectedItem().toString()));
                spinDestination.setAdapter(destinationAdapter);

                String startPosition = spinStartPosition.getSelectedItem().toString();
                String destination = spinDestination.getSelectedItem().toString();
                textDescription.setText("description : posisi awal anda " + startPosition + " dan tujuan anda " + destination);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinDestination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String startPosition = spinStartPosition.getSelectedItem().toString();
                String destination = spinDestination.getSelectedItem().toString();
                textDescription.setText("description : posisi awal anda " + startPosition + " dan tujuan anda " + destination);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



    }


    private List<Country> countryList(){
        List<Country> countries = new ArrayList<>();

        Country country1 = new Country();
        country1.setName("Indonesia");
        countries.add(country1);


        Country country2 = new Country();
        country2.setName("Mesir");
        countries.add(country2);

        return countries;
    }

    private List<City> cityList(){
        List<City> cities = new ArrayList<>();

        City city1 = new City();
        city1.setName("Rembang");
        city1.setCountry(countryList().get(0));
        cities.add(city1);

        City city2 = new City();
        city2.setName("Bandung");
        city2.setCountry(countryList().get(0));
        cities.add(city2);

        City city3 = new City();
        city3.setName("Jakarta");
        city3.setCountry(countryList().get(0));
        cities.add(city3);

        City city4 = new City();
        city4.setName("Cairo");
        city4.setCountry(countryList().get(1));
        cities.add(city4);

        City city5 = new City();
        city5.setName("Tanta");
        city5.setCountry(countryList().get(1));
        cities.add(city5);

        City city6 = new City();
        city6.setName("Aswan");
        city6.setCountry(countryList().get(1));
        cities.add(city6);


        return cities;
    }

    private List<City> cityListByCountry(String coutryName){
        List<City> cities = new ArrayList<>();
        for (City c : cityList()){
            if (c.getCountry().getName().equals(coutryName)){
                cities.add(c);
            }
        }

        return cities;
    }

}

