
/**
 * Laboratorio 1 de Estructuras de Datos 1
 * 
 * @author Mauricio Toro 
 * @version 1
 */

import java.util.Arrays;

public class Laboratory1
{
  // Computer the sum of an array
  public static int ArraySum(int[] A)
  {          
      int sum = 0;
      for (int i = 0; i < A.length; i++)
         sum = sum + A[i];
      return sum;
  }
  
  // Computes the maximum value of an array
  public static int ArrayMax(int[] A)
  {
      int max = A[0];
      for (int i = 0; i < A.length; i++)
         if (A[i] > max)
           max = A[i];
      return max;
  }
  
  // Sorts an array using Insertion Sort
  public static void InsertionSort(int[] A) throws InterruptedException
  {
       int temp,j;
       for (int i = 0; i < A.length; i++)
       {
	 TimeUnit.MILLISECONDS.sleep(1);
         j = i;
         while (j > 0 && A[j-1] > A[j])
           {
	       TimeUnit.MILLISECONDS.sleep(1);
               temp = A[j];
               A[j] = A[j-1];
               A[j-1] = temp;
               j = j-1;
            }           
       }
       System.out.println(Arrays.toString(A));
  }

      // Sorts an array using Merge Sort
      // Taken from www.cs.cmu.edu/
	public static void mergeSort(int [ ] a) throws InterruptedException
	{
		int[] tmp = new int[a.length];
		mergeSort(a, tmp,  0,  a.length - 1);
	}


	private static void mergeSort(int [ ] a, int [ ] tmp, int left, int right) throws InterruptedException
	{
		if( left < right )
		{
			TimeUnit.MILLISECONDS.sleep(1);
			int center = (left + right) / 2;
			mergeSort(a, tmp, left, center);
			mergeSort(a, tmp, center + 1, right);
			merge(a, tmp, left, center + 1, right);
		}
	}


    private static void merge(int[ ] a, int[ ] tmp, int left, int right, int rightEnd ) throws InterruptedException
    {
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

	TimeUnit.MILLISECONDS.sleep(1);
        while(left <= leftEnd && right <= rightEnd)
            if(a[left] <= a[right] )
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    // Copy rest of first half
            tmp[k++] = a[left++];

        while(right <= rightEnd)  // Copy rest of right half
            tmp[k++] = a[right++];

        // Copy tmp back
        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];
    }
  
  public static int[] ran(int n){
  	int []array=new int[n];
	for(int i=0;i<n;i++){
		array[i]=(int)(Math.random()*100);
	}
	return array;
  }
  public static void main(String[] args) throws InterruptedException
  {
      for (int j=5;j<225;j=j+10)
      { 
	      int[]X=ran(j);
	      long inicio= System.currentTimeMillis();
	      Laboratory1.mergeSort(X);
	      long fin= Syestem.currentTimeMillis();
	      System.out.println("Tamaño del arreglo: "+ j +" Tiempo Merge: "+(fin-inicio)); 
	      inicio= System.currentTimeMillis();
	      Laboratory1.InsertionSort(X);
	      fin= Syestem.currentTimeMillis();
	      System.out.println("Tamaño del arreglo: "+ j +" Tiempo Insertion: "+(fin-inicio)); 
	      System.out.println(Laboratory1.ArraySum(X) + " " + Laboratory1.ArrayMax(X) + "\n" );      
      }
  }
}
