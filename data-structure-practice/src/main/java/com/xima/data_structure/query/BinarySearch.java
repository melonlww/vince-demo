package com.xima.data_structure.query;

/**
 * 复杂二分法，元素中可能会有相同值
 *
 * 查找第一个等于给定值的元素
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {1, 3, 4, 5, 6, 7, 8, 8, 8, 18};
        System.out.println(bsearch2(a, a.length, 8));
    }

    //这段不是很容易理解
    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low < n && a[low] == value) return low;
        else return -1;
    }

    //比较容易理解
    public static int bsearch2(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid =  low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || (a[mid - 1] != value)) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }
}
