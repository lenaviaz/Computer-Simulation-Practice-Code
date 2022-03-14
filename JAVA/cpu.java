import java.util.ArrayList;

public class cpu {
    
    private int[] register = new int[8];
    private mmu m1;
    private IO device;

    public cpu(){
        
    }

    public void attachMem(mmu m1){
        this.m1 = m1;
    }

    public void attachIO(IO device){
        this.device = device;
    }

    public void run(ArrayList<instruction> instrList){
       

        for(instruction a: instrList){
            evalInstr(a);
        }

    }

    public void getRegVal(int a){
        System.out.println("Regiter at : " + a + " is -->   " + register[a]);
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

        case "Store":
        m1.write(inst.toInt(), register[inst.getval1()]);

        break;

        case "InB":
        int j = device.read();
        register[inst.getval1()] = j; 

        break;

        case "OutNum":
        device.write(register[inst.getval1()]);
        }
    }

    public static void main(String[] args){

        ArrayList<instruction> commands = new ArrayList<>();

        console con1 = new console();
        ram r1 = new ram(1000);
        mmu m1 = new mmu();
        m1.attach(0, r1);

        cpu c1 = new cpu();
        c1.attachMem(m1);
        c1.attachIO(con1);



        instruction i1 = new instruction("Data", 0, "!hlhe");
        instruction i2 = new instruction("LoadImm", 0, "26");
        instruction i3 = new instruction("Load", 1, "0");
        instruction i4 = new instruction("Store", 0, "1");
        instruction i5 = new instruction("InB", 2, "0");
       // instruction i6 = new instruction("OutB", 1, "0");

        commands.add(i1);
        commands.add(i2);
        commands.add(i3);
        commands.add(i4);
        commands.add(i5);

        c1.run(commands);

        c1.getRegVal(0);
        c1.getRegVal(1);
        c1.getRegVal(2);


    }

}
