import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CombateTest {
    @Test
    public void testeAtaqueSimples() {
        Atacante atacante = createMock(Atacante.class);
        Defensor defensor = createMock(Defensor.class);
        Magia magia = createMock(Magia.class);
        expect(atacante.atacar()).andReturn(20);
        expect(defensor.defender(20)).andReturn(10);
        replay(atacante, defensor, magia);
        Combate combate = new Combate(atacante, defensor, magia);
        int resultado = combate.realizarAtaque();
        assertEquals(10, resultado);
        verify(atacante, defensor, magia);
    }

    @Test
    public void testeMagiaDeFogo() {
        Atacante atacante = createMock(Atacante.class);
        Defensor defensor = createMock(Defensor.class);
        Magia magia = createMock(Magia.class);
        expect(magia.lancarMagia("fogo")).andReturn("Explosão de fogo!");
        replay(atacante, defensor, magia);
        Combate combate = new Combate(atacante, defensor, magia);
        String resultado = combate.usarMagia("fogo");
        assertEquals("Explosão de fogo!", resultado);
        verify(atacante, defensor, magia);
    }

    @Test
    public void testeDefesaInvalida() {
        Atacante atacante = createMock(Atacante.class);
        Defensor defensor = createMock(Defensor.class);
        Magia magia = createMock(Magia.class);
        expect(atacante.atacar()).andReturn(15);
        expect(defensor.defender(15)).andThrow(new RuntimeException("Defesa inválida!"));
        replay(atacante, defensor, magia);
        Combate combate = new Combate(atacante, defensor, magia);
        assertThrows(RuntimeException.class, combate::realizarAtaque);
        verify(atacante, defensor, magia);
    }

    @Test
    public void testeVariosAtaquesSeguidos() {
        Atacante atacante = createMock(Atacante.class);
        Defensor defensor = createMock(Defensor.class);
        Magia magia = createMock(Magia.class);
        expect(atacante.atacar()).andReturn(10).andReturn(25);
        expect(defensor.defender(10)).andReturn(8);
        expect(defensor.defender(25)).andReturn(15);
        replay(atacante, defensor, magia);
        Combate combate = new Combate(atacante, defensor, magia);
        assertEquals(8, combate.realizarAtaque());
        assertEquals(15, combate.realizarAtaque());
        verify(atacante, defensor, magia);
    }
}
