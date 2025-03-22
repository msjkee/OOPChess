package Pieces;

public class Bishop extends Piece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getWhitePieceSymbol() {
        return "♝";
    }

    @Override
    public String getBlackPieceSymbol() {
        return "♗";
    }

    //TODO
    @Override
    public boolean isMoveValid(int start_x, int start_y, int end_x, int end_y) {
        return false;
    }
}