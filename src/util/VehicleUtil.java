package util;

import dto.Vehicle;
import enums.VehicleType;

public class VehicleUtil {
   public static Vehicle generateVehicleDTO(VehicleType vehicleType,String regNo,String color){
        Vehicle vehicle=new Vehicle(vehicleType,regNo,color);
        return vehicle;
    }
}
