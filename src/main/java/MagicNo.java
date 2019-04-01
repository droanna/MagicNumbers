import java.io.*;
import java.util.LinkedList;
import java.util.List;

public interface MagicNo {

    static List<Integer> magicNumber(File file) throws IOException {
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
}
