package sky.pro.env_home_work8;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import sky.pro.env_home_work8.service.EmployeeServiceImpl;

import java.util.stream.Stream;

public class EmployeeServiceImplTest {
    private final EmployeeServiceImpl out = new EmployeeServiceImpl();
    private static Stream<Arguments> argumentsForEmployeeTests() {
        return Stream.of(
                Arguments.of("Иван", "Иванов", 5, 50000),
                Arguments.of("Иван1", "Иванов1", 5, 55000)
        );
    }
  /*  @ParameterizedTest
    @MethodSource("argumentsForEmployeeTests")
    public void paramTestPlus(int num1, int num2, int expected) {
        assertEquals(expected, out.calculatorPlus(num1,num2));
    }*/
}
