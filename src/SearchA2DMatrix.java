
public class SearchA2DMatrix {

	public static boolean searchMatrix(int[][] matrix, int target){
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return false;
		}
		
		int mid, ele;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int end = rows * cols - 1;
		int start = 0;
		
		while(start + 1 < end){
			mid = start + (end - start)/2;
			ele = matrix[mid/cols][mid%cols];
			
			
			if(ele == target){
				return true;
			}else if(ele < target){
				start = mid;
			}else{
				end = mid;
			}
		}
		
		ele = matrix[start/cols][start%cols];
		if(ele == target){
			return true;
		}

		ele = matrix[end/cols][end%cols];
		if(ele == target){
			return true;
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		int[][] i = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
		System.out.println(searchMatrix(i, 3));

	}

}
