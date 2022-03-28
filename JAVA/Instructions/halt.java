package Instructions;

public class halt extends instruction {

    public String halt;

    public halt(String halt) {
        this.halt = halt;
    }

    public String getName() {
        return halt;
    }

}
