import java.util.PriorityQueue;

public class MyHeap extends Logarithmeter{
    public static void main(String[] args) {
        //PriorityQueue<Integer> heap =new PriorityQueue<>((a,b)->{return b-a;});
        MyHeap1 heap=new MyHeap1(newRandomNum(20));
        for (int i = 0; i < heap.limit; i++) {
            heap.add(newRandomNum(20));
        }
        heap.showheap();
        while (!heap.isempty()) {
            System.out.print("弹出了："+heap.poll()+"----堆内剩余：");
            heap.showheap();
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
        heapinsert(heapsize++);
    }
    public void heapinsert(int index){
        while (heap[index]>heap[(index-1)/2]) {
            swap(index, (index-1)/2);
            index=(index-1)/2;
        }
    }
    public int poll(){
        if (isempty()) {
            return -1;
        }
        int ans=peak();
        swap(0, --heapsize);
        heapify(0);
        return ans;
    }
    public int peak(){
        if (isempty()) {
            return -1;
        }
        return heap[0];
    }
    public void heapify(int index){
        int leftsun=index*2+1;
        while (leftsun<heapsize) {
            int bigindex=(leftsun+1<heapsize)&&heap[leftsun+1]>heap[leftsun]?leftsun+1:leftsun;
            bigindex=heap[index]<heap[bigindex]?bigindex:index;
            if (bigindex==index) {
                break;
            }
            swap(index, bigindex);
            index=bigindex;
            leftsun=index*2+1;
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
    }
    public void showheap(){
        if (heapsize==0) {
            System.out.println("[]");
            return;
        }
        System.out.print("[");
        for (int i = 0; i < heapsize-1; i++) {
            System.out.print(heap[i]+",");
        }
        System.out.println(heap[heapsize-1]+"]");
    }
}
