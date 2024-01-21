package comp352.dsandalgos.huffman;

import java.util.HashMap;
import java.util.Map;

public class TwoWayMap<K, V> {
    private final Map<K, V> forwardMap;
    private final Map<V, K> reverseMap;

    public TwoWayMap() {
        forwardMap = new HashMap<>();
        reverseMap = new HashMap<>();
    }

    public void put(K key, V value) {
        forwardMap.put(key, value);
        reverseMap.put(value, key);
    }

    public V get(K key) {
        return forwardMap.get(key);
    }

    public K getKey(V value) {
        return reverseMap.get(value);
    }

    public void remove(K key) {
        V value = forwardMap.get(key);
        forwardMap.remove(key);
        reverseMap.remove(value);
    }

    public void removeValue(V value) {
        K key = reverseMap.get(value);
        reverseMap.remove(value);
        forwardMap.remove(key);
    }

    public boolean containsKey(K key) {
        return forwardMap.containsKey(key);
    }

    public boolean containsValue(V value) {
        return reverseMap.containsKey(value);
    }

    public int size() {
        return forwardMap.size();
    }
}
