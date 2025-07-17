package src.TrieTree;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr={522,332,213,12,4};
        radixSort(arr,0,4,3);
        System.out.println(Arrays.toString(arr));
    }

    private static void radixSort(int[] arr, int start, int end, int digit) {
        if (start>=end){
            return;
        }
        final int radix=10;

        //准备辅助数组
        int[] help=new int[end-start+1];


        //按照个位、十位、百位的顺序统计
        for (int i = 0; i < digit; i++) {
            int[] count=new int[radix];

            //统计出现的次数
            for (int i1 = 0; i1 < arr.length; i1++) {
                count[getDigit(arr[i1],i)]++;
            }

            //修改count数组变成累加和
            for (int i1 = 1; i1 < count.length; i1++) {
                count[i1]=count[i1-1]+count[i1];
            }

            //按照倒序遍历数组，将数据放入help中
            for (int i1 = end; i1 >= start; i1--) {
                int index=count[getDigit(arr[i1],i)]-1;//数据插入位置的索引
                help[index]=arr[i1];//根据索引将数据插入到help中
                count[getDigit(arr[i1],i)]--;//更新count数组
            }

            //把数据放回原数组
            for (int i1 = start; i1 <= end; i1++) {
                arr[i1]=help[i1-start];
            }
        }

    }

    //num是原数值，digit是第几位，0是个位，1是十位，2是百位，以此类推
    private static int getDigit(int num, int digit) {
        return (int)(num/Math.pow(10,digit))%10;
    }

}
