package assignment1;

public class MyProgram {

	public static void main(String[] args) {
		System.out.println("TEST TEST" + "\nHello User!\n\n");
		
		
		Event a = new Event("World of Robotics", "Laffere Hall");
		TicketType b = new TicketType("Student", 200.00);
		//TicketType c = new TicketType("VIP", -200.00);
		
		/*		
		private int _id;
		private Event _Event;
		private TicketType _TicketType;
		private String _studentName;
		private boolean _cancelled;
		private boolean _admitted;	*/
				
		System.out.println(a.get_name());
		System.out.println(a.get_location());
		
		System.out.println(b.get_name());
		System.out.println(b.get_price());
		
		//Event f = new Event("\n\nObject Oriented Programming", "");	
		
		//System.out.println(f.get_name());
		//System.out.println(f.get_location());
		
		System.out.println("\n\ntoString Test:\n\n");
		System.out.println(a);
		System.out.println(b);
		
		/*TO DO
		 * MAKE EVENT IMMUTABLE
		 * MAKE TICKETTYPE IMMUTABLE
		 * 
		 * */
		
		
		System.out.println("=== CAMPUS EVENT TICKETING DEMO ===\n");

        // 1. Initialize TicketManager (creates internal TicketBook with capacity of 10)
        TicketManager manager = new TicketManager(10);

        // 2. Create at least 2 events
        Event guestLecture = new Event("Cybersecurity Guest Lecture", "Engineering Building");
        Event musicFest = new Event("Fall Music Fest", "Student Union Plaza");

        // 3. Create at least 2 ticket types
        TicketType studentType = new TicketType("Student", 5.00);
        TicketType vipType = new TicketType("VIP", 25.00);

        System.out.println("--- Creating 5 Tickets ---");
        // 4. Create at least 5 tickets across different events and ticket types
        manager.createTicket(guestLecture, studentType, "Alice Smith");   // Ticket ID #1
        manager.createTicket(guestLecture, vipType, "Bob Jones");        // Ticket ID #2
        manager.createTicket(guestLecture, studentType, "Charlie Brown");// Ticket ID #3
        manager.createTicket(musicFest, studentType, "Diana Prince");    // Ticket ID #4
        manager.createTicket(musicFest, vipType, "Evan Wright");        // Ticket ID #5

        System.out.println("\n--- All Issued Tickets ---");
        manager.printAllTickets();

        System.out.println("\n--- Performing Valid Operations ---");
        // 5. Admit at least 1 ticket (Ticket #1)
        boolean admitSuccess = manager.admitTicket(1);
        System.out.println("Admitted Ticket #1 (Alice): " + admitSuccess);

        // 6. Cancel at least 1 ticket (Ticket #2)
        boolean cancelSuccess = manager.cancelTicket(2);
        System.out.println("Canceled Ticket #2 (Bob): " + cancelSuccess);

        System.out.println("\n--- Demonstrating Invalid Operations ---");
        // 7. Demonstrate invalid operation: attempting to admit a canceled ticket
        System.out.println("Attempting to admit canceled Ticket #2...");
        boolean invalidAdmit = manager.admitTicket(2);
        System.out.println("Admit canceled ticket succeeded? " + invalidAdmit + " (Expected: false)");

        // Demonstrate invalid operation: attempting to cancel an admitted ticket
        System.out.println("Attempting to cancel admitted Ticket #1...");
        boolean invalidCancel = manager.cancelTicket(1);
        System.out.println("Cancel admitted ticket succeeded? " + invalidCancel + " (Expected: false)");

        System.out.println("\n--- Final Report: All Tickets ---");
        // 8. Print all tickets
        manager.printAllTickets();

        System.out.println("\n--- Final Report: Guest Lecture Tickets Only ---");
        // 9. Print tickets for one specific event
        manager.printTicketsForEvent(guestLecture);

	}

}
