import java.util.HashMap;
import java.util.Map.Entry;

public class mmu implements memory{

    HashMap<Integer, memory> map = new HashMap<>();

    public mmu(){

    }

    public void attach(int address, memory m1){
        map.put(address, m1);
    }

    @Override
    public void initialize(int address, String word) {
        for (Entry<Integer, memory> entry : map.entrySet()) {
            int key = entry.getKey();
            memory m = entry.getValue(); 
            int check = key + m.getSize();          

            if(key <= address && check > address){
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

            if(key <= address && check > address){
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

            if(key <= address && check > address){
                int adjust = address - key;
                m.write(adjust, a);
            }
        }
        
    }

// Not neccesary as main method now works in CPU - just in case as a backup keep for now
   // public static void main(String[] args){
      //  mmu m1 = new mmu();
     /*    ram r1 = new ram(1000);
        rom r2 = new rom(1000);
        ram r3 = new ram(1000);
        rom r4 = new rom(1000);

         m1.attach(0, r1);
         m1.attach(1000, r2);
         m1.attach(2000, r3);
         m1.attach(3000, r4);

        m1.initialize(0, "eeeee");
        m1.initialize(1010, "hhhh");
        m1.initialize(2008, "!!!!!");
        m1.initialize(3002, "testing");

        
        m1.read(0); //output 101
        m1.read(1010); //output 104
        m1.read(2008);
        m1.read(3003); */
      

      //  m1.write(0, 33);
       // m1.write(1010, 33);
       // m1.read(0); //output 33
       // m1.read(1010); //outout should stay 104, rom

      
//}
}