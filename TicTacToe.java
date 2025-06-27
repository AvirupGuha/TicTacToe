import java.util.Scanner;

public class TicTacToe {
    static char[][] board = {
        {' ', ' ', ' '},
        {' ', ' ', ' '},
        {' ', ' ', ' '}
    };

    static char currentPlayer = 'X';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("🎮 Welcome to Tic-Tac-Toe Game!");
        printBoard();

        while (true) {
            System.out.println("\nPlayer " + currentPlayer + ", enter your move (row[1-3] and column[1-3]): ");
            int row = scanner.nextInt() - 1;
            int col = scanner.nextInt() - 1;

            if (isValidMove(row, col)) {
                board[row][col] = currentPlayer;
                printBoard();

                if (checkWin()) {
                    System.out.println("🎉 Player " + currentPlayer + " wins!");
                    break;
                }

                if (isBoardFull()) {
                    System.out.println("🤝 It's a draw!");
                    break;
                }

                switchPlayer();
            } else {
                System.out.println("❌ Invalid move! Try again.");
            }
        }

        scanner.close();
    }

    static void printBoard() {
        System.out.println("\n  1   2   3");
        for (int i = 0; i < 3; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) System.out.print(" | ");
            }
            if (i < 2) System.out.println("\n  ---------");
        }
        System.out.println();
    }

    static boolean isValidMove(int row, int col) {
        return row >= 0 && col >= 0 &&
               row < 3 && col < 3 &&
               board[row][col] == ' ';
    }

    static void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    static boolean isBoardFull() {
        for (char[] row : board)
            for (char cell : row)
                if (cell == ' ')
                    return false;
        return true;
    }

    static boolean checkWin() {
        // Rows and Columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer &&
                board[i][1] == currentPlayer &&
                board[i][2] == currentPlayer)
                return true;
            if (board[0][i] == currentPlayer &&
                board[1][i] == currentPlayer &&
                board[2][i] == currentPlayer)
                return true;
        }

        // Diagonals
        if (board[0][0] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][2] == currentPlayer)
            return true;

        if (board[0][2] == currentPlayer &&
            board[1][1] == currentPlayer &&
            board[2][0] == currentPlayer)
            return true;

        return false;
    }
}
