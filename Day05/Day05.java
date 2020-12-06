package Day05;

import Helper.Helper;

import java.util.ArrayList;
import java.util.Collections;

public class Day05 {

    private static Helper helper = new Helper();
    private static String file = "Day05\\input.txt";
    private int maxSeat = 0;
    private int mySeat = 0;
    private static ArrayList<Integer> seatId = new ArrayList<Integer>();

    private void returnResults() {
        System.out.println("#####Day5.1#####");
        System.out.println("Max seat nr: " + maxSeat); //991
        System.out.println("#####Day5.2#####");
        System.out.println("my seat: " + mySeat); //534
    }

    private void calculateSeat(ArrayList<String> arr) {
        int curSeat = 0;
        for (String s: arr) {
            double [] minMaxRow = {0.0, 127.0};
            double [] minMaxCol = {0.0, 7.0};
            for (int i = 0; i < s.length(); i++) {
                String str = String.valueOf(s.charAt(i));
                if (str.equals("F") || str.equals("B")) {
                   minMaxRow = calculateRow(minMaxRow, str);
                } else {
                    minMaxCol = calculateColumn(minMaxCol, str);
                }
            }
            curSeat = (int)minMaxRow[0] * 8 + (int) minMaxCol[0];
            seatId.add(curSeat);
            if (curSeat > maxSeat) {
                maxSeat = curSeat;
            }
        }
    }

    private void calculateMySeat() {
        Collections.sort(seatId);
        for (int i = 0; i<seatId.size()-1; i++) {
            if (seatId.get(i) == seatId.get(i+1)-2) {
                mySeat = seatId.get(i) +1;
                break;
            }
        }
    }

    private static double [] calculateRow(double [] minMax, String letter) {
        double [] result = minMax;
        if (letter.equals("F")) {
           result[1] = Math.floor((result[1] + result[0])/ 2);
        } else if (letter.equals("B")) {
            result[0] =  Math.ceil((result[1] + result[0]) /2);
        } else {
            System.out.println("Invalid character");
        }
        return result;
    }

    private static double [] calculateColumn(double [] minMax, String letter) {
        double [] result = minMax;
        if (letter.equals("L")) {
            result[1] = Math.floor((result[1] + result[0]) / 2);
        } else if (letter.equals("R")) {
            result[0] =  Math.ceil((result[1] + result[0]) /2);
        } else {
            System.out.println("Invalid character");
        }
        return result;
    }

    public static void main(String [ ] args) {
        Day05 d5 = new Day05();
        ArrayList<String> data = helper.readFile(file);
        d5.calculateSeat(data);
        d5.calculateMySeat();
        d5.returnResults();

    }
}
