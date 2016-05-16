package designmode;


import javax.swing.plaf.synth.SynthEditorPaneUI;

/**
 * 装饰着模式.（增强功能）
 * 组合
 * 在不改变原类文件和使用的前提下，动态的扩展一个对象的功能，他通过创建一个包装对象也就是装饰者来包裹真实的对象
 * java.io
 * 操作流 对 节点流的装饰
 */
public class DecoratorPattern {
    public static void test(){
        Sound sound = new Sound("张三",200);
        Microphone microphone = new Microphone(sound);
        System.out.println(sound);
        System.out.println(microphone);
    }

}

class Microphone{
    private Sound sound;
    public Microphone(Sound sound) {
        this.sound = sound;
    }

    @Override
    public String toString() {
        return sound.getOwner()+"的音量为："+(sound.getVolume()*20);
    }
}

class Sound{
    private String owner;
    private int volume;

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Sound(String owner) {
        this(owner,100);
    }

    public Sound(String owner, int volume) {
        this.owner = owner;
        this.volume = volume;
    }

    @Override
    public String toString() {
        return owner+"的音量为："+volume;
    }
}
