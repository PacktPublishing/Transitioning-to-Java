package com.kenfogel.arraysandcollections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * A simple example of the HashMap
 *
 * @author Ken Fogel
 */
public class HashMapExample {

    public void perform() {
        // Declare a HashMap using generic notation
        Map<Integer, Integer> hashMap = new HashMap<>();

        hashMap.put(6, 6);
        hashMap.put(5, 4);
        hashMap.put(4, 8);
        hashMap.put(3, 10);
        hashMap.put(2, 6);

        // Display value based on the key
        System.out.printf("%s%n", hashMap.get(4));
        /*
         * The result for this get will be null because there is no key with a
         * value of 1
         */
        System.out.printf("%s%n", hashMap.get(1));

        /*
         * The key value must be unique. This allows us to retrieve all the keys
         * using the entrySet method of the collection into a Set object and
         * then iterate through the set and use the return value as the key into
         * the map. The Set is order based on the value or hashCode of the key
         * value.
         *
         */
        Set s = hashMap.entrySet();

        // create an iterator
        Iterator it = s.iterator();

        // iterate and print the mappings
        while (it.hasNext()) {
            System.out.printf("%s%n", it.next());
        }
    }

    public static void main(String[] args) {
        new HashMapExample().perform();
    }

}
