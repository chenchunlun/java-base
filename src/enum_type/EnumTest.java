package enum_type;

import static enum_type.OpConstant.*;

/**
 * Created by hp on 2016/6/15 0015.
 */
public class EnumTest {
    public static void doOp(OpConstant opConstant){
        switch (opConstant){
            case TURN_LEFT :
                System.out.println("向左转");
                break;
            case TURN_RIGHT:
                System.out.println("向右转");
                break;
            case SHOOT:
                System.out.println("射击");
                break;
            default:
                System.out.print("没有匹配的枚举");
        }
    }
}

enum OpConstant{
    TURN_LEFT,TURN_RIGHT,SHOOT
}
