/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.LocationDao;
import java.sql.Connection;
import java.util.List;
import manager.DBManager;
import model.Location;

/**
 *
 * @author relu
 */
public class LocationService {
        
    public List<Location> getLocations() {
        DBManager dbManager = new DBManager();
        Connection connection = dbManager.getConnection();    
        LocationDao locationDao = new LocationDao(connection);
        
        List<Location> locationsMap = locationDao.getLocations();        
        dbManager.closeConnection(connection);
        
        return locationsMap;
    }
}
