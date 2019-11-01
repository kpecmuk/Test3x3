import java.util.ArrayList;

/**
 * @author kpecmuk
 * @since 31.10.2019
 */
public class GameField {
    private ArrayList<Cell> gameField = new ArrayList<>();
    private int sizeX;
    private int sizeY;

    public GameField(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        for (int x = 0; x < sizeX; x++) {
            for (int y = 0; y < sizeY; y++) {
                gameField.add(new Cell(x, y));
            }
        }
    }

    public ArrayList<Cell> getGF() {
        return gameField;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    void showField() {

    }

}