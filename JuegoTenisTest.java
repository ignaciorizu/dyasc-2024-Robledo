
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import juego.JuegoTenis;

public class JuegoTenisTest {

    private JuegoTenis juego;

    @BeforeEach
    public void setUp() {
        juego = new JuegoTenis("Jugador 1", "Jugador 2");
    }

    @Test
    public void losJugadoresEmpiezanConCeroPuntos() {
        assertEquals("0", juego.obtenerPuntaje("Jugador 1"));
        assertEquals("0", juego.obtenerPuntaje("Jugador 2"));
    }
}
