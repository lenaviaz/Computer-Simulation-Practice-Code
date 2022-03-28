package Instructions;

public class jz extends instruction {

    public String jz;
    public int reg;
    public int offset;

    public jz(String jz, int reg, int offset) {
        this.jz = jz;
        this.reg = reg;
        this.offset = offset;
    }

    public String getName() {
        return jz;
    }

    public int getReg() {
        return reg;
    }

    public int getOffset() {
        return offset;
    }

}
