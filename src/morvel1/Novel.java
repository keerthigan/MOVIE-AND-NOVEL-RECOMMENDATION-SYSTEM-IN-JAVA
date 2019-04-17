package morvel1;


public class Novel {
	protected final String title;
	protected final int year;
	protected final String author;
	protected final String publisher;
	protected final String genre;
	
	public Novel(String title, int year, String author, String publisher, String genre) {
		super();
		this.title = title;
		this.year = year;
		this.author = author;
		this.publisher = publisher;
		this.genre = genre;
	}
}
