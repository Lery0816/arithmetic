import java.util.PriorityQueue;

public class MyHeap {
    public static void main(String[] args) {
        //PriorityQueue<Integer> heap =new PriorityQueue<>((a,b)->{return b-a;});
        MyHeap1 heap=new MyHeap1(5);
        heap.add(0);
        heap.add(3);
        heap.add(1);
        heap.add(2);
        while (!heap.isempty()) {
            System.out.println(heap.poll()+"----"+heap.heapsize);
        }


    }

}
class MyHeap1{
    final int limit;
    int[] heap;
    int heapsize=0;
    public MyHeap1(int limit){
        this.limit=limit;
        heap=new int[limit];
    }
    public void add(int arr){
        if (isfull()) {
            return;
        }
        heap[heapsize]=arr;
        heapify(heapsize++);

    }
    public int poll(){
        if (isempty()) {
            return -1;
        }
        int index=0;
        while (index*2+1<=limit) {
            int bigindex=index*2+2<=limit&&heap[index*2+1]>heap[index*2+2]?index*2+1:index*2+2;
            swap(index, bigindex);
            index=bigindex;
        }
        return heap[heapsize--];
    }
    public int peak(){
        if (isempty()) {
            return -1;
        }
        return heap[0];
    }
    public void heapify(int index){
        while (heap[index]>heap[((index-1)/2)]) {
            swap(index, ((index-1)/2));
            index=((index-1)/2);
        }
    }
    public void swap(int a,int b){
        int help=heap[a];
        heap[a]=heap[b];
        heap[b]=help;

    }
    public boolean isfull(){
        if (heapsize<limit) {
            return false;
        }
        return true;
    }
    public boolean isempty(){
        if (heapsize>0) {
            return false;
        }
        return true;
    }}
