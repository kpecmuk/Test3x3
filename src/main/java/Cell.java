/**
 * @author kpecmuk
 * @since 31.10.2019
 */
class Cell {

    private int x;
    private int y;
    private Box icon;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Box getIcon() {
        return icon;
    }

    void setIcon(Box icon) {
        this.icon = icon;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}