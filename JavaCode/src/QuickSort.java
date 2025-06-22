package src;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={1,3,3,1,1,2,5,8,6,5,4,3,6,5};
        new QuickSort().sort(arr);
        for (int i : arr) {
            System.out.print(i);
        }
    }
    
    public void sort(int[] arr){
        if (arr==null||arr.length<2) {
            return;
        }
        process(arr,0,arr.length-1);
        
    }
        
    private void process(int[] arr, int L, int R) {
        if (L>=R) {
            return;
        }
        int cur=L;
        int Lindex=L-1;
        int Rindex=R;
        while (cur<Rindex) {
            if (arr[cur]<arr[R]) {
                swap(arr,++Lindex,cur++);
            }else if (arr[cur]>arr[R]) {
                swap(arr, --Rindex, cur);
            }else{
                cur++;
            }
        }
        swap(arr, Rindex, R);
        process(arr, L, Lindex);
        process(arr, Rindex, R);
    }
                
    private void swap(int[] arr, int i, int j) {
        int var=arr[i];
        arr[i]=arr[j];
        arr[j]=var;
    }
}
