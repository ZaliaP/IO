import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;

@DisplayName("Testy zarzadzanieKontemUzytkownika z mockami")
class zarzadzanieKontemUzytkownikaTest {

    @Mock
    private IModelKina model;

    @InjectMocks
    private zarzadzanieKontemUzytkownika zarzadzanie;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Wybranie opcji 1 - edycja danych użytkownika")
    void testEdycjaDanychUzytkownika() {
        //given
        int opcja = 1;
        String userId = "15";
        String[] noweDane = {"Anna", "Maria"};

        //when
        zarzadzanie.zarzadzanieKontemUzytkownika(opcja, userId, noweDane);

        //then
        verify(model, times(1))
                .aktualizujDaneUzytkownika(userId, noweDane);

        verify(model, times(1))
                .zarejestrowanieZdarzenia("Zakonczono zarzadzanie kontem.");

        verify(model, never())
                .pobierzHistorieRezerwacji(anyString());
    }
}
