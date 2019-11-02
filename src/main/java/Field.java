import java.util.ArrayList;

/**
 * Игровое поле, состоящее из списка всех ячеек, из которого оно состоит.
 *
 * @author kpecmuk
 * @since 31.10.2019
 */
public class Field {
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

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void turn(Coord coord) {
        for (Cell cell : field) {

        }

    }
}