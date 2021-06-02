package RevisitingConcepts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class RandomizedSet {
    static HashSet<Integer> uniqueValueSet = new HashSet<>();
    static List<Integer> listToGetTheRandomVal = new ArrayList<>();

    static Random rand = new Random();
    static int count = 0;

    public static void main(String[] args) {
        insert(1);
        remove(2);
        insert(2);
        System.out.println(getRandom());
        remove(1);
        insert(2);
        System.out.println(getRandom());

        for (int i = 0; i < 5000; i++) {
            System.out.println(getRandom());
        }
    }

    public static boolean insert(int val) {
        boolean isUniqueElement = uniqueValueSet.add(val);
        if (isUniqueElement) {
            listToGetTheRandomVal.add(val);
        }
        return isUniqueElement;
    }

    public static boolean remove(int val) {
        boolean isElementRemoved = uniqueValueSet.remove(val);
        if (isElementRemoved) {
            listToGetTheRandomVal.remove(Integer.valueOf(val));
        }
        return isElementRemoved;
    }

    //1,2,3,4
    public static int getRandom() {
        return listToGetTheRandomVal.get(rand.nextInt(listToGetTheRandomVal.size()));
    }
}
