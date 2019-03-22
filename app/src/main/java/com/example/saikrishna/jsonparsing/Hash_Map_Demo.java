package com.example.saikrishna.jsonparsing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Hash_Map_Demo {
    public static void main(String[] args)
    {

        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("11111");
        stringArrayList.add("22222");
        stringArrayList.add("33333");
        stringArrayList.add("44444");
        stringArrayList.add("55555");
        stringArrayList.add("66666");

       // System.out.println("Initial Mappings are: " + stringArrayList.set(3,"232323"));
       // System.out.println("Initial Mappings are: " + stringArrayList);

        // Creating an empty HashMap
        HashMap<String, Integer> hash_map = new HashMap<String, Integer>();

        // Mapping int values to string keys
        hash_map.put("aa", 10);
        hash_map.put("wbba", 15);
        hash_map.put("sccb", 20);
        hash_map.put("rddc", 25);
        hash_map.put("oeed", 30);
        for (String key : hash_map.keySet()) {
            System.out.println("Key: " + key + ", Value: " + hash_map.get(key));
            if(key.equalsIgnoreCase("wbba"))
            {
                System.out.println("Key1: " + key );
            }
        }


        // Displaying the HashMap
        //System.out.println("Initial Mappings are: " + hash_map);

        // Using keySet() to get the set view of keys


       /* Iterator<Map.Entry<String, Integer>> entries = hash_map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Integer> entry = entries.next();
           // System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }*/


    }
}
