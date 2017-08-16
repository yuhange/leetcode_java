package facade;

/**
 * Created by lenovo on 2017/3/19.
 */
public class Facade {
    private Fan fan;
    private TV tv;
    private Light light;
    public Facade(Fan fan, TV tv, Light light) {
        this.fan = fan;
        this.tv = tv;
        this.light = light;
    }

    public void startShow() {
        fan.on();
        fan.speedUp();
        light.on();
        light.adjust();
        tv.on();
        tv.change();
    }

    public void endShow() {
        tv.off();
        light.off();
        fan.off();
    }
}
