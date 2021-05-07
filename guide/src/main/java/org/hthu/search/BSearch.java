package org.hthu.search;

/**
 * @file: BSearch.java
 * @version: 1.0
 * @Description 二分查找
 * @author: 胡海涛(X4818)
 * @date 2020年12月19日 下午5:06:53
 */
public class BSearch {

    /**
     * 普通二分查找,有序数组、不含有重复元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bSearch(int[] a, int n, int value) {
        int low = 0;
        int hight = n - 1;
        while (low <= hight) {
            int mid = low + ((hight - low) >> 1);
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                hight = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 递归实现普通二分查找
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int dgSearch(int[] a, int n, int value) {
        int low = 0;
        int hight = n - 1;
        return dgSearchStep(a, low, hight, value);
    }

    private int dgSearchStep(int[] a, int low, int hight, int value) {
        if (low > hight) {
            return -1;
        }
        int mid = low + ((hight - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return dgSearchStep(a, mid + 1, hight, value);
        } else {
            return dgSearchStep(a, low, mid - 1, value);
        }
    }

    /**
     * 二分查找变体:含有重复元素
     * 查找第一个值等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bSearchChange1(int[] a, int n, int value) {
        int low = 0;
        int hight = n - 1;
        while (low <= hight) {
            int mid = low + ((hight - low) >> 1);
            if (a[mid] == value) {
                if (mid == 0 || a[mid - 1] != value) {
                    return mid;
                }
                hight = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                hight = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找变体:含有重复元素
     * 查找最后一个值等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bSearchChange2(int[] a, int n, int value) {
        int low = 0;
        int hight = n - 1;
        while (low <= hight) {
            int mid = low + ((hight - low) >> 1);
            if (a[mid] == value) {
                if ((mid == n - 1) || a[mid + 1] != value) {
                    return mid;
                }
                low = mid + 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                hight = mid - 1;
            }
        }
        return -1;
    }

    /**
     * 二分查找变体:含有重复元素
     * 查找第一个大于等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bSearchChange3(int[] a, int n, int value) {
        int low = 0;
        int hight = n - 1;
        while (low <= hight) {
            int mid = low + ((hight - low) >> 1);
            if (a[mid] >= value) {
                if (mid == 0 || a[mid - 1] < value) {
                    return mid;
                }
                hight = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个小于等于给定值的元素
     *
     * @param a
     * @param n
     * @param value
     * @return
     */
    public int bSearchChange4(int[] a, int n, int value) {
        int low = 0;
        int hight = n - 1;
        while (low <= hight) {
            int mid = low + ((hight - low) >> 1);
            if (a[mid] <= value) {
                if ((mid == n - 1) || a[mid + 1] > value) {
                    return mid;
                }
                low = mid + 1;
            } else {
                hight = mid - 1;
            }
        }
        return -1;
    }
}
