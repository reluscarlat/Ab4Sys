/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;
import java.util.List;

/**
 *
 * @author relu
 */
public class Spot {
    private int id;
    private String name;
    private String location;      
    private float price;
    private List<String> activities;
    private Date startDate;
    private Date endDate;

    public Spot(int id, String name, String location, float price, List<String> activities, Date startDate, Date endDate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.activities = activities;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<String> getActivities() {
        return activities;
    }

    public void setActivities(List<String> activities) {
        this.activities = activities;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Spot{" + "name=" + name + ", location=" + location + ", price per day=" + price + ", activities=" + activities + ", startDate=" + startDate + ", endDate=" + endDate + '}';
    }
}
