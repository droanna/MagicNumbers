import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MagicNumber {


    public static List<Integer> magicNumber(File file) throws IOException {
        List<Integer> numbers = new LinkedList<>();

        try {
            InputStream inputStream = new FileInputStream(file);
            int number = inputStream.read();

            while (number != -1) {
                numbers.add(number);
                number = inputStream.read();
            }
            return numbers;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return numbers;
    }


    public static String fileType(Map<String, int[]> extensions, List<Integer> numbers) {
        int i = 0;
        Iterator<String> iterator = extensions.keySet().iterator();
        String key = iterator.next();
        for (String s : extensions.keySet()) {
            int[] current = extensions.get(key);
            while (i < current.length) {
                if (current[i] == numbers.get(i)) {
                    i++;
                    if (i == current.length) {
                        if (key.charAt(key.length() - 1) > '0' && key.charAt(key.length() - 1) < '9') {
                            return key.substring(0, key.length() - 1);
                        } else {
                            return key;
                        }
                    }
                } else {
                    break;
                }
            }
            if (iterator.hasNext()) {
                key = iterator.next();
            }
        }
        return "Unknown format";
    }
}

