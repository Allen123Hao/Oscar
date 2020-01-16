package com.hao.arithmetic;

/**
 * <code>Sorts</code>
 *
 * @description:
 * @author: Hao Xueqiang(xueqiang.hao@tendcloud.com)
 * @creation: 2016/12/15
 * @version: 1.0
 */
public class Sorts {
    public static  void fibonacci(){
//        int i = 10;
        int[] a = new int[15];
        a[0] = 1;
        a[1] = 2;
        for(int i=2;i<a.length;i++){
            a[i] = a[i-1]+a[i-2];
        }
        for(int j : a){
            System.out.print(j);
            System.out.print(",");
        }
    }
    public static void binarySearch(){
        int[] arr = {1,2,3,5,8,13,21,34,55,89,144,233,377,610,987};
        int t = 987;
        int low = 0;
        int hight = arr.length-1;
        int middle = (low+hight)/2;
        while(t<arr[middle]){
            if(t==arr[hight]){
                middle = hight;
                break;
            }
            if(middle == low){
                break;
            }
            hight = middle;
            middle = (low+hight)/2;
            while(t > arr[middle]){
                if(t==arr[hight]){
                    middle = hight;
                    break;
                }
                if(middle == low){
                    break;
                }
                low = middle;
                middle = (low+hight)/2;
            }
        }
        while(t > arr[middle]){
            if(t==arr[hight]){
                middle = hight;
                break;
            }
            if(middle == low){
                break;
            }
            low = middle;
            middle = (low+hight)/2;
            while(t<arr[middle]){
                if(t==arr[hight]){
                    middle = hight;
                    break;
                }
                if(middle == low){
                    break;
                }
                hight = middle;
                middle = (low+hight)/2;
            }
        }
        System.out.println(middle);

    }

    public static void binarySearch1(){
        int[] arr = {1,2,3,5,8,13,21,34,55,89,144,233,377,610,987};
        int x = 987;
        int low = 0,high = arr.length;
        int middle = 0;
        if(low > high){
            middle = -1;
        }
        while(low < high){
            middle = (low+high)/2;
            if(x == arr[middle]){
                break;
            }else if(x < arr[middle]){
                high = middle-1;
            }else if(x > arr[middle]){
                low = middle+1;
            }
        }
        System.out.println(middle);
    }

    public static void main(String[] args) {
        Sorts.binarySearch1();
    }
}
