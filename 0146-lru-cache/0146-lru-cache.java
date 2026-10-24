class Node{
    int val , key;
    Node prev , next;
    Node(int key , int val){
        this.val = val;
        this.key = key;
    }
}

class DLL{
    Node head , tail;
    public int size;
    DLL(){
        head = null;
        tail = head;
    }
    void remove(Node temp){
        if(head == null) return;
        if(temp == head && temp == tail){
            head = null;
            tail = null;
        }
        else if(temp == head){
            head.next.prev = null;
            head = head.next;
        }
        else if(temp == tail){
            tail.prev.next = null;
            tail = tail.prev;
        }
        else {
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev; 
        }
        size--;
    }
    void add(Node temp){
        if(head == null){
            head = temp;
            tail = temp;
            size++;
            return;
        }
        tail.next = temp;
        temp.prev = tail;
        tail = tail.next;
        size++;
    }
}
class LRUCache {
    public int cap;
    public HashMap<Integer , Node> map;
    public DLL list ;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
        list = new DLL();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            int val = temp.val;
            list.remove(temp);
            list.add(temp);
            return val;
        }
        else return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node temp = map.get(key);
            list.remove(temp);
            list.add(temp);
            temp.val = value;    
            return;        
        }
        if(list.size >= cap){
            map.remove(list.head.key);
            list.remove(list.head);
        }
        Node temp = new Node(key , value);
        list.add(temp);
        map.put(key , temp);
    }
}