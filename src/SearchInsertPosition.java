/**
 * Given a sorted array and a target value, return the index if the target is
 * found. If not, return the index where it would be if it were inserted in
 * order.
 * 
 * You may assume no duplicates in the array.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 * @author cassie9082
 * 
 */

/*
 * 本题是基本考察二分查找的题目，与基本二分查找方法不同的地方是，二分查找法当查找的target不在list中存在时返回-1，
 * 而本题则需要返回该target应在此list中插入的位置。
 * 当循环结束时，如果没有找到target，那么low一定停target应该插入的位置上，high一定停在恰好比target小的index上。
 * [1,3,5,6], 7 low = 0, high = 3 step1: mid = 1 A[mid] = 3, 3<7 low = mid + 1 =
 * 2 low = 2, high = 3  step2: mid = 2 A[mid] = 5, 5<7 low = mid + 1 = 3 low = 3, high = 3
 * step3: mid = 3 A[mid] = 6, 6<7 low = mid + 1 = 4 low = 4, high = 3 return low = 4; [1,3,5,6], 0 low = 0, high = 3
 * 
 * step1: mid = 1 A[mid] = 3, 3>0 high = mid - 1 = 0 low = 0, high = 0
 * step2: mid = 0 A[mid] = 1, 1>0 high = mid - 1 = -1 low = 0, high = -1 return 0
 */
public class SearchInsertPosition {

	public static int searchInsert(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int start = 0;
		int end = A.length - 1;
		int mid = -1;

		if (target < A[0]) {
			return 0;
		}

		if (target > A[A.length - 1]) {
			return A.length;
		}

		while (start + 1 < end) {
			mid = start + (end - start) / 2;
			if (A[mid] > target) {
				end = mid;
			} else if (A[mid] == target) {
				return mid;
			} else {
				start = mid;
			}
		}

		if (A[start] == target) {
			return start;
		}
		if (A[end] == target) {
			return end;
		}

		if (A[start] < target) {
			return start + 1;
		}

		if (A[end] > target) {
			return end - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] test = { 0, 3, 5, 7, 9, 11, 13 };
		int result = searchInsert(test, 4);
		System.out.println(result);
	}

}
