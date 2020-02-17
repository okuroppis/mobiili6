package com.example.kutonen;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity

public class MyEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String tieto;
    public String aika;


}
