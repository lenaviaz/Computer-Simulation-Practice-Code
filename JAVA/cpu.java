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
        System.out.print("halt program");
            running = false;
        break;

        case "Test":
         System.out.print("I've been called");
        break;
        }

        
    }

    public void evalFibonacci(){

    ArrayList<instruction> commands = new ArrayList<>();

    instruction set1 = new instruction("LoadImm", 0, 0);
    instruction set2 = new instruction("LoadImm", 1, 1);
    instruction i1 = new instruction("Data", 0, "Enter a number between zero and nine : 0");
    instruction i2 = new instruction("OutStr", 0, 0);
    instruction i3 = new instruction("InB",7, 0);
    // instruction temp = new instruction("Add", 7, 5, 5);

    // instruction mult1 = new instruction("Add", 7,7,7);
    // instruction mult2 = new instruction("Add", 7,5,7);


    instruction one = new instruction("LoadImm", 6, 1);

    //we have the value to add to the counter and the negative itterator
   // instruction check = new instruction("JZ", 7, x);

    instruction add1 = new instruction("Add", 0, 1, 2); //adds 1 and 2 into 3
    instruction add2 = new instruction("Add", 1, 3, 0); //adds 1 and 2 into 1
    instruction add3 = new instruction("Add", 2, 3, 1); //adds 1 and 2 into 1 //count = 1
    instruction sub = new instruction("Sub", 7, 6, 7);
    instruction check0 = new instruction("JZ", 7, 26); //add 1

    // first itteration complete - fib of 1 is last reg

    instruction add4 = new instruction("Add", 0, 1, 2); //adds 1 and 2 into 3
    instruction add5 = new instruction("Add", 1, 3, 0); //adds 1 and 2 into 1
    instruction add6 = new instruction("Add", 2, 3, 1); //adds 1 and 2 into 1 //count = 1
    instruction sub1 = new instruction("Sub", 7, 6, 7);
    instruction check1 = new instruction("JZ", 7, 21); // add 1

    //second itteration complete

    
    instruction add7 = new instruction("Add", 0, 1, 2); //adds 1 and 2 into 3
    instruction add8 = new instruction("Add", 1, 3, 0); //adds 1 and 2 into 1
    instruction add9 = new instruction("Add", 2, 3, 1); //adds 1 and 2 into 1 //count = 1
    instruction sub2 = new instruction("Sub", 7, 6, 7);
    instruction check2 = new instruction("JZ", 7, 16);

    //third itteration complete

    instruction add10 = new instruction("Add", 0, 1, 2); //adds 1 and 2 into 3
    instruction add11 = new instruction("Add", 1, 3, 0); //adds 1 and 2 into 1
    instruction add12 = new instruction("Add", 2, 3, 1); //adds 1 and 2 into 1 //count = 1
    instruction sub3 = new instruction("Sub", 7, 6, 7);
    instruction check3 = new instruction("JZ", 7, 11);

    //third itteration complete


    instruction add13 = new instruction("Add", 0, 1, 2); //adds 1 and 2 into 3
    instruction add14 = new instruction("Add", 1, 3, 0); //adds 1 and 2 into 1
    instruction add15 = new instruction("Add", 2, 3, 1); //adds 1 and 2 into 1 //count = 1
    instruction sub4 = new instruction("Sub", 7, 6, 7);
    instruction check4 = new instruction("JZ", 7, 6);

//four itteration complete


    instruction add16 = new instruction("Add", 0, 1, 2); //adds 1 and 2 into 3
    instruction add17 = new instruction("Add", 1, 3, 0); //adds 1 and 2 into 1
    instruction add18 = new instruction("Add", 2, 3, 1); //adds 1 and 2 into 1 //count = 1
    instruction sub5 = new instruction("Sub", 7, 6, 7);
    instruction check5 = new instruction("JZ", 7, 0);

//fifth itteration complete






    instruction halt1 = new instruction("Halt");


    //instruction i5 = new instruction("JNZ", 0, 2); // if zero jump to halt
   // instruction i6 = new instruction("JNZ", 0, 1);
    //this means zero was entered to spit out zero and hault the program
  //  instruction i7 = new instruction("Halt");
   // instruction i8 = new instruction("Test");//halt code


    commands.add(set1);
    commands.add(set2);
    commands.add(i1);
    commands.add(i2);
    commands.add(i3);
    // commands.add(temp);
    // commands.add(mult1);
    // commands.add(mult2);
    commands.add(one);
    commands.add(add1);
    commands.add(add2);
    commands.add(add3);
    commands.add(sub);
    commands.add(check0);
     commands.add(add4);
      commands.add(add5);
      commands.add(add6);
      commands.add(sub1);
      commands.add(check1);

     commands.add(add7); 
     commands.add(add8);
      commands.add(add9);
      commands.add(sub2);
      commands.add(check2);

        commands.add(add10);
        commands.add(add11);
        commands.add(add12);
        commands.add(sub3);
        commands.add(check3);

        commands.add(add13);
        commands.add(add14);
        commands.add(add15);
        commands.add(sub4);
        commands.add(check4);

        commands.add(add16);
        commands.add(add17);
        commands.add(add18);
        commands.add(sub5);
        commands.add(check5);

      commands.add(halt1);


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
