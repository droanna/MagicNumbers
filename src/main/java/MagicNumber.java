import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MagicNumber {


    public static List<Integer> magicNumber(File file) throws IOException {
        List<Integer> numbers = new LinkedList<>();
        byte[] b = new byte[6];

        try {
            InputStream inputStream = new FileInputStream(file);

            inputStream.read(b);
            int i = 0;
            while (i < b.length) {
                byte by = b[i];
                int number = Byte.toUnsignedInt(by);
                numbers.add(number);
                i++;
            }

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

    private static Map<String, int[]> getExtensions() {

        int[] jpg1 = {0xFF, 0xD8};
        int[] jpg2 = {0xFF, 0xD9};
        int[] gif1 = {0x47, 0x49, 0x46, 0x38, 0x39, 0x61};
        int[] gif2 = {0x47, 0x49, 0x46, 0x38, 0x37, 0x61};

        Map<String, int[]> extensions = new HashMap<>();
        extensions.put("jpg1", jpg1);
        extensions.put("jpg2", jpg2);
        extensions.put("gif1", gif1);
        extensions.put("gif2", gif2);
        return extensions;
    }

    public static void returnType(String fileName) throws IOException {
        Logger logger = Logger.getLogger(Class.class.getName());
        List<Integer> magicNumber = magicNumber(new File(fileName));
        logger.log(Level.INFO, "File type: " + fileType(getExtensions(), magicNumber));
    }
}

