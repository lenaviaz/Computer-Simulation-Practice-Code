package Instructions;

public class j extends instruction {

    public String j;
    public int offset;

    public j(String j, int offset) {
        this.j = j;
        this.offset = offset;
    }

    public String getName() {
        return j;
    }

    public int getOffset() {
        return offset;
    }

}
