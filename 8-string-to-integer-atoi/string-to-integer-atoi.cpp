class Solution {
public:
    int myAtoi(string s) {
        int i = 0;
        int n = s.length();

        // 1. Remove spaces
        while (i < n && s[i] == ' ')
            i++;

        // 2. Check sign
        int sign = 1;

        if (i < n && s[i] == '-') {
            sign = -1;
            i++;
        }
        else if (i < n && s[i] == '+') {
            i++;
        }

        // 3. Convert digits
        long long num = 0;

        while (i < n && s[i] >= '0' && s[i] <= '9') {
            num = num * 10 + (s[i] - '0');

            // 4. Check limit
            if (num * sign > 2147483647)
                return 2147483647;

            if (num * sign < -2147483648LL)
                return -2147483648LL;

            i++;
        }

        return num * sign;
    }
};
