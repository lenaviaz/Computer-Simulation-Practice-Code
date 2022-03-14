public class rom implements memory{
    
    private int size;
    private int[] capacity;
    
    public rom(int a){
        size = a;
        capacity = new int[size];
    
    }
    
    @Override
    public void initialize(int address, String word) {
        System.out.println("ROM initialize");

        for(int i = 0; i < word.length(); i++){
            int a = (int)word.charAt(i);
    
            capacity[address] = a;
            address++;
        }
        
    }
    
   @Override
    public int read(int address) {
        System.out.println(capacity[address]);
        return capacity[address];
    
    
    }
    
    @Override
    public void write(int address, int a) {
    // do nothing
    }

    @Override
    public int getSize() {
        return size;
    }

}
