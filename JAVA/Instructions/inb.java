package Instructions;

public class inb extends instruction {

    public String inb;
    public int reg;
    public int port;

    public inb(String inb, int reg, int port) {
        this.inb = inb;
        this.reg = reg;
        this.port = port;

    }

    public String getName() {
        return inb;
    }

    public int getReg() {
        return reg;
    }

    public int getPort() {
        return port;
    }

}
