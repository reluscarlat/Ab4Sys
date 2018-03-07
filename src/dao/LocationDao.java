/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Location;
import model.LocationType;

/**
 *
 * @author relu
 */
public class LocationDao {
    private Connection connection;

    public LocationDao(Connection connection) {
        this.connection = connection;
    }
    
    public List<Location> getLocations() {
        List<Location> locations = new ArrayList<>();
        
        String sqlQuery = "SELECT * FROM Locations";
        
        try(PreparedStatement statement = connection.prepareStatement(sqlQuery);
            ResultSet rs = statement.executeQuery();){
            while(rs.next()) {
                String type = rs.getString(1);
                String name = rs.getString(2);
                String parent = rs.getString(3);
                Location l = new Location(LocationType.valueOf(type), name, parent);
                locations.add(l);
            }
            
        } catch(SQLException e) {
            e.printStackTrace();
        }  
        return locations;
    }
}
