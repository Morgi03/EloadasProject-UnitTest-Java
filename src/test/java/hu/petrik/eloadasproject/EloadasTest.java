package hu.petrik.eloadasproject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EloadasTest {
    Eloadas eloadas;

    @BeforeEach
    void setUp() {
        eloadas = new Eloadas(4, 5);
    }

    @Test
    void Eloadas() {
        assertThrows(IllegalArgumentException.class, () -> new Eloadas(0, 0));
        assertThrows(IllegalArgumentException.class, () -> new Eloadas(0, 5));
        assertThrows(IllegalArgumentException.class, () -> new Eloadas(4, 0));
        assertThrows(IllegalArgumentException.class, () -> new Eloadas(-7, 5));
        assertThrows(IllegalArgumentException.class, () -> new Eloadas(4, -3));
        assertThrows(IllegalArgumentException.class, () -> new Eloadas(-7, -3));
        assertThrows(IllegalArgumentException.class, () -> new Eloadas(-7, 0));
        assertThrows(IllegalArgumentException.class, () -> new Eloadas(0, -3));
    }

    @Test
    void lefoglal() {
        for (int i = 0; i < 20; i++) {
            //Első 20 hely sikeresen lefoglalható
            assertTrue(eloadas.lefoglal());
        }
        // teltháznál már nem lehet több helyet lefoglalható
        assertFalse(eloadas.lefoglal());
        assertFalse(eloadas.lefoglal());

    }

    @Test
    void getSzabadHelyek() {
        assertEquals(20, eloadas.getSzabadHelyek());
        eloadas.lefoglal();
        assertEquals(19, eloadas.getSzabadHelyek());
        for (int i = 0; i < 18; i++) {
            eloadas.lefoglal();
        }
        assertEquals(1, eloadas.getSzabadHelyek());
        eloadas.lefoglal();
        assertEquals(0, eloadas.getSzabadHelyek());
        eloadas.lefoglal();
        assertEquals(0, eloadas.getSzabadHelyek());
    }

    @Test
    void getTeli() {
        assertFalse(eloadas.getTeli());
        eloadas.lefoglal();
        assertFalse(eloadas.getTeli());
        for (int i = 0; i < 18; i++) {
            eloadas.lefoglal();
        }
        assertFalse(eloadas.getTeli());
        eloadas.lefoglal();
        assertTrue(eloadas.getTeli());
        eloadas.lefoglal();
        assertTrue(eloadas.getTeli());
    }

    @Test
    void foglalt() {
        assertThrows(IllegalArgumentException.class, () -> eloadas.foglalt(0, 0));
        assertThrows(IllegalArgumentException.class, () -> eloadas.foglalt(0, 5));
        assertThrows(IllegalArgumentException.class, () -> eloadas.foglalt(4, 0));
        assertThrows(IllegalArgumentException.class, () -> eloadas.foglalt(-7, 5));
        assertThrows(IllegalArgumentException.class, () -> eloadas.foglalt(4, -3));
        assertThrows(IllegalArgumentException.class, () -> eloadas.foglalt(-7, -3));
        assertThrows(IllegalArgumentException.class, () -> eloadas.foglalt(-7, 0));
        assertThrows(IllegalArgumentException.class, () -> eloadas.foglalt(0, -3));
        assertThrows(IllegalArgumentException.class, () -> eloadas.foglalt(5, 3));
        assertThrows(IllegalArgumentException.class, () -> eloadas.foglalt(3, 6));

        assertFalse(eloadas.foglalt(1,1));
        eloadas.lefoglal();
        assertTrue(eloadas.foglalt(1,1));
        assertFalse(eloadas.foglalt(1,2));
        assertFalse(eloadas.foglalt(2,1));
        eloadas.lefoglal();
        assertTrue(eloadas.foglalt(1,1));
        assertTrue(eloadas.foglalt(1,2));
        assertFalse(eloadas.foglalt(2,1));
        //Első sor maradék helyeit lefoglalom
        for (int i = 0; i < 3; i++) {
            eloadas.lefoglal();
        }
        assertTrue(eloadas.foglalt(1,1));
        assertTrue(eloadas.foglalt(1,2));
        assertFalse(eloadas.foglalt(2,1));

        eloadas.lefoglal();

        assertTrue(eloadas.foglalt(1,1));
        assertTrue(eloadas.foglalt(1,2));
        assertTrue(eloadas.foglalt(2,1));


    }
}