package edu.wctc;

import java.io.*;
import java.util.Scanner;

public class Main {

    private static Scanner keyboard;
    private static PaintCalculator paintCalculator;

    public static void main(String[] args) {

        keyboard = new Scanner(System.in);
        paintCalculator = new PaintCalculator();

        try {
            new Main().printRoom();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private void printMenu(){
        System.out.println();
        System.out.println("Select Action");
        System.out.println("1. Add room");
        System.out.println("2. View rooms");
        System.out.println("3. Read rooms from file");
        System.out.println("4. Write rooms to file");
        System.out.println("5. Exit program");
        System.out.print("Please enter your choice: ");
    }

    private double promptForDimension(String dimensionName){
        System.out.println();
        System.out.println("Enter the " + dimensionName);
        double userInput = Double.parseDouble(keyboard.nextLine());

        return userInput;
    }

    private void createRoom(){
        System.out.println();
        double userEnterWidth = promptForDimension("width");

        double userEnterLength = promptForDimension("length");

        double userEnterHeight = promptForDimension("height");

        paintCalculator.addRoom(userEnterWidth, userEnterLength, userEnterHeight);
    }

    private void printRoom() throws IOException, ClassNotFoundException {
        boolean userContinue = true;

        while(userContinue){
            printMenu();

            String userInput = keyboard.nextLine();
            switch (userInput){
                case "1":
                    createRoom();
                    break;
                case "2":
                    System.out.println(paintCalculator.toString());
                    break;
                case "3":
                    readFile();
                    break;
                case "4":
                    writeFile();
                    break;
                case "5":
                    userContinue = false;
                    break;
            }
        }
    }

    private void readFile() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("room.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);

        paintCalculator = (PaintCalculator) ois.readObject();

        ois.close();
    }

    private void writeFile() throws IOException {
        FileOutputStream fos = new FileOutputStream("room.dat");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(paintCalculator);

        oos.flush();
        oos.close();
    }
}
