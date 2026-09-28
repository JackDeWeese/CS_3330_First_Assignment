package assignment1;

public class TicketBook {
	private Ticket[] _tickets;
	private int _count;
	
	
	
	public TicketBook(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("TicketBook capacity must be greater than 0!");
		}
		
		_tickets = new Ticket[capacity];	
		_count = 0;
	}
	
	
	public void createTicket(int id, Event event, TicketType ticketType, String studentName) {
		if(_count >= _tickets.length) {
			throw new IllegalArgumentException("Tickets exceed maximum capacity for event!");
		}
		
		Ticket newTicket = new Ticket(id, event, ticketType, studentName);
		_tickets[_count] = newTicket;
		_count++;
	}
	
	public Ticket findById(int id) {
		for(int i = 0; i < _count; i++) {
			if(_tickets[i].get_id() == id) {
				return _tickets[i];
			}
		}
		
		return null;
	}

	// Prints all stored tickets
    public void printAll() {
        if (_count == 0) {
            System.out.println("No tickets found in the book.");
            return;
        }
        for (int i = 0; i < _count; i++) {
            System.out.println(_tickets[i]);
        }
    }

    // Prints tickets for a specific event
    // Design Choice Note: We use reference equality (==) to compare the Event object
    // of each ticket with the requested Event. This checks if both variables point to
    // the exact same object in memory without needing to override equals().
    public void printForEvent(Event event) {
        if (event == null) {
            throw new IllegalArgumentException("Event cannot be null when printing.");
        }

        boolean found = false;
        for (int i = 0; i < _count; i++) {
            if (_tickets[i].get_Event() == event) {
                System.out.println(_tickets[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No tickets found for event: " + event.get_name());
        }
    }

    public int getCount() {
        return _count;
    }

    public int getCapacity() {
        return _tickets.length;
    }
	
}
