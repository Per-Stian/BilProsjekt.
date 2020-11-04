import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;

public class Motors implements Runnable{

    private Sensor sensor;
    public Motors(Sensor sensor) {
        this.sensor = sensor;
    }

    // get a handle to the GPIO controller
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput motor1pinA = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23, "m1");
        final GpioPinDigitalOutput motor2pinA = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, "m2");

    public Motors(String two) {
    }

    public void run() {
        try{

        System.out.println("rotate both motors clockwise for 3 seconds");
        motor1pinA.high();
        motor2pinA.high();
        // wait 3 seconds

        Thread.sleep(3000);
        System.out.println("Stopping motor 1");
        motor1pinA.low();
        System.out.println("Stopping motor 2");
        motor2pinA.low();
        gpio.shutdown();
    }catch (InterruptedException e){}

}}