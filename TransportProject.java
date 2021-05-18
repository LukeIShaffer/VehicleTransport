/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransportProject;
import java.util.List;
import java.util.LinkedList;
/**
 *
 * @author astrozaya
 */
public class TransportProject {
    
     public static void main(String[] args){
        TransportationSimulator ts = new TransportationSimulator();
    
    ts.runTransportSimulation(setupVehicleList());

        System.out.println("Simulation results: ");
        System.out.println(ts.getSimulationResults());
}

public static List<TransportVehicle> setupVehicleList(){
        Spaceship atlas2 = new Spaceship();
        atlas2.setCallSign("The Atlas 3000 Spaceship");

        EscapePod escape = new EscapePod();
        escape.setCallSign("The Trusty Dusty Escape Pod");


        List<TransportVehicle> vList = new LinkedList<>();
        vList.add(atlas2);
        vList.add(escape);

        return vList;
    }

    public static double computeTravelTime(TransportVehicle vehicle, double distance){
        return distance/vehicle.getAverageSpeed();
    }
}