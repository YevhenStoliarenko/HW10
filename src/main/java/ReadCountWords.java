import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ReadCountWords {
    public void readCountWords() throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("words.txt"));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        String resultbuilder = null;
        while (scanner.hasNext()) {
            if (scanner.hasNextLine()) {
                line = scanner.nextLine();
                stringBuilder.append(line);
                stringBuilder.append(" ");

            }

            resultbuilder = stringBuilder.toString();
        }
        scanner.close();
        String result = resultbuilder.replaceAll("\\s+", " ");
        String[] words = result.split(" ");
        System.out.println(Arrays.toString(words));

        Map<String, Integer> mapWords = new HashMap<>();
        int counter = 1;
        for (int i = 0; i < words.length; i++) {
            if (!mapWords.containsKey(words[i])) {
                mapWords.put(words[i], 0);

            }
            mapWords.put(words[i], mapWords.get(words[i]) + 1);
        }
        //System.out.println(mapWords);

        List<String> list = new ArrayList<>(List.of(words));
        //System.out.println(list);

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(mapWords.entrySet());
        //System.out.println(entries);
        Comparator<Map.Entry<String, Integer>> fazit = Map.Entry.comparingByValue();
        entries.sort(fazit.reversed());

        for (Map.Entry<String, Integer> str : entries
        ) {
            System.out.println(str);
        }

    }
}
