package main;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1,"odin");
        hm.put(2,"dva");
        hm.put(3,"tre");
        //hm.put(2,"chetire");
        //hm.put(2,"dva");
        hm.put(5,"pyat");
        System.out.println(hm);
    }
}
