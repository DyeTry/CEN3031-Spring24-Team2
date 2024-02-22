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