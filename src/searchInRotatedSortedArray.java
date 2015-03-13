
public class searchInRotatedSortedArray {

	public static int search(int[] A, int target){
		if(A == null || A.length == 0){
			return -1;
		}
		
		int start = 0;
		int end = A.length - 1;
		int mid;
		
		while(start + 1 < end){
			mid = start + (end - start) / 2;
			if(A[mid] == target){
				return mid;
			}
			if(A[mid] > A[start]){
				if(target >= A[start] && target <= A[mid]){
					end = mid;
				}else{
					start = mid;
				}
			}else{
				if(target >= A[mid] && target <= A[end]){
					start = mid;
				}else{
					end = mid;
				}
			}
		}
		
		if(A[start] == target){
			return start;
		}
		if(A[end] == target){
			return end;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] test ={4, 5, 6, 7, 0, 1, 2};
		int result = search(test, 2);
		System.out.println(result);
	}

}
