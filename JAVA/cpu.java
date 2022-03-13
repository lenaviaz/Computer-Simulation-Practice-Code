import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class cpu {
    
    private int[] register;
    private memory m1;
    private IO device;

    public cpu(){



    }

    public void attachMem(memory m1){

    }

    public void attachIO(IO i1){

    }

    public void run(List<Map> instrList){

    }

    public void evalInstr(Map<Integer, List<String>> map){

    }



    public static void main(String[] args){

        console con1 = new console();
        ram r1 = new ram(1000);
        mmu m1 = new mmu();
        m1.attach(0, r1);

        cpu c1 = new cpu();
        c1.attachMem(m1);
        c1.attachIO(con1);


    }

}
