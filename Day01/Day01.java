package Day01;

import Helper.Helper;
import java.util.*;

class Day01 {

  private static Helper helper = new Helper();
  private static String file = "Day01\\input.txt";
  private final static int matchNumber = 2020;
  private int resOne;
  private int resTwo;


  private void returnResults() {
    System.out.println("#####Day1.1#####");
    System.out.println("Multiply two: " + resOne); //299299
    System.out.println("#####Day1.2#####");
    System.out.println("Multiply three: " + resTwo); //287730716
  }

  private void elementResult(ArrayList<String> arr, int sum) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.size(); i++) {
      int y = Integer.parseInt(arr.get(i));
      int x = sum - y;
      if (map.containsKey(x)) {
        resOne = x * y;
      }
      map.put(y,i);
    }
    for (int i = 0; i<arr.size() -1; i++ ) {
      for ( int j = i + 1; j < arr.size(); j++ ) {
        int y = Integer.parseInt(arr.get(i));
        int z = Integer.parseInt(arr.get(j));
        int x = sum - (y + z);
        if (map.containsKey(x) && (map.get(x) != i) && (map.get(x) != j)) {
          resTwo = x * y * z;
          break;
        }
      }
    }
  }

  public static void main (String [] args) {
    Day01 d1 = new Day01();
    ArrayList<String> data = helper.readFile(file);
    d1.elementResult(data, matchNumber);
    d1.returnResults();
  }
}
