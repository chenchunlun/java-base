import designmode.DecoratorPattern;
import designmode.Singleton;
import io.ByteStream;
import io.CharStream;
import io.ProcessStream;
import io.RandomAccess;
import org.omg.SendingContext.RunTime;
import thread.DeallockThread;
import thread.MyThread;
import thread.SynThread;

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
        DeallockThread.test();
    }
}
