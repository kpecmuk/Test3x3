import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Класс координат. Здесь содержатся координаты ячейки.
 *
 * @author kpecmuk
 * @since 01.11.2019
 */
class Coord {
    private static final Logger log = LoggerFactory.getLogger(Coord.class);

    private int x;
    private int y;

    Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }
}