public class Book implements Media {
    private String title;
    private List<String> authors;
    private int reviews;
    private List

    public Book (String titie, List<String> authors, Scanner content) {
        authors = new ArrayList<>();
        
        for (String author: authors) {
            authors.add(author);
        }
        /*The scanner object gives access to the content of the book
         - probably content.next() because we are doinga  toekn at a time.
        */
    }
}   