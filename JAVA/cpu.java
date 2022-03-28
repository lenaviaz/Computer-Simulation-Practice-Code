import java.util.ArrayList;

import Instructions.data;
import Instructions.instruction;
import Instructions.load;
import Instructions.loadImm;
import Instructions.inb;
import Instructions.store;
import Instructions.outnum;
import Instructions.outstr;
import Instructions.add;
import Instructions.sub;
import Instructions.j;
import Instructions.jz;
import Instructions.jnz;
import Instructions.jreg;
import Instructions.halt;

public class cpu {

    private int[] register = new int[8];
    private mmu m1;
    private IO device;
    int pointer;
    boolean running = true;

    public cpu() {

    }

    public void attachMem(mmu m1) {
        this.m1 = m1;
    }

    public void attachIO(IO device) {
        this.device = device;
    }

    public void run(ArrayList<instruction> instrList) {

        for (pointer = 0; pointer < instrList.size(); pointer++) {
            if (running == true) {
                instruction a = instrList.get(pointer);
                evalInstr(a);
            } else {
                break;
            }
        }
    }

    public void viewAllreg() {
        System.out.println("-------------------  Register ---------------------------------");
        for (int a = 0; a < 8; a++) {
            System.out.print(" | " + register[a] + " | ");

        }
        System.out.println("");
        System.out.println("--------------------- Memory Module --------------------------");

    }

    public void readAllmem() {
        for (int i = 0; i < 10; i++) {
            System.out.print(" | " + m1.read(i) + " | ");
            if (m1.read(i) == 0)
                break;
        }
    }

    public void evalInstr(instruction inst) {

        switch (inst.getName()) {

            case "Data":
                int x = ((data) inst).getAddress();
                String y = ((data) inst).getMessage();
                m1.initialize(x, y);
                break;

            case "LoadImm":
                int a = ((loadImm) inst).getNumber();
                register[((loadImm) inst).getReg()] = a;
                break;

            case "Load":
                int theAdd = ((load) inst).getAddress();
                m1.read(theAdd);
                register[((load) inst).getReg()] = m1.read(theAdd);
                break;

            case "Store":
                m1.write(((store) inst).getAddress(), register[((store) inst).getReg()]);
                break;

            case "InB":
                int j = device.read() - 48;
                register[((inb) inst).getReg()] = j;
                break;

            // case "OutB":
            // //device.write();

            // break;

            case "OutNum":
                device.write(register[((outnum) inst).getReg()]);
                break;

            case "OutStr":

                for (int i = ((outstr) inst).getAddress(); i < 100; i++) {
                    if (m1.read(i) != 48) {
                        device.write(m1.read(i));
                    } else {
                        System.out.println("");
                        break;
                    }

                }

                break;

            case "Add":
                register[((add) inst).getRegC()] = register[((add) inst).getRegA()] + register[((add) inst).getRegB()];
                break;

            case "Sub":
                register[((sub) inst).getRegC()] = register[((sub) inst).getRegA()] - register[((sub) inst).getRegB()];

                break;

            case "J":
                pointer += ((j) inst).getOffset() - 1;
                break;

            case "JZ":

                if (register[((jz) inst).getReg()] == 0)
                    pointer += ((jz) inst).getOffset() - 1;
                break;

            case "JNZ":
                if (register[((jnz) inst).getReg()] != 0)
                    pointer += ((jnz) inst).getOffset() - 1;
                break;

            case "Jreg":
                pointer += register[((jreg) inst).getReg()];
                break;

            case "Halt":
                running = false;
                break;

        }
    }

    public void evalFibonacci() {

        ArrayList<instruction> commands = new ArrayList<>();

        instruction set1 = new loadImm("LoadImm", 0, 0);
        instruction set2 = new loadImm("LoadImm", 1, 1);
        instruction i1 = new data("Data", 0, "Enter a number between zero and nine : 0");
        instruction i2 = new outstr("OutStr", 0, 0);
        instruction i3 = new inb("InB", 7, 0);
        instruction storeInt = new store("Store", 7, 60);
        instruction one = new loadImm("LoadImm", 6, 1);
        instruction check00 = new jz("JZ", 7, 51); // ad

        instruction add1 = new add("Add", 0, 1, 2); // adds 1 and 2 into 3
        instruction add2 = new add("Add", 1, 3, 0); // adds 1 and 2 into 1
        instruction add3 = new add("Add", 2, 3, 1); // adds 1 and 2 into 1
        instruction sub = new sub("Sub", 7, 6, 7);
        instruction check0 = new jz("JZ", 7, 46); // ad

        instruction add4 = new add("Add", 0, 1, 2); // adds 1 and 2 into 3
        instruction add5 = new add("Add", 1, 3, 0); // adds 1 and 2 into 1
        instruction add6 = new add("Add", 2, 3, 1); // adds 1 and 2 into 1
        instruction sub1 = new sub("Sub", 7, 6, 7);
        instruction check1 = new jz("JZ", 7, 41);

        instruction add7 = new add("Add", 0, 1, 2); // adds 1 and 2 into 3
        instruction add8 = new add("Add", 1, 3, 0); // adds 1 and 2 into 1
        instruction add9 = new add("Add", 2, 3, 1); // adds 1 and 2 into 1
        instruction sub2 = new sub("Sub", 7, 6, 7);
        instruction check2 = new jz("JZ", 7, 36);

        instruction add10 = new add("Add", 0, 1, 2); // adds 1 and 2 into 3
        instruction add11 = new add("Add", 1, 3, 0); // adds 1 and 2 into 1
        instruction add12 = new add("Add", 2, 3, 1); // adds 1 and 2 into 1
        instruction sub3 = new sub("Sub", 7, 6, 7);
        instruction check3 = new jz("JZ", 7, 31);

        instruction add13 = new add("Add", 0, 1, 2); // adds 1 and 2 into 3
        instruction add14 = new add("Add", 1, 3, 0); // adds 1 and 2 into 1
        instruction add15 = new add("Add", 2, 3, 1); // adds 1 and 2 into 1
        instruction sub4 = new sub("Sub", 7, 6, 7);
        instruction check4 = new jz("JZ", 7, 26);

        instruction add16 = new add("Add", 0, 1, 2); // adds 1 and 2 into 3
        instruction add17 = new add("Add", 1, 3, 0); // adds 1 and 2 into 1
        instruction add18 = new add("Add", 2, 3, 1); // adds 1 and 2 into 1
        instruction sub5 = new sub("Sub", 7, 6, 7);
        instruction check5 = new jz("JZ", 7, 21);

        instruction add19 = new add("Add", 0, 1, 2); // adds 1 and 2 into 3
        instruction add20 = new add("Add", 1, 3, 0); // adds 1 and 2 into 1
        instruction add21 = new add("Add", 2, 3, 1); // adds 1 and 2 into 1
        instruction sub6 = new sub("Sub", 7, 6, 7);
        instruction check6 = new jz("JZ", 7, 16);

        instruction add22 = new add("Add", 0, 1, 2); // adds 1 and 2 into 3
        instruction add23 = new add("Add", 1, 3, 0); // adds 1 and 2 into 1
        instruction add24 = new add("Add", 2, 3, 1); // adds 1 and 2 into 1
        instruction sub7 = new sub("Sub", 7, 6, 7);
        instruction check7 = new jz("JZ", 7, 11);

        instruction add25 = new add("Add", 0, 1, 2); // adds 1 and 2 into 3
        instruction add26 = new add("Add", 1, 3, 0); // adds 1 and 2 into 1
        instruction add27 = new add("Add", 2, 3, 1); // adds 1 and 2 into 1
        instruction sub8 = new sub("Sub", 7, 6, 7);
        instruction check8 = new jz("JZ", 7, 6);

        instruction add28 = new add("Add", 0, 1, 2); // adds 1 and 2 into 3
        instruction add29 = new add("Add", 1, 3, 0); // adds 1 and 2 into 1
        instruction add30 = new add("Add", 2, 3, 1); // adds 1 and 2 into 1
        instruction sub9 = new sub("Sub", 7, 6, 7);
        instruction check9 = new jz("JZ", 7, 0);
        instruction halt1 = new halt("Halt");
        instruction finalread = new data("Data", 30, "Fibonnaci number is :  0");
        // instruction storeFib = new store("Store", 0, 59);
        instruction finalread2 = new outstr("OutStr", 30, 0);

        commands.add(set1);
        commands.add(set2);
        commands.add(i1);
        commands.add(i2);
        commands.add(i3);
        commands.add(storeInt);
        commands.add(one);
        commands.add(check00);
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

        commands.add(add19);
        commands.add(add20);
        commands.add(add21);
        commands.add(sub6);
        commands.add(check6);

        commands.add(add22);
        commands.add(add23);
        commands.add(add24);
        commands.add(sub7);
        commands.add(check7);

        commands.add(add25);
        commands.add(add26);
        commands.add(add27);
        commands.add(sub8);
        commands.add(check8);

        commands.add(add28);
        commands.add(add29);
        commands.add(add30);
        commands.add(sub9);
        commands.add(check9);

        commands.add(finalread);
        // commands.add(storeFib);
        commands.add(finalread2);
        commands.add(halt1);// final

        commands.add(i1);
        commands.add(i2);

        run(commands);
        System.out.println(register[0]);
        viewAllreg();
        readAllmem();

    }

    public static void main(String[] args) {

        console con1 = new console();
        ram r1 = new ram(1000);
        mmu m1 = new mmu();
        m1.attach(0, r1);

        cpu c1 = new cpu();
        c1.attachMem(m1);
        c1.attachIO(con1);
        c1.evalFibonacci();

    }
}
