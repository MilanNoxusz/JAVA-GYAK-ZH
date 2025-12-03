package com.example.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


@Entity
@Table(name = "station")
public class Station {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Column(name = "station_name")
    @Size(min=5, max=100, message = "A név 5 - 100 karakter hosszú lehet")
    private String nev;

    @Column(name = "max")
    @Min(4)
    @Max(1000)
    private int max;

    @Column(name = "lat")
    private float lat;

    @Column(name = "lon")
    private float lon;

    public Station(int id, String nev, int max, float lat, float lon) {
        this.id = id;
        this.nev = nev;
        this.max = max;
        this.lat = lat;
        this.lon = lon;
    }

    public Station() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", max=" + max +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }

}

