/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted in ascending from left to right. Integers in
 * each column are sorted in ascending from top to bottom. For example,
 * 
 * Consider the following matrix:
 * 
 * [
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
  ]
 * 
 * Given target = 5, return true.
 * Given target = 20, return false.
 * 
 * 从最右上角开始做。由于左边的元素一定不大于当前元素，而下面的元素一定不小于当前元素，因此每次比较时均可排除一列或者一行元素
 * 复杂度要求——O(m+n) time and O(1) extra space
 * @author cassie9082
 * 
 */
public class SearchA2DMatrixII {

	public static void main(String[] args) {
		int[][] matrix = {{-5}};
		System.out.println(searchMatrix(matrix, -5));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix[0] == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        
        int m = 0;
        int n = matrix[0].length - 1;
        int ele;
        while(m < matrix.length && n >= 0){
            ele = matrix[m][n];
            if(ele == target){
                return true;
            }
            else if(target < ele){
                n --;
            }
            else if(target > ele){
                m ++;
            }
        }
        return false;
    }
	
}
