
public interface memory {

    public void initialize(int address, String word);

    public int read(int address);

    public void write(int address, int a);

    public int getSize();
}
