package Instructions;

public class add extends instruction {

    String add;
    int regA;
    int regB;
    int regC;

    public add(String add, int regA, int regB, int regC) {

        this.add = add;
        this.regA = regA;
        this.regB = regB;
        this.regC = regC;
    }

    public String getName() {
        return add;
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
