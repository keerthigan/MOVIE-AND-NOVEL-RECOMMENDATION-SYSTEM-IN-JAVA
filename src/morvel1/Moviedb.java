package morvel1;

import java.util.ArrayList;


public class Moviedb {
	protected ArrayList<Movie1> movies = new ArrayList<Movie1>();
	
	
public void addMovie() {
	Movie1 m1 = new Movie1("harry potter", 2014, "jk.rowling", 4.6, "thriller");
	Movie1 m2 = new Movie1("stormbreaker", 2006, "geoffrey", 5.1, "adventure");
	movies.add(m1);
	movies.add(m2);
}
	
public ArrayList<Movie1> findByTitle(String[] criteria) {
		ArrayList<Movie1> searched = new ArrayList<Movie1>();
		for (Movie1 t : movies) {
			int traverse = 0;
			for (String str : criteria) {
				if (t.title.toLowerCase().contains(str)) {
					traverse++;
				}
			}
			if (traverse == criteria.length) {
				searched.add(t);
			}

		}
		return searched;
	}

public void findmovies(String genre) {
	ArrayList<Movie1> found = new ArrayList<Movie1>();
	for(Movie1 n : movies) {
		if(genre.equalsIgnoreCase(n.genre)) {
			found.add(n);
		}
	}
	MainMenu.displaymovie(found);
}

}
