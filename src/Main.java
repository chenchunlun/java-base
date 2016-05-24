import designmode.DecoratorPattern;
import designmode.ProducerConsumer;
import designmode.Singleton;
import dll.NativeHello;
import io.ByteStream;
import io.CharStream;
import io.ProcessStream;
import io.RandomAccess;
import net.Datagram;
import net.InetAddress01;
import net.tcp.Test;
import org.omg.SendingContext.RunTime;
import thread.DeallockThread;
import thread.MyThread;
import thread.SynThread;
import thread.TimerThread;

public class Main {

    public static void main(String[] args) {
        // ByteStream.test();
        //CharStream.test();
        //ProcessStream.test();
        //RandomAccess.test();
        //DecoratorPattern.test();
        //MyThread.test();
        // SynThread.test();
        //Singleton.test();
        //DeallockThread.test();
        // ProducerConsumer.test();
        //TimerThread.test();
        //NativeHello.test();
        //InetAddress01.test();
        //Datagram.test();
        Test.test();
    }
}
