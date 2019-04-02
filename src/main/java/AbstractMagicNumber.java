import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractMagicNumber {

    public void returnType(String fileName) throws IOException {
        Logger logger = Logger.getLogger(Class.class.getName());
        List<Integer> magicNumber = magicNumber(new File(fileName));
        logger.log(Level.INFO, "File type: " + fileType(getExtensions(), magicNumber));
    }

    public abstract List<Integer> magicNumber(File file) throws IOException;

    public abstract String fileType(Map<String, int[]> extensions, List<Integer> numbers);

    public abstract Map<String, int[]> getExtensions();

}
