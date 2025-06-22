package src;

public class SmallSum {
    public static void main(String[] args) {
        //int[] arr={1,4,2,3,4,5,6,6,3,2,4};
        int[] arr1={1,3,2,3};
        int ans=smallSum(arr1);
        System.out.println(ans);
    
    }
    public static int smallSum(int[] arr){
        if (arr==null||arr.length<2) {
            return 0;
        }
        int ans=process(arr,0,arr.length-1);
        return ans;
    }
    public static int process(int[] arr,int start,int end){
        if (start==end) {
            return 0;
        }
        int mid=start+((end-start)>>1);
        int result=0;
        result+=process(arr, start, mid);
        result+=process(arr, mid+1, end);
        result+=merge(arr,start,mid,end);
        return result;
    }
    public static int merge (int[] arr,int start,int mid,int end){
        int[] help=new int[end-start+1];
        int r=start;
        int l=mid+1;
        int index=0;
        int res=0;
        while (r<=mid&&l<=end) {
            res+=arr[r]<arr[l]?(end-l+1)*arr[r]:0;
            help[index++]=arr[r]<arr[l]?arr[r++]:arr[l++];
        }
        while (r<=mid) {
            help[index++]=arr[r++];
        }
        while (l<=end) {
            help[index++]=arr[l++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[start+i]=help[i];
        }
        return res;
    }
}
