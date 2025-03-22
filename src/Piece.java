public abstract class Piece {
    private String color;
    private String symbol;

    public Piece(String color, String symbol) {
        this.color = color;
        this.symbol = symbol;
    }

    public String getColor() {
        return color;
    }

    public String getSymbol() {
        return symbol;
    }

    public abstract boolean isMoveValid(int start_x, int start_y, int end_x, int end_y);
}