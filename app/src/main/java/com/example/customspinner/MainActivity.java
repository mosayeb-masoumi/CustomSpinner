package com.example.customspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.example.customspinner.Adapter.SpinnerAdapter;
import com.example.customspinner.model.ViewPerson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Spinner spinner=findViewById(R.id.spinner);
        final ArrayList<ViewPerson> people = new ArrayList<>();
        people.add(new ViewPerson("Mohammad",R.drawable.img_mohammad));
        people.add(new ViewPerson("Bashir", R.drawable.img_bashir));
        people.add(new ViewPerson("Amir", R.drawable.img_amir));
        people.add(new ViewPerson("Ali", R.drawable.img_ali));
        people.add(new ViewPerson("Iman", R.drawable.img_iman));
        people.add(new ViewPerson("Reza", R.drawable.img_reza));

        SpinnerAdapter adapter= new SpinnerAdapter(MainActivity.this,people);
        spinner.setAdapter(adapter);


        //to change action bar title
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                getSupportActionBar().setTitle(people.get(position).getName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
