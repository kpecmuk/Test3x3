public enum Box {
    emo1,
    emo2,
    emo3,
    emo4;

    public Object image;

    public Box getNextNumberBox() {
        if (ordinal() == 3) {
            return Box.values()[0];
        } else
            return Box.values()[this.ordinal() + 1];
    }
}