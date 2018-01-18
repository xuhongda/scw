/**
 * @authorxuhongda on 2017/12/12
 * PACKAGE_NAME
 * scw-parent
 */

import java.lang.annotation.*;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface AnotationTest {
        String author() default "ss";
        String date();
        int revision() default 1;
        String comments();
}
