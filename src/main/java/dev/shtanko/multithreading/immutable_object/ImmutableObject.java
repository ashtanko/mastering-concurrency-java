package dev.shtanko.multithreading.immutable_object;

import java.util.HashMap;
import java.util.Iterator;

public final class ImmutableObject {
    private final int id;

    private final String name;

    private final HashMap<String, String> testMap;

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    /**
     * Accessor function for mutable objects
     */
    public HashMap<String, String> getTestMap() {
        //return testMap;
        return (HashMap<String, String>) testMap.clone();
    }

    /**
     * Constructor performing Deep Copy
     *
     * @param i  id
     * @param n  name
     * @param hm map
     */

    public ImmutableObject(int i, String n, HashMap<String, String> hm) {
        System.out.println("Performing Deep Copy for Object initialization");
        this.id = i;
        this.name = n;
        HashMap<String, String> tempMap = new HashMap<String, String>();
        String key;
        Iterator<String> it = hm.keySet().iterator();
        while (it.hasNext()) {
            key = it.next();
            tempMap.put(key, hm.get(key));
        }
        this.testMap = tempMap;
    }

    public ImmutableObject(int i, String n, HashMap<String, String> hm, boolean sc) {
        System.out.println("Performing Shallow Copy for Object initialization");
        this.id = i;
        this.name = n;
        this.testMap = hm;
    }
}
