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
		int min = num[0];
		for(int i = 1; i < num.length; i++){
			if(num[i] < min){
				min = num[i];
			}
		}
		return min;
	}

}
