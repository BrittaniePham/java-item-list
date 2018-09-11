package a01_Item_List;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class runs the movie app
 * 
 * @author Brittanie Pham
 *
 */
public class MovieApp {
	
	static ArrayList<Movie> movies = new ArrayList<>();
	
	/**
	 * main method to run the app
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		
		Movie movie1 = new Movie("To All the Boys I Loved Before", "romance", 2018);
		Movie movie2 = new Movie("Ready Player One", "action", 2018);
		Movie movie3 = new Movie("The Boy", "thriller", 2016);
		Movie movie4 = new Movie("A Quiet Place", "thriller", 2018);

		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		movies.add(movie4);
		menu(input);
	}
	
	/**
	 * prints the menu with options for the user to choose from
	 * @param input passed to selection method to allow for user to choose what they want to do
	 */
	private static void menu(Scanner input) {
		System.out.println();
		System.out.println("1. Display all movies");
		System.out.println("2. Add a movie");
		System.out.println("3. Find a movie");
		System.out.println("4. Delete a movie");
		System.out.println("5. Number of movies in list");
		System.out.println("6. Exit");
		System.out.println();
		selection(input, movies);	
	}
	
	/**
	 * depending on what the user chooses from the menu, this directs them to that specific objective
	 * @param input user's input to choose what they want to do from the menu options
	 * @param movies array list of movies 
	 */
	private static void selection(Scanner input, ArrayList<Movie> movies) {
		if (input.hasNextInt()) { //TODO
			System.out.println("Enter your selection");
			int number = input.nextInt();
			switch (number) {
			case 1:
				displayAll(movies);
				menu(input);
				break;
			case 2:
				addMovie();
				menu(input);
				break;
			case 3:
				findMovie(input);
				menu(input);
				break;
			case 4:
				deleteMovie(input);
				menu(input);
				break;
			case 5:
				movieCount();
				menu(input);
				break;
			case 6:
				System.out.println("goodbye");
				break;
			default:
				System.out.println("Invalid choice, try again");
				System.out.println();
				selection(input, movies);
			}
		}
		else{
			System.out.println("Invalid selection");
//			menu(input);
		}
	}
	
	/**
	 * shows all of the movies currently in the array list
	 * @param movies array list of movies
	 */
	private static void displayAll(ArrayList<Movie> movies) {
		System.out.println("----------------------------------------------------------------------------");
		for (Movie movie: movies) {
			System.out.println(movie);
		}
		System.out.println("----------------------------------------------------------------------------");
	}
	
	/**
	 * allows use to add a movie to the array list named movies
	 */
	private static void addMovie() {
		@SuppressWarnings("resource")
		Scanner input2 = new Scanner(System.in);
		
		System.out.println("Name: ");
		String name = input2.nextLine();
		System.out.println("Genre: ");
		String genre = input2.nextLine();
		System.out.println("Year: ");
		int year = input2.nextInt();
		Movie userMovie = new Movie(name, genre, year);
		movies.add(userMovie); 
		System.out.println();
		System.out.println("The movie \"" + userMovie.getTitle() + "\" has successfully been added");
		
	}
	
	/**
	 * allows the user to find a specific movie from the movies array list by the id.
	 * @param input the id of the movie the user wants to find
	 */
	private static void findMovie(Scanner input) {
		System.out.println("Please enter the id of the movie you want to find: ");
		boolean found = false; 
		int id = input.nextInt();
		for (Movie movie: movies) {
			if(movie.getId() == id)
			System.out.println(movie);
		}
		if(found == false) { 
			System.out.println("The id " + id + " could not be found");
		}
	}
	
	/**
	 * allows the user to delete a specific movie from the movies array list by the id.
	 * @param input the id of the movie the user wants to delete
	 */
	private static void deleteMovie(Scanner input) {
		System.out.println("Please enter the id of the movie you want to delete: ");
		Movie currentMovie = null;
		boolean found = false;
		int id = input.nextInt();
		for (Movie movie: movies) {
			if(movie.getId() == id) {
				currentMovie = movie;
				System.out.println(" '" + movie.getTitle() + "' has been removed");
				Movie.decreaseCount();
				found = true;
			}
		}
		if(found == false) {
			System.out.println("The id " + id + " could not be found");
		}
		movies.remove(currentMovie);
	}
	
	/**
	 * returns the total number of movies in the movie array list
	 */
	private static void movieCount() {
		System.out.println("Number of movies: " + Movie.getCount());
	}
}
