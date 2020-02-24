package thread;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ConcurrentHashMapDemo {

    public static void main(String[] args) {
        Map map = Collections.synchronizedMap(new HashMap<>());
        map.put("a", 1);

    }

}
