public enum Box {
    ICON,
    emo1,
    emo2,
    emo3,
    emo4;

    public Object image;

    public Box getNextNumberBox() {

        return Box.values()[this.ordinal() + 1];
    }

    int getNumber() {
        return this.ordinal();
    }
}
