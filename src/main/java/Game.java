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

    Field getField() {
        return field;
    }

    Game(int cols, int rows) {
        field = new Field(cols, rows);
        for (Cell cell : field.getGF())
            cell.setIcon(Icons.values()[0]);
    }

    /**
     * на старте надо перемешать кубик
     * rotate случайно выбирает сколько раз будем 'крутить кубик' дополнительно к тем трём оборотам
     */
    void start() {
        log.info("Start new game");
        Random random = new Random();
        int rotate = random.nextInt(5) + 3;
        Turn turn = new TurnNext();

        for (int i = 0; i < rotate; i++) {
            int x = random.nextInt(field.getSizeX());
            int y = random.nextInt(field.getSizeY());
            turn.rightNow(new Coord(x, y), field);
            log.info("Coord = " + (x + 1) + " " + (y + 1));
        }
    }

    Icons getIcon(Cell cell) {
        return cell.getIcon();
    }
}