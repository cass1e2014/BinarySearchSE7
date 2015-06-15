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

	public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return null;
        }
        
        int[] result = new int[2];
        int start, end, mid;
        //left bound ::
        start = 0;
        end = nums.length - 1;
        while(start + 1 < end){
            mid = start + (end - start) / 2;
            if(nums[mid] > target){
                end = mid;
            }else if(nums[mid] == target){
                //算左边界的时候，当mid的对应值等于target的时候，把end给mid
                //这样就不会进入下一个while loop，left bound即确定
                end = mid;
            }else{
                start = mid;
            }
        }
        if(nums[start] == target){
            result[0] = start;
        }else if(nums[end] == target){
            result[0] = end;
        }else{
            result[0] = result[1] = -1;
            return result;
        }
        
        //right bound ::
         start = 0;
         end = nums.length - 1;
         while(start + 1 < end){
             mid = start + (end - start) / 2;
             if(nums[mid] > target) {
                 end = mid;
             }else if(nums[mid] == target){
                 start = mid;
             }else{
                 start = mid;
            }
         }
         
         //要把nums[end] == target 写在nums[start] == target前面
         //[2,2], 2 ==> return [0,1]
         if(nums[end] == target){
            result[1] = end;
         }else if(nums[start] == target){
            result[1] = start;
         }else{
            result[0] = result[1] = -1;
            return result;
         }
         return result;
    }
	
	public static void main(String[] args) {
		int[] test = {2, 2};
		int[] result = searchRange(test, 2);
		System.out.println(Arrays.toString(result));
	}

}
