public enum Box {
    ICON,
    surprised1,
    surprised2,
    surprised3,
    happy1;

    public Object image;

    public Box getNextNumberBox() {

        return Box.values()[this.ordinal() + 1];
    }

    int getNumber() {
        return this.ordinal();
    }
}
