/* Radisa Hussein Rachmadi - 2301891752
	Binus Computer Science 2023
	Even Semester
*/

// ================================================================== //

#include <iostream>

/* run this program using the console pauser or add your own getch, system("pause") or input loop */


using namespace std; //no longer neccessary to type in std


//All void classes for shapes
//-----------------------------------------------------------------//


void leftAngledTriangle(int rows)
// For left alligned, right angle - triangle
{
	for(int i= 1; i <= rows; i++)
	{
		for(int j = 1; j <= i; j++)
		{
			cout << "* ";
		}
		cout << "\n";
	}
	
	
}

void flippedLeftAngledTriangle(int rows)
// For upside down, left alligned, right angle-triangle
{
	for(int i = rows; i >= 1; i--)
	{
		for(int j = 1; j <= i; j++)
		{
			cout << "* ";
		}
		cout << "\n";
	}
	
	
}

void rightAngledTriangle(int rows)
// For right alligned, right angle - triangle
{
	for (int i = 1; i <= rows;i++)
	{
		for (int k = rows - i; k > 0;k--)
		{
			cout << "  ";
		}
		
		for (int x = 1; x<=i;x++)
		{
			cout << "*" << " ";
		}
		
		cout << "\n";
	}
	
}

void flippedRightAngledTriangle(int rows)
// For upside down, right alligned, right angle - triangle
{
	for (int i = rows; i > 0;i--)
	{
		for(int k = rows - i; k > 0;k--)
		{
			cout << "  ";
		}
		
		for (int x = 1; x <= i ;x++)
		{
			cout << "*" << " ";
		}
		
		cout << "\n";
	}
	
}

void equilateralTriangle(int rows)
// For equilateral triangle
{
	
	for (int i = 1; i <= rows; i++)
	{
		for (int j = rows - i; j > 0; j--)
		{
			cout << "  ";
		}
		
		for (int k = 1; k <= (i*2) - 1;k++)
		{
			cout << "* ";
		}
		
		for (int j = rows - i; j > 0; j--)
		{
			cout << "  ";
		}
		
		cout << "\n";
	}
	
}

void flippedEquilateralTriangle(int rows)
// For upside down, equilateral triangle
{
	
	for (int i = rows; i > 0; i--)
	{
		for (int j = rows - i; j > 0; j--)
		{
			cout << "  ";
		}
		
		for (int k = 1; k <= (i*2)-1;k++)
		{
			cout << "* ";
		}
		
		for (int j = rows - i; j > 0; j--)
		{
			cout << "  ";
		}
		
		cout << "\n";
	}
	
}

void rhombus(int rows)
// For rhombus / diamond, has a total of (n*2) - 1 rows
{
	for (int i = 1; i <= rows; i++)
	{
		for (int j = rows - i; j > 0; j--)
		{
			cout << "  ";
		}
		
		for (int k = 1; k <= (i*2) - 1;k++)
		{
			cout << "* ";
		}
		
		for (int j = rows - i; j > 0; j--)
		{
			cout << "  ";
		}
		
		cout << "\n";
	}
	
	for (int i = rows - 1; i > 0; i--)
	{
		for (int j = rows - i; j > 0; j--)
		{
			cout << "  ";
		}
		
		for (int k = 1; k <= (i*2)-1;k++)
		{
			cout << "* ";
		}
		
		for (int j = rows - i; j > 0; j--)
		{
			cout << "  ";
		}
		
		cout << "\n";
	}
}

// ---------------------------------------------------------------- //

int main(){
// Main function to call all the void functions
	
	//User input for number of rows; exception for Rhombus
	cout << "Number of Rows: ";
	int rowInput;
	cin >> rowInput;
	
	
	leftAngledTriangle(rowInput);
		cout << "\n";
	flippedLeftAngledTriangle(rowInput);
		cout << "\n";
	
	rightAngledTriangle(rowInput);
		cout << "\n";
	
	flippedRightAngledTriangle(rowInput);
		cout << "\n";
	
	equilateralTriangle(rowInput);
		cout << "\n";
		
	flippedEquilateralTriangle(rowInput);
		cout << "\n";
	
	rhombus(rowInput);
	
	
	return 0;

}

// ================================================================== //

/* Radisa Hussein Rachmadi - 2301891752
	Binus Computer Science 2023
	Even Semester
*/

