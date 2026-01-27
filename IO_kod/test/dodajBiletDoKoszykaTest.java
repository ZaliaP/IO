import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class dodajBiletDoKoszykaTest {

    private dodajBiletDoKoszyka biletDoKoszyka;

    @BeforeAll
    static void setUpBeforeClass() {
        System.out.println("Testy klasy dodajBiletDoKoszyka");
    }

    @BeforeEach
    void setUp() {
        //given
        biletDoKoszyka = new dodajBiletDoKoszyka();
    }

    @AfterEach
    void tearDown() {
        biletDoKoszyka = null;
    }

    @AfterAll
    static void tearDownAfterClass() {
        System.out.println("Zakończenie testów");
    }


    @Order(1)
    @DisplayName("Dodanie biletu do koszyka - zakończone sukcesem")
    @ParameterizedTest
    @CsvSource({
            "19, 102, 90, 05-02-2026, 10A",
            "07, 108, 90, 08-03-2026, '10B, 11B'",
            "80, 103, 50, 29-01-2026, 15F"
    })
    void dodajBiletDoKoszyka(String uzytkownikID, int filmID, int kinoID, String data, String miejsca) {
        // when
        // then
        assertDoesNotThrow(() ->
                biletDoKoszyka.dodajBiletDoKoszyka(
                        uzytkownikID, filmID, kinoID, data, miejsca
                )
        );
    }
}