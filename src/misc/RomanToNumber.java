package misc;

import java.util.HashMap;

public class RomanToNumber {

    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));
    }

        public static int romanToInt(String s) {

            int number=0;

            HashMap<Character, Integer> map = new HashMap<Character,Integer>();
            map.put('I',1);
            map.put('V',5);
            map.put('X',10);
            map.put('L',50);
            map.put('C',100);
            map.put('D',500);
            map.put('M',1000);

            for (int i=0; i<s.length();i++){
                if (s.charAt(i)=='V')
                {
                    if(i>0&&s.charAt(i-1)=='I' ){
                        number=number-map.get(s.charAt(i-1));
                        number = number +4;


                    }
                    else{
                        number=number+map.get(s.charAt(i));
                    }
                }

                else if (s.charAt(i)=='X')
                {
                    if(i>0&& s.charAt(i-1)=='I' ){
                        number=number-map.get(s.charAt(i-1));
                        number = number +9;
                    }
                    else{
                        number=number+map.get(s.charAt(i));
                    }

                }


                else if (s.charAt(i)=='L')
                {
                    if(i>0&& s.charAt(i-1)=='X' ){
                        number=number-map.get(s.charAt(i-1));
                        number = number +40;
                    }
                    else{
                        number=number+map.get(s.charAt(i));
                    }

                }

                else if (s.charAt(i)=='C')
                {
                    if(i>0&& s.charAt(i-1)=='X' ){
                        number=number-map.get(s.charAt(i-1));
                        number = number +90;
                    }
                    else{
                        number=number+map.get(s.charAt(i));
                    }

                }

                else if (s.charAt(i)=='D')
                {
                    if(i>0&& s.charAt(i-1)=='C' ){
                        number=number-map.get(s.charAt(i-1));
                        number = number +400;
                    }
                    else{
                        number=number+map.get(s.charAt(i));
                    }

                }

               else if (s.charAt(i)=='M')
                {
                    if(i>0&& s.charAt(i-1)=='C' ){
                        number=number-map.get(s.charAt(i-1));
                        number = number +900;
                    }
                    else{
                        number=number+map.get(s.charAt(i));
                    }

                }

                else{
                    number=number+map.get(s.charAt(i));
                }


            }

            return number;
        }

}
