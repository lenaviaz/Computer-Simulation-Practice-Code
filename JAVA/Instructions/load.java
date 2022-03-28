package Instructions;

public class load extends instruction {

    public String load;
    public int reg;
    public int address;

    public load(String load, int reg, int address) {
        this.load = load;
        this.reg = reg;
        this.address = address;

    }

    public String getName() {
        return load;
    }

    public int getReg() {
        return reg;
    }

    public int getAddress() {
        return address;
    }

}
