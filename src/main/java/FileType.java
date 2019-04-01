import java.util.Iterator;
import java.util.List;
import java.util.Map;

public interface FileType {

    static String fileType(Map<String, int[]> extensions, List<Integer> numbers) {
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
