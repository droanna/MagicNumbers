import java.util.HashMap;
import java.util.Map;

public interface Extensions {

    static Map<String, int[]> getExtensions() {

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
}
