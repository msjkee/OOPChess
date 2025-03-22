package Pieces;

public abstract class Piece {
    private String color;
    private String symbol;

    public Piece(String color) {
        this.color = color;
        this.symbol = getSymbolForPiece(color);
    }

    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return symbol;
    }

    private String getSymbolForPiece(String color) {
        if (color.equals("White")) {
            return getWhitePieceSymbol();
        } else {
            return getBlackPieceSymbol();
        }
    }

    public abstract String getWhitePieceSymbol();
    public abstract String getBlackPieceSymbol();

    public abstract boolean isMoveValid(int start_x, int start_y, int end_x, int end_y, Piece chessBoard[][]);
}