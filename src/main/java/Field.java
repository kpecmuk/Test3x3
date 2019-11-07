import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Поле игры, состоящее из ячеек Cell. Здесь же обработка этих ячеек.
 *
 * @author kpecmuk
 * @since 31.10.2019
 */
class Field {
    private static final Logger log = LoggerFactory.getLogger(Game.class);
    private ArrayList<Cell> field = new ArrayList<>();
    private int sizeX;
    private int sizeY;

    int getSizeX() {
        return sizeX;
    }

    int getSizeY() {
        return sizeY;
    }

    Field(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                field.add(new Cell(new Coord(x, y)));
            }
        }
    }

    ArrayList<Cell> getGF() {
        return field;
    }
}