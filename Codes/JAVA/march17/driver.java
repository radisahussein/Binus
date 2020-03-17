//Radisa Hussein Rachmadi - 2301891752
package march17;
import java.util.Scanner;
import java.util.Arrays;

public class driver
{
    public static void main(String[] args)
    {
        utility myUtility = new utility();


        // NUMBER ONE
        myUtility.one();

        //NUMBER TWO
        Scanner sc = new Scanner(System.in);
        System.out.print("\nInput ROT : ");
        int rot = sc.nextInt();
        
        if (rot < 1)
        {
            System.out.println("Please input postive integers above 1");
            System.exit(0);
        }

        myUtility.two(rot);

        // NUMBER THREE
        int matrix[][] = { { 1 , 2 , 3},
                        { 4 , 5 , 6 },
                        { 7 , 8 , 9}};

        for (int[] row : matrix)
        {   
            System.out.println(Arrays.toString(row));
        }
        

        if (myUtility.symmetric(matrix, 3) == true)
        {
            System.out.println("This matrix is symmetric");
        }   

        else
        {
            System.out.println("This matrix is assymetrical!");
        }
    


        // NUMBER FOUR
        System.out.print("Input a positive number greater than 1 : ");
        int size = sc.nextInt();
        if (size > 1 && (size % 2 == 1))
        {
            myUtility.oddMagicSquare(size);
        }

        else if (size > 1 && (size % 2 == 0))
        {
            myUtility.evenMagicSquare(size);
        }

        else
        {
            System.out.println("Error! Invalid Size");
            System.exit(0);
        }


        sc.close();
        
    }
};
