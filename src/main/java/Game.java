import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * Класс обработки игровых событий и управления игрой.
 *
 * @author kpecmuk
 * @since 01.11.2019
 */
class Game {
    private static final Logger log = LoggerFactory.getLogger(Game.class);
    private Field field;

    Field field() {
        return field;
    }

    Game(int cols, int rows) {
        field = new Field(cols, rows);
        for (Cell cell : field.getGF()) {
//            cell.setIcon(Box.values()[(cell.getCoord().getX() + cell.getCoord().getY()) % Box.values().length]);
            cell.setIcon(Box.emo5);
        }
    }

    /**
     * на старте надо перемешать кубик
     * rotate случайно выбирает сколько раз будем 'крутить кубик' дополнительно к тем трём оборотам
     */
    void start() {
        Random random = new Random();
        int rotate = random.nextInt(5); //

        for (int i = 0; i < 3 + rotate; i++) {
            int x = random.nextInt(field.getSizeX());
            int y = random.nextInt(field.getSizeY());
            field.turnIcon(new Coord(x, y));
            log.info("Coord = " + (x + 1) + " " + (y + 1));
        }
    }


    void pressLeftButton(Coord coord) {
//        log.info("Mouse left key pressed at: " + coord.getX() + " " + coord.getY());
        field.turnIcon(coord);
    }

    Box getBox(Cell cell) {
        return cell.getIcon();
    }
}