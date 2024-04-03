package module2;


import java.util.Map;
import java.util.stream.Collectors;

import java.util.*;

public class Module2 {
    public static Map dictinary(String str) {
        int quantity = 1;
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (hashMap.containsKey(str.charAt(i))) {
                hashMap.replace(str.charAt(i), (hashMap.get(str.charAt(i)) + 1));
            } else {
                hashMap.put(str.charAt(i), quantity);
            }
        }
        return hashMap;
    }

    public static HashSet<String> noDuplicates(Object... arg) {
        HashSet<String> hashSet = new HashSet<String>();
        for (Object i : arg) {
            String b = String.valueOf(i);
            hashSet.add(b);
        }
        return hashSet;
    }

    public static <К, V> HashMap reverseMap(HashMap map){
        HashMap newMap = new HashMap<>();
        map.forEach((key, values) -> {
            if( newMap.containsKey(values)) {
               List l = new ArrayList<>();
               l.add(newMap.get(values));
               l.add(key);
               newMap.replace(values, l);
            }
            else {
                List keyList = new ArrayList<>();
                keyList.add(key);
                newMap.put(values, keyList);
            }
        });
    return newMap;
    }

    //цей взяв з інтернету...
    public static Map<Integer, List<String>> reverseMap2(HashMap map2){
        Map<String, Integer> map = new HashMap<>();
        map.put("a",1);
        map.put("b",2);
        map.put("c",2);
        map.put("d",2);

        Map<Integer, List<String>> mapInversed =
                map.entrySet()
                        .stream()
                        .collect(Collectors.groupingBy(Map.Entry::getValue, Collectors.mapping(Map.Entry::getKey, Collectors.toList())));
        return mapInversed;
    }

    public static void printOrder(String[] array){
        HashSet hashSet = new HashSet();
        for (String str : array) {
            hashSet.add(str);
        }
        System.out.println(hashSet);

        TreeSet treeSet = new TreeSet();
        for (String str : array) {
            treeSet.add(str);
        }
        System.out.println(treeSet);
    }

    public static Map sortMapV1(ArrayList keyList, ArrayList valueList){
        Map treeMap = new TreeMap<>();
        if (keyList.size()>valueList.size()){
            for (int i = 0; i < keyList.size(); i++) {
                treeMap.put(keyList.get(i), null);
            }
        }
        else {
            for (int i = 0; i < keyList.size(); i++) {
                treeMap.put(keyList.get(i), valueList.get(i));
            }
        }
        return treeMap;
    }

    public static Map sortMapV2(ArrayList keyList, ArrayList valueList) throws Exception{
        Map treeMap = new TreeMap<>();
        if (keyList.size()>valueList.size()){
          throw new Exception("Value is not enough for map");
        }
        else if (keyList.size()<valueList.size()) {
            throw new Exception("Key is not enough for map");
        }
        else {
            for (int i = 0; i < keyList.size(); i++) {
                treeMap.put(keyList.get(i), valueList.get(i));
            }
        }
        return treeMap;
    }


    public static void main(String[] args) throws Exception {
        System.out.println(dictinary("asd ddsda asd 1 sdacxAA"));
        System.out.println();

        HashSet<String> hashSet = noDuplicates("asd", 1, "23", "asd", 1, 2);
        System.out.println(hashSet);
        System.out.println();

        HashMap hashMap = new HashMap();
        hashMap.put(1,"ads");
        hashMap.put(2,"qwe");
        hashMap.put(3,"ads");
        hashMap.put("asd",1);
        hashMap.put("asd",1);
        hashMap.put(9,"zxc");
        System.out.println(reverseMap(hashMap));
        System.out.println(reverseMap2(hashMap));
        System.out.println();

        String array[]= {"Order1", "Order2","Order2","Order3", "Order3", "Order3"};
        printOrder(array);
        System.out.println();

        ArrayList firstList = new ArrayList<>(Arrays.asList("xyz", "abcd", "ert", "bad"));
        ArrayList secondList = new ArrayList<>(Arrays.asList("xyz", "abc","t"));
        ArrayList thirdList = new ArrayList<>(Arrays.asList(1, 2,  5));
        ArrayList fourthList = new ArrayList<>(Arrays.asList(1, 3, 4));

        System.out.println(sortMapV1(firstList, secondList));
        System.out.println(sortMapV1(secondList, firstList));
        System.out.println(sortMapV1(thirdList, fourthList));
        try {
            System.out.println(sortMapV2(firstList, secondList));
            System.out.println(sortMapV2(secondList, firstList));
            System.out.println(sortMapV2(thirdList, fourthList));
        } catch (Exception e) {
            System.out.println("message: " + e);
        }
        try {
            System.out.println(sortMapV2(secondList, firstList));
            System.out.println(sortMapV2(thirdList, fourthList));
        } catch (Exception e) {
            System.out.println("message: " + e);
        }
        try {

            System.out.println(sortMapV2(thirdList, fourthList));
        } catch (Exception e) {
            System.out.println("message: " + e);
        }

        
        }
    }
