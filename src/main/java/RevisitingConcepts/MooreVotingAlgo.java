package RevisitingConcepts;

public class MooreVotingAlgo {
    public static void main(String[] args) {
        mooreVotingAlgo(new int[]{2,2,2,3,4,5});
    }

    private static void mooreVotingAlgo(int[] nums) {
        int majorityElement = nums[0];
        int counter = 1;

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] != majorityElement) {
                counter--;
                if (counter == 0) {
                    majorityElement = nums[i];
                    counter = 1;
                }
            }
            else {
                counter++;
            }
        }

        counter=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == majorityElement) counter++;
            if (counter >= nums.length/2) {
                System.out.println(majorityElement);
                break;
            }
        }


    }
}
