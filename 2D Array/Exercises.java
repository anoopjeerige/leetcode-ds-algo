import java.util.*;

public class Exercises {
	
	/**
	* 2D Array - Diagonal Traverse
	*/
	public static int[] findDiagonalOrder(int[][] matrix) {

		// total rows
		int m = matrix.length;
		// total columns
		int n = matrix[0].length;
		// result to be returned
		int[] result = new int[m * n];
		// direction of diagonal traverse - diagonally upwards(1) and diagonally downwards(-1)
		int d = 1;
		// row index
		int row = 0;
		// column index
		int col = 0;


		// Traverse all elements
		for (int i = 0; i < (m * n); i++) {
			result[i] = matrix[row][col];
			row -= d;
			col += d;

			// Check bottom border
			if (row >= m) {
				row = m - 1;
				col += 2;
				d = -d;
			}

			// Check right border
			if (col >= n) {
				col = n - 1;
				row += 2;
			}

			// Check top border
			if (row < 0) {
				row = 0;
				d = -d;
			}

			// Check left border
			if (col < 0) {
				col = 0;
				d = -d;
			}
		}

		return result;
    }

    /**
    * 2D Array - Spiral Order
    */
    public static List<Integer> spiralOrder(int[][] matrix) {
        
        // Result to be returned
        List<Integer> result = new ArrayList<Integer>();
        
        // Total rows
        int mU = matrix.length;

        // Empty input check
        if (mU == 0) {
        	return result;
        }
        
        // Total columns
        int nU = matrix[0].length;

        // Total elements
        int n = mU * nU;
        
        // Lower limit of rows
        int mL = 0;
        
        // Lower limit of columns
        int nL = 0;

        // row index
        int row = 0;

        // column index
        int col = 0;

        // horizontal and vertical traverse directions in right(1), left(-1), same row or column(0)
        // Start horizontally right and same row
        int vD = 0;
        int hD = 1;

        // Traverse all elements in spiral order
        for (int i = 0; i < n; i++) {

        	result.add(matrix[row][col]);
        	// Row index moves along the vertical direction
        	row += vD;
        	// Column index moves along the horizontal direction
        	col += hD;

        	// Check right border
        	if (col >= nU) {
        		col = nU - 1;
        		row += 1;
        		
        		vD = 1;
        		hD = 0;
        	}

        	// Check bottom border
        	if (row >= mU) {
        		row = mU - 1;
        		col -= 1;
        		
        		vD = 0;
        		hD = -1;
        	}

        	// Check left border
        	if (col < nL) {
        		col = nL;
        		row -= 1;
        		
        		vD = -1;
        		hD = 0;
        	}

        	// Check top border
        	if ((row == mL) && (col == nL)) {
        		row += 1;
        		col += 1;

        		mL += 1;
        		nL += 1;
        		mU -= 1;
        		nU -= 1;

        		vD = 0;
        		hD = 1;
        	}
        }
        return result;
    }

    /**
    * 2D Array - Pascal's Triangle
    */
    public static List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if (numRows == 0) {
        	return result;
        }

        List<Integer> temp = new ArrayList<Integer>();
        temp.add(1);
        result.add(temp);

        if (numRows == 1) {
        	return result;
        }

        for (int i = 0; i < numRows - 1; i++) {
        	List<Integer> row = new ArrayList<Integer>();
        	row.add(1);
        	for (int j = 0; j < result.get(i).size() - 1; j++) {
        		row.add(result.get(i).get(j) + result.get(i).get(j + 1));
        	}
        	row.add(1);
        	result.add(row);
        }

        return result;

    }

    /**
    * Function to display array elements
    */
    public static void displayArray(int[] items) {
    	for (int item: items) {
    		System.out.print(item);
    		System.out.print(" ");
    	}
    	System.out.println();
    }

    /**
    * Function to display array elements
    */
    public static void displayArray(int[][] items) {

    	for (int[] itemRow: items) {
    		for (int item: itemRow) {
    			System.out.print(item);
    			System.out.print(" ");
    		}
    		System.out.println();
    	}
    }

    /**
    * Function to display array elements
    */
    public static void displayArray(List<Integer> items) {

    	for (int item: items) {
    		System.out.print(item);
    		System.out.print(" ");
    	}
    	System.out.println();
    }

    /**
    * Function to display array elements
    */
    public static void display2DArray(List<List<Integer>> items) {

    	for(List<Integer> itemRow: items) {
    		for (int item: itemRow) {
    			System.out.print(item);
    			System.out.print(" ");
    		}
    		System.out.println();
    	}
    }

    public static void main(String[] args) {

    	// // Test 2D Array - Diagonal Traverse
    	// int[][] test = {{1, 2}, {3, 4}};

    	// int[] result = findDiagonalOrder(test);

    	// displayArray(result);
    	// displayArray(test);

    	// // Test 2D Array - Spiral Order
    	// int[][] test = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    	// int[][] test1 = {};
    	// List<Integer> result = spiralOrder(test1);
    	// displayArray(result);

    	// Test 2D Array - Pascal's Triangle
    	List<List<Integer>> result = generate(2);
    	display2DArray(result);

    }
}