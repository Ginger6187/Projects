package com.company;

import java.util.Scanner;
class Calc{
public static void main(String[]args){
    Scanner scanner = new Scanner(System.in);
    String str = scanner.nextLine();
    str = str.replaceAll(" ", "");
    Cut cut = new Cut();
    String op ="\\"+ cut.nameOfoOper(str);
    String [] numbers  = cut.cutting(str,op);

    Convertation convertation = new Convertation();
    convertation.numToInt(numbers);
    Operations operations = new Operations();
    operations.Calculate(convertation.result1, convertation.result2, cut.nameOfoOper(str));
    ArrayToRomanResult arrayToRomanResult = new ArrayToRomanResult();



    if (convertation.index == 2){


        System.out.println(arrayToRomanResult.romanNumb[operations.result -1 ]);
    }
    else
        System.out.println(operations.result);






}
        }
 class Cut{

    public String nameOfoOper(String s){
        String[] operation={"+","-","*","/"};
        String oper="";
        boolean flag = false;
        int k = 0;
        for(int i = 0; i<=operation.length - 1; i++ ){
            if (s.contains(operation[i])) {
                oper = operation[i];
                k++;
                flag = true;

            }
        }
        if (!flag)
            throw new ArrayStoreException("Необходимо ввести операцию(+-*/");
        if (k>1)
            throw new ArrayStoreException("Можно использовать не больше двух чисел!");

        return oper;

    }
    public String [] cutting(String str, String op){
        String [] numbers;
        numbers = str.split(op);


        return numbers;

    }

 }
class Convertation{

    int result1;
    int result2;
    int index;

    public void numToInt(String[] str1){
        String [] arab = {"1","2","3","4","5","6","7","8","9","10"};
        String [] rome = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        String number1 = str1[0];
        String number2 = str1[1];



        for (int i = 0; i < arab.length; i++ )
            if (number1.equals(arab[i])) {
                 result1 = i + 1;
            }
        for (int i = 0; i < arab.length; i++ )
            if (number2.equals(arab[i])) {
                result2 = i + 1;
            }
        for (int i = 0; i < rome.length; i++ )
            if (number1.equals(rome[i])) {
                result1 = i + 1;
                index++;

            }
        for (int i = 0; i < rome.length; i++ )
            if (number2.equals(rome[i])) {
                result2 = i + 1;
                index++;
            }
        if(index==1){
            throw new ArrayStoreException("Оба числа должны быть арабскими, или римскими!");
        }



    }
}
class Operations{
     int result;

    public void Calculate(int num1, int num2, String oper){

        switch (oper) {
            case "+" -> result = num1 + num2;
            case "-" -> result = num1 - num2;
            case "*" -> result = num1 * num2;
            case "/" -> result = num1 / num2;
        }


    }

}
class ArrayToRomanResult{
    String [] romanNumb={"I","II","III","IV","V","VI","VII","VIII","IX","X",
            "XI","XII","XIII","XIV","XV","XVI","XVII","XVIII","XIX","XX",
            "XXI","XXII","XXIII","XXIV","XXV","XXVI","XXVII","XXVIII","XXIX","XXX",
            "XXXI","XXXII","XXXIII","XXXIV","XXXV","XXXVI","XXXVII","XXXVIII","XXXIX","XL",
            "XLI","XLII","XLIII","XLIV","XLV","XLVI","XLVII","XLVIII","XLIX","L",
            "LI","LII","LIII","LIV","LV","LVI","LVII","LVIII","LIX","LX",
            "LXI","LXII","LXIII","LXIV","LXV","LXVI","LXVII","LXVIII","LXIX","LXX",
            "LXXI","LXXII","LXXIII","LXXIV","LXXV","LXXVI","LXXVII","LXXIII","LXXIX","LXXX",
            "LXXXI","LXXXII","LXXXIII","LXXXIV","LXXXV","LXXXVI","LXXXVII","LXXXVIII","LXXXIX","XC",
            "XCI","XCII","XCIII","XCIV","XCV","XCVI","XCVII","XCVIII","XCIX","C"};
}