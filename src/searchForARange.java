import java.util.Arrays;

/**
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 */

public class searchForARange {

	public static int[] searchRange(int[] A, int target){
		int bound[] = new int[2];
		int start, end, mid;
		
		//left bound
		start = 0;
		end = A.length - 1;
		while(start + 1 < end){
			mid = start + (end - start)/2;
			if(A[mid] > target){
				end = mid;
			}else if(A[mid] == target){
				end = mid;//当mid位置的value和target相等时，因为要求左边边界，把mid位置赋给end
			}else{
				start = mid;
			}
		}
		
		if(A[start] == target){
			bound[0] = start;
		}else if(A[end] == target){
			bound[0] = end;
		}else{
			bound[0] = bound[1] = -1;
		}
		
		
		//right bound
		start = 0 ;
		end = A.length - 1;
		while(start + 1 < end){
			mid = start + (end - start)/2;
			if(A[mid] == target){
				start = mid;//当mid位置的value和target相等的时候，因为要求右边边界，把mid位置给start
			}else if(A[mid] > target){
				end = mid;
			}else{
				start = mid;
			}
		}
		
		if(A[start] == target){
			bound[1] = start;
		}else if(A[end] == target){
			bound[1] = end;
		}else{
			bound[1] = bound[0] = -1;
		}
		return bound;
	}
	
	public static void main(String[] args) {
		int[] test = {5, 7, 7, 8, 8, 10};
		int[] result = searchRange(test, 8);
		System.out.println(Arrays.toString(result));
	}

}
