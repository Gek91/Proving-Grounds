package leetcode.exercise36

/*
https://leetcode.com/problems/valid-sudoku
 */

import org.junit.Assert
import org.junit.Test

class Test36 {

    @Test
    fun testIsValidSudoku1() {

        val input : Array<CharArray> = arrayOf(
            charArrayOf('5','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9')
        );

        val output : Boolean = isValidSudoku(input);

        Assert.assertTrue(output);
    }

    @Test
    fun testIsValidSudoku2() {

        val input : Array<CharArray> = arrayOf(
            charArrayOf('8','3','.','.','7','.','.','.','.'),
            charArrayOf('6','.','.','1','9','5','.','.','.'),
            charArrayOf('.','9','8','.','.','.','.','6','.'),
            charArrayOf('8','.','.','.','6','.','.','.','3'),
            charArrayOf('4','.','.','8','.','3','.','.','1'),
            charArrayOf('7','.','.','.','2','.','.','.','6'),
            charArrayOf('.','6','.','.','.','.','2','8','.'),
            charArrayOf('.','.','.','4','1','9','.','.','5'),
            charArrayOf('.','.','.','.','8','.','.','7','9')
        );

        val output : Boolean = isValidSudoku(input);

        Assert.assertFalse(output);
    }

    @Test
    fun testIsValidSudoku3() {

        val input : Array<CharArray> = arrayOf(
            charArrayOf('.','.','.','.','5','.','.','1','.'),
            charArrayOf('.','4','.','3','.','.','.','.','.'),
            charArrayOf('.','.','.','.','.','3','.','.','1'),
            charArrayOf('8','.','.','.','.','.','.','2','.'),
            charArrayOf('.','.','2','.','7','.','.','.','.'),
            charArrayOf('.','1','5','.','.','.','.','.','.'),
            charArrayOf('.','.','.','.','.','2','.','.','.'),
            charArrayOf('.','2','.','9','.','.','.','.','.'),
            charArrayOf('.','.','4','.','.','.','.','.','.')
        );

        val output : Boolean = isValidSudoku(input);

        Assert.assertFalse(output);
    }
}