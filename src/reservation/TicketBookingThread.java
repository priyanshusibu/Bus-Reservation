package reservation;
class TicketBookingThread extends Thread {
    private TicketCounter ticketCounter;
    private String passengerName;
    private int noOfSeatsToBook;
    private String ticketType;

    public TicketBookingThread(TicketCounter ticketCounter, String passengerName, int noOfSeatsToBook, String ticketType) {
        this.ticketCounter = ticketCounter;
        this.passengerName = passengerName;
        this.noOfSeatsToBook = noOfSeatsToBook;
        this.ticketType = ticketType;
    }
    
    public void run() {
        ticketCounter.bookTicket(passengerName, noOfSeatsToBook, ticketType);
    }
}
