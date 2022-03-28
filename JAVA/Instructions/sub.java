package Instructions;

public class sub extends instruction {

    String sub;
    int regA;
    int regB;
    int regC;

    public sub(String sub, int regA, int regB, int regC) {

        this.sub = sub;
        this.regA = regA;
        this.regB = regB;
        this.regC = regC;
    }

    public String getName() {
        return sub;
    }

    public int getRegA() {
        return regA;
    }

    public int getRegB() {
        return regB;
    }

    public int getRegC() {
        return regC;
    }

}
