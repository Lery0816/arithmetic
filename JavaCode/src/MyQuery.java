package src;

import java.util.Arrays;

public class MyQuery {
    public static void main(String[] args) {
        MyQuery mq= new MyQuery(5);
        mq.pull(1);
        mq.pull(2);
        mq.pull(3);
        mq.pull(4);
        mq.pull(5);
        int[] arr=new int[5];
        for (int i = 0; i < arr.length; i++) {
            int pup = mq.pup();
            arr[i]=pup;
        }
        System.out.println(Arrays.toString(arr));
        

    }
    int[] arr;
    int head=0;
    int last=0;
    int limit;
    int size;
    public MyQuery(int limit){
        arr=new int[limit];
        this.limit=limit;
        size=limit;
    }
    public void pull(int num){
        if (limit==0) {
            throw new RuntimeException("队列已满");
        }
        arr[last]=num;
        last=next(last);
        limit--;
    }
    public int pup(){
        if (limit==size) {
            throw new RuntimeException("队列已空");
        }
        int ans=arr[head];
        head=next(head);
        limit++;
        return ans;
    }
    public int next(int index){
        return index=index==size-1?0:index+1;
    }
}
