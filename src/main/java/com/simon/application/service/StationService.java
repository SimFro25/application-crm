package com.simon.application.service;

import com.simon.application.model.Station;
import com.simon.application.util.DBHelper;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class StationService {

    DBHelper dbHelper;


    public StationService() {
        dbHelper = DBHelper.getInstance();
    }

    public List<Station> getAllStations() {
        List<Station> stations = new ArrayList<>();

        try {
            Statement statement = dbHelper.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM stations");

            while (result.next()) {
                stations.add(Station.builder()
                        .id(result.getLong("id"))
                        .name(result.getString("name"))
                        .latitude(result.getDouble("latitude"))
                        .longitude(result.getDouble("longitude"))
                        .build());
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return stations;
    }

    public Station getStationById(long id) {
        Station station = null;

        try {
            Statement statement = dbHelper.getConnection().createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM stations WHERE id = " + id + "");

            if (result.next()) {
               station = Station.builder()
                        .id(result.getLong("id"))
                        .name(result.getString("name"))
                        .latitude(result.getDouble("latitude"))
                        .longitude(result.getDouble("longitude"))
                        .build();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return station;
    }

    public void create(String name, double latitude, double longitude) {
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement("INSERT INTO stations (name, latitude, longitude) VALUES (?, ?, ?)");

            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, latitude);
            preparedStatement.setDouble(3, longitude);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(long id, String name, double latitude, double longitude) {
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement("UPDATE stations SET name = ?, latitude = ?, longitude = ?  WHERE id = ?");

            preparedStatement.setString(1, name);
            preparedStatement.setDouble(2, latitude);
            preparedStatement.setDouble(3,longitude);
            preparedStatement.setLong(4, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remove(long id) {
        try {
            PreparedStatement preparedStatement = dbHelper.getConnection().prepareStatement("DELETE FROM stations WHERE id = ?");

            preparedStatement.setLong(1, id);

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
