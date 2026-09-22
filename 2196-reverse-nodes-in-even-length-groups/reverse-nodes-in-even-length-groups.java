class Solution {
    public ListNode reverseEvenLengthGroups(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        int group = 1;

        while(curr != null) {
            ListNode start = curr;
            int count = 0;

            while(curr != null && count < group) {
                curr = curr.next;
                count++;
            }

            if(count % 2 == 0) {
                ListNode p = curr;
                ListNode node = start;

                for(int i = 0; i < count; i++) {
                    ListNode next = node.next;
                    node.next = p;
                    p = node;
                    node = next;
                }

                prev.next = p;
                prev = start;
            } else {
                prev = start;
                for(int i = 1; i < count; i++)
                    prev = prev.next;
            }

            group++;
        }

        return head;
    }
}