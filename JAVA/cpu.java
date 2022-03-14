import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cpu {
    
    private int[] register = new int[8];
    private mmu m1;
    private IO device;
    private instruction inst;

    public cpu(){
        
    }

    public void attachMem(mmu m1){
        this.m1 = m1;
    }

    public void attachIO(IO i1){

    }

    public void run(ArrayList<instruction> instrList){
       

        for(instruction a: instrList){
            evalInstr(a);
        }

    }

    public void evalInstr(instruction inst){
        
        switch(inst.getData()){

        case "Data":
        int x = inst.getval1();
        String y = inst.getval2();
         m1.initialize(x, y);

        
        break;

        case "LoadImm":
            int a = inst.toInt();
            register[inst.getval1()] = a;


        break;

        case "Load":
        int theAdd = inst.toInt();

         m1.read(theAdd);

         register[inst.getval1()] = m1.read(theAdd);
    

        break;

        }

        
    }

    public static void main(String[] args){

        ArrayList<instruction> commands = new ArrayList<>();

  //      HashMap<String, List<Integer>> instructions = new HashMap<String, List<Integer>>();
    
      // commands.add(i3);

        console con1 = new console();
        ram r1 = new ram(1000);
        mmu m1 = new mmu();
        m1.attach(0, r1);

       // m1.initialize(0, "!!!!!!");

        cpu c1 = new cpu();
        c1.attachMem(m1);
        c1.attachIO(con1);



        instruction i1 = new instruction("Data", 0, "!hlhe");
        instruction i2 = new instruction("LoadImm", 0, "222");
        instruction i3 = new instruction("Load", 1, "2");
        commands.add(i1);
        commands.add(i2);
        commands.add(i3);

        c1.run(commands);

        System.out.println("reg 0 is : " + c1.register[0]);
        System.out.println("reg 1 is   " + c1.register[1]);
        //System.out.println(c1.register[0]);

    }

}
