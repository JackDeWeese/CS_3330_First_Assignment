package assignment1;

public class TicketManager {
	private final TicketBook _ticketBook;
    private int _nextId; // Non-static counter for ticket IDs

    // Constructor creates the internal TicketBook with the given capacity
    public TicketManager(int capacity) {
        this._ticketBook = new TicketBook(capacity);
        this._nextId = 1; // Start IDs at 1
    }

    // Creates a ticket by auto-generating the ID and passing it to TicketBook
    public boolean createTicket(Event event, TicketType type, String studentName) {
        try {
            _ticketBook.createTicket(_nextId, event, type, studentName);
            _nextId++; // Increment counter only after successful creation
            return true;
        } catch (Exception e) {
            System.out.println("Failed to create ticket: " + e.getMessage());
            return false;
        }
    }

    // Admits a ticket by looking it up and delegating to Ticket.admit()
    public boolean admitTicket(int id) {
        Ticket ticket = _ticketBook.findById(id);
        if (ticket == null) {
            System.out.println("Admit failed: Ticket #" + id + " not found.");
            return false;
        }
        // Delegate state transition rule to Ticket
        return ticket.admit();
    }

    // Cancels a ticket by looking it up and delegating to Ticket.cancel()
    public boolean cancelTicket(int id) {
        Ticket ticket = _ticketBook.findById(id);
        if (ticket == null) {
            System.out.println("Cancel failed: Ticket #" + id + " not found.");
            return false;
        }
        // Delegate state transition rule to Ticket
        return ticket.cancel();
    }

    // High-level report delegates directly to TicketBook
    public void printAllTickets() {
        _ticketBook.printAll();
    }

    // High-level report delegates directly to TicketBook
    public void printTicketsForEvent(Event event) {
        _ticketBook.printForEvent(event);
    }
}
