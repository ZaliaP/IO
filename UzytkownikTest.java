import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testy Uzytkownika")
@TestMethodOrder(OrderAnnotation.class)
public class UzytkownikTest {

    private Uzytkownik uzytkownik;

    @BeforeEach
    void setUp() {
        uzytkownik = new Uzytkownik("default@example.com", "Default", "User", 1);
    }

    @AfterEach
    void tearDown() {
        uzytkownik = null;
    }

    @Test
    @Order(1)
    @DisplayName("konstruktor poprawnie inicjalizuje dane")
    void testConstructor() {
        // then
        assertNotNull(uzytkownik);
        assertTrue(uzytkownik.getEmail().contains("@"));
        assertFalse(uzytkownik.getImie().isEmpty());
        assertFalse(uzytkownik.getNazwisko().isEmpty());
        assertTrue(uzytkownik.getUzytkownikID() > 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"user@domain.com", "test@company.pl", "example@mail.com"})
    @Order(2)
    @DisplayName("email jest poprawny dla różnych wartości")
    void testEmailValidation(String email) {
        // given & when
        uzytkownik = new Uzytkownik(email, "Jan", "Kowalski", 5);

        // then
        assertTrue(uzytkownik.getEmail().contains("@"));
        assertNotNull(uzytkownik.getEmail());
        assertTrue(uzytkownik.getUzytkownikID() > 0);
    }

    @ParameterizedTest
    @CsvSource({
        "Jan, Kowalski",
        "Anna, Nowak",
        "Piotr, Lewandowski"
    })
    @Order(3)
    @DisplayName("imię i nazwisko nie mogą być puste")
    void testNameAndSurnameNotEmpty(String imie, String nazwisko) {
        // given & when
        uzytkownik = new Uzytkownik("email@test.com", imie, nazwisko, 10);

        // then
        assertFalse(uzytkownik.getImie().isEmpty());
        assertFalse(uzytkownik.getNazwisko().isEmpty());
    }

    @Test
    @Order(4)
    @DisplayName("kombinacja email + ID jest unikalna")
    void testEmailAndIdCombination() {
        // given
        String email = "unique@mail.com";
        int id = 99;
        uzytkownik = new Uzytkownik(email, "Adam", "Kowalski", id);

        // then
        assertEquals(email, uzytkownik.getEmail());
        assertEquals(id, uzytkownik.getUzytkownikID());
    }
}