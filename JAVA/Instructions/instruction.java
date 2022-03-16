package Instructions;
public class instruction {

    private String InstName;
    private int data1;
    private String data2;

    public instruction(String InstName, int data1, String data2){
        this.InstName = InstName;
        this.data1= data1;
        this.data2 = data2;
    }

    public int getdata1(){
        return data1;
    }

    public String getdata2(){
        return data2;
    }

    private int loadImm1;
    private int loadImm2;

    public instruction(String InstName, int loadImm1, int loadImm2){
        this.InstName = InstName;
        this.loadImm1= loadImm1;
        this.loadImm2 = loadImm2;
    }

    //loadImm

    public int getloadImm1(){
        return loadImm1;
    }

    public int getloadImm2(){
        return loadImm2;
    }

    //load

    public int getload1(){
        return loadImm1;
    }

    public int getload2(){
        return loadImm2;
    }

    //store

    public int getstore1(){
        return loadImm1;
    }

    public int getstore2(){
        return loadImm2;
    }

    //inb

    public int getinb1(){
        return loadImm1;
    }

    public int getinb2(){
        return loadImm2;
    }

    //outb

    public int getOutb1(){
        return loadImm1;
    }

    public int getOutb2(){
        return loadImm2;
    }






    //outnum





    //outstr

    public int getOutstr1(){
        return loadImm1;
    }

    public int getOutstr2(){
        return loadImm2;
    }




    int rega;
    int regb;
    int regc;

    public instruction(String InstName, int rega, int regb, int regc){
        this.InstName = InstName;
        this.rega = rega;
        this.regb = regb;
        this.regc = regc;

    }

    public int getRega(){
        return rega;
    }

    public int getRegb(){
        return regb;
    }

    public int getRegc(){
        return regc;
    }


    int offset;

    public instruction(String InstName, int offset){
        this.InstName = InstName;
        this.offset = offset;
    }

    public int getOffset(){
        return offset;
    }


    //JZ

    public int getjz1(){
        return loadImm1;
    }

    public int getjz2(){
        return loadImm2;
    }


    //JReg

    public int getReg(){
        return offset;
    }

    public instruction(String InstName){
        this.InstName = InstName;
    }

    public String getInstName(){
        return InstName;
    }

}