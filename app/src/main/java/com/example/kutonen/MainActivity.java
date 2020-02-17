package com.example.kutonen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView teksti;
    ListView lista;
    Button nappula;
    TauluDao td;
    MyEntity myEntity;
    ArrayAdapter<MyEntity> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.lista);
        teksti = findViewById(R.id.teksti);
        nappula = findViewById(R.id.nappula);
        MyEntity myEntity = new MyEntity();

        ArrayList list = new ArrayList();

        adapter = new adapteri(this,R.id.lista,list);
        lista.setAdapter(adapter);










        tietokanta db = Room.databaseBuilder(getApplicationContext(),
                tietokanta.class, "tietoa").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        this.td = db.tauluDao();
        adapter.addAll(td.getAllInDescendingOrder());



        nappula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyEntity myEntity = new MyEntity();

                String aika = Calendar.getInstance().getTime().toString();

                myEntity.aika = aika;
                myEntity.tieto = teksti.getText().toString();

                td.InsertMyEntity(myEntity);


                adapter.clear();
                adapter.addAll(td.getAllInDescendingOrder());







            }
        });



    }
}