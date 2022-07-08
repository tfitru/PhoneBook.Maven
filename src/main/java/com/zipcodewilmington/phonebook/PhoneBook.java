package com.zipcodewilmington.phonebook;

import java.lang.reflect.Array;
import java.util.*;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private String name = "";
    private String phoneNumber;



    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this(new LinkedHashMap<>());
    }

    public void add(String name, String phoneNumber) {
        this.phonebook.put(name, Collections.singletonList(phoneNumber));

    }

    public void addAll(String name, String... phoneNumbers) {
        // put
//        LinkedHashMap<String, List<String>> map2 = new LinkedHashMap<>();
//        map2.put(name, Arrays.asList(phoneNumbers));
        this.phonebook.put(name, new ArrayList<>(Arrays.asList(phoneNumbers)));
//        System.out.println(map2);
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return this.phonebook.containsKey(name);
    }

    public Boolean hasEntry(String name, String phoneNumber) {
        if(this.phonebook.containsKey(name) && this.phonebook.containsValue(Collections.singletonList(phoneNumber))){
            return true;
        } else
        return false;
    }

    public List<String> lookup(String name) {
        return new ArrayList<>(this.phonebook.get(name));
    }

    public String reverseLookup(String phoneNumber)  {
        Map<List<String>, String> inverseMap = new HashMap<>();
        for(Map.Entry<String, List<String>> entry : this.phonebook.entrySet()){
            inverseMap.put(entry.getValue(), entry.getKey());
        }

        // ReverseLook


        return inverseMap.get(Collections.singletonList(phoneNumber));
    }

//    String[] names = new String[]{"John", "Joe", "Jim", "Jay"};
//        for (int i = 0; i < names.length; i++) {
//        String name = names[i];
//        phoneBook.add(name, "");
//    }

    public List<String> getAllContactNames() {
            List<String> getAll = new ArrayList<>(this.phonebook.keySet());

        return getAll;
    }

    public Map<String, List<String>> getMap() {
        return phonebook;
    }
}
