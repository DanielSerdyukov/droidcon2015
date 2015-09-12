package moscow.droidcon2015.processor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Daniel Serdyukov
 */
@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.FIELD})
public @interface BindView {

    int value();

}
