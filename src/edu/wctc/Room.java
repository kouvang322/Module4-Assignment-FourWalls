package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Room implements Serializable {

    private List<Wall> wallList;

    public Room(double width, double length, double height){
        wallList = new ArrayList<>();

        Wall wall1 = new Wall(width, height);
        Wall wall2 = new Wall(width, height);
        Wall wall3 = new Wall(length, height);
        Wall wall4 = new Wall(length, height);

        wallList.add(wall1);
        wallList.add(wall2);
        wallList.add(wall3);
        wallList.add(wall4);
    }

    public double getArea(){
        double roomArea = 0;

        for(Wall wall: wallList){
            roomArea += wall.getArea();
        }

        return roomArea;
    }

    @Override
    public String toString(){
        String roomInfo= "";

        for(Wall wall: wallList){
            roomInfo += wall.getArea();
        }
       return roomInfo;
    }

}
