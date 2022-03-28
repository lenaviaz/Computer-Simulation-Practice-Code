package Instructions;

public class jnz extends instruction {

    public String jnz;
    public int reg;
    public int offset;

    public jnz(String jnz, int reg, int offset) {
        this.jnz = jnz;
        this.reg = reg;
        this.offset = offset;
    }

    public String getName() {
        return jnz;
    }

    public int getReg() {
        return reg;
    }

    public int getOffset() {
        return offset;
    }

}
