package leetcode.exercise36

fun isValidSudoku(board: Array<CharArray>): Boolean {
    return checkRows(board) && checkColumn(board) && checkSubBoards(board);
}

private fun checkRows(board: Array<CharArray>) : Boolean {

    for(row in board) {
        val rowResult = checkRow(row);

        if(!rowResult) {
            return false;
        }
    }

    return true;
}

private fun checkRow(row : CharArray): Boolean {

    val checkHelper = HashMap<Char, Boolean>();

    for(char in row) {
        if(char != '.') {
            if(checkHelper.containsKey(char)) {
                return false;
            }

            checkHelper.put(char, true);
        }
    }

    return true;
}

private fun checkColumn(board: Array<CharArray>) : Boolean{

    for(colum in 0..8) {

        val checkHelper = HashMap<Char, Boolean>();

        for(rowElem in 0..8) {

            val char = board[rowElem][colum];

            if(char != '.') {
                if(checkHelper.containsKey(char)) {
                    return false;
                }
            }

            checkHelper.put(char, true);
        }
    }

    return true;
}

private fun checkSubBoards(board: Array<CharArray>) : Boolean {

    for(subBoardRowIndex in 0..2) {
        for(subBoardColumnIndex in 0..2) {
            val checkHelper = HashMap<Char, Boolean>();
            for(rowIndex in 0..2) {
                for(columnIndex in 0..2) {
                    val char = board[rowIndex + 3*subBoardRowIndex][columnIndex + 3*subBoardColumnIndex];

                    if(char != '.') {
                        if(checkHelper.containsKey(char)) {
                            return false;
                        }
                    }
                    checkHelper.put(char, true);
                }
            }
        }
    }

    return true;
}