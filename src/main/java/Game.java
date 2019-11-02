import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kpecmuk
 * @since 01.11.2019
 */
public class Game {
    private static final Logger log = LoggerFactory.getLogger(Game.class);
    private Field field;

    public Field field() {
        return field;
    }

    public Game(int cols, int rows) {
        field = new Field(cols, rows);
        for (Cell cell : field.getGF()) {
            cell.setIcon(Box.values()[(cell.getCoord().getX() + cell.getCoord().getY()) % Box.values().length]);
        }
    }

    public void start() {

    }

    public void pressLeftButton(Coord coord) {
        log.info("Mouse left key pressed at: " + coord.getX() + " " + coord.getY());
        field.turn(coord);
    }

    public Box getBox(Cell cell) {
        return cell.getIcon();
    }
}