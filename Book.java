import java.util.*;

/*
 * 
 */
public class Book implements Media {
    
    private String title;
    private List<String> authors;
    private int numOfRatings = 0;
    private int totalRating = 0;
    private Scanner scan;

    
    /*
     * 
     */
    public Book (String titie, List<String> authors, Scanner content) {
        authors = new ArrayList<>();
        
        for (String author: authors) {
            authors.add(author);
        }

        this.title = title;
        this.scan = content;

        /*The scanner object gives access to the content of the book
         - probably content.next() because we are doinga  toekn at a time.
        */
    }

    /**
     * Gets all of the content contained in this media.
     *
     * @ returns    The content stored in a List of strings. If there is no content, an empty list
     */
    public List<String> getContent() {
        
    }

    /*
     * 
     */
    public String toString() {
        String allAuthors = "";
        if (numOfRatings == 0) {
            
            for (int i = 0; i < authors.size(); i++) {
                if (i == 0 || i == authors.size() - 1) {
                    allAuthors += authors.get(i);
                } else {
                    allAuthors += ", " + authors.get(i);
                }
            }
            return title + " by " + allAuthors;
        } else {
            for (int i = 0; i < authors.size(); i++) {
                if (i == 0 || i == authors.size() - 1) {
                    allAuthors += authors.get(i);
                } else {
                    allAuthors += ", " + authors.get(i);
                }
            }

            return title + " by " + allAuthors + ": " + getAverageRating() + " (" + numOfRatings
                + " ratings)";
        }
    }

    /**
     * Gets the average (mean) of all ratings for this media.
     *
     * @return      The average (mean) of all ratings for this media. 
     *              If no ratings exist, returns 0.
     */
    public double getAverageRating() {
        return Math.round(((double) totalRating / numOfRatings) * 100) / 100.0;
    }

    /*
     * 
     */
    public String getTitle() {
        return title;
    }

    /*
     * 
     */
    public List<String> getArtists() {

        List<String> listOfAuthors = new ArrayList<>();

        for (String author: authors) {
            listOfAuthors.add(author);
        }
        return listOfAuthors;
    }

    /*
     * 
     */
    public void addRating(int score) {
        numOfRatings++;
        totalRating += score;
    }

    /**
     * Gets the number of times this media has been rated.
     *
     * @return      The number of ratings for this media.
     */
    public int getNumRatings() {
        return numOfRatings;
    }
}   