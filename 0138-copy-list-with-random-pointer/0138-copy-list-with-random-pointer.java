class Solution {
    public Node deepCopy(Node head){
        Node t1 = head.next;
        Node dummy = new Node(head.val);
        Node t2 = dummy;
        while(t1 != null){
            Node t = new Node(t1.val);
            t2.next = t;
            t2 = t2.next;

            t1 = t1.next;
        }
        return dummy;
    }
    // public void alternatively(Node head , Node head2){
    //     Node dummy = new Node(-1);
    //     Node t = dummy;
    //     Node t1 = head;
    //     Node t2 = head2;

    //     while(t1 != null && t2 != null){
    //         t.next = t1;
    //         t1 =t1.next;
    //         t = t.next;

    //         t.next = t2;
    //         t2 = t2.next;
    //         t = t.next;
    //     }
    // }

    // public void randomassign(Node head , Node head2){
    //     Node t1 = head;
    //     Node t2 = head2;

    //     while(t1 != null){
    //         t2 = t1.next;

    //         if(t1.random == null) t2.random = t1.random;
    //         else t2.random = t1.random.next;
    //         t1 = t1.next.next;
    //     }
    // }
    // public Node copyRandomList(Node head) {
    //     if(head == null) return null;
    //     // Step 1 :- Create Deep Copy
    //     Node head2 = deepCopy(head);

    //     // Step 2 :- Connect the nodes Alternatively
    //     alternatively(head,head2);

    //     //Step 3 :- Assign the Randoms 
    //     randomassign(head,head2);

    //     // Step 4 :- Connect the nodes of the head2 together
    //     Node t1 = head;
    //     Node t2 = head2;

    //     while(t1 != null){
    //        t1.next = t2.next;
    //         t1 = t1.next;
    //         if(t1 == null) break;
    //         t2.next = t1.next;
    //         t2 = t2.next;
    //     }
    //     return head2;
    // }

    public Node copyRandomList(Node head){
        if(head == null) return null;
        Node head2 = deepCopy(head);

        HashMap<Node,Node> map = new HashMap<>();
        Node t1 = head , t2 = head2;
        while(t1 != null){
            map.put(t1,t2);
            t1 = t1.next; t2 = t2.next;
        }
        t1 = head; t2 = head2;

        while(t2 != null){
            // if(t1.random == null) t2.random = null;
             t2.random = map.get(t1.random);
            t2 = t2.next ;t1 = t1.next;
        }
        return head2;
    }
}