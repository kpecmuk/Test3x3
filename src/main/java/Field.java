import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

/**
 * Поле игры, состоящее из ячеек Cell. Здесь же обработка этих ячеек.
 *
 * @author kpecmuk
 * @since 31.10.2019
 */
public class Field {
    private static final Logger log = LoggerFactory.getLogger(Game.class);
    private ArrayList<Cell> field = new ArrayList<>();
    private int sizeX;
    private int sizeY;

    public Field(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                field.add(new Cell(new Coord(x, y)));
            }
        }
    }

    public ArrayList<Cell> getGF() {
        return field;
    }

    public void turn(Coord coord) {
        for (Cell cell : field) {
            if (cell.getCoord().equals(coord)) {
                log.info("Turning icon");
                log.info("Old icon id: " + cell.getIcon().ordinal());
                cell.setIcon(cell.getIcon().getNextNumberBox());
                log.info("New icon id: " + cell.getIcon().ordinal());
            }
        }
    }
}