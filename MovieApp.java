package a01_Item_List;

import java.util.ArrayList;
import java.util.Scanner;

public class MovieApp {
	
	static ArrayList<Movie> movies = new ArrayList<>();
	
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
	
	private static void selection(Scanner input, ArrayList<Movie> movies) {
		System.out.println("Enter your selection");
		int number = input.nextInt();
		switch (number) {
		case 1:
			displayAll(movies);
			menu(input);
			break;
		case 2:
			addMovie();
			System.out.println("Your movie has successfully been added");
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
	
	private static void displayAll(ArrayList<Movie> movies) {
		System.out.println("----------------------------------------------------------------------------");
		for (Movie movie: movies) {
			System.out.println(movie);
		}
		System.out.println("----------------------------------------------------------------------------");
	}
	
	private static void addMovie() {
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
		
	}
	
	private static void findMovie(Scanner input) {
		System.out.println("Please enter the id of the movie you want to find: ");
		int id = input.nextInt();
		for (Movie movie: movies) {
			if(movie.getId() == id)
			System.out.println(movie);
		}
	}
	
	private static void deleteMovie(Scanner input) {
		System.out.println("Please enter the id of the movie you want to delete: ");
		Movie currentMovie = null;
		boolean found = false;
		int id = input.nextInt();
		for (Movie movie: movies) {
			if(movie.getId() == id) {
				currentMovie = movie;
				System.out.println(" '" + movie.getTitle() + "' has been removed");
				found = true;
			}
		}
		if(found == false) {
			System.out.println("The id " + id + " could not be found");
		}
		movies.remove(currentMovie);
	}
	
	private static void movieCount() {
		System.out.println("Number of movies: " + Movie.getCount());
	}
}
