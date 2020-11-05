import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

public class Motors implements Runnable{

    // get a handle to the GPIO controller
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput motor1and2pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23, "m1");
        final GpioPinDigitalOutput motor3and4pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, "m2");

    public Motors(String two) {
    }

    public void run() {
        Sensor sensorObject = new Sensor();
        sensorObject.run();
        try{
        System.out.println("rotate both motors clockwise for 3 seconds");
        motor1and2pin.high();
        motor3and4pin.high();
        if (Distance < 30);
        motor1and2pin.low();
        motor3and4pin.low();
        System.out.println("Stopping motors");
        gpio.shutdown();


        // wait 3 seconds
       // Thread.sleep(3000);
        //System.out.println("Stopping motor 1");
        //motor1and2pin.low();
        //System.out.println("Stopping motor 2");
        //motor3and4pin.low();
        //gpio.shutdown();
        } catch (InterruptedException e){}
    }
}