public class EjercicioEnLineaCodingBat
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
  
        return (bunnies/2) + bunnies + bunnies ;
    }
    public int triangle(int rows) {
        if(rows == 0)
        return 0;
        if(rows == 1)
        return 1;
  
        return triangle(rows - 1) + rows;
    }
    // Ejercicios recursion2
}
