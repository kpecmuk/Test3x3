public enum Box {
    ICON,
    NUM1,
    NUM2,
    NUM3,
    NUM4,
    NUM5,
    NUM6,
    NUM7,
    NUM8;

    public Object image;

    public Box getNextNumberBox() {

        return Box.values()[this.ordinal() + 1];
    }

    int getNumber() {
        return this.ordinal();
    }
}
