import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {
        String s = "abc";
        String s1 = new String("abc");

        System.out.println(s == s1);
        s1 = s1.intern();

        System.out.println(s == s1);

        Child child = new Child();

        Integer i = new Integer(10);
        Integer j = new Integer(20);

        swap(i, j);

        System.out.println(i + " " + j);

        int i1 = 10;
        int j2 = 20;

        swap(i1, j2);

        System.out.println(i1 + " " + j2);

        /*System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));*/
    }

    private static void swap(Integer i, Integer j) {
        Integer temp = new Integer(i);
        i = j;
        j = temp;
    }

    private static void swap(int i,int j) {
        int temp = i;
        i = j;
        j = temp;
    }

/*    private static List<List<String>> groupAnagrams(String[] strs) {
        Arrays.sort(strs, (o1, o2) -> 0ve1);
        return null;
    }*/
}

class Parent {
    Parent(int i) {
        System.out.println("hello");
    }
}

class Child extends Parent{
    Child() {
        super(10);
        System.out.println("hello child");
    }
}