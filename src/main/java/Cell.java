/**
 * @author kpecmuk
 * @since 31.10.2019
 */
class Cell {

    private Coord coord;
    private Box icon;

    public Cell(Coord coord) {
        this.coord = coord;
    }

    public Box getIcon() {
        return icon;
    }

    void setIcon(Box icon) {
        this.icon = icon;
    }

    public Coord getCoord() {
        return coord;
    }
}