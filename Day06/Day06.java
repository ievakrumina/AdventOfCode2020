package Day06;

import Helper.Helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Day06 {
    private static Helper helper = new Helper();
    private static String file = "Day06\\input.txt";
    private int countOfUniqueAnswers = 0;
    private int countOfGroupAnswers = 0;

    private void returnResults() {
        System.out.println("#####Day6.1#####");
        System.out.println("Count of answers: " + countOfUniqueAnswers); //6596
        System.out.println("#####Day6.2#####");
        System.out.println("Count of answers: " + countOfGroupAnswers); //3219
    }

    private void calculateAnswers(ArrayList<String> arr) {
        HashMap<String,Integer> answers = new HashMap<String, Integer>();
        int persons = 0;
        for (String str:arr) {
            if (str.isEmpty()) {
                countOfUniqueAnswers += answers.size();
                for (Map.Entry element:answers.entrySet()) {
                    if ((int) element.getValue() ==  persons) {
                        countOfGroupAnswers ++;
                    }
                }
                answers.clear();
                persons = 0;
            } else {
                persons ++;
                for (int i=0; i < str.length(); i++){
                    String letter = String.valueOf(str.charAt(i));
                    if (answers.containsKey(letter)) {
                        answers.put(letter, answers.get(letter)+1);
                    } else {
                        answers.put(letter,1);
                    }
                }
            }
        }
        countOfUniqueAnswers +=answers.size();
        for (Map.Entry element:answers.entrySet()) {
            if ((int) element.getValue() == persons) {
                countOfGroupAnswers++;
            }
        }
    }

    public static void main(String [ ] args) {
        Day06 d6 = new Day06();
        ArrayList<String> data = helper.readFile(file);
        d6.calculateAnswers(data);
        d6.returnResults();
    }
}
