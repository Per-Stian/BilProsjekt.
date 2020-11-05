public class Main {
    public static void main(String[] args) {
        //initialising threads
        Thread n1 = new  Thread(new Sensor("one"));
        Thread n2 = new  Thread(new Motors("two"));

        //Starting the threads
        n1.start();
        n2.start();
    }
}
