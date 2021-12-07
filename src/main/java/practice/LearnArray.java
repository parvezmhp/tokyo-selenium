package practice;

import java.util.ArrayList;
import java.util.List;

//Name of all the states
public class LearnArray {
//    public void stringArray () {
//        String [] stateName = {"FL", "NY", "PA", "DL"};
//           for (int x=2; x<stateName.length; x++) {
//            System.out.println("Name of the state is: "+stateName[x]);
//        }
//           for (String state : stateName) {
//            System.out.println("Name of the state is: "+ state);
//           }

    public void listArray() {
        List<String> lists = new ArrayList<>();

        lists.add("Robin");
        lists.add("Calvin");
        lists.add("Samir");
        System.out.println(lists);

//for (String list : lists) {
//    System.out.println("Print value of list is :" + list);

//        for (int i = 0; i < lists.size(); i++) {
//            System.out.println("Value  is :" + lists.get(i));
//        }
        lists.remove("Robin");
        lists.add("Kyra");
//        System.out.println(lists);
    for(String list : lists);
    System.out.println("Name is :" + lists);

    }
}




