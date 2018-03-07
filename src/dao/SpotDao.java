/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Spot;

/**
 *
 * @author relu
 */
public class SpotDao {
    private Connection connection ;

    public SpotDao(Connection connection) {
        this.connection = connection;
    }
    
    public List<Spot> getSpots() {
        List<Spot> spots = new ArrayList<>();
        
        String sqlQuery = "SELECT * FROM Spots ";
        
        try(PreparedStatement statement = connection.prepareStatement(sqlQuery);
            ResultSet rs = statement.executeQuery();){
            while(rs.next()) {
                int spot_id = rs.getInt(1);
                String name = rs.getString(2);
                String locationName = rs.getString(3);
                float price = rs.getFloat(4);
                Date startDate = rs.getDate(5);
                Date endDate = rs.getDate(6);
                List<String> activities = this.getActivities(spot_id);
                Spot spot = new Spot(spot_id, name, locationName, price, activities, startDate, endDate);
                spots.add(spot);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return spots;
    }
    
    public List<String> getActivities(int spotId) {
        List<String> activities = new ArrayList<>();
        
        String sqlQuery = "SELECT * FROM Activities WHERE spotId = ?";
        
        try(PreparedStatement statement = connection.prepareStatement(sqlQuery);){
            statement.setInt(1, spotId);
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                String activity = rs.getString(2);
                activities.add(activity);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }   
        return activities;
    }
    
    public List<String> getActivities() {
        List<String> activities = new ArrayList<>();
        
        String sqlQuery = "SELECT DISTINCT * FROM Activities ";
        
        try(PreparedStatement statement = connection.prepareStatement(sqlQuery);
                ResultSet rs = statement.executeQuery();){
            while(rs.next()) {
                String activity = rs.getString(2);
                activities.add(activity);
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }   
        return activities;
    }
}
