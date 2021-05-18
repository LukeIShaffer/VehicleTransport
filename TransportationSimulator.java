/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransportProject;
import java.util.List;
import java.util.Random;
/**
 *
 * @author Luke
 */
public class TransportationSimulator implements TransportSimulatable {
    private String simulationResults;
    
    
    // create a constructor
    public TransportationSimulator(){
        simulationResults = null;
    }
    
    @Override
    public void runTransportSimulation(List<TransportVehicle> vList) {
        
        StringBuilder sb = new StringBuilder();
        int passTotal = 0;
        // Only examine elements if we actually have a list and that list
        // is NOT empty (!)
        if(vList != null && !vList.isEmpty()){
            // Use Enhanced for Loop to visit each item individually
            // This says, serve me once TransportVehicle at a time, 
            // and do so by sticking it in the variable called v
            // which I can look at more closely inside the for loop
            for(TransportVehicle v: vList){
                    sb.append("-----------------------------------------\n");

                    sb.append("Examining Vehicle: " + v.getCallSign() + "\n");

                    sb.append("Passenger Count: " + v.getPassengerCount() + "\n");

                   int injuries = possiblyInjured(v.getSafetyCoefficient(),v.getPassengerCount());

                    sb.append("Passenger Injuries: " + injuries + "\n");

                    sb.append("Passenger fatalities: " + possiblyDead(injuries) + "\n");

                    passTotal = passTotal + v.getPassengerCount();
                }
            sb.append("****** OVERALL RESULTS *******");
            sb.append("\nTotal Passengers in all vehicles: " + passTotal);
            
        }
        // after we've run the simulatoin, dump our String train into 
        // the member variable which holds simulation results
        simulationResults = sb.toString();
        
    }

    @Override
    public String getSimulationResults() {
        if(simulationResults != null){
            
        
        
        // ship to caller the results of the most recent simulation
        return simulationResults;
        }
       return null;
    }
    
    public int possiblyInjured (double safety, int passengers){
        Random randomly = new Random();
        double likelihood = randomly.nextDouble();
        if(likelihood >= safety){
            return 0;
        }else{
            return (int)(passengers + safety);
        }
    }
    
    public int possiblyDead (int injuries){
        Random randomly = new Random();
        double likelihood = randomly.nextDouble();
        
        return(int) Math.round(injuries * likelihood);
    }
    
}
