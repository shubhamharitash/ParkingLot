package dto;

import enums.VehicleType;

public class Vehicle {
    VehicleType vehicleType;
    String regNo;
    String color;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Vehicle(VehicleType vehicleType, String regNo, String color) {
        this.vehicleType = vehicleType;
        this.regNo = regNo;
        this.color = color;
    }
}
