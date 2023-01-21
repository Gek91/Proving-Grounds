package leetcode.exercise2155

import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun maxScoreIndices1(nums: IntArray): List<Int> {

    var maxScore : Int = 0;
    var resultIndex : MutableSet<Int> = HashSet();

    for(index in 0..nums.size/2+1) {

        val scores = computeSplitScore(nums, index);

        if(scores.first >= maxScore) {
            if(scores.first > maxScore) {
                maxScore = scores.first;
                resultIndex = HashSet();
            }
            resultIndex.add(index);
        }

        if(scores.second >= maxScore) {
            if(scores.second > maxScore) {
                maxScore = scores.second;
                resultIndex = HashSet();
            }
            resultIndex.add(nums.size - index);
        }

    }

    return ArrayList(resultIndex);
}

private fun computeSplitScore(nums: IntArray, splitIndex: Int) : Pair<Int,Int> {

    var score = 0;
    var inverseScore = 0;

    val inverseUpperBound = nums.size -1;

    for(forIndex in 0..splitIndex-1) {
        if(nums.get(forIndex) == 0){
            score++;
        }
        if(nums.get(inverseUpperBound - forIndex) == 1) {
            inverseScore++;
        }
    }

    for(forIndex in splitIndex..inverseUpperBound) {
        if(nums.get(forIndex) == 1){
            score++;
        }
        if(nums.get(inverseUpperBound - forIndex) == 0) {
            inverseScore++;
        }
    }

    return Pair(score,inverseScore);
}

fun maxScoreIndices(nums: IntArray): List<Int> {

    var totalOneCount = 0;

    for(index in 0..nums.size-1) {
        totalOneCount += nums[index];
    }

    var maxScore : Int = totalOneCount;
    var resultIndexes : MutableList<Int> = mutableListOf(0);

    var leftOneCount = 0;

    for(index in 1..nums.size) {

        leftOneCount += nums[index - 1];

        val leftZeroCount = index - leftOneCount;
        val rightOneCount = totalOneCount - leftOneCount;

        val score = leftZeroCount + rightOneCount;

        if(score >= maxScore) {
            if(score > maxScore) {
                maxScore = score;
                resultIndexes = ArrayList();
            }
            resultIndexes.add(index);
        }
    }

    return resultIndexes;
}