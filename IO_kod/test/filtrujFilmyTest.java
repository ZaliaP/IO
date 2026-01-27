import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class filtrujFilmyTest {

    private filtrujFilmy filtrujFilmy;

    @BeforeAll
    static void setUpBeforeClass() {
        System.out.println("Testy klasy filtrujFilmy");
    }

    @BeforeEach
    void setUp() {
        //given
        filtrujFilmy = new filtrujFilmy();
    }

    @AfterEach
    void tearDown() {
        filtrujFilmy = null;
    }

    @AfterAll
    static void tearDownAfterClass() {
        System.out.println("Zakończenie testów");
    }

    @Order(1)
    @DisplayName("Filtruj filmy")
    @ParameterizedTest
    @ValueSource(strings = {"05-05-2026", "06-06-2026"})
    void filtrujFilmy(String data) {
        //when
        //then
        assertDoesNotThrow(() ->
            filtrujFilmy.filtrujFilmy(19, data)
        );
    }

    @Test
    @Order(2)
    @DisplayName("Filtrowanie filmów – data jest null")
    void filtrujFilmy_nullData() {
        //when
        //then
        assertThrows(IllegalArgumentException.class, () ->
                filtrujFilmy.filtrujFilmy(102, null)
        );
    }

    @Test
    @Order(3)
    @DisplayName("Filtrowanie filmów – data jest pusta")
    void filtrujFilmy_blankData() {
        //when
        //then
        assertThrows(IllegalArgumentException.class, () ->
                filtrujFilmy.filtrujFilmy(102, "")
        );
    }

    @Test
    @Order(4)
    @DisplayName("Filtrowanie filmów – id filmu jest mniejsze od 0")
    void filtrujFilmy_idlessthanzero() {
        //when
        //then
        assertThrows(IllegalArgumentException.class, () ->
                filtrujFilmy.filtrujFilmy(-1, "26-02-2026")
        );
    }
}