public class Logarithmeter {
    public static void main(String[] args) {
        
    }


    static int[] newRandomArr(int maxLength,int maxValue){
        int[] arr=new int[(int)(Math.random()*(maxLength+1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=newRandomNum(maxValue);
        }
        return arr;
    }

    static int newRandomNum(int maxValue){
        return ((int)(Math.random()*maxValue)-(int)(Math.random()*maxValue));
    }

    static int[] copyArr(int[] arr){
        int[] a=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i]=arr[i];
        }
        return a;
    }

    static boolean compare(int[] a,int[] b){
        if (a.length!=b.length) {
            return false;
        }
        for (int i = 0; i < b.length; i++) {
            if (a[i]!=b[i]) {
                return false;
            }
        }
        return true;
    }
}
