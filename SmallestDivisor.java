public class SmallestDivisor {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1, right = 0;
        for (int num : nums) right = Math.max(right, num);
        while (left < right) {
            int mid = (left + right) / 2;
            if (canDivide(nums, mid, threshold)) right = mid;
            else left = mid + 1;
        }
        return left;
    }

    private boolean canDivide(int[] nums, int div, int threshold) {
        int sum = 0;
        for (int num : nums) sum += (num + div - 1) / div;
        return sum <= threshold;
    }

    public static void main(String[] args) {
        SmallestDivisor obj = new SmallestDivisor();
        int[] nums = {1, 2, 5, 9};
        System.out.println(obj.smallestDivisor(nums, 6)); // Output: 5
    }
}
