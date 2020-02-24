package hashmap;

import java.util.HashMap;

public class HashDemo {

    public static void main(String[] args) {
        HashMap map = new HashMap(16, 0.75f);
        map.put(1, 2);
        map.put(2, 3);
    }
}
