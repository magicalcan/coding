package snapshot;
import java.util.*;

public class SnapshotKeyValue<K,V> {

    Map<K, TreeMap<Integer, V>> map;
    int snapId = 0;

    public SnapshotKeyValue() {
        map = new HashMap<>();
    }
    
    public void set(K key, V val) {
        if (!map.containsKey(key)){
            map.put(key, new TreeMap<>());
        }
        map.get(key).put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public V get_from_snapshot(K key, int snapId) {
        return map.get(key).floorEntry(snapId).getValue();
    }

    public static void main(String[] args){
        SnapshotKeyValue<Integer, Integer> tester = new SnapshotKeyValue<>();
        tester.set(0, 5);
        tester.snap();
        tester.set(0, 6);
        System.out.println(tester.get_from_snapshot(0, 0));
    }
}
