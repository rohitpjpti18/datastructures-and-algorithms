package src.linkedlistandarray;

public class TrappingRainwater {
    public int trap(int[] height) {
        int n = height.length;
        int left, right, leftMax, rightMax, result;

        left = leftMax = rightMax = result = 0;
        right = n - 1;

        while(left < right) {
            if(height[left] <= height[right]) {
                if(height[left] >= leftMax) leftMax = height[left];
                else result += leftMax - height[left];
                ++left;
            } else {
                if(height[right] >= rightMax) rightMax = height[right];
                else result += rightMax - height[right];
                --right;
            }
        }

        return result;
    }
}
