
class Solution {
    public int myAtoi(String s) {
        int i = 0;
        int sign = 1;
        long num = 0;

        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i < s.length() && s.charAt(i) == '-') {
            sign = -1;
            i++;
        } 
        else if (i < s.length() && s.charAt(i) == '+') {
            i++;
        }

        while (i < s.length() && 
               s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            
            num = num * 10 + (s.charAt(i) - '0');

            if (num * sign > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }

            if (num * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        return (int)(num * sign);
    }
}
