public enum Icons {
    emo1,
    emo2,
    emo3,
    emo4;

    public Object image;

    public Icons getNextIconNumber() {
        if (ordinal() == 3) {
            return Icons.values()[0];
        } else
            return Icons.values()[this.ordinal() + 1];
    }

    public Icons getPrevIconNumber() {
        if (ordinal() == 0) {
            return Icons.values()[3];
        } else
            return Icons.values()[this.ordinal() - 1];
    }
}