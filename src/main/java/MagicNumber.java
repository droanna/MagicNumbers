import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MagicNumber extends MagicNumber2 {

    public MagicNumber() {
    }

    public void returnType(String fileName) throws IOException {
        Logger logger = Logger.getLogger(Class.class.getName());
        List<Integer> magicNumber = magicNumber(new File(fileName));
        logger.log(Level.INFO, "File type: " + fileType(getExtensions(), magicNumber));
    }

    @Override
    public List<Integer> magicNumber(File file) throws IOException {
        return MagicNo.magicNumber(file);
    }

    @Override
    public String fileType(Map<String, int[]> extensions, List<Integer> numbers) {
        return FileType.fileType(extensions, numbers);
    }

    @Override
    public Map<String, int[]> getExtensions() {
        return Extensions.getExtensions();
    }
}