package morvel1;

import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
	static Moviedb db = new Moviedb();
	static Noveldb ndb = new Noveldb();
	
	
	public static void main(String[] args) throws Exception {
		db.addMovie();
		ndb.addNovel();
		Scanner scanner = new Scanner(System.in);
		boolean enter = true;
		while (enter != false) {
			System.out.println("\n" + "Welcome to MORVEL! LOGIN TO CONTINUE.");
			System.out.println("ENTER USERNAME");
			String username = scanner.nextLine();
			System.out.println("ENTER PASSWORD");
			String password = scanner.nextLine();
			if (username.equalsIgnoreCase("morvel") && password.equalsIgnoreCase("morvel.123")) {
				enter = false;
				menu();
			} else {
				System.out.println("INVLAID USER DETAILS");
			}
		}
		scanner.close();
	}

	public static void menu() {
		Scanner menusc = new Scanner(System.in);
		int choice = -1;
		while (choice != 0) {
			System.out.println("\n" + "Welcome to MORVEL! Select a choice from the menu.");
			System.out.println("1 to search for movies");
			System.out.println("2 to search for novels");
			System.out.println("3 to get recommended novels");
			System.out.println("4 to get recommended movies");
			System.out.println("0 to quit");
			try {
				System.out.print("Enter your choice: ");
				choice = Integer.parseInt(menusc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Invalid Input. Type a number.");
				choice = -1;
			}

			switch (choice) {
			case 0:
				System.out.println("THANKS FOR USING MORVEL");
				break;
			case 1:
				System.out.print("Enter the movie title: ");
				String[] title = menusc.nextLine().toLowerCase().split(" ");
				ArrayList<Movie1>gettitle = db.findByTitle(title);
				displaymovie(gettitle);
				break;
			case 2:
				System.out.print("Enter the novel title: ");
				String[] ntitle = menusc.nextLine().toLowerCase().split(" ");
				ArrayList<Novel>getntitle = ndb.findByTitle(ntitle);
				displaynovel(getntitle);
				break;
			case 3:
				System.out.print("Enter the movie title: ");
				String[] mtitle = menusc.nextLine().toLowerCase().split(" ");
				ArrayList<Movie1>getmtitle = db.findByTitle(mtitle);
				for(Movie1 g : getmtitle) {
					String genre =g.genre;
					ndb.findnovels(genre);
				}
				break;
			case 4:
				System.out.print("Enter the novel title: ");
				String[] noveltitle = menusc.nextLine().toLowerCase().split(" ");
				ArrayList<Novel>getnoveltitle = ndb.findByTitle(noveltitle);
				for(Novel g : getnoveltitle) {
					String genre =g.genre;
					db.findmovies(genre);
				}
				break;
			}	
		}
		menusc.close();
	}
	
	public static void displaymovie(ArrayList<Movie1> found) {
		if(found.size() == 0) {
			System.out.println("NO RESULTS FOUND");
		}else {
			for(Movie1 m : found) {
				System.out.println("title :" + m.title + "year :" + m.year + "director :" + m.director + "rating :" + m.rating + "genre :" + m.genre);
			}
		}
		
	}
	
	public static void displaynovel(ArrayList<Novel> found) {
		if(found.size() == 0) {
			System.out.println("NO RESULTS FOUND");
		}else {
			for(Novel m : found) {
				System.out.println("title :" + m.title + "year :" + m.year + "Author :" + m.author + "Publisher :" + m.publisher + "genre :" + m.genre);
			}
		}
		
	}

}
