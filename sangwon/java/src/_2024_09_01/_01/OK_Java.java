package _2024_09_01._01;

import _2024_09_01.org.opentutorials.iot.DimmingLights;
import _2024_09_01.org.opentutorials.iot.Elevator;
import _2024_09_01.org.opentutorials.iot.Lighting;
import _2024_09_01.org.opentutorials.iot.Security;

import javax.swing.*;

public class OK_Java {
    public static void main(String[] args) {

        String id = JOptionPane.showInputDialog("Enter a ID");
        String bright = JOptionPane.showInputDialog("Enter a Bright level");

        // Elevator call
        Elevator myElevator = new Elevator(id);
        myElevator.callForUp(1);

        // Security off
        Security mySecurity = new Security(id);
        mySecurity.off();

        // Light on
        Lighting hallLamp = new Lighting(id + " / Hall Lamp");
        hallLamp.on();

        Lighting floorLamp = new Lighting(id + " / floor Lamp");
        floorLamp.on();

        DimmingLights moodLamp = new DimmingLights(id + " moodLamp");
        moodLamp.setBright(Double.parseDouble(bright));
        moodLamp.on();
    }
}
