/**
 * Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why? Suppose a sorted
 * array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * @author cassie9082
 * 
 */
/**
 * 重复元素的出现影响到了算法的复杂度 所以最坏情况就会出现每次移动一步，总共移动n此，算法的时间复杂度变成O(n)。
 * 
 */
public class FindMinimumInRotatedSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findMin(int[] num) {
		if (num == null || num.length == 0) {
			return 0;
		}
		int len = num.length;
		if (len == 1) {
			return num[0];
		} else if (len == 2) {
			return Math.min(num[0], num[1]);
		}

		int start = 0;
		int end = len - 1;

		while (start + 1 < end) {
			int mid = start + (end - start) / 2;
			// 此种情况array是sort的，直接返回array的起点
			if (num[start] < num[end]) {
				return num[start];
			}

			// left side is sorted. CUT the left side.
			if (num[mid] > num[start]) {
				start = mid;
				// left side is unsorted, right side is sorted. CUT the right
				// side.
			} else if (num[mid] < num[start]) {
				end = mid;
			} else{
				start ++;
			}
		}
		return Math.min(num[start] , num[end]);
	}

}
