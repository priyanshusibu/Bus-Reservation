package reservation;

class Ticket {
    public static final String ECONOMY = "ECONOMY";
    public static final String BUSINESS = "BUSINESS";
    public static final String FIRST_CLASS = "FIRST_CLASS";

    private String type;
    private double price;

    public Ticket(String type) {
        this.type = type;
        this.price = getPrice(type);
    }

    private double getPrice(String type) {
        switch (type) {
            case ECONOMY:
                return 100;
            case BUSINESS:
                return 200;
            case FIRST_CLASS:
                return 300;
            default:
                return 0;
        }
    }

    public String getType() { return type; }
    public double getPrice() { return price; }
}