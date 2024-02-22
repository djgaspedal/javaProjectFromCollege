// gmh80623@lockhaven.edu

import java.util.*;

// 	- Public Class That Asks User For Number of Generated Matrixes.
//		- Prints Those Matrixes.
//			- Checks For The Same Number on Rows,
//				- Columns, Diagonals, and Sub-Diagonals.
//					- Lists Where 1s && 0s Appear.
public class Chapter8Assignment {

	// Main Method Runs Every Other Method
	//		Through a "Method Pipeline" Like This:
	//						-> userInputAndNumMatrixes -> printCheckMatrix
	//						-> 4x Checking Methods -> generateRandomMatrix
	//						-> printWhere1And0 -> printMatrix						
	public static void main(String[] args) {
		
		// Runs Program Fully.
		userInputAndNumMatrixes();
        
	}
	
	// Prints Confirmation For Rows, Columns, Sub-Diagonals, and Diagonals with the same numbers.
    public static void printCheckMatrix(int[][] matrix) {
    	
    	// Checks Diagonal
    	if(checkDiagonal(matrix)) {
    		System.out.println("Diagonal of Same Number: true!");
    	}
    	
    	// Checks Sub-Diagonal
    	if(checkSubdiagonal(matrix)) {
    		System.out.println("Sub-Diagonal of Same Number: true!");
    	}
    	
    	// Checks *ALL* Rows.
    	for(int a = 0; a < matrix.length; a++) {
    		
    		if(checkRow(matrix, a) == true) {
    			
    			System.out.println("Index of Row That Has The Same Number: " + a);
    		}
    	}
        
    	// Checks *ALL* Columns.
    	for(int b = 0; b < matrix.length; b++) {
    		if(checkColumn(matrix, b) == true) {
    			
    			System.out.println("Index of Column That Has The Same Number: " + b);
    		}
    	}
    }
	
	
	public static void userInputAndNumMatrixes() {
		
		// New Scanner Object For User Input.
		Scanner userInput = new Scanner(System.in);
		
		// # of Matrices Primitive int Variable Named 'numMatrices'.
		System.out.print("Enter the number of matrices to generate: ");
        int numMatrices = userInput.nextInt();
		
        // Length of Matrice Primitive int Variable Named 'len'.
		System.out.println("Enter The Length of a Square Matrix: ");
		int len = userInput.nextInt();
		
		// Repeats Bulk of Program For How Many Matrices User Requests.
        for (int matrixNum = 1; matrixNum <= numMatrices; matrixNum++) {
        	
        	// Prints Where Same Numbers Exist Using Return Values From The 'generateRandomMatrix()' Method.
        	printCheckMatrix(generateRandomMatrix(len));
        	
        	// Serves For Formatting Purposes ONLY.
        	System.out.println();
        }
        
        // Closes Scanner For No Memory Leaks
        userInput.close();
	}
	
	// Initializes/Generates a Random Matrix and Calls The 'printMatrix()' Method Within Code Block.
	public static int[][] generateRandomMatrix(int size) {
        
		// Initializes New Matrix Every Invocation.
		int[][] inputMatrix = new int[size][size];
		
		// New Random Object For Use Within Method
        Random random = new Random();
        
        for (int i = 0; i < size; i++) {
        	
            for (int j = 0; j < size; j++) {
            	
            	// Psuedo-Randomly Generates 0 or 1 Using The Random Class.
                inputMatrix[i][j] = random.nextInt(2);
            }
        }
        
        // Uses Generated Matrix as a Parameter To Print To Console.
        // Note: **ONLY PRINTS THE MATRIX WITH RANDOM 1s && 0s**
        printMatrix(inputMatrix);
        
        // Records Where 1s && 0s Are
        printWhere1And0(inputMatrix);
        
        // Return Generated 'inputMatrix' After Calling 'printMatrix()'.
        return inputMatrix;
    }
	
	// Prints to Console where 1s && 0s Exist
	public static void printWhere1And0(int[][] inputMatrix) {
		
		for (int i = 0; i < inputMatrix.length; i++) {
			for (int j = 0; j < inputMatrix.length; j++) {
				
            	if(inputMatrix[i][j] == 1) {
            		
            		System.out.println("1 Exists At: " + "[Row:" + i + "]" + " [Column:" + j + "]");
            	} else {
            		
            		System.out.println("0 Exists At: " + "[Row:" + i + "]" + " [Column:" + j + "]");
            	}
            }
        }
		
		// Serves For Formatting Purposes ONLY.
		System.out.println();
	}
	

    // Prints The Matrix To Console Using A Matrix as a Parameter.
    public static void printMatrix(int[][] matrix) {
    	
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
            	
                System.out.print(matrix[i][j]);
            }
            
            // Serves For Formatting Purposes ONLY.
            System.out.println();
        }
        
        // Serves For Formatting Purposes ONLY.
        System.out.println();
    }

    // Checks If a Row Contains All The Same Numbers.
    public static boolean checkRow(int[][] matrix, int row) {
    	
        int size = matrix.length;
        
        int firstValue = matrix[row][0];
        
        for (int j = 1; j < size; j++) {
        	
            if (matrix[row][j] != firstValue) {
            	
                return false;
            }
        }
        
        return true;
    }

    // Checks If a Column Contains All The Same Numbers.
    public static boolean checkColumn(int[][] matrix, int col) {
    	
        int size = matrix.length;
        
        int firstValue = matrix[0][col];
        
        for (int i = 1; i < size; i++) {
        	
            if (matrix[i][col] != firstValue) {
            	
                return false;
            }
        }

        return true;
    }

    // Checks If The Main Diagonal Contains All The Same Numbers.
    public static boolean checkDiagonal(int[][] matrix) {
    	
        int size = matrix.length;
        
        int firstValue = matrix[0][0];
        
        for (int i = 1, j = 1; i < size && j < size; i++, j++) {
        	
            if (matrix[i][j] != firstValue) {
            	
                return false;
            }
        }
        
        return true;
    }

    // Checks If The Sub-Diagonal Contains All The Same Numbers.
    public static boolean checkSubdiagonal(int[][] matrix) {
    	
        int size = matrix.length;
        
        int firstValue = matrix[1][0];
        
        for (int i = 2, j = 0; i < size && j < size - 2; i++, j++) {
        	
            if (matrix[i][j] != firstValue) {
            	
                return false;
                
            }
        }
        
        return true;
    }
    
}