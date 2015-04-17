/**
 * Follow up for "Search in Rotated Sorted Array": What if duplicates are
 * allowed?
 * 
 * Would this affect the run-time complexity? How and why?
 * 
 * Write a function to determine if a given target is in the array.
 * 
 * @author cassie9082
 * 
 * 考虑1111111111181， 无法二分，只能线性
 */
public class SearchInRotatedSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean search(int[] A, int target) {
		for(int i = 0; i < A.length; i ++){
			if(A[i] == target){
				return true;
			}
		}
		return false;
	}

}
