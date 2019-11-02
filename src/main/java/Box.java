public enum Box {
    emo5,
    emo6,
    emo7,
    emo8;

    public Object image;

    public Box getNextNumberBox() {
        if (ordinal() == 3) {
            return Box.values()[0];
        } else
            return Box.values()[this.ordinal() + 1];
    }
}
