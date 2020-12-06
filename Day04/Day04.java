package Day04;



import Helper.Helper;

import java.util.ArrayList;

public class Day04 {
    private static Helper helper = new Helper();
    private static String file = "Day04\\input.txt";
    private static String [] keys = {"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
    private int validPassportsOne = 0;
    private int validPassportsTwo = 0;

    private void returnResults() {
        System.out.println("#####Day4.1#####");
        System.out.println("Valid passwords: " + validPassportsOne); //226
        System.out.println("#####Day4.2#####");
        System.out.println("Valid passwords: " + validPassportsTwo); //160
    }

    private void checkPassports(ArrayList<String> arr) {
        int countOfKeys= 0;
        int countOfMatches = 0;
        for (String s: arr) {
            String [] sArr =  s.split(" ");
            for (String ss:sArr) {
                for (String k : keys) {
                    if (ss.contains(k)) {
                        countOfKeys++;
                        countOfMatches = checkRules(ss,k,countOfMatches);
                        break;
                    }
                }
            }

            if (s.isEmpty() || arr.indexOf(s) == arr.size()-1) {
                if (countOfKeys >= keys.length) {
                    validPassportsOne++;
                }
                if (countOfMatches >= keys.length) {
                    validPassportsTwo++;
                }
                countOfKeys = 0;
                countOfMatches = 0;
            }
        }
    }

    private static int checkRules(String str, String key, int count) {
        switch (key) {
            case "byr":
                if(str.matches("byr:19[2-9][0-9]") || str.matches("byr:200[0-2]")) {
                   count++;
                }
                break;
            case "iyr":
                if (str.matches("iyr:201[0-9]") || str.matches("iyr:2020")) {
                    count++;
                }
                break;
            case "eyr":
                if (str.matches("eyr:202[0-9]") || str.matches("eyr:2030")) {
                    count++;
                }
                break;
            case "hgt":
                if (str.matches("hgt:59in") || str.matches("hgt:[6-7][0-9]in") || str.matches("hgt:1[5-8][0-9]cm") || str.matches("hgt:19[0-3]cm")) {
                    count++;
                }
                break;
            case "hcl":
                if (str.matches("hcl:#[0-9a-f]{6}")) {
                    count++;
                }
                break;
            case "ecl":
                if (str.matches("ecl:amb") || str.matches("ecl:blu") || str.matches("ecl:brn") || str.matches("ecl:gry") || str.matches("ecl:grn") || str.matches("ecl:hzl") || str.matches("ecl:oth")) {
                    count++;
                }
                break;
            case "pid":
                if (str.matches("pid:[0-9]{9}")) {
                    count++;
                }
                break;
        }
        return count;
    }
    public static void main(String [ ] args) {
        Day04 d4 = new Day04();
        ArrayList<String> data = helper.readFile(file);
        d4.checkPassports(data);
        d4.returnResults();
    }
}


