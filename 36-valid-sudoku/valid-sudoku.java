class Solution {

    public boolean isValidSudoku(char[][] board) 
    {

        if (!checkRows(board))
            return false;

        if (!checkCols(board))
            return false;

        if (!checkBoxes(board))
            return false;

        return true;
    }

    public boolean checkRows(char[][] board) 
    {

        // for every row
        // use HashSet
        // if duplicate found -> false
        for(int row=0;row<board.length;row++){
            HashSet<Character> set = new HashSet<>();
            for(int col=0;col<board.length;col++){
                char ch = board[row][col];

                if (ch == '.')
                continue;

                if (set.contains(ch))
                return false;

                set.add(ch);
            }
        }

        return true;
    }

    public boolean checkCols(char[][] board) 
    {

        // for every column
        // use HashSet
        // if duplicate found -> false
        for(int col=0;col<board.length;col++){
            HashSet<Character> set = new HashSet<>();
            for(int row=0;row<board.length;row++){
                char ch = board[row][col];

                if (ch == '.')
                continue;

                if (set.contains(ch))
                return false;

                set.add(ch);
            }
        }

        return true;
    }
    public boolean checkBoxes(char[][] board) {

    for (int row = 0; row < 9; row += 3) {

        for (int col = 0; col < 9; col += 3) {

            HashSet<Character> set = new HashSet<>(); // ✅ new set for EACH box

            for (int r = row; r < row + 3; r++) {

                for (int c = col; c < col + 3; c++) {

                    char ch = board[r][c];

                    if (ch == '.') continue;

                    if (set.contains(ch))
                        return false;

                    set.add(ch);
                }
            }
        }
    }

    return true;
            // The top-left corner of every box is:

        // (0,0) (0,3) (0,6)

        // (3,0) (3,3) (3,6)

        // (6,0) (6,3) (6,6)
}

    
}

