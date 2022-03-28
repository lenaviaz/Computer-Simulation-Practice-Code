package Instructions;

public class loadImm extends instruction {

    public String loadImm;
    public int reg;
    public int number;

    public loadImm(String loadImm, int reg, int number) {
        this.loadImm = loadImm;
        this.reg = reg;
        this.number = number;

    }

    public String getName() {
        return loadImm;
    }

    public int getReg() {
        return reg;
    }

    public int getNumber() {
        return number;
    }

}
