import java.util.HashMap;
import java.util.Map;

/**
 * =========================================================================
 * DOMAIN MODEL - Room Hierarchy (from Use Case 2)
 * =========================================================================
 */
abstract class Room {
    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    public void displayRoomDetails() {
        System.out.println(this.getClass().getSimpleName() + ":");
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Size: " + squareFeet + " sqft");
        System.out.println("Price per night: " + pricePerNight);
    }
}

class SingleRoom extends Room {
    public SingleRoom() { super(1, 250, 1500.0); }
}

class DoubleRoom extends Room {
    public DoubleRoom() { super(2, 400, 2500.0); }
}

class SuiteRoom extends Room {
    public SuiteRoom() { super(3, 750, 5000.0); }
}

/**
 * =========================================================================
 * CLASS - RoomInventory
 * =========================================================================
 * Use Case 3: Centralized Room Inventory Management
 * This class acts as the single source of truth for room availability.
 * @version 3.1
 */
class RoomInventory {
    /** * Stores available room count for each room type.
     * Key -> Room type name (String) | Value -> Count (Integer)
     */
    private Map<String, Integer> roomAvailability;

    public RoomInventory() {
        roomAvailability = new HashMap<>();
        initializeInventory();
    }

    /** Centralizes inventory setup instead of using scattered variables. */
    private void initializeInventory() {
        roomAvailability.put("SingleRoom", 5);
        roomAvailability.put("DoubleRoom", 3);
        roomAvailability.put("SuiteRoom", 2);
    }

    public Map<String, Integer> getRoomAvailability() {
        return roomAvailability;
    }

    public void updateAvailability(String roomType, int count) {
        roomAvailability.put(roomType, count);
    }
}

/**
 * =========================================================================
 * MAIN CLASS - UseCase3InventorySetup
 * =========================================================================
 * This class demonstrates how room availability is managed using a centralized
 * inventory with a HashMap, providing O(1) lookup efficiency.
 * @version 3.1
 */
public class BookMyStayApp {

    public static void main(String[] args) {
        // 1. Initialize Centralized Inventory
        RoomInventory inventory = new RoomInventory();

        // 2. Initialize Domain Objects
        Room single = new SingleRoom();
        Room doubleR = new DoubleRoom();
        Room suite = new SuiteRoom();

        System.out.println("Hotel Room Inventory Status\n");

        // 3. Display Status by combining Domain Data and Inventory State
        displayStatus(single, inventory);
        displayStatus(doubleR, inventory);
        displayStatus(suite, inventory);
    }

    /**
     * Helper method to link a Room object with the Inventory Map state.
     */
    private static void displayStatus(Room room, RoomInventory inventory) {
        String type = room.getClass().getSimpleName();
        Integer available = inventory.getRoomAvailability().get(type);

        room.displayRoomDetails();
        System.out.println("Available Rooms: " + (available != null ? available : 0));
        System.out.println("----------------------------");
    }
}