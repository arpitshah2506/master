import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class testMemory {
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{3,2,3}));
        moveZeros(new int[]{1});

        int[] ints = twoSum(new int[]{1, 2, 3, 4}, 6);
        System.out.println(ints[0] + " " + ints[1]);

        int[] result = twoSumInputArrayIsSorted(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 6);
        System.out.println(result[0] + " " + result[1]);

        System.out.println(kadaneAlgo(new int[]{1,2,3,4,5,6}));

        System.out.println(kadaneAlgoWithNegativeNumber(new int[]{1,2,3,-2,3,2,-1}));

        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = node.next;

        System.out.println(loopHasCycle(node));

        LRUCache cache = new LRUCache(3);
        lru(cache);

        System.out.println(search(new int[]{-1,0,3,5,9,12}, 12));
    }

    private static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            else if (target < nums[mid]) right = mid;
            else left = mid + 1;
        }

        return -1;
    }

    private static void lru(LRUCache cache) {
        System.out.println("---------------------------\n\n");

        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(3, 3);
        cache.put(4, 4);
        System.out.println(cache.get(4));
        System.out.println(cache.get(3));
        System.out.println(cache.get(2));
        System.out.println(cache.get(1));
        cache.put(5,5);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
        System.out.println(cache.get(5));

        cache.currentPosition();
    }

    private static ListNode loopHasCycle(ListNode node) {
        ListNode fastPointer = node.next.next;
        ListNode slowPointer = node.next;

        while (fastPointer != null && fastPointer.next != null ) {
            if (fastPointer == slowPointer) {
                break;
            } else {
                fastPointer = fastPointer.next.next;
                slowPointer = slowPointer.next;
            }
        }

        while (fastPointer != null) {
            if (node == fastPointer) {
                return node;
            }
            fastPointer = fastPointer.next;
            node = node.next;
        }
        return null;
    }

    private static int kadaneAlgoWithNegativeNumber(int[] nums) {
        int sum = 0;
        int result = 0;

        for (int index = 0; index < nums.length; index++) {
            sum = sum + nums[index];
            if (sum < 0) {
                sum = 0;
            } else if (result < sum) {
                result = sum;
            }
        }

        return result;
    }

    private static int kadaneAlgo(int[] nums) {
        int sum = nums[0];
        int result = nums[0];

        for (int index = 1; index < nums.length; index++) {
            sum = Math.max(sum, sum + nums[index]);
            result = Math.max(result, sum);
        }
        return result;
    }

    private static int[] twoSumInputArrayIsSorted(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return new int[] {left + 1, right + 1};
            } else if (numbers[left] + numbers[right] > target) {
                right = right - 1;
            } else {
                left = left + 1;
            }
        }

        return new int[2];
    }

    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> onePass = new HashMap<>();
        int[] indexes = new int[2];
        for (int index = 0; index < nums.length; index++) {
            if (onePass.containsKey(target - nums[index])) {
                indexes[0] = onePass.get(target - nums[index]);
                indexes[1] = index;
                break;
            } else {
                onePass.put(nums[index], index);
            }
        }

        return indexes;
    }

    private static void moveZeros(int[] nums) {
        int nonZeroIndex = 0;

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != 0) {
                nums[nonZeroIndex] = nums[index];
                if (index != nonZeroIndex)
                    nums[index] = 0;
                nonZeroIndex++;
            }
        }

        for (int index = nonZeroIndex; index < nums.length; index++) {
            nums[index] = 0;
        }

        for (int index = 0; index < nums.length; index++) {
            System.out.println(nums[index]);
        }
    }

    private static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        for (int index = 0; index < nums.length; index++) {
            if (candidate == nums[index]) {
                count++;
            } else {
                count-= 1;
            }

            if (count == 0) {
                candidate = nums[index];
            }
        }

        int target = nums.length / 2;
        count = 0;
        for (int index = 0; index < nums.length; index++) {
            if (candidate == nums[index]) {
                count++;
                if (count == target) {
                    return candidate;
                }
            }
        }

        return -1;
    }
}

class LRUCache {
    private int capacity;
    private int currentCapacity;
    private LinkedHashMap<Integer, Integer> keyValue;

    public LRUCache(int capacity) {
        keyValue = new LinkedHashMap<>();
        this.capacity = capacity;
        this.currentCapacity = 0;
    }

    public int get(int key) {
        int returnVal;

        if (keyValue.get(key) != null) {
            returnVal = keyValue.get(key);
        } else {
            return -1;
        }

        Integer val = keyValue.get(key);
        keyValue.remove(key);
        keyValue.put(key, val);

        return returnVal;
    }

    public void put(int key, int value) {
        if (keyValue.containsKey(key)) {
            keyValue.put(key, value);
            get(key);
            return;
        }

        if (currentCapacity == capacity) {
            keyValue.remove(keyValue.entrySet().iterator().next().getKey());
        }

        currentCapacity = currentCapacity + 1;
        keyValue.put(key, value);
    }

    public void currentPosition() {
        System.out.println(keyValue);
    }
}
