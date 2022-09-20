import java.io.*;
import java.util.*;

public class BOJ_12100_G2_2048 {
    static int n;
    static int[][] initBoard;

    static int maxVal;

    static void move(int d, int[][] board) {
        if (d == 0) {
            for (int y = 0; y < n; y++) {
                for (int i = n - 2; i >= 0; i--) {
                    for (int j = n - 2; j >= 0; j--) {
                        if (board[y][j + 1] == 0) {
                            board[y][j + 1] = board[y][j];
                            board[y][j] = 0;
                        }
                    }
                }
            }
        } else if (d == 1) {
            for (int x = 0; x < n; x++) {
                for (int i = n - 2; i >= 0; i--) {
                    for (int j = n - 2; j >= 0; j--) {
                        if (board[j + 1][x] == 0) {
                            board[j + 1][x] = board[j][x];
                            board[j][x] = 0;
                        }
                    }
                }
            }
        } else if (d == 2) {
            for (int y = 0; y < n; y++) {
                for (int i = 1; i < n; i++) {
                    for (int j = 1; j < n; j++) {
                        if (board[y][j - 1] == 0) {
                            board[y][j - 1] = board[y][j];
                            board[y][j] = 0;
                        }
                    }
                }
            }
        } else if (d == 3) {
            for (int x = 0; x < n; x++) {
                for (int i = 1; i < n; i++) {
                    for (int j = 1; j < n; j++) {
                        if (board[j - 1][x] == 0) {
                            board[j - 1][x] = board[j][x];
                            board[j][x] = 0;
                        }
                    }
                }
            }
        }
    }

    static void merge(int d, int[][] board) {
        if (d == 0) {
            for (int y = 0; y < n; y++) {
                int x = n - 2;
                while (x >= 0) {
                    if (board[y][x + 1] == board[y][x]) {
                        board[y][x + 1] *= 2;
                        for (int i = x - 1; i >= 0; i--) {
                            board[y][i + 1] = board[y][i];
                        }
                        board[y][0] = 0;
                    }
                    x--;
                }
            }
        } else if (d == 1) {
            for (int x = 0; x < n; x++) {
                int y = n - 2;
                while (y >= 0) {
                    if (board[y + 1][x] == board[y][x]) {
                        board[y + 1][x] *= 2;

                        for (int i = y - 1; i >= 0; i--) {
                            board[i + 1][x] = board[i][x];
                        }
                        board[0][x] = 0;
                    }
                    y--;
                }
            }
        } else if (d == 2) {
            for (int y = 0; y < n; y++) {
                int x = 1;
                while (x < n - 1) {
                    if (board[y][x - 1] == board[y][x]) {
                        board[y][x - 1] *= 2;
                        for (int i = x + 1; i < n; i++) {
                            board[y][i - 1] = board[y][i];
                        }
                        board[y][n - 1] = 0;
                    }
                    x++;
                }
            }
        } else if (d == 3) {
            for (int x = 0; x < n; x++) {
                int y = 1;
                while (y < n - 1) {
                    if (board[y - 1][x] == board[y][x]) {
                        board[y - 1][x] *= 2;

                        for (int i = y + 1; i < n; i++) {
                            board[i - 1][x] = board[i][x];
                        }
                        board[n - 1][x] = 0;
                    }
                    y++;
                }
            }
        }
    }

    static int[][] boardCopy(int[][] tempBoard) {
        int[][] newBoard = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newBoard[i][j] = tempBoard[i][j];
            }
        }
        return newBoard;
    }

    static void backtrack(int idx, int[][] tempBoard) {
        if (idx >= 5) {
            int val = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    val = Math.max(val, tempBoard[i][j]);
                }
            }
            maxVal = Math.max(maxVal, val);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int[][] board = boardCopy(tempBoard);
            move(d, board);
            merge(d, board);
            backtrack(idx + 1, board);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());

        initBoard = new int[n][n];

        for (int j = 0; j < n; j++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                initBoard[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // for (int j = 0; j < n; j++) {
        // for (int i = 0; i < n; i++) {
        // System.out.print(initBoard[j][i] + " ");
        // }
        // System.out.println();
        // }

        backtrack(0, initBoard);
        sb.append(maxVal);
        System.out.println(sb.toString());

    }
}