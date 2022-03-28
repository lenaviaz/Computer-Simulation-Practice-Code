
public class ram implements memory {

    private int size;
    private int[] capacity;

    public ram(int a) {
        size = a;
        capacity = new int[size];

    }

    @Override
    public void initialize(int address, String word) {

        System.out.println("RAM initialize ");
        for (int i = 0; i < word.length(); i++) {
            int a = (int) word.charAt(i);

            capacity[address] = a;
            address++;
        }
    }

    public int getSize() {
        return size;
    }

    @Override
    public int read(int address) {
        int toRead = capacity[address];
        return toRead;
    }

    @Override
    public void write(int address, int a) {
        capacity[address] = a;
    }
}