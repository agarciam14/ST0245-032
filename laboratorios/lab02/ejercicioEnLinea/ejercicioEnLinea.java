public class ejercicioEnLinea
{
    //Ejercicios Array 2
    public int countEvens(int[] nums) {
        int cont = 0;
  
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] % 2 == 0) {
                cont = cont + 1;
            }
        }
        return cont;
    }
    
    
    
    public int bigDiff(int[] nums) {
        int vm = nums[0];
        int vM = 0;
  
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= vM) {
                vM = nums[i];
            }
        }
  
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= vm) {
                vm = nums[i];
            }
        }
  
        return vM - vm;
    }
    
    
    
    
    public int centeredAverage(int[] nums) {
        int may = nums[0];
        int men = nums[0];
        int sum = 0;
  
        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
    
            if(nums[i] < men) 
            men = nums[i];
            if(nums[i] > may) 
            may = nums[i];
        }
  
        return (sum - (may + men)) / (nums.length -2);
    }
    
    
    
    public int sum13(int[] nums) {
        int cont = 0;
  
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 13) {
                i++;
            } else {
                cont += nums[i];
            }
        }
        return cont;
    }
    
    
    
    
    public int sum67(int[] nums) {
        int cont = 0;
  
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 6) {
                cont += nums[i];
            } else { 
                while(nums[i] != 7) {
                    i++;
                }  
            }
        }
        return cont;
    }
    
    
    //Ejercicios Array 3
    public int maxSpan(int[] nums) {
     if(nums.length < 2)
        return nums.length;
  
     if(nums[nums.length - 1] == nums[0])
        return nums.length;
    
     return nums.length - 1;
     }
    
    
    
    public int[] fix34(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 3) {
                int save = nums[i+1];
                nums[i+1] = 4;
                for(int j = i + 2; j < nums.length; j++) {
                    if(nums[j] == 4)
                    nums[j] = save;
                }
            }
        }
        return nums;
    }
    
    
    
    public int[] fix45(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4) {
                for (int j = 0; j < nums.length; j++) {
                    if (nums[j] == 5) {
                        if (j > 0 && nums[j-1] != 4) {
                            int save = nums[i+1];
                            nums[i+1] = 5;
                            nums[j] = save;
                        } else if (j == 0) {
                            int save = nums[i+1];
                            nums[i+1] = 5;
                            nums[j] = save;
                        }
                    }
                }
            }
        }
        return nums;
    }
    
    
    
    public boolean canBalance(int[] nums) {
        int sum = 0;
  
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int suma = 0;
            for (int j = nums.length-1; j > i; j--) {
                suma += nums[j];
            }
            if (suma == sum)
            return true;
        }
        return false;
    }
    public boolean linearIn(int[] outer, int[] inner) {
        int out = 0;
        int in = 0;
  
        while (in < inner.length && out < outer.length) {
            if (outer[out] == inner[in]) {
                out++;
                in++;
            } else out++;
        }
        return (in == inner.length);
    }
}
