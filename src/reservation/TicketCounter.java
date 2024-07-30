package reservation;
import java.util.ArrayList;
import java.util.List;

class TicketCounter {
    private int availableSeats;
    private final List<String> waitingList = new ArrayList<>();
    public TicketCounter(int initialSeats) {
        this.availableSeats = initialSeats;
    }

    public synchronized boolean bookTicket(String pname, int numberOfSeats, String ticketType) {
        if ((availableSeats >= numberOfSeats) && (numberOfSeats > 0)) {
            availableSeats -= numberOfSeats;
            double totalCost = numberOfSeats * new Ticket(ticketType).getPrice();
            System.out.printf("Booking Confirmed for %s: %d %s class seat(s). Total cost: $%.2f%n", 
                              pname, numberOfSeats, ticketType, totalCost);
            System.out.printf("Remaining seats: %d%n", availableSeats);
            return true;
        } else {
            System.out.printf("Sorry %s, not enough seats available. Adding to waiting list.%n", pname);
            waitingList.add(pname);
            return false;
        }
    }

    public synchronized void displayWaitingList() {
        System.out.println("Waiting List:");
        for (int i = 0; i < waitingList.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, waitingList.get(i));
        }
    }
}

