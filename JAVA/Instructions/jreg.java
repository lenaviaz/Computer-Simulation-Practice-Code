package Instructions;

public class jreg extends instruction {

    public String jreg;
    public int reg;

    public jreg(String jreg, int reg) {
        this.jreg = jreg;
        this.reg = reg;
    }

    public String getName() {
        return jreg;
    }

    public int getReg() {
        return reg;
    }
}
