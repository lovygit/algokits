public class BoxRemover{
  public int removeBoxes(int[] boxes) {
        int n = boxes.length;
        int[][][] dp = new int[n][n][n];
        return removeBoxesSub(boxes, 0, n - 1, 0, dp);
    }

  private int removeBoxesSub(int[] boxes, int i, int j, int k, int[][][] dp) {
      System.out.println("i "+i+", j "+j+", k "+k);
      if (i > j) return 0;
      if (dp[i][j][k] > 0) return dp[i][j][k];

      //merge box at i
      int res = (k + 1) * (k + 1) + removeBoxesSub(boxes, i + 1, j, 0, dp);
      //merge box at m and box[m]==box[i]
      //if(boxes[i]==boxes[m]) and we do not merge box at i ,we will get more than one box can merge at m,becase we remove
      //the boxes from i+1 to m-1 firstly
      for (int m = i + 1; m <= j; m++) {
          if (boxes[i] == boxes[m]) {
              res = Math.max(res, removeBoxesSub(boxes, i + 1, m - 1, 0, dp) + removeBoxesSub(boxes, m, j, k + 1, dp));
          }
      }
      dp[i][j][k] = res;
      return res;
  }
}
