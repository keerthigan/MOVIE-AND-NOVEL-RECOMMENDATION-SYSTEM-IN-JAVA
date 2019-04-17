package morvel1;

import java.util.ArrayList;

public class Noveldb {
	protected ArrayList<Novel> novels = new ArrayList<Novel>();
	
	
	public void addNovel() {
		Novel n1 = new Novel("harry potter", 2014, "jk.rowling", "jack", "thriller");
		Novel n2 = new Novel("cascade", 2006 , "geoffrey sax", "jill", "adventure");
		novels.add(n1);
		novels.add(n2);
	}
		
	public ArrayList<Novel> findByTitle(String[] criteria) {
			ArrayList<Novel> searched = new ArrayList<Novel>();
			for (Novel n : novels){
				int traverse = 0;
				for (String str : criteria) {
					if (n.title.toLowerCase().contains(str)) {
						traverse++;
					}
				}
				if (traverse == criteria.length) {
					searched.add(n);
				}

			}
			return searched;
		}
	
	public void findnovels(String genre) {
		ArrayList<Novel> found = new ArrayList<Novel>();
		for(Novel n : novels) {
			if(genre.equalsIgnoreCase(n.genre)) {
				found.add(n);
			}
		}
		MainMenu.displaynovel(found);
	}
	

}
