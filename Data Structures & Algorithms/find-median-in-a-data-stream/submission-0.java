class MedianFinder {
    int size;
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;
    public MedianFinder() {
        size = 0;
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
        minHeap = new PriorityQueue<>((a, b) -> a - b);
    }
    
    public void addNum(int num) {
        int left = maxHeap.size() == 0 ? Integer.MAX_VALUE : maxHeap.peek();
        int right = minHeap.size() == 0 ? Integer.MIN_VALUE : minHeap.peek();

        if (left > num) {
            maxHeap.offer(num);
        } else {
            minHeap.offer(num);
        }

        int n1 = maxHeap.size();
        int n2 = minHeap.size();

        if (n2 > n1 || n1 - n2 >= 2) {
            if (n2 > n1) {
                maxHeap.offer(minHeap.poll());
            } else {
                minHeap.offer(maxHeap.poll());
            }
        }

        size++;
    }
    
    public double findMedian() {
        int left = maxHeap.size() == 0 ? 0 : maxHeap.peek();
        int right = minHeap.size() == 0 ? 0 : minHeap.peek();

        return size % 2 == 0 ? (double) (left + right) / 2.0 : (double) left;
    }
}
