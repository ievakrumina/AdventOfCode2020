package Day03;

import Helper.Helper;
import java.util.*;

public class Day03 {
    private static Helper helper = new Helper();
    private static String file = "Day03\\input.txt";
    private int [] treeCount = new int[5];
    private int [] lastPos = {0,0,0,0,0};
    private static String tree = "#";

    private void returnResults() {
        System.out.println("#####Day3.1#####");
        System.out.println("Tree count: " + treeCount[1]); //240
        System.out.println("#####Day3.2#####");
        long result =1;
        for (int num:treeCount){
            result = result * num;
        }
        System.out.println("Multiply trees: " + result); //2832009600
    }

    private void slideThroughMap(ArrayList<String> arr) {
        arr.remove(0);
        for (String a:arr) {
            checkTreeInRow(a, 1, 0);
            checkTreeInRow(a, 3, 1);
            checkTreeInRow(a, 5, 2);
            checkTreeInRow(a, 7, 3);
        }
        arr.remove(0);
        for (int i = 0 ; i < arr.size(); i = i+2) {
            checkTreeInRow(arr.get(i), 1,4);
        }
    }


    private void checkTreeInRow(String str, int step, int sled) {
        int len = str.length();
        int pos = lastPos[sled];
        pos = pos + step;
        System.out.println(lastPos[sled]);
        if (pos > len -1) {
            pos = pos - len;
        }
        if (pos == len) {
            pos = pos - 1;
        }
        lastPos[sled] = pos;
        String s = String.valueOf(str.charAt(pos));
        if (s.equals(tree)) {
            treeCount[sled]++;
        }
    }


    public static void main (String [] args) {
        Day03 d3 = new Day03();
        ArrayList<String> map = helper.readFile(file);
        d3.slideThroughMap(map);
        d3.returnResults();
    }

}

