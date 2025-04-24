class Solution {
    private var maxDiff = 0
    private var answer = intArrayOf(-1)

    fun solution(n: Int, info: IntArray): IntArray {
        val ryan = IntArray(11)
        dfs(n, 0, info, ryan)
        return answer
    }

    private fun dfs(n: Int, idx: Int, info: IntArray, ryan: IntArray) {
        if (idx == 11) {
            if (n > 0) ryan[10] += n
            val (ryanScore, apeachScore) = calculateScores(info, ryan)
            val diff = ryanScore - apeachScore
            if (diff > 0) {
                if (diff > maxDiff) {
                    maxDiff = diff
                    answer = ryan.copyOf()
                } else if (diff == maxDiff) {
                    if (isBetter(ryan, answer)) {
                        answer = ryan.copyOf()
                    }
                }
            }
            if (n > 0) ryan[10] -= n
            return
        }

        if (n > info[idx]) {
            ryan[idx] = info[idx] + 1
            dfs(n - ryan[idx], idx + 1, info, ryan)
            ryan[idx] = 0
        }
        dfs(n, idx + 1, info, ryan)
    }

    private fun calculateScores(apeach: IntArray, ryan: IntArray): Pair<Int, Int> {
        var ryanScore = 0
        var apeachScore = 0
        for (i in 0..10) {
            if (apeach[i] == 0 && ryan[i] == 0) continue
            if (ryan[i] > apeach[i]) ryanScore += 10 - i
            else apeachScore += 10 - i
        }
        return Pair(ryanScore, apeachScore)
    }

    private fun isBetter(a: IntArray, b: IntArray): Boolean {
        for (i in 10 downTo 0) {
            if (a[i] > b[i]) return true
            else if (a[i] < b[i]) return false
        }
        return false
    }
}