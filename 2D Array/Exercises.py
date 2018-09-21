class Solution:

    def findDiagonalOrder(self, matrix):
        """
        2D Array - Diagonal Traverse
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        if len(matrix) == 0:
            return []

        m, n = len(matrix), len(matrix[0])
        result = []
        row, col, d = 0, 0, 1

        for i in range(m * n):
            result.append(matrix[row][col])
            row -= d
            col += d

            if row >= m:
                row = m - 1
                col += 2
                d = -d

            if col >= n:
                col = n - 1
                row += 2
                d = -d

            if row < 0:
                row = 0
                d = -d

            if col < 0:
                col = 0
                d = -d

        return result


    def spiralOrder(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: List[int]
        """
        # Empty input check
        if len(matrix) == 0:
            return []

        # Initialize boundry limits for rows and columns
        mU, nU, mL, nL = len(matrix), len(matrix[0]), 0, 0

        # Initialize row index, column index, and traversal directions, horizontal and vertical taking values (-1, 0, 1)
        row, col, hD, vD = 0, 0, 1, 0

        # Result to store sprial order
        result = []

        # Total elements count
        n = mU * nU

        # Loop through all elements
        for _ in range(n):
            # Traverse and append spiral order
            result.append(matrix[row][col])
            row += vD
            col += hD

            # Right border check
            if col >= nU:
                vD = 1
                hD = 0
                col = nU - 1
                row += 1

            # Bottom border check
            if row >= mU:
                vD = 0
                hD = -1
                col -= 1
                row = mU - 1

            # Left border check
            if col < nL:
                vD = -1
                hD = 0
                col = nL
                row -= 1

            # Top border check
            if row == mL and col == nL:
                hD = 1
                vD = 0
                row += 1
                col += 1
                nL += 1
                mL += 1
                nU -= 1
                mU -= 1

        return result


if __name__ == '__main__':
    
    # # Test 2D Array - Diagonal Traverse
    # print(Solution().findDiagonalOrder([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))
    # print(Solution().findDiagonalOrder([[1, 2], [3, 4]]))

    # Test 2D Array - Spiral Matrix
    print(Solution().spiralOrder([[1, 2, 3], [4, 5, 6], [7, 8, 9]]))
