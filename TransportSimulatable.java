/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TransportProject;
import java.util.List;
/**
 *
 * @author Luke
 */
public interface TransportSimulatable {
    public void runTransportSimulation(List<TransportVehicle> vList);
    
    public String getSimulationResults();
}
