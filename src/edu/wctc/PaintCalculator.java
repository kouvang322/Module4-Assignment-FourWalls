package edu.wctc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PaintCalculator implements Serializable {
    private List<Room> roomList = new ArrayList<>();

    public void addRoom(double width, double length, double height){

        Room room = new Room(width, length, height);

        roomList.add(room);
    }

    @Override
    public String toString(){
        String roomPaint = "";

        for(Room room: roomList){
            roomPaint += room.getArea();
        }

        if(roomList.size() == 0){
            return "No rooms on the list.";
        }
        else{
            return roomPaint;
        }
    }

}
