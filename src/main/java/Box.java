import java.util.Random;

public enum Box {
    emo5,
    emo6,
    emo7,
    emo8;

    public Object image;

    public Box getNextNumberBox() {

        return Box.values()[this.ordinal() + 1];
    }

    private Random random = new Random();


    int getNumber() {
        return this.ordinal();
    }
}
