import java.util.*;

class MaxHeap{

    List<Integer> heap = new ArrayList<>();

    public Integer max(){
        if(heap.size() == 0){
            throw new ArrayIndexOutOfBoundsException();
        }
        return heap.get(0);
    }

    public Integer extractMax(){
        Integer max = max();
        Integer last = heap.get(heap.size()-1);
        heap.set(0, last);
        heap.set(heap.size()-1, max);
        heap.remove(heap.size()-1);
        heapifyDown(0);
        return max;
    }

    public void insert(Integer i){
        heap.add(i);
        heapifyUp(heap.size()-1);
    }
    public void poll(){

    }

    private void swap(int i, int j){
        int tmp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, tmp);
    }

    /**
     * Conserve the invariant by repeatidly calling heapifydown until the invariant is kept 
     * of a leaf is reached.
     */
    public void heapifyDown(int i){
        // Check if child
        if(rightIndex(i) >= heap.size()-1 || leftIndex(i) >= heap.size()-1){
            return;
        }
        if(leftChild(i) > heap.get(i)){
            swap(i, leftIndex(i));
            heapifyDown(leftIndex(i));
        }
        else if(rightChild(i) > heap.get(i)){
            swap(i, rightIndex(i));
            heapifyDown(rightIndex(i));
        }
    }

    public void heapifyUp(int i){

        if(i <= 0){
            return;
        }

        if(parentIndex(i) < heap.get(i)){
            swap(i, parentIndex(i));
            heapifyUp(parentIndex(i));
        }
        if(parentIndex(i) < heap.get(i)){
            swap(i, parentIndex(i));
            heapifyDown(parentIndex(i));
        }
    }
    /** 
     * Returns right child of node i
     */
    public Integer rightChild(int i){
        return heap.get(i*2+1);
    }
    /**
     * Returns the right index of node i
     */
    public int rightIndex(int i){
        return (i*2+1);
    }
    /**
     * Returns left child of node i
     * @param i index of node
     */
    public Integer leftChild(int i){
        return heap.get(i*2);
    }
    /**
     * Returns left index of node i
     */
    public int leftIndex(int i){
        return i*2;
    }
    /**
     * Returns left child of node i
     * @param i index of node
     */
    public Integer parent(int i){
        return heap.get(i/2);
    }
    /**
     * Returns left index of node i
     */
    public int parentIndex(int i){
        return i/2;
    }

    public void printAll(){
        int size = heap.size();
        for(int i = 0; i < size; i++){
            System.out.println(extractMax());
        }
    }
    public static void main(String[] args){
        MaxHeap h = new MaxHeap();
        h.insert(5);
        h.insert(3);
        h.insert(6);
        h.insert(9);
        h.insert(2);
        h.insert(70);
        h.insert(1);
        h.insert(10);
        h.insert(32);
        h.insert(4);
        h.insert(10);
        h.insert(1);
        h.insert(100);
        h.printAll();
    }

}