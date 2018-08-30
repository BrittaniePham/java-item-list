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

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getId() {
		return id;
	}
	
	public static int getCount() {
		return count;
	}
	
	@Override
	public String toString() {
		return getTitle() + " - " + getGenre() + " - released in " + getYear() + " - id: " + getId();
	}
}

