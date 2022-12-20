import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


public class main {

    public static void main (String[] args) throws IOException {
        countWord("src/main/resources/text.txt");
    }

    public static void countWord (String path) throws IOException {

        String string = Files.readString(Paths.get(path))
                .replace("\n", "")
                .replaceAll("[,.;\\t\\s]", " ")
                .replace("  ", " ");

        String[] strings = string.split(" ");
        Map<String, Integer> integerMap = new TreeMap<>(String::compareToIgnoreCase);

        for (String s : strings){
            integerMap.merge(s, 1, Integer::sum);
        }
        for (String name: integerMap.keySet()){
            String value = integerMap.get(name).toString();
            System.out.println(name + " " + value);
        }
    }
}
