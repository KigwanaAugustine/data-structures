package HashTables;

import java.util.LinkedList;

public class HashTable {
    public int capacity;
    public LinkedList<Entry>[] entries;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.entries = new LinkedList[capacity];
    }

    public void put(int key , String value){
        var entry = getEntry(key);

        if (entry != null) {
            entry.value = value;
            return;
        }

        getOrCreateBucket(key).add(new Entry(key, value));        
    }

    public void remove(int key){
        var entry = getEntry(key);
        
        if (entry == null)
            throw new IllegalStateException("No value exists for this key");
        
        getBucket(key).remove(entry);
    }

    public String get(int key){
        var entry = getEntry(key);
        return entry == null ? null : entry.value;
    }

    public LinkedList<Entry> getBucket(int key){
        return entries[hash(key)];
    }

    public LinkedList<Entry> getOrCreateBucket(int key){
       int index = hash(key);
       var bucket = entries[index];
       if (bucket == null) 
        entries[index] = new LinkedList<>();
        
       return bucket;
    }

    public int hash(int key){
        return key % capacity;
    }

    private Entry getEntry(int key){
        var bucket = getBucket(key);

        if(bucket != null){
            for (var entry : bucket) {
                if (entry.key == key) 
                   return entry;
            }
        }

        return null;
    }

    private class Entry{
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
    
}
