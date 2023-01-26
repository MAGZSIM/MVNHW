import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {
    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
    // эквивалентные негативные значения, баг, могут быть проблемы при возврате.
    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndNegativeCost() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = -60_000;
        boolean registered = true;
        long expected = -1800;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    // эквивалентные позитивные значения
    @org.junit.jupiter.api.Test
    void shouldCalculateUnRegistered() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 10_000;
        boolean registered = false;
        long expected = 100;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    // граничные значения
    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredLimitValue() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 134;
        boolean registered = true;
        long expected = 4;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void shouldCalculateUnRegisteredLimitValue() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 49_900;
        boolean registered = false;
        long expected = 499;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }



}
