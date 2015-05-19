/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author cassie9082
 * 
 */

/**
 * 首先假设一个sorted没有rotated的数组[1,2,3]，假设我们通过一个pivot把这个数组rotate，那么结果可能为：[2,3,1],
 * [3,1,2], 可以发现：num[low]永远大于（或等于）num[high]。
 * 
 * num[mid]有两种可能性，如果num[mid] >
 * num[high]，证明num[mid]在rotated后的那个区间内，这个区间我们刚才已知都大于pivot之前的值
 * ，所以最小值就在low=mid+1那个区间内。另一种可能，num[mid] <=
 * num[high]，那么我们刚才可以看出来这种可能性说明mid~high之间是排好序的，那么最小值在high=mid这个区间内（mid可能是最小值）。
 * 
 */
public class FindMinimumInRotatedSortedArray {

	public static void main(String[] args) {
		int[] num = {7, 1, 2, 3, 4, 5, 6};
		System.out.println(findMin(num));
	}

	public static int findMin(int[] num) {
		if(num == null || num.length == 0){
			return 0;
		}
		int start = 0;
		int end = num.length - 1;
		
		while(start + 1 < end){
			int mid = start + (end - start) / 2;
			if(num[mid] <= num[start]) { 
				end = mid;
			}else{
				start = mid;
			}
		}
		
		if(num[start] < num[end]){
			return num[start];
		}else{
			return num[end];
		}
	}
}
