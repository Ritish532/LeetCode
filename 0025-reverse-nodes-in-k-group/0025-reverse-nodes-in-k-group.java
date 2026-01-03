class Solution {
    public int length(ListNode temp){
        int count = 0;
        while(temp != null){
            temp = temp.next;
            count++;
        }
        return count;
    }
    public ListNode reverse(ListNode strt , ListNode end){
        ListNode prev = null;
        ListNode curr = strt;
        ListNode nxt = strt;
        while(curr != end){
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        curr.next = prev;
        return end;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = length(head);
        ListNode dummy = new ListNode(1);
        ListNode prev = dummy;
        ListNode strt = head;
        ListNode end = head;
        ListNode tail = head;
        int r = 0;
        while(r+k <= len){
            r += k;
            int c = 1;
            while(c < k){
                c++;
                end = end.next;
            }
            tail = end.next;
            prev.next = reverse(strt,end);
            prev = strt;
            strt.next = tail;
            strt = tail;
            end = tail;
        }
        return dummy.next;
    }
}