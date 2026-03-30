class DynamicArray {
    private int[] arr;
    private int length;
    private int capacity;

    public DynamicArray(int capacity) {
        this.arr = new int[capacity];
        this.length = 0;
        this.capacity = capacity;

    }

    public int get(int i) {
        return this.arr[i];
    }

    public void set(int i, int n) {
        this.arr[i] = n;
    }

    public void pushback(int n) {
        if (this.length == this.capacity) {
            resize();
        }

        this.arr[this.length] = n;
        length += 1;        
    }

    public int popback() {
        int res = this.arr[this.length-1];
        this.length -= 1;
        return res;
    }

    private void resize() {
        this.capacity *= 2;
        int[] temp = this.arr;
        this.arr = new int[this.capacity];
        for (int i = 0; i < this.length; i++) {
            this.arr[i] = temp[i];
        }
    }

    public int getSize() {
        return this.length;
    }

    public int getCapacity() {
        return this.capacity;
    }
}
