/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.SpotDao;
import java.sql.Connection;
import java.util.List;
import manager.DBManager;
import model.Spot;

/**
 *
 * @author relu
 */
public class SpotService {
    public List<Spot> getSpots() {
        DBManager dBManager = new DBManager();
        Connection connection = dBManager.getConnection();
        SpotDao spotDao = new SpotDao(connection);
        
        List<Spot> spots = spotDao.getSpots();
        dBManager.closeConnection(connection);
        
        return spots;      
    } 
    
    public List<String> getActivities() {
        DBManager dBManager = new DBManager();
        Connection connection = dBManager.getConnection();
        SpotDao spotDao = new SpotDao(connection);
        
        List<String> activities = spotDao.getActivities();
        dBManager.closeConnection(connection);
        
        return activities;      
    } 
}
