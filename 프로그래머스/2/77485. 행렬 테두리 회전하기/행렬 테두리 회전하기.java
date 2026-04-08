class Solution {
        public int[] solution(int rows, int columns, int[][] queries) {
            int qLen = queries.length;
            int[] answer = new int[qLen];
            int n = rows;
            int m = columns;

            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    grid[i][j] = i * m + j + 1;
                }
            }

            for (int qidx = 0; qidx < qLen; qidx++) {
                int[] q = queries[qidx];

                int a1 = q[0] -1;
                int b1 = q[1] -1;

                int a2 = q[2] -1;
                int b2 = q[3] -1;

                int min = n * m + 1; // 나올 수 없는 큰 값 세팅

                // 가장 첫번째를 저장
                int tmp = grid[a1][b1];
                min = Math.min(tmp, min);

                for (int i = a1; i < a2; i++) {
                    grid[i][b1] = grid[i + 1][b1];
                    min = Math.min(min, grid[i][b1]);
                }

                for (int i = b1; i < b2; i++) {
                    grid[a2][i] = grid[a2][i + 1];
                    min = Math.min(min, grid[a2][i]);
                }

                for (int i = a2; i > a1; i--) {
                    grid[i][b2] = grid[i - 1][b2];
                    min = Math.min(min, grid[i][b2]);
                }

                for (int i = b2; i > b1; i--) {
                    grid[a1][i] = grid[a1][i - 1];
                    min = Math.min(min, grid[a1][i]);
                }
                grid[a1][b1+1] = tmp;
                min = Math.min(min, tmp);
                
                answer[qidx] = min;

            }
            return answer;
        }
    }