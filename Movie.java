package a01_Item_List;

/**
 * This class represents a Movie
 * 
 * @author Brittanie Pham
 * August 30, 2018
 *
 */
public class Movie {
	
	private String title;
	private String genre;
	private int year;
	private final int id;
	private static int count = 0;

	/**
	 * Constructs and initializes a Movie
	 * @param title title of movie
	 * @param genre genre movie belongs to
	 * @param year year the movie was published
	 */
	public Movie(String title, String genre, int year) {
		this.title = title;
		this.genre = genre;
		this.year = year;
		count++;
		this.id = getCount();
	}

	/**
	 * gets the title of a movie
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * gets the genre of a movie
	 * @return
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * gets the year of a movie
	 * @return
	 */
	public int getYear() {
		return year;
	}

	/**
	 * gets the unique id of a movie
	 * @return
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * gets the count of total movies
	 * @return
	 */
	public static int getCount() {
		return count;
	}
	
	/**
	 * decreases the total count of movies by 1
	 */
	public static void decreaseCount() {
		count--;
	}
	
	@Override
	public String toString() {
		return getTitle() + " - " + getGenre() + " - released in " + getYear() + " - id: " + getId();
	}
}

