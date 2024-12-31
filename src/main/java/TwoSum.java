public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        //Loop through each element in the array
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++){
                if (nums [i] + nums [j] == target) {
                    return  new int[] {i, j};
                }
            }

        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {
        // Create an object of the TwoSum class
        TwoSum ts = new TwoSum();

        // Define input
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        // Call the twoSum method using the ts object
        int[] result = ts.twoSum(nums, target);

        // Print the result
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
    }
}
