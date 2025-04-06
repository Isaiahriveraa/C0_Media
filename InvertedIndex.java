import java.util.*;

public class InvertedIndex {
    public static void main(String[] args) {
        List<Media> docs = List.of(
            new Book("Mistborn", List.of("Brandon Sanderson"),
                     new Scanner("Epic fantasy worldbuildling content")),
            new Book("Farenheit 451", List.of("Ray Bradbury"),
                     new Scanner("Realistic \"sci-fi\" content")),
            new Book("The Hobbit", List.of("J.R.R. Tolkein"),
                     new Scanner("Epic fantasy quest content"))
        );
        
        Map<String, Set<Media>> result = createIndex(docs);
        System.out.println(docs);
        System.out.println();
        System.out.println(result);
    }

    // TODO: Write and document your createIndex method here
    public static Map<String, Set<Media>> createIndex(List<Media> docs) {
        //map is a treemap
        //set is a hashset
        Map<String, Set<Media>> wordToMedia = new TreeMap<>();

        for (Media currMedia: docs) {
            List<String> content = currMedia.getContent();
            for (String currWord : content) {
                String lowerCaseWord = currWord.toLowerCase();
                if (!wordToMedia.containsKey(lowerCaseWord)) {
                    wordToMedia.put(lowerCaseWord, new HashSet<>());
                }
                wordToMedia.get(lowerCaseWord).add(currMedia);
            }
        }
        return wordToMedia;
    }
}
