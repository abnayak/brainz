public class ProductArrayExceptSelf {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        Solution solution = new Solution();
        int[] result = solution.productExceptSelf(array);
        for (int i : result ) {
            System.out.println(i);
        }
    }

    public static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int[] productLeft = new int[nums.length];
            int[] productRight = new int[nums.length];
            int[] solution = new int[nums.length];

            if (nums.length == 1) {
                solution = nums;
                return solution;
            }

            productLeft[0] = productRight[nums.length-1] = 1;

            for(int index = 1; index < nums.length; index++) {
                productLeft[index] = productLeft[index-1] * nums[index-1];
            }

            for(int index = nums.length-2; index >= 0; index--) {
                productRight[index] = productRight[index+1] * nums[index+1];
            }

            for(int index = 0; index < nums.length; index++) {
                if(index == 0) {
                    solution[index] = productRight[index];
                } else if(index == nums.length-1) {
                    solution[index] = productLeft[index];
                }
                solution[index] = productLeft[index] * productRight[index];
            }
            return solution;
        }
    }
}
