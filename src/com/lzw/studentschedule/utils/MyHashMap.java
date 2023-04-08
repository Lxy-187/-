package com.lzw.studentschedule.utils;

public class MyHashMap<K,V> {
    private int size;
    private int DEFAULT_CAPACITY = 16;
    private Entry<K,V>[] table;

    public MyHashMap(){
        table = new Entry[DEFAULT_CAPACITY];
    }

    public void put(K key, V value){
        int hash = hash(key);
        Entry<K,V> newEntry = new Entry<K,V>(key, value, null);
        if(table[hash] == null){
            table[hash] = newEntry;
        }else{
            Entry<K,V> previous = null;
            Entry<K,V> current = table[hash];
            while(current != null){
                if(current.key.equals(key)){
                    if(previous == null){
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return;
                    }else{
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }

    public V get(K key){
        int hash = hash(key);
        if(table[hash] == null){
            return null;
        }else{
            Entry<K,V> temp = table[hash];
            while(temp != null){
                if(temp.key.equals(key)){
                    return temp.value;
                }
                temp = temp.next;
            }
            return null;
        }
    }

    public boolean remove(K key){
        int hash = hash(key);
        if(table[hash] == null){
            return false;
        }else{
            Entry<K,V> previous = null;
            Entry<K,V> current = table[hash];
            while(current != null){
                if(current.key.equals(key)){
                    if(previous == null){
                        table[hash] = table[hash].next;
                    }else{
                        previous.next = current.next;
                    }
                    return true;
                }
                previous = current;
                current = current.next;
            }
            return false;
        }
    }

    public int size(){
        return size;
    }

    private int hash(K key){
        return Math.abs(key.hashCode()) % DEFAULT_CAPACITY;
    }

    class Entry<K,V>{
        K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V value, Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}
