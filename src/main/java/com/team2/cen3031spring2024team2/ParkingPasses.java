public class ParkingPasses {

    private String name;
    private String description;
    private int price;
    private String id;

    public ParkingPasses() {};

    public ParkingPasses(String name, String description, int price, String id) {

        this.name = name;
        this.description = description;
        this.price = price;
        this.id = id;
    }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public int getPrice() { return price; }

    public String getId() { return id; }
}

/**
 * Available Parking Passes
 *
 * Reserved/Administrative - $363.00 yearly
 * Faculty and Staff - $145.00 yearly
 * Resident - $145.00 yearly
 * Commuter - $114.00 yearly
 * Motorcycle - $73.00 yearly
 */