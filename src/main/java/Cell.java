/**
 * @author kpecmuk
 * @since 31.10.2019
 */
class Cell {

    private int x;
    private int y;
    private Box symbol;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Box getSymbol() {
        return symbol;
    }

    void setSymbol(Box symbol) {
        this.symbol = symbol;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}