/**
 * There is an integer array which has the following features:
 * 
 * The numbers in adjacent positions are different. A[0] < A[1] && A[A.length -
 * 2] > A[A.length - 1]. We define a position P is a peek if A[P] > A[P-1] &&
 * A[P] > A[P+1]. Find a peak element in this array. Return the index of the
 * peak. Note The array may contains multiple peeks, find any of them.
 * 
 * Example [1, 2, 1, 3, 4, 5, 7, 6] return index 1 (which is number 2) or 6
 * (which is number 7)
 * 
 * Challenge Time complexity O(logN)
 * 
 * @author cassie9082
 * 
 */

public class FindPeakElement {
	
	/**
	 * @param A: An integers array. ［BinarySearch]
	 * @return: return any of peek positions. 关键 ：：可以返回任意peek值的位置！
	 */
	public int findPeak(int[] A) {
		int point = 1;
		int size = A.length;
		while(point <= size){
			int mid = (point + size) / 2;
			if(A[mid] > A[mid - 1] && A[mid] > A[mid + 1]){
				return mid;
			}
			if(A[mid] > A[mid - 1]){
				point = mid + 1;
			}else{
				point = mid - 1;
			}
		}
		return -1;
	}
}
