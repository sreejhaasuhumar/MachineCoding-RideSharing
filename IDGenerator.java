package Entity;

public class IDGenerator {
	static long id;

	public static long getId() {
		id++;
		return id;
	}

	public static void setId(long id) {
		IDGenerator.id = id;
	}
	
	

}
