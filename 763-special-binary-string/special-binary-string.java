class Solution {
    public String makeLargestSpecial(String s) {

        if (s.length() == 0) {
            return "";
        }

        int count = 0;
        int start = 0;

        java.util.List<String> list = new java.util.ArrayList<>();

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '1') {
                count++;
            } else {
                count--;
            }

            if (count == 0) {

                String inside = s.substring(start + 1, i);

                String part = "1" + makeLargestSpecial(inside) + "0";

                list.add(part);

                start = i + 1;
            }
        }

        // Put bigger strings first
        java.util.Collections.sort(list, java.util.Collections.reverseOrder());

        String answer = "";

        for (String x : list) {
            answer = answer + x;
        }

        return answer;
    }
}