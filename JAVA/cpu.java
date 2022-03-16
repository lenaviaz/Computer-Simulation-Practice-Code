import java.util.ArrayList;
import java.util.Scanner;

import Instructions.instruction;

public class cpu {
    
    private int[] register = new int[8];
    private mmu m1;
    private IO device;
    int pointer;
    boolean running = true;

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
            if(running == true){
            instruction a = instrList.get(pointer);
            evalInstr(a);
            //System.out.println(pointer);
            } else {
                break;
            }
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
        
        switch(inst.getInstName()){

        case "Data":
        int x = inst.getdata1();
        String y = inst.getdata2();
        m1.initialize(x, y);
        break;

        case "LoadImm":
        int a = inst.getloadImm2();
        register[inst.getloadImm1()] = a;
        break;

        case "Load":
         int theAdd = inst.getload2();
         m1.read(theAdd);
         register[inst.getload1()] = m1.read(theAdd);
         break;

         case "Store":
         m1.write(inst.getstore2(), register[inst.getstore1()]);
         break;

         case "InB":
         int j = device.read() - 48;
         register[inst.getinb1()] = j; 
         break;

    //     case "OutB":
    //   //  device.write()

    //     break;

    //     case "OutNum":
    //     device.write(register[inst.getval1()]);

    //     break;

         case "OutStr": 
         for(int i = inst.getOutstr1(); i < 100; i++){
            if(m1.read(i) != 48){
                device.write(m1.read(i));
            } else{
                System.out.println("");
                break;
            }
            

         }
                 

         break; 

        case "Add" : 
        register[inst.getRegc()] = register[inst.getRega()] + register[inst.getRegb()];
        break;


        case "Sub" :
        register[inst.getRegc()] = register[inst.getRega()] - register[inst.getRegb()];
        
        break;

        case "J" :
        pointer += inst.getOffset() - 1;
        break;

        case "JZ" :

        if(register[inst.getjz1()] == 0)
            pointer += inst.getjz2() - 1;
        break;

        case "JNZ" :
        if(register[inst.getjz1()] != 0)
            pointer += inst.getjz2() - 1;
        break;

        case "Jreg" :
            pointer += register[inst.getReg()];
        break;

        case "Halt" :
            running = false;
        break;

        }

        
    }

    public void evalFibonacci(){

    ArrayList<instruction> commands = new ArrayList<>();


    instruction i1 = new instruction("Data", 0, "Enter a number between zero and nine : 0");
    instruction out = new instruction("OutStr", 0, 0);
    instruction i5 = new instruction("InB", 0, 0);

    commands.add(i1);
    commands.add(out);
    commands.add(i5);


    run(commands);
    viewAllreg();
    readAllmem();

    }



    public static void main(String[] args){

        console con1 = new console();
        ram r1 = new ram(1000);
        mmu m1 = new mmu();
        m1.attach(0, r1);

        cpu c1 = new cpu();
        c1.attachMem(m1);
        c1.attachIO(con1);

        c1.evalFibonacci();



/*         instruction i1 = new instruction("Data", 0, "Enter a number between zero and nine : 0");
        instruction out = new instruction("OutStr", 0, 0);
        instruction i5 = new instruction("InB", 0, 0);
        instruction i2 = new instruction("LoadImm", 0, 26);
         instruction i3 = new instruction("Load", 3, 0);
         instruction i4 = new instruction("Store", 3, 1);
       //  instruction i5 = new instruction("InB", 2, 0);
        // //instruction i6 = new instruction("OutB", 1, 0);

        instruction i7 = new instruction("Add", 0, 2, 3);
        instruction i8 = new instruction("Sub", 0, 2, 3);
        instruction i9 = new instruction("J", 3);
        instruction i10 = new instruction("JZ", 1, 2);
        instruction i11 = new instruction("JNZ", 2, 8);
        instruction i12 = new instruction("JReg", 2);
        instruction i13 = new instruction("Halt");

         commands.add(i1);
         commands.add(out);
         commands.add(i5);

        

        c1.run(commands);
        c1.viewAllreg();
        c1.readAllmem(); */

    }
}
