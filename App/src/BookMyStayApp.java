/**
 * =========================================================================
 * ABSTRACT CLASS - Room
 * =========================================================================
 * This abstract class represents a generic hotel room.
 * It models attributes that are intrinsic to a room type and remain
 * constant regardless of availability.
 * * @version 2.1
 */
abstract class Room {
    protected int numberOfBeds;

    protected int squareFeet;

    protected double pricePerNight;

    /**
     * Constructor used by child classes to initialize common room attributes.
     * * @param numberOfBeds number of beds in the room
     * @param squareFeet   total room size
     * @param pricePerNight cost per night
     */
    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    public void displayRoomDetails() {
        System.out.println("Room Type: " + this.getClass().getSimpleName());
        System.out.println("Beds: " + numberOfBeds + " | Size: " + squareFeet + " sq ft | Price: $" + pricePerNight);
    }
}

/**
 * CLASS - SingleRoom
 * Represents a single room in the hotel.
 * @version 2.1
 */
class SingleRoom extends Room {
    public SingleRoom() {
        super(1, 250, 1500.0);
    }
}

/**
 * CLASS - DoubleRoom
 * Represents a double room in the hotel.
 * @version 2.1
 */
class DoubleRoom extends Room {
    public DoubleRoom() {
        super(2, 400, 2500.0);
    }
}

/**
 * CLASS - SuiteRoom
 * Represents a suite room in the hotel.
 * @version 2.1
 */
class SuiteRoom extends Room {
    /** Initializes a SuiteRoom with predefined attributes. */
    public SuiteRoom() {
        super(3, 750, 5000.0);
    }
}

/**
 * =========================================================================
 * MAIN CLASS - UseCase2RoomInitialization
 * =========================================================================
 * Use Case 2: Basic Room Types & Static Availability
 * * Description:
 * This class demonstrates room initialization using domain models before
 * introducing centralized inventory management.
 * * Availability is represented using simple variables to highlight limitations.
 * * @version 2.1
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        int singleAvailable = 10;
        int doubleAvailable = 7;
        int suiteAvailable = 3;

        System.out.println("=================================================");
        System.out.println("   BOOK MY STAY - ROOM INITIALIZATION (v2.1)    ");
        System.out.println("=================================================");

        singleRoom.displayRoomDetails();
        System.out.println("Current Availability: " + singleAvailable);
        System.out.println("-------------------------------------------------");

        doubleRoom.displayRoomDetails();
        System.out.println("Current Availability: " + doubleAvailable);
        System.out.println("-------------------------------------------------");

        suiteRoom.displayRoomDetails();
        System.out.println("Current Availability: " + suiteAvailable);
        System.out.println("-------------------------------------------------");
    }
}
