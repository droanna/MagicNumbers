import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends MagicNumber {

    private static int[] jpg1 = {0xFF, 0xD8};
    private static int[] jpg2 = {0xFF, 0xD9};
    private static int[] gif1 = {0x47, 0x49, 0x46, 0x38, 0x39, 0x61};
    private static int[] gif2 = {0x47, 0x49, 0x46, 0x38, 0x37, 0x61};


    private static Map<String, int[]> extensions = new HashMap<>();

    public static void main(String[] args) throws IOException {

        Logger logger = Logger.getLogger(Class.class.getName());

        extensions.put("jpg1", jpg1);
        extensions.put("jpg2", jpg2);
        extensions.put("gif1", gif1);
        extensions.put("gif2", gif2);

        List<Integer> magicNumber = magicNumber(new File("zaba.jpg"));
        logger.log(Level.INFO, "File type: " + fileType(extensions, magicNumber));

        List<Integer> magicNumber2 = magicNumber(new File("SmallFullColourGIF.gif"));
        logger.log(Level.INFO, "File type: " + fileType(extensions, magicNumber2));

        List<Integer> magicNumber3 = magicNumber(new File("Przyklad.txt"));
        logger.log(Level.INFO, "File type: " + fileType(extensions, magicNumber3));

    }
}


