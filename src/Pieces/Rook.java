package Pieces;

public class Rook extends Piece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getWhitePieceSymbol() {
        return "♜";
    }

    @Override
    public String getBlackPieceSymbol() {
        return "♖";
    }

    @Override
    public boolean isMoveValid(int start_x, int start_y, int end_x, int end_y, Piece chessBoard[][]) {
        //x - line (stroka), y - row (stolbec)
        // The rook moves either vertically or horizontally
        if (start_x != end_x && start_y != end_y) {
            return false;
        }

        if (start_x == end_x) {
            int step;

            if (end_y > start_y) {
                step = 1;  // Moving to the right (forwards through the columns)
            } else {
                step = -1; // Moving to the left (backwards through the columns)
            }
            // Horizontal movement (by line)
            for (int y = start_y + step; y != end_y; y += step) {
                if (chessBoard[start_x][y] != null) {
                    return false;
                }
            }
        } else {
            int step;
            if (end_x > start_x) {
                step = 1;
            } else {
                step = -1;
            }
            // Vertical movement (by column)
            for (int x = start_x + step; x != end_x; x += step) {
                if (chessBoard[x][start_y] != null) {
                    return false;
                }
            }
        }

        Piece target = chessBoard[end_x][end_y];
        return target == null || !target.getColor().equals(this.getColor());
    }
}