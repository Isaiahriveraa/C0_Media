import java.util.*;

/*
 * 
 */
public class Book implements Media, Comparable<Book> {
    
    private String title;
    private List<String> listOfAuthors;
    private int numOfRatings = 0;
    private int totalRating = 0;
    private List<String> contentOfBook;


    /*
     * 
     */
    public Book (String title, List<String> authors, Scanner content) {
        this.listOfAuthors = new ArrayList<>();
        for (String author: authors) {
            listOfAuthors.add(author);
        }
        this.title = title;
        contentOfBook = new ArrayList<>();

        while (content.hasNext()) {
            String currentToken = content.next();
            contentOfBook.add(currentToken);
        }
    }

    /**
     * Gets all of the content contained in this media.
     *
     * @ returns    The content stored in a List of strings. If there is no content, an empty list
     */
    public List<String> getContent() {
        List<String> content = new ArrayList<>();
        for (String token: contentOfBook) {
            content.add(token);
        }
        return content;
    }

    /*
     * Behavior:
     *      Initally the method tries to compare average rating, if there is a tie or no ratings 
     *      then it compares the number of ratings and if it is stilled tied then we will compare
     *      the title that way we can organize it alphabetically.
     * Exception:
     * Return:
     *      int: 
     *          This number will help us compare the Book objects.
     * Parameters:
     *      Book other:
     *          Passed in to compare to the current object vs the other object.
     */
    public int compareTo(Book other) {
        int value = 0;
        double thisAvg = this.getAverageRating();
        double otherAvg = other.getAverageRating();
        if (thisAvg != otherAvg) {
            if (thisAvg < otherAvg) {
                value = -1;
            } else {
                value = 1;
            }
        }
        if (value == 0 || this.numOfRatings == 0 || other.numOfRatings == 0) {
            value = this.numOfRatings - other.numOfRatings;
        }

        if (value == 0) {
            value = this.title.compareTo(other.title);
        }
        return value;
    }

    /*
     * 
     */
    public String toString() {
        String allAuthors = "";
        if (numOfRatings == 0) {
            for (int i = 0; i < listOfAuthors.size(); i++) {
                if (i == 0) {
                    allAuthors += listOfAuthors.get(i);
                } else {
                    allAuthors += ", " + listOfAuthors.get(i);
                }
            }
            return title + " by " + "[" + allAuthors + "]";
        } else {
            for (int i = 0; i < listOfAuthors.size(); i++) {
                if (i == 0) {
                    allAuthors += listOfAuthors.get(i);
                } else {
                    allAuthors += ", " + listOfAuthors.get(i);
                }
            }
            double roundedAvg = Math.round(getAverageRating() * 100) / 100.0;
            return title + " by " + "[" + allAuthors + "]" + ": " + roundedAvg + " (" + 
                numOfRatings + " ratings)";
        }
    }

    /**
     * Gets the average (mean) of all ratings for this media.
     *
     * @return      The average (mean) of all ratings for this media. 
     *              If no ratings exist, returns 0.
     */
    public double getAverageRating() {
        if (numOfRatings == 0) {
            return 0.0;
        }
        return (double) totalRating / numOfRatings;
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

        List<String> returnedList = new ArrayList<>();

        for (String author: listOfAuthors) {
            returnedList.add(author);
        }
        return returnedList;
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