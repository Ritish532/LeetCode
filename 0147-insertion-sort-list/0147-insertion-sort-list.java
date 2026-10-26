class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode temp = head;
        head  = head.next; 
        temp.next = null;
        while(head != null){
            ListNode prev = null;
            ListNode curr = temp;
            ListNode next = head.next;
            if(temp.val >= head.val){
                head.next = temp;
                temp = head;
            }
            else{
                while(curr != null && curr.val < head.val){
                    prev = curr;
                    curr = curr.next;
                }
                prev.next = head;
                head.next = curr;
            }
            head = next;
        }
        return temp;
    }
}