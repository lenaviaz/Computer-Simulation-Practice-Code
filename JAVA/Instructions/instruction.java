package Instructions;
public class instruction {

    private String data;
    private int val1;
    private int val2int;
    private String val2;

    public instruction(String data, int val1, String val2){
        this.data = data;
        this.val1= val1;
        this.val2 = val2;
    }

    public instruction(String data, int val1, int val2int){
        this.data = data;
        this.val1= val1;
        this.val2int = val2int;
    }

    public String getData(){
        return data;
    }

    public int getval1(){
        return val1;
    }

    public String getval2(){
        return val2;
    }

    public int getval2int(){
        return val2int;
    }

 //   public int toInt(){
   //     int a = Integer.parseInt(val2);
 //       return a;
  //  }

}
