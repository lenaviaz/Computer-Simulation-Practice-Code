import java.util.ArrayList;
import java.util.Scanner;

import Instructions.instruction;

public class cpu {
    
    private int[] register = new int[8];
    private mmu m1;
    private IO device;
    int pointer;

    public cpu(){
        
    }

    public void attachMem(mmu m1){
        this.m1 = m1;
    }

    public void attachIO(IO device){
        this.device = device;
    }

    public void run(ArrayList<instruction> instrList){
       
        for(pointer = 0; pointer < instrList.size(); pointer++){
            instruction a = instrList.get(pointer);
            evalInstr(a);
        }
    }

    public void getRegVal(int a){
        System.out.println("Regiter at : " + a + " is -->   " + register[a]);
    }

    public void viewAllreg(){
        System.out.println("-------------------  Register ---------------------------------");
        for(int a = 0; a < 8; a++){
        System.out.print(" | " +  register[a] + " | ");

        }
        System.out.println("");
        System.out.println("--------------------- Memory Module --------------------------");

    }

    public void readAllmem(){
        for(int i = 0; i < 10; i++){
                System.out.print(" | " + m1.read(i) + " | ");
                    if(m1.read(i) == 0)
                        break;
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
        int a = inst.getval2int();
        register[inst.getval1()] = a;
        break;

        case "Load":
        int theAdd = inst.getval2int();
        m1.read(theAdd);
        register[inst.getval1()] = m1.read(theAdd);
        break;

        case "Store":
        m1.write(inst.getval2int(), register[inst.getval1()]);
   

        break;

        case "InB":
        int j = device.read();
        register[inst.getval1()] = j; 
        break;

        case "OutB":
      //  device.write()

        break;

        case "OutNum":
        device.write(register[inst.getval1()]);

        break;

        case "OutStr": 

        break;

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

       // c1.menu();

        instruction i1 = new instruction("Data", 0, "h!!!!");
        instruction i2 = new instruction("LoadImm", 0, 26);
        instruction i3 = new instruction("Load", 3, 0);
        instruction i4 = new instruction("Store", 3, 1);
        instruction i5 = new instruction("InB", 2, 0);
        //instruction i6 = new instruction("OutB", 1, 0);


        commands.add(i1);
        commands.add(i2);
        commands.add(i3);
        commands.add(i4);
        commands.add(i5);
       // commands.add(i6);

        c1.run(commands);
        c1.viewAllreg();
        c1.readAllmem();

    }
}
