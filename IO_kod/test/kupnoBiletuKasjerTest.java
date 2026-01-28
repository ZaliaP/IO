import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test kupna biletu przez kasjera")
class kupnoBiletuKasjerTest {

    class TestowyDokument extends Dokument {
        public TestowyDokument(int aDokumentID, double aCena) {
            super(aDokumentID, aCena);
        }
    }

    @Mock
    private IModelKina model;

    @InjectMocks
    private kupnoBiletuKasjer kupnoBiletu;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void kupnoBiletu() {
        //given
        int seansID = 103;
        String[] miejsca = {"10A"};
        int cena = 10;
        List<Dokument> dokument = Arrays.asList(new TestowyDokument(seansID, cena));

        when(model.sprawdzDostepnoscMiejsca(eq(seansID), any(String[].class))).thenReturn(true);
        when(model.finalizujZakup(any(String[].class), eq(seansID), anyInt())).thenReturn(dokument);

        doNothing().when(model).aktualizujMiejscaNaSali(anyInt(), any(String[].class));
        doNothing().when(model).zarejestrowanieZdarzenia(anyString());

        //when
        List<Dokument> wynik = kupnoBiletu.kupnoBiletu(model, seansID);

        //then
        assertNotNull(wynik, "Dokument nie może być pusty");
        assertEquals(1, wynik.size());

        verify(model, times(1)).sprawdzDostepnoscMiejsca(eq(seansID), any());
        verify(model, times(1)).finalizujZakup(any(), eq(seansID), anyInt());
        verify(model, times(1)).zarejestrowanieZdarzenia(contains("Zakup zakonczony"));
    }
}