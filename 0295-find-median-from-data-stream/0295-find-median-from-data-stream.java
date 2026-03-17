class MedianFinder {
    PriorityQueue<Integer> MaxHeap;
    PriorityQueue<Integer> MinHeap;
    public MedianFinder() {
        MaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        MinHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(MaxHeap.size() == 0) MaxHeap.add(num);
        else if(num > MaxHeap.peek()) MinHeap.add(num);
            else MaxHeap.add(num);

        // Balance

        if(MaxHeap.size() == MinHeap.size() + 2) MinHeap.add(MaxHeap.remove());
        if(MinHeap.size() == MaxHeap.size() + 2) MaxHeap.add(MinHeap.remove());

    }
    
    public double findMedian() {
        if(MaxHeap.size() == MinHeap.size()) return ((MinHeap.peek()+MaxHeap.peek())/2.0);
        if(MaxHeap.size() > MinHeap.size()) return MaxHeap.peek();  
        else return MinHeap.peek();  
    }
}