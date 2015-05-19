/**
 * 
 * @author Cassie
 *
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * 
 * 
 * 整数的求平方根函数
 * 这个其实也是毕竟常见的面试问题，要求不调用math库，实现对整数的sqrt方法，返回值只需要是整数。
 * 其实这个问题用数学的表达方式就是：对于非负整数x，找出另一个非负整数n，其中n满足 n^2 <= x < (n+1)^2。
 * 所以最直接的方法就是从0到x遍历过去直到找到满足上述条件的n。这个算法的复杂度自然是O(n)。
 * 仔细想想，其实要找的数是在0和x之间，而他正巧可以视为一个有序的数组。似乎有可以运用二分查找法的可能。
 * 再回想二分查找法是要找到满足“与目标数相等”这一条件的数，而这里同样也是要找满足一定条件的数。
 * 所以就可以用二分法来解这个问题了，让复杂度降为O(logn)。
 */
 
public class Sqrt {

	public static void main(String[] args) {
		Sqrt s = new Sqrt();
        System.out.println(s.sqrt(25));
        System.out.println(s.sqrt(2));
        System.out.println(s.sqrt(48));
        System.out.println(s.sqrt(50));

	}

	public int sqrt(int x) {
		 if(x < 1){
			 return x;
		 }
		 
		 int start = 1;
		 int end = x;
		 int mid = 0;
		 
		 while(start + 1 < end){
			 mid = start + (end - start)/2;
			 //不能寫成mid*mid == x， 怕溢出
			 if(mid == x/mid){
				 return mid;
			 }else if(mid > x/mid){
				 end = mid;
			 }else{
				 start = mid;
			 }
		 }
		 
		 //x如果是50的話，7 * 7=49，所以最後return的是7（49 < 50 < 64)-->(n^2 < x < (n+1)^2)
		 if(start < x/start){
		     return start;
		 }
		 
		 return end;
	}
}
