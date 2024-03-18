package core.design;

import java.util.ArrayList;
import java.util.List;

/**
 * LC 706. Design HashMap
 */
public class DesignHashMap {
    class Pair<K, V> {
        public K key;
        public V val;

        public Pair(K f, V v) {
            this.key = f;
            this.val = v;
        }
    }

    class Bucket {
        private List<Pair<Integer, Integer>> bucket;

        public Bucket() {
            this.bucket = new ArrayList<>();
        }

        public Integer get(Integer key) {
            for (Pair<Integer, Integer> p : this.bucket) {
                if (p.key.equals(key)) {
                    return p.val;
                }
            }
            return -1;
        }

        public void update(Integer key, Integer value) {
            boolean found = false;
            for (Pair<Integer, Integer> p : this.bucket) {
                if (p.key.equals(key)) {
                    p.val = value;
                    found = true;
                }
            }
            if (!found) {
                this.bucket.add(new Pair<>(key, value));
            }
        }

        public void remove(Integer key) {
            for (Pair<Integer, Integer> p : this.bucket) {
                if (p.key.equals(key)) {
                    this.bucket.remove(p);
                    break;
                }
            }
        }
    }

    class MyHashMap {
        private int keySpace;
        private List<Bucket> hashTable;

        public MyHashMap() {
            this.keySpace = 2069;
            this.hashTable = new ArrayList<>();
            for (int i = 0; i < keySpace; i++) {
                this.hashTable.add(new Bucket());
            }
        }

        public void put(int key, int value) {
            int hashKey = key % this.keySpace;
            this.hashTable.get(hashKey).update(key, value);
        }

        public int get(int key) {
            int hashKey = key % this.keySpace;
            return this.hashTable.get(hashKey).get(key);
        }

        public void remove(int key) {
            int hashKey = key % this.keySpace;
            this.hashTable.get(hashKey).remove(key);
        }
    }

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
}
