package officeprograms;


import java.io.BufferedReader;

import java.io.IOException;

import java.io.InputStreamReader;

import java.util.ArrayList;

import java.util.HashMap;

import java.util.List;

import java.util.Map;

public class HackerCup {

    static Map<Integer, Integer> patternMap = new HashMap<Integer, Integer>();

    static Map<Integer, Integer> stringMap = new HashMap<Integer, Integer>();

    public static void checkHackerCup(String str, int line) {

        int count = Integer.MAX_VALUE;

        for (int i = 0; i < str.length(); i++) {

            if (stringMap.get(new Integer(str.charAt(i))) != null) {

            stringMap.put(new Integer(str.charAt(i)),

            stringMap.get(new Integer(str.charAt(i))) + 1);

            }else{

            stringMap.put(new Integer(str.charAt(i)),1);

            }

        }

        for (Map.Entry<Integer, Integer> entry : patternMap.entrySet()) {

            if (stringMap.get(entry.getKey()) == null || stringMap.get(entry.getKey()).intValue() == 0){

                count = 0;

                break ;

            }else{

                count = Math.min(count, stringMap.get(entry.getKey()).intValue()/(patternMap.get(entry.getKey())));

            }

        }
        
        System.out.println("Case " + line + " # " + count);

        stringMap.clear();

    }



    public static void main(String[] args) throws IOException {

        BufferedReader bufferRead = new BufferedReader(new InputStreamReader(

                System.in));

        String s = bufferRead.readLine();

        int num = Integer.parseInt(s);

        List<String> stringList = new ArrayList<String>();

        for (int i = 0; i < num; i++) {

            stringList.add(bufferRead.readLine());

        }

        String strCup = "HACKERCUP";

        for (int i = 0; i < strCup.length(); i++) {

        if(patternMap.get(strCup.charAt(i)) != null)

        patternMap.put(new Integer(strCup.charAt(i)),patternMap.get(new Integer(strCup.charAt(i))) + 1 );

        else

        patternMap.put(new Integer(strCup.charAt(i)), 1);

        }

        for (int i = 0; i < stringList.size(); i++) {

            checkHackerCup(stringList.get(i), i + 1);

        }

    }



}