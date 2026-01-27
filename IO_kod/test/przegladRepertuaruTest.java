import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class przegladRepertuaruTest {

    private przegladRepertuaru przeglad;

    @BeforeAll
    static void setUpBeforeClass() {
        System.out.println("Testy klasy PrzegladRepertuaru");
    }

    @BeforeEach
    void setUp() {
        //given
        przeglad = new przegladRepertuaru();
    }

    @AfterEach
    void tearDown() {
        przeglad = null;
    }

    @AfterAll
    static void tearDownAfterClass() {
        System.out.println("Zakończenie testów");
    }

    @Test
    @Order(1)
    @DisplayName("Przegląd repertuaru - repertuar nie jest null albo nie jest pustym zbiorem")
    void testPrzegladRepertuaruNotNull() {
        //when
        String[] filmy = przeglad.przeglapertuaru();

        //then
        assertAll(
                () -> assertNotNull(filmy, "Tablica filmów nie powinna być nullem"),
                () -> assertTrue(filmy.length > 0, "Tablica filmów nie powinna być pusta")
        );
    }
}