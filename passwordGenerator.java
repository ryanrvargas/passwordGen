import java.util.ArrayList;

public class passwordGenerator {
    private String password;
    private int length;
    private final String c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-={}[]|:;<>,.?/";
    ArrayList<String> savedP = new ArrayList<String>();


    public passwordGenerator(int length){
        this.length = length;
        this.password = "";
    }

    public void getSavedP(){
        int index = 1;
        for (String p : savedP){
            System.out.printf("%d:Password:%s\n",index, p);
            index += 1;
        }
    }

    public void generateP(){
        for (int i = 0; i < length; i++){
            this.password += c.charAt((int)(Math.random()*c.length()));
        }
        savedP.add(this.password);
        this.password = "";
    }


}
