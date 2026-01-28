import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Testy FabrykaBiletu")
@TestMethodOrder(OrderAnnotation.class)
public class FabrykaBiletuTest {

    private Rezerwacja rezerwacja;

    @BeforeEach
    void setUp() {
        rezerwacja = new Rezerwacja("2026-01-27", "2026-01-28", 50.0,
                                    new String[]{"A1"}, 1, 1);
    }

    @AfterEach
    void tearDown() {
        rezerwacja = null;
    }

    @Test
    @Order(1)
    @DisplayName("Tworzenie biletu z poprawnymi danymi")
    void testCreateTicket() {
        // given
        String kodQR = "QR123";
        String numerMiejsca = "A1";
        FabrykaBiletu fabryka = new FabrykaBiletu(kodQR, numerMiejsca, rezerwacja);

        // when
        Bilet bilet = fabryka.utworzDokument();

        // then
        assertNotNull(bilet);
        assertEquals(kodQR, bilet.getKodQR());
        assertEquals(numerMiejsca, bilet.getNumerMiejsca());
        assertEquals(rezerwacja.getKwotaRezerwacji(), bilet.getCena(), 0.001);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @Order(2)
    @DisplayName("kodQR null lub pusty rzuca wyjątek")
    void testKodQRNullOrEmptyThrowsException(String kodQR) {
        // given & when & then
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new FabrykaBiletu(kodQR, "A1", rezerwacja));
        assertTrue(ex.getMessage().contains("kodQR"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @Order(3)
    @DisplayName("numerMiejsca null lub pusty rzuca wyjątek")
    void testNumerMiejscaNullOrEmptyThrowsException(String numerMiejsca) {
        // given & when & then
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new FabrykaBiletu("QR123", numerMiejsca, rezerwacja));
        assertTrue(ex.getMessage().contains("numerMiejsca"));
    }

    @Test
    @Order(4)
    @DisplayName("rezerwacja null rzuca wyjątek")
    void testReservationNullThrowsException() {
        // given & when & then
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class,
                () -> new FabrykaBiletu("QR123", "A1", null));
        assertTrue(ex.getMessage().contains("rezerwacja"));
    }

    @Test
    @Order(5)
    @DisplayName("utworzDokument() zwraca nowy obiekt za każdym razem")
    void testUtworzDokumentReturnsNewObject() {
        // given
        FabrykaBiletu fabryka = new FabrykaBiletu("QR123", "A1", rezerwacja);

        // when
        Bilet bilet1 = fabryka.utworzDokument();
        Bilet bilet2 = fabryka.utworzDokument();

        // then
        assertNotSame(bilet1, bilet2);
    }
}
