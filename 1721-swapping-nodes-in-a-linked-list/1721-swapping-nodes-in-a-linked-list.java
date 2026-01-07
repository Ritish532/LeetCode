class Solution {
    public int length(ListNode head){
        int count = 1;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
    public ListNode swapNodes(ListNode head, int k) {

        int len = length(head);
        int n = len - k ;

        ListNode t1 = head;
        ListNode t2 = head;

        int i = 1;
        while(i < k){
            i++;
            t1 = t1.next;
        }

        i = 1;
        while(i < n){
            i++;
            t2 = t2.next;
        }

        int temp = t1.val;
        t1.val = t2.val;
        t2.val = temp;
        return head;
    
    }
}