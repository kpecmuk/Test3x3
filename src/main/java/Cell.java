/**
 * Одинокая ячейка в которой хранятся её координаты и содержимое
 *
 * @author kpecmuk
 * @since 31.10.2019
 */
class Cell {
    private Coord coord;
    private Icons icon;

    Cell(Coord coord) {
        this.coord = coord;
    }

    Icons getIcon() {
        return icon;
    }

    void setIcon(Icons icon) {
        this.icon = icon;
    }

    Coord getCoord() {
        return coord;
    }
}