/**
 * @author kpecmuk
 * @since 31.10.2019
 */
class Symbol {

    private int sym = 1;

    public int getSym() {
        return sym;
    }

    public void setSym(int sym) {
        this.sym = sym;
    }

    public void nextSym(){
        if (sym == 4){
            sym = 1;
        } else {
            sym++;
        }
    }
}