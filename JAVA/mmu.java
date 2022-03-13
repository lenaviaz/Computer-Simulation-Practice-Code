import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class mmu implements memory{

   // HashMap<Integer, Integer> mapInt = new HashMap<>();
    HashMap<Integer, memory> map = new HashMap<>();
   //HashMap<HashMap, memory> map = new HashMap<>();
    public mmu(){

    }


    public void attach(int address, memory m1){
       // mapInt.put(address, m1.getSize());
        map.put(address, m1);

       // System.out.println(address);
    }

    @Override
    public void initialize(int address, String word) {
        // TODO Auto-generated method stub

        for (Entry<Integer, memory> entry : map.entrySet()) {
            int key = entry.getKey();
            memory m = entry.getValue(); 
            int check = key + m.getSize();          

// if(address >= key && address <= (key + m.getSize())){
             if(key <= address && check > address){
                int adjust = address - key;
                m.initialize(adjust, word);
                break;
            }  
            // ...
        }

        
    }

    @Override
    public int read(int address) {

        for (Entry<Integer, memory> entry : map.entrySet()) {
            int key = entry.getKey();
            memory m = entry.getValue();
            int check = key + m.getSize();

            if(key <= address && check > address){
                int adjust = address - key;
                m.read(adjust);
            }
        }
        return 0;
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

            if(key <= address && check > address){
                int adjust = address - key;
                m.write(adjust, a);
            }
        }
        
    }


    public static void main(String[] args){
        mmu m1 = new mmu();
        ram r1 = new ram(1000);
        rom r2 = new rom(1000);

         m1.attach(0, r1);
         m1.attach(1000, r2);

        m1.initialize(0, "eeeee");;
        m1.initialize(1010, "hhhh");

        
        m1.read(0); //output 101
        m1.read(1010); //output 104
      

        m1.write(0, 33);
        m1.write(1010, 33);
        m1.read(0); //output 33
        m1.read(1010); //outout should stay 104, rom

      
}
}