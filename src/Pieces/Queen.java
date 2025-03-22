package Pieces;

public class Queen extends Piece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getWhitePieceSymbol() {
        return "♛";
    }

    @Override
    public String getBlackPieceSymbol() {
        return "♕";
    }

    @Override
    public boolean isMoveValid(int start_x, int start_y, int end_x, int end_y, Piece chessBoard[][]) {
        //x - line (stroka), y - row (stolbec)
        int dx = end_x - start_x;
        int dy = end_y - start_y;

        // Moves diagonally
        if (Math.abs(dx) == Math.abs(dy)) {
            int step_x;
            int step_y;

            if (dx > 0) {
                step_x = 1;
            } else {
                step_x = -1;
            }

            if (dy > 0) {
                step_y = 1;
            } else {
                step_y = -1;
            }

            int x = start_x + step_x;
            int y = start_y = step_y;

            while (x != end_x && y != end_y) {
                if (chessBoard[x][y] != null) {
                    return false;
                }
                x += step_x;
                y += step_y;
            }

            Piece target = chessBoard[end_x][end_y];
            return target == null || !target.getColor().equals(this.getColor());
        }

        // Moves forward
        if (start_x == end_x || start_y == end_y) {
            // Horizontally
            if (start_x == end_x) {
                int step;
                if (end_y > start_y) {
                    step = 1;
                } else {
                    step = -1;
                }

                for (int y = start_y + step; y != end_y; y += step) {
                    if (chessBoard[start_x][y] != null) {
                        return false;
                    }
                }
                //Vertically
            } else {
                int step;
                if (end_x > start_x) {
                    step = 1;
                } else {
                    step = -1;
                }

                for (int x = start_x + step; x != end_x; x += step) {
                    if (chessBoard[x][start_y] != null) {
                        return false;
                    }
                }
            }

            Piece target = chessBoard[end_x][end_y];
            return target == null || !target.getColor().equals(this.getColor());
        }

        return false; // not forward and not diagonally
    }
}