package dev.shtanko.multithreading.immutable_object;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Demo {
    public static void main(String[] args) {
        Map<String, String> h1 = new HashMap<>();
        h1.put("1", "first");
        h1.put("2", "second");

        String s = "original";

        int i = 10;

        ImmutableObject immutableObject = new ImmutableObject(i, s, h1);

        //Let's see whether its copy by field or reference
        System.out.println(Objects.equals(s, immutableObject.getName()));
        System.out.println(h1 == immutableObject.getTestMap());
        //print the ce values
        System.out.println("ce id:" + immutableObject.getId());
        System.out.println("ce name:" + immutableObject.getName());
        System.out.println("ce testMap:" + immutableObject.getTestMap());
        //change the local variable values
        i = 20;
        s = "modified";
        h1.put("3", "third");
        //print the values again
        System.out.println("ce id after local variable change:" + immutableObject.getId());
        System.out.println("ce name after local variable change:" + immutableObject.getName());
        System.out.println("ce testMap after local variable change:" + immutableObject.getTestMap());

        Map<String, String> hmTest = immutableObject.getTestMap();
        hmTest.put("4", "new");

        System.out.println("ce testMap after changing variable from accessor methods:" + immutableObject.getTestMap());
    }
}
