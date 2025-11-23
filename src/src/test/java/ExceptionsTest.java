import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class ExceptionsTest {
    @Test
    void exceptionCheck(){
        System.out.println(Optional.ofNullable(null));
        //System.out.println(null); - вызывает AmbiguousMethodException
        // в Java нет исключения AmbiguousMethodException.
        //Эта проблема решается на этапе компиляции.
        //В блоке catch обработать его не получиться, поскольку ошибка не возникает во время выполнения программы.

        try{
            Assertions.assertTrue(false);
        } catch (Error e) {
            System.out.println(e.getMessage());
        }
    }


}
