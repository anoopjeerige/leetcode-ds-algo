import java.util.*;

public class BuiltinHashSet<K> {

    public void oper() {
        Set<K> hashSet = new HashSet<K>();

        hashSet.add((K)"test");
        hashSet.add((K)Integer.valueOf(1));
        hashSet.add((K)Integer.valueOf(4));
        hashSet.add((K)"hello");

        System.out.println(hashSet.size());

        System.out.println("Contains: " + 1 + hashSet.contains(Integer.valueOf(1)));
        System.out.println("Contains: " + 1 + hashSet.contains("Test"));

        System.out.println(hashSet.remove("test"));

        for(K item : hashSet) {
            System.out.println(item);
        }

    }

    public static void main(String[] args) {
        new BuiltinHashSet().oper();    
    }
}
