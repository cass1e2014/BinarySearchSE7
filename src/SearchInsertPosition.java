
public class SearchInsertPosition {

	public static int searchInsert(int[] A, int target){
		if(A == null || A.length == 0){
			return -1;
		}
		
		int start = 0;
		int end = A.length - 1;
		int mid = -1;
		int count = 0;
		
		if(target < A[0]){
			return 0;
		}
		
		if(target > A[A.length - 1]){
			return A.length;
		}
		
		while(start + 1 < end){
			System.out.println("While" + count++);
			mid = start + (end - start)/2;
			System.out.println("start = " + start + ", end = " + end + ", mid = " + mid);
			if(A[mid] > target){
				end = mid;
			}else if(A[mid] == target){
				return mid;
			}else{
				start = mid;
			}
		}
		
		System.out.println("End While:");
        System.out.println("start = " + start + ", end = " + end + ", mid = " + mid);
        
		if(A[start] == target){
			return start;
		}
		if(A[end] == target){
			return end;
		}
		
		if(A[start] < target){
			return start + 1;
		}
		
		if(A[end] > target){
			return end - 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] test = {0, 3, 5, 7, 9, 11, 13};
		int result = searchInsert(test, 4);
		System.out.println(result);
	}

}
