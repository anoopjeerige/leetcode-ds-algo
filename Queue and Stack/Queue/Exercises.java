import java.util.*;

class Exercises {

	/** 
	* Using Floodfill algorithm
	* with implicit stack implementation four way
	* 1) Pick a start node which is a land '1' 
	* 2) Use flood fill algorithm to replace all connecting (4-way) lands with water '0'
	* 3) On return, count as one island
	* 4) Repeat until no lands
	*/
	public int numIslands(char[][] grid) {

		// Counter for number of islands
		int islandCount = 0;
		// Check empty input
		if (grid == null) {
			return islandCount;
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				// Check if land '1'
				if (grid[i][j] == '1') {
					// Floodfill connecting lands to water
					// floodFillStack(grid, i, j);
					floodFillQueue(grid, i, j);
					// Count islands
					islandCount++;
				}
			}
		}
		return islandCount;

	}

	/**
	* Floodfill method determines the area connected by target nodes '1'(land) and replaces it to '0'(water)
	*/
	public void floodFillStack(char[][] grid, int i, int j) {

		// Check valid node and node is land
		if (i >=0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
			// Set to water '0'
			grid[i][j] = '0';
			// Perform floodfill in four way
			// One step to south of node
			floodFillStack(grid, i + 1, j);
			// One step to north of node
			floodFillStack(grid, i - 1, j);
			// One step to west of node
			floodFillStack(grid, i, j - 1);
			// One step to east of node
			floodFillStack(grid, i, j + 1);
		}
	}

	/** 
	* Floodfill method determines the area connected by target nodes '1' (land) and replaces it to '0' (water)
	*/
	public void floodFillQueue(char[][] grid, int i, int j) {

		int m = grid.length;
		int n = grid[0].length;

		// Initialize empty queue to process connecting nodes
		Queue<Integer> q = new LinkedList<Integer>();

		// Set node to water '0'
		grid[i][j] = '0';

		// Encode node position and add to queue
		int code = i * n + j;
		q.offer(code);

		while (!q.isEmpty()) {

			// Remove first node from queue
			code = q.poll();

			// Decode position of node (Note - Use larger value if n and m)
			int x = code / n;
			int y = code % n;

			System.out.println("x:" + x);
			System.out.println("y:" + y);

			// Check node in four-way direction is target node
			// Set that node to water '0' and add to queue
			// West
			if (y > 0 && grid[x][y - 1] == '1') {
				grid[x][y - 1] = '0';
				q.offer(x * n + (y - 1));
			}

			// East
			if (y < n - 1 && grid[x][y + 1] == '1') {
				grid[x][y + 1] = '0';
				q.offer(x * n + (y + 1));
			}

			// North
			if (x > 0 && grid[x - 1][y] == '1') {
				grid[x - 1][y] = '0';
				q.offer((x - 1) * n + y);
			}

			// South
			if (x < m - 1 && grid[x + 1][y] == '1') {
				grid[x + 1][y] = '0';
				q.offer((x + 1) * n + y);
			}
		}

	}

	/** Open the Lock
	 * Using BFS to process the nodes and its successors
	 */
	public int openLock(String[] deadends, String target) {
        
		Queue<String> q = new LinkedList<String>();
		Set<String> deads = new HashSet<String>(Arrays.asList(deadends));
		Set<String> visited = new HashSet<String>();

		int depth = 0;
		String marker = "*";

		q.addAll(Arrays.asList("0000", marker));

		while (!q.isEmpty()) {

			String node = q.poll();

			if (node.equals(target)) {
				return depth;
			}

			if (deads.contains(node) || visited.contains(node)) {
				continue;
			}

			if (marker.equals(node) && q.isEmpty()) {
				return -1;
			}

			if (marker.equals(node)) {
				q.add(marker);
				depth++;
			} else {
				q.addAll(findSuccessors(node));
				visited.add(node);
			}
		}
		return depth;
    }

    /** Helper for open the lock
    * Given a node xxxx representing 4 locks with slots from 0 - 9, the function finds the successors of the nodes,
    * and returns them as a list
    */
    public List<String> findSuccessors(String node) {

    	List<String> result = new LinkedList<String>();
    	StringBuilder sb = new StringBuilder(node.length());

    	for(int i = 0; i < node.length(); i++) {
    		// forward direction
    		sb.append(node.substring(0, i)); // add substring before ith index
    		sb.append(node.charAt(i) == '9' ? 0 : node.charAt(i) - '0' + 1); // a hack to covert char to int, add converted ith char
    		sb.append(node.substring(i + 1)); // add substring after ith index
    		result.add(sb.toString()); // add to result
			
			// reverse direction
			sb.append(node.substring(0, i));
			sb.append(node.charAt(i) == '0' ? 9 : node.charAt(i) - '0' - 1);
			sb.append(node.substring(i + 1));
			result.add(sb.toString());
			
            sb.delete(0, node.length());
    	}
    	return result;
    }

    /** Display List of strings */
    public static void display(List<String> items) {
    	for(String item: items) {
    		System.out.print(item + " ");
    	}
    	System.out.println();
    }

	/** Testing */
	public static void main(String[] args) {

		// // Testing numIslands
		// // char[][] grid = {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}};
		// char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
		// System.out.println(grid.length);
		// System.out.println(grid[0].length);

		// Exercises ex = new Exercises();
		// System.out.println(ex.numIslands(grid));

		// Testing openLock
		Exercises ex = new Exercises();
		String[] deadends = {"0201","0101","0102","1212","2002"};
		String target = "0202";
		
		System.out.println(ex.openLock(deadends, target));

	}
}