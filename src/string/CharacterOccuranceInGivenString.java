package string;

import java.util.Map;
import java.util.TreeMap;

public class CharacterOccuranceInGivenString {

    public static void main(String[] args) {
        System.out.println(frequencyCalculator("acbeaeeewild"));

    }

    public static String frequencyCalculator(String input){
        String str="";
        TreeMap<Character,Integer> map = new TreeMap<Character,Integer>();
        for(int i =0; i<input.length();i++){
            Character c =input.charAt(i);
            if(map.containsKey(c)){
                int temp=map.get(c);
                temp=temp+1;
                map.put(c,temp);
            }

            else{
                map.put(c,1);
            }
        }

       for( Map.Entry<Character,Integer> entry : map.entrySet()){
           str=str+entry.getKey()+entry.getValue();
       }

       return str;
    }
}
