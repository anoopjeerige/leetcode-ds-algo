import java.util.*;
import java.util.Map.Entry;

public class BuiltInHashMap<K, V> {

    public void oper() {

        Map<Integer, String> dota = new HashMap<>();
        dota.put(1, "Juggernaut");
        dota.put(2, "Grimstroke");

        System.out.println(dota.get(2));

        System.out.println(dota.containsKey(2));

        System.out.println(dota.containsValue("Juggernaut"));

        dota.put(3, "Bristleback");

        for(Entry<Integer, String> e : dota.entrySet())
            System.out.println("Key: " + e.getKey() + "Value: " + e.getValue());

    }

    public static void main(String[] args) {
        new BuiltInHashMap().oper();
    }
} 