public class instruction {

    private String data;
    private int val1;
    private String val2;

    public instruction(String data, int val1, String val2){
        this.data = data;
        this.val1= val1;
        this.val2 = val2;
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

    public int toInt(){
        int a = Integer.parseInt(val2);
        return a;
    }

}
