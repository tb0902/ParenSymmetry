
package src.main.java;
import java.io.*;
import java.util.Scanner;


public class ParenSymmetry {


    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();


        Boolean b0 = ps.isBalanced("()");
        printResult(b0, true);


        String[] falseStrings = {"(", "((", ")", "", "(()())((())))"};
        Boolean falses = true;
        for (String strToTest : falseStrings) {
            falses = ps.isBalanced(strToTest);
        }
        printResult(falses, false);


        String[] trueStrings = {"()", "(())", "(((())))", "", "(()())((()))", "(   )", "( () ( ) )"};
        Boolean trues = false;
        for (String strToTest : trueStrings) {
            trues = ps.isBalanced(strToTest);
        }
        printResult(trues, true);

        ps.checkFile("TestStrings0.txt");
    }

    private static void printResult(Boolean b0, boolean b) {
        if (b0 == null) {
            System.out.println("Null Failure");
            return;
        }
        if (b0 == b) {
            System.out.println("Success");
        } else {
            System.out.println("Failure");
        }
    }

    private Boolean isBalanced(String s) {
        int counter = 0; //makes a counter and sets it to 0
        for (char ch : s.toCharArray()) //goes through each char in the loop
            if (s.toCharArray()[0] == ')') { //if the string begins with an open parenthesis its false immediately
                return false;
            } else if (ch == '(') {
                counter++; // counter will increase as it sees a left paren
            } else if (ch == ')') {
                counter--; // counter will decrease as it sees a right paren
            }
        if (counter < 0) { // for that reason it SHOULD be 0 at the end of the loop
            return false;
        }
        return counter == 0;
    }


    private void checkFile(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            while (scanner.hasNext())
                System.out.println(isBalanced(scanner.nextLine()));
// Prints out the outcome of isBalanced from the next line beginning at the files start, 0
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}