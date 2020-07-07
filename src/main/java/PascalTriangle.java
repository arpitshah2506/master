import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        System.out.println(generatePascal(2));
    }

    private static List<List<Integer>> generatePascal(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>(numRows);
        if (numRows >= 1)
        {
            pascal.add(new ArrayList<Integer>(){{add(1);}});;
        }
        if (numRows >= 2)
        {
            pascal.add(new ArrayList<Integer>(){{add(1);add(1);}});
        }
        for (int index = 2; index < numRows; index++)
        {
            List<Integer> onEachItr = new ArrayList<>();
            onEachItr.add(1);
            int count = 0;
            while (count < pascal.get(index - 1).size() - 1)
            {
                onEachItr.add(pascal.get(index - 1).get(count) + pascal.get(index - 1).get(count + 1));
                count = count + 1;
            }
            onEachItr.add(1);
            pascal.add(onEachItr);
        }
        return pascal;
    }
}
