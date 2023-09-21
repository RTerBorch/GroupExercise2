package gruppprojekt;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

public class CarTest {


    @Test void carTest_valid(){
        assertNotNull(new Car());
    }


}
