/**
 * Одинокая ячейка в которой хранятся её координаты и содержимое
 *
 * @author kpecmuk
 * @since 31.10.2019
 */
class Cell {
    private Coord coord;
    private Box icon;

    Cell(Coord coord) {
        this.coord = coord;
    }

    Box getIcon() {
        return icon;
    }

    void setIcon(Box icon) {
        this.icon = icon;
    }

    Coord getCoord() {
        return coord;
    }
}