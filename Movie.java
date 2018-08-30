package a01_Item_List;

public class Movie {
	
	//fields
	private String title;
	private String genre;
	private int year;
	private final int id;
	private static int count = 0;
	
	//constructor
	public Movie(String title, String genre, int year) {
		this.title = title;
		this.genre = genre;
		this.year = year;
		count++;
		this.id = getCount();
	}

	public String getTitle() {
		return title;
	}

	public String getGenre() {
		return genre;
	}

	public int getYear() {
		return year;
	}

	public int getId() {
		return id;
	}
	
	public static int getCount() {
		return count;
	}
	
	public static void decreaseCount() {
		count--;
	}
	
	@Override
	public String toString() {
		return getTitle() + " - " + getGenre() + " - released in " + getYear() + " - id: " + getId();
	}
}

