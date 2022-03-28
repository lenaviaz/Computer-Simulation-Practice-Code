package Instructions;

public class outnum extends instruction {

    public String outnum;
    public int reg;
    public int port;

    public outnum(String outnum, int reg, int port) {
        this.outnum = outnum;
        this.reg = reg;
        this.port = port;

    }

    public String getName() {
        return outnum;
    }

    public int getReg() {
        return reg;
    }

    public int getPort() {
        return port;
    }

}
