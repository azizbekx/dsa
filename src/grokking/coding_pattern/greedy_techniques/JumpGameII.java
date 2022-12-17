package grokking.coding_pattern.greedy_techniques;

public class JumpGameII {
    public static int jumpGame2(int[] nums) {
        int farthestJump = 0; // farthest index we can reach
        int currentJump = 0; // index of store the number of jumps
        int jumps = 0; // number of jumps
        for (int i = 0; i < nums.length; i++) {
            farthestJump = Math.max(i + nums[i], farthestJump);
            currentJump = nums[i];
            if (i == currentJump){
                jumps++;
                currentJump = farthestJump;
            }
        }
        return jumps;
    }
}
