package RevisitingConcepts;

import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        asteroidCollision(new int[]{1,-2,-2}); //3, 2, -5 //5, 2, -5
        //asteroidCollision(new int[]{5, 2, -5});
    }

    private static void asteroidCollision(int[] asteroids) {
        Stack<Integer> asteroidStack = new Stack<>();
        int[] nums;
        boolean needToInsertAfterAllCollision = false;

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] < 0 && asteroidStack.size() > 0 && asteroidStack.peek() > 0) {
                while (asteroidStack.size() > 0 && asteroidStack.peek() > 0) {
                    if (asteroidStack.peek() < Math.abs(asteroids[i])) {
                        needToInsertAfterAllCollision = true;
                        asteroidStack.pop();
                    } else if (asteroidStack.peek() == Math.abs(asteroids[i])) {
                        needToInsertAfterAllCollision = false;
                        asteroidStack.pop();
                        break;
                    }
                }
                if (needToInsertAfterAllCollision) {
                    asteroidStack.push(asteroids[i]);
                }
            } else {
                asteroidStack.push(asteroids[i]);
            }
        }

        nums = new int[asteroidStack.size()];
        for (int i = 0; i < asteroidStack.size(); i++) {
            nums[i] = asteroidStack.get(i);
        }

        for (int j = 0; j < asteroidStack.size(); j++) {
            System.out.println(asteroidStack.get(j));
        }
    }
}
