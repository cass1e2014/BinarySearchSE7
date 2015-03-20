/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author cassie9082
 * 
 */

/*
 * 这道题是一道常见的二分查找法的变体题。
 * 
 * 要解决这道题，需要明确rotated sorted
 * array的特性，那么就是至少有一侧是排好序的（无论pivot在哪，自己画看看）。接下来就只需要按照这个特性继续写下去就好。以下就以伪代码方法来说明：
 * 
 * 如果target比A[mid]值要小 如果A[mid]右边有序（A[mid]<A[high])
 * 那么target肯定不在右边（target比右边的都得小），在左边找 如果A[mid]左边有序
 * 那么比较target和A[low]，如果target比A[low]还要小，证明target不在这一区，去右边找；反之，左边找。
 * 如果target比A[mid]值要大 如果A[mid]左边有序（A[mid]>A[low]）
 * 那么target肯定不在左边（target比左边的都得大），在右边找 如果A[mid]右边有序
 * 那么比较target和A[high]，如果target比A[high]还要大，证明target不在这一区，去左边找；反之，右边找。
 */
public class searchInRotatedSortedArray {

	public static int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int start = 0;
		int end = A.length - 1;
		int mid;

		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (A[mid] == target) {
				return mid;
			}
			if (A[mid] > A[start]) {
				if (target >= A[start] && target <= A[mid]) {
					end = mid;
				} else {
					start = mid;
				}
			} else {
				if (target >= A[mid] && target <= A[end]) {
					start = mid;
				} else {
					end = mid;
				}
			}
		}

		if (A[start] == target) {
			return start;
		}
		if (A[end] == target) {
			return end;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] test = { 4, 5, 6, 7, 0, 1, 2 };
		int result = search(test, 2);
		System.out.println(result);
	}

}
