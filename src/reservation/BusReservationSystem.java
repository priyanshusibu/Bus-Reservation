package reservation;
public class BusReservationSystem {
    public static void main(String[] args) {
        TicketCounter ticketCounter = new TicketCounter(15);
        
        Thread t1 = new TicketBookingThread(ticketCounter, "John", 2, Ticket.ECONOMY);
        Thread t2 = new TicketBookingThread(ticketCounter, "Martin", 3, Ticket.BUSINESS);
        Thread t3 = new TicketBookingThread(ticketCounter, "Sarah", 4, Ticket.FIRST_CLASS);
        Thread t4 = new TicketBookingThread(ticketCounter, "Emily", 2, Ticket.ECONOMY);
        Thread t5 = new TicketBookingThread(ticketCounter, "Michael", 5, Ticket.BUSINESS);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ticketCounter.displayWaitingList();
    }
}