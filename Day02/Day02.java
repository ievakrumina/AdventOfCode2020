package Day02;

import Helper.Helper;
import java.util.*;

public class Day02 {

  private static Helper helper = new Helper();
  private int countOfValidPwdOne = 0;
  private int countOfValidPwdTwo = 0;
  private static String file = "Day02\\input.txt";

  private void returnResults() {
    System.out.println("#####Day2.1#####");
    System.out.println("Valid password count: " + countOfValidPwdOne); //564
    System.out.println("#####Day2.2#####");
    System.out.println("Valid password count: " + countOfValidPwdTwo); //325
  }

  private void checkInputData(ArrayList<String> arrList) {
    for (String s:arrList) {
      checkIfValidOne(s);
      checkIfValidTwo(s);
    }
    returnResults();
  }

  private void checkIfValidOne(String str) {
    String [] strArr = str.split("\\s+|-|:");
    int min = Integer.parseInt(strArr[0]);
    int max = Integer.parseInt(strArr[1]);
    char letter = strArr[2].charAt(0);
    String pwd = strArr[4];
    int countOfLetter = 0;

    for (int i = 0; i<pwd.length(); i++) {
      if (pwd.charAt(i) == letter) {
        countOfLetter++;
      }
    }

    if ( (countOfLetter >= min) && (countOfLetter <= max)) {
      countOfValidPwdOne++;
    }
  }

  private void checkIfValidTwo(String str) {
    String [] strArr = str.split("\\s+|-|:");
    int min = Integer.parseInt(strArr[0]) -1;
    int max = Integer.parseInt(strArr[1]) -1;
    char letter = strArr[2].charAt(0);
    String pwd = strArr[4];
    if (((pwd.charAt(min) == letter) && !(pwd.charAt(max) == letter)) || ((pwd.charAt(max) == letter) && !(pwd.charAt(min) == letter))){
      countOfValidPwdTwo++;
    }
  }

  public static void main(String [] args) {
    Day02 pwd = new Day02();
    ArrayList<String> passwordHint = helper.readFile(file);
    pwd.checkInputData(passwordHint);
  }
}
