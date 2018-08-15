package com.Numerals;
import java.util.*;

public class Main {

    //init multiplier hashMap mM
    private static HashMap<Integer, Integer> multiplierMap = new HashMap<Integer, Integer>();
    private static HashMap<Integer, String> numeralMap = new HashMap<Integer, String>();

    public static void main(String[] args) {

        //fill multiplier hash map
        multiplierMap.put(1, 1);
        multiplierMap.put(2, 10);
        multiplierMap.put(3, 100);
        multiplierMap.put(4, 1000);
        multiplierMap.put(5, 10000);

        //fill numeral hash map
        numeralMap.put(1, "I");
        numeralMap.put(2, "II");
        numeralMap.put(3, "III");
        numeralMap.put(4, "IV");
        numeralMap.put(5, "V");
        numeralMap.put(6, "VI");
        numeralMap.put(7, "VII");
        numeralMap.put(8, "VIII");
        numeralMap.put(9, "IX");

        numeralMap.put(10, "X");
        numeralMap.put(20, "XX");
        numeralMap.put(30, "XXX");
        numeralMap.put(40, "XL");
        numeralMap.put(50, "L");
        numeralMap.put(60, "LX");
        numeralMap.put(70, "LXX");
        numeralMap.put(80, "LXXX");
        numeralMap.put(90, "XC");

        numeralMap.put(100, "C");
        numeralMap.put(200, "CC");
        numeralMap.put(300, "CCC");
        numeralMap.put(400, "CD");
        numeralMap.put(500, "D");
        numeralMap.put(600, "DC");
        numeralMap.put(700, "DCC");
        numeralMap.put(800, "DCCC");
        numeralMap.put(900, "CM");

        numeralMap.put(1000, "M");
        numeralMap.put(2000, "MM");
        numeralMap.put(3000, "MMM");
        numeralMap.put(4000, "MV");
        numeralMap.put(5000, "V");


        //new scanner object
        Scanner sc = new Scanner(System.in);

        //loop forever
        while(true){
            //prompt user for input
            System.out.println("Enter an Integer number to convert to Roman Numeral (Max 5000): ");

            //get the input as an int
            int number = sc.nextInt();

            if(number > 0 && number <= 5000) {
                //convert to numeral to print to console
                System.out.println(number + " = " + intToNumeral(number));
            }
            else{
                System.out.println("Value must be between 1 - 5000");
            }


        }


    }

    //method to convert integer number to numeral
    private static String intToNumeral(int number) {

        StringBuilder sb = new StringBuilder();
        List<Integer> splitNumberList = new ArrayList<Integer>();

        //split the number into digits
        while(number > 0)
        {
            splitNumberList.add(number % 10);
            number /= 10;
        }

        //reverse the list to get in correct order
        Collections.reverse(splitNumberList);

        //get number size, store for use in loop
        int size = splitNumberList.size();


        //loop through values,
        for (int i: splitNumberList) {
            if(i == 0){
                continue;
            }

            //get the multiplier value and get the value
            int multiplier = multiplierMap.get(size);
            int value = i * multiplier;

            //lookup corresponding numeral and append to stringbuilder object
            sb.append(numeralMap.get(value));
            //decrease the size variable
            size--;

        }

        //return the numeral string
        return sb.toString();
    }

}
