import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testy Klienta")
@TestMethodOrder(OrderAnnotation.class)
public class KlientTest {

    private Klient klient;

    @BeforeEach
    void setUp() {
        klient = new Klient("test@example.com", "Jan", "Kowalski", 1);
    }

    @AfterEach
    void tearDown() {
        klient = null;
    }

    @Test
    @Order(1)
    @DisplayName("konstruktor poprawnie inicjalizuje pola")
    void testConstructor() {
        // then
        assertNotNull(klient);
        assertTrue(klient.getEmail().contains("@"));
        assertEquals("Jan", klient.getImie());
    }

    @ParameterizedTest
    @ValueSource(strings = {"short", "123456", "abc!@#", "ComplexPass1!"})
    @Order(2)
    @DisplayName("ustawianie i odczyt hasła")
    void testSetAndGetHaslo(String haslo) {
        // when
        klient.setHaslo(haslo);

        // then
        assertEquals(haslo, klient.getHaslo());
        assertTrue(klient.getHaslo().length() > 0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"user1", "admin", "tester"})
    @Order(3)
    @DisplayName("ustawianie i odczyt loginu")
    void testSetAndGetLogin(String login) {
        // when
        klient.setLogin(login);

        // then
        assertEquals(login, klient.getLogin());
        assertNotNull(klient.getLogin());
    }

    @ParameterizedTest
    @CsvSource({
        "user1, pass1",
        "admin, SecurePassword123",
        "test.user, P@ssw0rd!"
    })
    @Order(4)
    @DisplayName("kombinacje login + hasło")
    void testLoginAndHasloCombination(String login, String haslo) {
        // when
        klient.setLogin(login);
        klient.setHaslo(haslo);

        // then
        assertEquals(login, klient.getLogin());
        assertEquals(haslo, klient.getHaslo());
        assertNotEquals("wrong", klient.getLogin());
    }

    @Test
    @Order(5)
    @DisplayName("aktualizacja loginu i hasła działa poprawnie")
    void testUpdateLoginAndHaslo() {
        // given
        String login1 = "firstLogin";
        String login2 = "secondLogin";
        String haslo1 = "firstPass";
        String haslo2 = "secondPass";

        // when
        klient.setLogin(login1);
        klient.setHaslo(haslo1);

        // then
        assertEquals(login1, klient.getLogin());
        assertEquals(haslo1, klient.getHaslo());

        // when
        klient.setLogin(login2);
        klient.setHaslo(haslo2);

        // then
        assertEquals(login2, klient.getLogin());
        assertEquals(haslo2, klient.getHaslo());
        assertNotEquals(login1, klient.getLogin());
        assertNotEquals(haslo1, klient.getHaslo());
    }
}
