package jzoffer;

/**
 * create by fungus on 2018/6/24
 *
 * 统计一个数字在排序数组中出现的次数。
 **/

public class GetNumberOfK {

    public int GetNumberOfK(int [] array , int k) {
        int length = array.length;
        if (length == 0) return length;
        int firstK = getFirstK(array, k, 0, length - 1);
        int lastK = getLastK(array, k, 0, length - 1);
        if (firstK != -1 && lastK != -1) {
            return lastK - firstK + 1;
        }
        return 0;
    }

    private int getFirstK(int[] arr, int k, int start, int end) {
        if (start > end) return -1;
        int mid = (end + start) >> 1;
        if (arr[mid] > k) {
            return getFirstK(arr, k, start, mid - 1);
        } else if (arr[mid] < k) {
            return getFirstK(arr, k, mid + 1, end);
        } else if (mid - 1 >= 0 && arr[mid - 1] == k) {
            return getFirstK(arr, k, start, mid - 1);
        } else {
            return mid;
        }
    }

    private int getLastK(int[] arr, int k, int start, int end) {
        if (start > end) return -1;
        int mid = (end + start) >> 1;
        if (arr[mid] > k) {
            return getLastK(arr, k, start, mid - 1);
        } else if (arr[mid] < k) {
            return getLastK(arr, k, mid + 1, end);
        } else if (mid + 1 < arr.length && arr[mid + 1] == k) {
            return getLastK(arr, k, mid + 1, end);
        } else {
            return mid;
        }
    }
}
