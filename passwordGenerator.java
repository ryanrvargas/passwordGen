public class passwordGenerator {
    private String password;
    private int length;
    private final String c = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-={}[]|:;<>,.?/";

    public passwordGenerator(int length){
        this.length = length;
        this.password = null;
    }

    public String getPassword(){
        return password;
    }

    public void generateP(){
        for (int i = 0; i < length; i++){
            password += c.charAt((int)(Math.random()*c.length()));
        }
    }

}
