package src.Heap;

import java.util.PriorityQueue;

public class Lc_253 {
    public static void main(String[] args) {
        int[][] arrs={{0, 5}, {1, 2}, {3, 4}, {6, 10}};
        int ans=process(arrs);
        System.out.println(ans);
    }
    public static int process(int[][] arrs){
        PriorityQueue<Integer> heap=new PriorityQueue<>();
        int ans=0;
        for(int[] arr:arrs){
            while(!heap.isEmpty()&&arr[0]>=heap.peek()){
                heap.poll();
            }
            heap.add(arr[1]);
            ans=Math.max(ans,heap.size());
        }
        return ans;
    }
}
