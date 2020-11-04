import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.RaspiPin;

public class Sensor implements Runnable{
    //GPIO Pins
    private static GpioPinDigitalOutput sensorTriggerPin ;
    private static GpioPinDigitalInput sensorEchoPin ;


    final static GpioController gpio = GpioFactory.getInstance();
    public double Distance ;
    public Sensor(String one) {
    }


    public void run() {
        sensorTriggerPin =  gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04); // Trigger pin as OUTPUT
        sensorEchoPin = gpio.provisionDigitalInputPin(RaspiPin.GPIO_17,PinPullResistance.PULL_DOWN); // Echo pin as INPUT


        while(true){
            try {
                Thread.sleep(2000);
                sensorTriggerPin.high(); // Make trigger pin HIGH
                Thread.sleep((long) 0.01);// Delay for 10 microseconds
                sensorTriggerPin.low(); //Make trigger pin LOW

                while(sensorEchoPin.isLow()){ //Wait until the ECHO pin gets HIGH
                }
                long startTime= System.nanoTime(); // Store the current time to calculate ECHO pin HIGH time.

                while(sensorEchoPin.isHigh()){ //Wait until the ECHO pin gets LOW
                }
                long endTime= System.nanoTime(); // Store the echo pin HIGH end time to calculate ECHO pin HIGH time.

                Distance = ((((endTime-startTime)/1e3)/2) / 29.1);
                System.out.println("Distance :"+ Distance +" cm"); //Printing out the distance in cm
                Thread.sleep(1000);


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}