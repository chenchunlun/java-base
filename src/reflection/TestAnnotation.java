package reflection;

import java.lang.annotation.*;

/**
 * Created by hp on 2016/6/3 0003.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TestAnnotation {
    String value();
}
