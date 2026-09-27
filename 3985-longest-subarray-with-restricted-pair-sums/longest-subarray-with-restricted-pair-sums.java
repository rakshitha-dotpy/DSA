class Solution {
    public int maxSubarray(int[] nums) {
        int n = nums.length;
        int[] freq = new int[501];

        int left = 0;
        int ans = 0;

        for (int right = 0; right < n; right++) {
            freq[nums[right]]++;

            while (!isValid(freq)) {
                freq[nums[left]]--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    private boolean isValid(int[] freq) {

        // z = x + y
        for (int x = 1; x <= 250; x++) {

            if (freq[x] == 0)
                continue;

            for (int y = x; x + y <= 500; y++) {

                if (freq[y] == 0)
                    continue;

                int z = x + y;

                if (freq[z] == 0)
                    continue;

                // x and y are the same value.
                // Need two distinct indices containing x.
                if (x == y) {
                    if (freq[x] >= 2) {
                        return false;
                    }
                } 
                // x and y are different values,
                // so their indices are automatically distinct.
                else {
                    return false;
                }
            }
        }

        return true;
    }
}