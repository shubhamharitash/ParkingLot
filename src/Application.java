import constants.Commands;
import enums.DisplayType;
import enums.VehicleType;
import service.InMemoryService;
import service.ParkingLotService;
import util.VehicleUtil;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        InMemoryService inMemoryService=new InMemoryService();
        ParkingLotService parkingLotService=new ParkingLotService();
            while (true) {
                String[] inp = scanner.nextLine().trim().split(" ");
                try {
                    switch (inp[0]) {
                        case Commands.CREATE: {
                            parkingLotService.create_parkingLot(inp[1], Integer.parseInt(inp[2]), Integer.parseInt(inp[3]));
                        }
                        break;
                        case Commands.DISPLAY: {
                            parkingLotService.display(DisplayType.valueOf(inp[1]), VehicleType.valueOf(inp[2]));
                        }
                        break;
                        case Commands.PARK: {
                            parkingLotService.park_vehicle(VehicleUtil.generateVehicleDTO(VehicleType.valueOf(inp[1]), inp[2], inp[3]));
                        }
                        break;
                        case Commands.UNPARK: {
                            parkingLotService.unpark_vehicle(inp[1]);
                        }
                        break;
                        case Commands.EXIT: {
                            System.exit(0);
                        }
                        break;
                        default: {
                            System.out.println("INVALID INPUT");
                        }
                    }
                }
               catch (RuntimeException e){
                        System.out.println(e);
                    }
        }

    }
}
