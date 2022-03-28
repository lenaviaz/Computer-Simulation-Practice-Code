package Instructions;

public class store extends instruction {

    public String store;
    public int reg;
    public int address;

    public store(String store, int reg, int address) {
        this.store = store;
        this.reg = reg;
        this.address = address;

    }

    public String getName() {
        return store;
    }

    public int getReg() {
        return reg;
    }

    public int getAddress() {
        return address;
    }

}
