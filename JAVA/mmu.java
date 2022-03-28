import java.util.HashMap;
import java.util.Map.Entry;

public class mmu implements memory {

    HashMap<Integer, memory> map = new HashMap<>();

    public mmu() {

    }

    public void attach(int address, memory m1) {
        map.put(address, m1);

    }

    @Override
    public void initialize(int address, String word) {
        for (Entry<Integer, memory> entry : map.entrySet()) {
            int key = entry.getKey();
            memory m = entry.getValue();
            int check = key + m.getSize();

            if (key <= address && check > address) {
                int adjust = address - key;
                m.initialize(adjust, word);
                break;
            }

        }
    }

    @Override
    public int read(int address) {

        for (Entry<Integer, memory> entry : map.entrySet()) {
            int key = entry.getKey();
            memory m = entry.getValue();
            int check = key + m.getSize();

            if (key <= address && check > address) {
                int adjust = address - key;
                return m.read(adjust);

            }
        }
        return 120;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void write(int address, int a) {
        for (Entry<Integer, memory> entry : map.entrySet()) {
            int key = entry.getKey();
            memory m = entry.getValue();
            int check = key + m.getSize();

            if (key <= address && check > address) {
                int adjust = address - key;
                m.write(adjust, a);
            }
        }

    }
}