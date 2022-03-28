package Instructions;

public class data extends instruction {

    public String data;
    public int address;
    public String message;

    public data(String data, int address, String message) {
        this.data = data;
        this.address = address;
        this.message = message;

    }

    public String getName() {
        return data;
    }

    public int getAddress() {
        return address;
    }

    public String getMessage() {
        return message;
    }

}
