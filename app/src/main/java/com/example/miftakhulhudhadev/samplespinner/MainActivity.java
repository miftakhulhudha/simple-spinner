package com.example.miftakhulhudhadev.samplespinner;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.miftakhulhudhadev.samplespinner.entity.City;
import com.example.miftakhulhudhadev.samplespinner.entity.Country;
import com.example.miftakhulhudhadev.samplespinner.entity.Street;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by miftakhulhudhadev on 28/10/16.
 */

public class MainActivity extends AppCompatActivity {

    private Spinner spinStartPosition, spinDestination, spinStreet;
    private TextView textDescription;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        spinStartPosition = (Spinner) findViewById(R.id.spin_start_position);
        spinDestination= (Spinner) findViewById(R.id.spin_destination);
        spinStreet= (Spinner) findViewById(R.id.spin_street);
        textDescription = (TextView) findViewById(R.id.text_description);

        final ArrayAdapter<Country> startPositionAdapter = new ArrayAdapter<Country>(this, android.R.layout.simple_spinner_item, countryList());
        final ArrayAdapter<City> destinationAdapter = new ArrayAdapter<City>(this, android.R.layout.simple_spinner_item, cityList());
        final ArrayAdapter<Street> streetAdapter = new ArrayAdapter<Street>(this, android.R.layout.simple_spinner_item, streetList());

        spinStartPosition.setAdapter(startPositionAdapter);
        spinDestination.setAdapter(destinationAdapter);
        spinStreet.setAdapter(streetAdapter);


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
                final ArrayAdapter<Street> streetArrayAdapter= new ArrayAdapter<Street>(MainActivity.this, android.R.layout.simple_spinner_item, streetListByCity(spinDestination.getSelectedItem().toString()));
                spinStreet.setAdapter(streetArrayAdapter);

                String startPosition = spinStartPosition.getSelectedItem().toString();
                String destination = spinDestination.getSelectedItem().toString();
                textDescription.setText("description : posisi awal anda " + startPosition + " dan tujuan anda " + destination);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinStreet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String startPosition = spinStartPosition.getSelectedItem().toString();
                String destination = spinDestination.getSelectedItem().toString();
                String street = spinStreet.getSelectedItem().toString();
                textDescription.setText("description : posisi awal anda " + startPosition + " dan tujuan anda " + destination + " Jalan "+ street);
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

    private List<Street> streetList(){
        List<Street> streets = new ArrayList<Street>();

        Street street1 = new Street();
        street1.setName("Jl. Pemuda");
        street1.setCity(cityList().get(0));
        streets.add(street1);

        Street street2 = new Street();
        street2.setName("Jl. Rembang - Blora");
        street2.setCity(cityList().get(0));
        streets.add(street2);

        Street street3 = new Street();
        street3.setName("Jl. Demang Waru");
        street3.setCity(cityList().get(0));
        streets.add(street3);

        Street street4 = new Street();
        street4.setName("Jl. Asia Afrika");
        street4.setCity(cityList().get(1));
        streets.add(street4);

        Street street5 = new Street();
        street5.setName("Jl. Dalem Kaum");
        street5.setCity(cityList().get(1));
        streets.add(street5);

        Street street6 = new Street();
        street6.setName("Jl. Naripan");
        street6.setCity(cityList().get(1));
        streets.add(street6);

        Street street7 = new Street();
        street7.setName("Jl. Danau Sunter Utara");
        street7.setCity(cityList().get(2));
        streets.add(street7);

        Street street8 = new Street();
        street8.setName("Jl. Danau Agung 2");
        street8.setCity(cityList().get(2));
        streets.add(street8);

        Street street9 = new Street();
        street9.setName("Jl. Pulau galang");
        street9.setCity(cityList().get(2));
        streets.add(street9);

        Street streeta = new Street();
        streeta.setName("Jl. Baturaja");
        streeta.setCity(cityList().get(3));
        streets.add(streeta);

        Street streetb = new Street();
        streetb.setName("Jl. Teluk Betung");
        streetb.setCity(cityList().get(3));
        streets.add(streetb);

        Street streetc = new Street();
        streetc.setName("Jl. Lumajang");
        streetc.setCity(cityList().get(4));
        streets.add(streetc);

        Street streetd = new Street();
        streetd.setName("Jl. Imam Bonjol");
        streetd.setCity(cityList().get(4));
        streets.add(streetd);

        Street streete = new Street();
        streete.setName("Jl. Indramayu");
        streete.setCity(cityList().get(5));
        streets.add(streete);

        Street streetf = new Street();
        streetf.setName("Jl. Panarukan");
        streetf.setCity(cityList().get(5));
        streets.add(streetf);


        return streets;

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


    private List<Street> streetListByCity(String cityName){
        List<Street> streets = new ArrayList<>();
        for (Street s : streetList()){
            if (s.getCity().getName().equals(cityName)){
                streets.add(s);
            }
        }
        return streets;
    }


}

