import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author kpecmuk
 * @since 07.11.2019
 */
public class TurnNext implements Turn {
    private static final Logger log = LoggerFactory.getLogger(TurnNext.class);

    @Override
    public void rightNow(Coord coord, Field field) {
        for (Cell cell : field.getGF()) {
            if ((cell.getCoord().getX() == coord.getX()) || (cell.getCoord().getY() == (coord.getY()))) {
                cell.setIcon(cell.getIcon().getNextIconNumber());
            }
        }
    }
}