package Instructions;

public class outstr extends instruction {

    public String outstr;
    public int address;
    public int port;

    public outstr(String outstr, int address, int port) {
        this.outstr = outstr;
        this.address = address;
        this.port = port;

    }

    public String getName() {
        return outstr;
    }

    public int getAddress() {
        return address;
    }

    public int getPort() {
        return port;
    }

}
