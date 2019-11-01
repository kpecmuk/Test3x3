import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kpecmuk
 * @since 01.11.2019
 */
public class Game {
    private static final Logger log = LoggerFactory.getLogger(Game.class);
    private GameField gameField;

    public GameField getGameField() {
        return gameField;
    }

    public Game(int cols, int rows) {
        gameField = new GameField(cols, rows);
    }

    public void start() {

    }

    public void pressLeftButton(Coord coord) {

    }

    public Box getBox(Cell cell) {
        return Box.NUM1;
    }
}