public class SimpleSort extends Logarithmeter{
    public static void main(String[] args) {
        int time=50000;
        int maxLength=100;
        int maxValue=100;
        boolean result = true;
        for (int t = 0; t < time; t++) {
            int[] arr=newRandomArr(maxLength,maxValue);
            int[] arr1=copyArr(arr);
            int[] arr2=copyArr(arr);
            selectsort(arr1);
            bubbleSort(arr2);
            if (!compare(arr1, arr2)) {
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i]);
                }
                System.out.println();
                for (int i = 0; i < arr1.length; i++) {
                    System.out.print(arr[i]);
                }
                System.out.println();
                for (int i = 0; i < arr2.length; i++) {
                    System.out.print(arr[i]);
                }
                System.out.println();
                return;
            }
        }
        System.out.print(result?"Yes":"error");
    }

    static void insertsort(int[] arr){
        if (arr==null||arr.length<2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int j=i;
            while (j>0&&arr[j]<arr[j-1]) {
                swap(arr, j, j-1);
                j--;
            }
        }
    }

    static void selectsort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int minindex=i;
            for (int j = i; j < arr.length; j++) {
                minindex=arr[minindex]>arr[j]?j:minindex;
            }
            swap(arr, i, minindex);
        }
    }

    static void bubbleSort(int[] arr){
        for (int i = arr.length-1; i >0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j]>arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }

    static void swap(int[] arr,int a,int b){
        int i=arr[a];
        arr[a]=arr[b];
        arr[b]=i;
    }
}
