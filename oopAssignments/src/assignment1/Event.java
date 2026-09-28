package assignment1;

public final class Event {
	private final String _name;
	private final String _location;
	
	//encapsulation
	public Event(String name, String location) {
		if(name == null || name.isBlank()) {
			throw new IllegalArgumentException("Event name cannot be null or empty!");
		}
		if(location == null || location.isBlank()) {
			throw new IllegalArgumentException("Event location cannot be null or empty!");
		}
		
		//funnily enough this is literally the same work as
		//setters i have found, but just inside the encapsulation
		
		_name = name;			
		_location = location;	
	}

	
	public String toString() {
		return get_name() + " @ " + get_location();
	}
	
	
	/*------------get functions-------------*/	
	String get_name() {
		return _name;
	}
	
	String get_location() {
		return _location;
	}
}
