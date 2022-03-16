import java.util.Scanner;

public class console implements IO{

    @Override
    public char write(int a) {
       char b = (char) a;
       System.out.print(b);
        return b;
    }

    @Override
    public int read() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char c = scan.next().charAt(0);

        int a = c;
        scan.close();
        return a;
        
    }



    
}
