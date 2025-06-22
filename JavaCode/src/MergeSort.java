package src;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr={1,4,2,3,4,5,6,6,3,2,4};
        int[] arr1={};
        new MergeSort().sort(arr1);
        for (int i : arr1) {
            System.out.print(i);
        }
        
    
    }
    void sort(int[] arr){
        if (arr==null||arr.length<2) {
            return;
        }
        process(arr,0,arr.length-1);
        }

    private void process(int[] arr, int start, int end) {
        if (start==end) {
            return;
        }
        int mid=start+((end-start)>>1);
        process(arr, start, mid);
        process(arr, mid+1, end);
        merge(arr,start,mid,end);
            }
    private void merge(int[] arr, int start, int mid, int end) {
        int lindex=start;
        int rindex=mid+1;
        int i=0;
        int[] help=new int[end-start+1];
        while (lindex<mid+1&&rindex<end+1) {
            help[i++]=arr[lindex]<arr[rindex]?arr[lindex++]:arr[rindex++];        
        }
        while(lindex<mid+1){
            help[i++]=arr[lindex++];
        }
        while(rindex<end+1){
            help[i++]=arr[rindex++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[start+j]=help[j];
        }
    }
    
}
