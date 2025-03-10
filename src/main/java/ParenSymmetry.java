import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class ParenSymmetry {

    public Boolean isBalanced(String s) {
        int numParens = 0;
        for (int i = 0; i <= (s.length() - 1); i++) {
            if (s.charAt(i) == '(') {
                numParens++;
            } else if (s.charAt(i) == ')') {
                numParens--;
            }
        }
        return numParens == 0;
        //return null;
    }

    public void checkFile(String filename) {
        try {
            File newFile = new File(filename);
            Scanner scanner = new Scanner(newFile);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(isBalanced(data));
            }
            scanner.close();
        } catch (FileNotFoundException e) {
        }
    }
        // open file named filename

        // for each line in the file
            // read the line
            // print whether or not the line's parenthesis are balanced

        // CLOSE the file


    public static void main(String[] args) {
        ParenSymmetry ps = new ParenSymmetry();

        ps.checkFile("TestStrings0.txt");

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


}
