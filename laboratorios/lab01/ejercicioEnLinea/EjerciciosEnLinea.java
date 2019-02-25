public class EjercicioEnLinea
{
    //Ejercicios recursion1
    public int factorial(int n) {
        if(n == 0) 
        return 1;

        return factorial(n-1) * n;
    }
    public int bunnyEars(int bunnies) {
        if(bunnies == 0)
        return 0;
  
        return bunnyEars(bunnies - 1) + 2;
    }
    public int fibonacci(int n) {
        if(n == 0)
        return 0;
        if(n == 1)
        return 1;
  
        return fibonacci(n-1) + fibonacci(n-2);
    }
    public int bunnyEars2(int bunnies) {
        if(bunnies == 0)
        return 0;
        if(bunnies == 1)
        return 2;
  
        return (3 - bunnies % 2) + bunnyEars2(bunnies - 1);
    }
    public int triangle(int rows) {
        if(rows == 0)
        return 0;
        if(rows == 1)
        return 1;
  
        return triangle(rows - 1) + rows;
    }
    // Ejercicios recursion2
    public boolean splitArray(int[] nums) {
        int i=0;
        int sum1=0;
        int sum2=0;
        return splitArray(nums, i, sum1, sum2);
    }
    private boolean splitArray(int[] nums, int i, int sum1, int sum2){
        if(i>=nums.length){
            return sum1==sum2;
        }
        return splitArray(nums,i+1,sum1+nums[i],sum2)||splitArray(nums,i+1,sum1,sum2+nums[i]);
    }
    public boolean splitOdd10(int[] nums) {
        int i=0;
        int sum1=0;
        int sum2=0;
        return splitOdd10(nums,i,sum1,sum2);
    }
    private boolean splitOdd10(int[] nums, int i, int sum1, int sum2){
        if(i>=nums.length){
        return (sum1%10==0&&sum2%2!=0);
        }
        return splitOdd10(nums, i+1, sum1+nums[i], sum2)||splitOdd10(nums, i+1, sum1, sum2+nums[i]);
    }
    public boolean split53(int[] nums) {
      int i=0;
      int sum1=0;
      int sum2=0;
      return split53(nums,i,sum1,sum2);
    }
    private boolean split53(int[] nums, int i, int sum1, int sum2){
      if(i>=nums.length){
        return (sum1==sum2);
      }
      int value= nums[i];
      if (value%5==0){
        return split53(nums, i+1, sum1+nums[i], sum2);
      }
      if (value%3==0){
        return split53(nums, i+1, sum1, sum2+nums[i]);
      }
      return split53(nums, i+1, sum1+nums[i], sum2)||split53(nums, i+1, sum1, sum2+nums[i]);
    }
    public boolean groupNoAdj(int start, int[] nums, int target) {
      if(start>=nums.length){
        return target==0;
      }
      return groupNoAdj(start+2,nums,target-nums[start])||groupNoAdj(start+1,nums,target);
    }
    public boolean groupSumClump(int start, int[] nums, int target) {
      if(start>=nums.length){
        return target==0;
      }
      int rep=1;
      for(int i=start+1;i<=nums.length-1;i++){
        if(nums[i]==nums[start]){
          rep++;
        }else{
          break;
        }
      }
      return groupSumClump(start+rep,nums,target)||groupSumClump(start+rep,nums,target-(nums[start]*rep));
    }
    
    
    public boolean groupSum5(int start, int[] nums, int target) {
  if(start < nums.length) {
    if(start > 0) {
      if(nums[start - 1] % 5 == 0 && nums[start] == 1) 
        return groupSum5(start + 1,nums,target);
    } 
  if(nums[start] % 5 == 0)
    return groupSum5(start+1,nums,target-nums[start]);
  else 
    return groupSum5(start+1,nums,target) || groupSum5(start+1,nums,target-nums[start]);
  }
  
  if(target == 0) 
      return true; 
    return false; 
  }
}
