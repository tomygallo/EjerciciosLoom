package _04TierraDeFantasias_Razas;
import static org.junit.Assert.*;

import org.junit.Test;

public class Tests {


    @Test
    public void WriveDescansa() {
        Wrives Rai = new Wrives();
        Rai.descansar();
        assertEquals(158, Rai.getSalud());
    }

    @Test
    public void WriveEsAtacado() {
        Vainilla Vai = new Vainilla();
        Wrives Rai = new Wrives();
        Vai.atacar(Rai);
        assertEquals(78, Rai.getSalud());
    }

    @Test
    public void WriveAtaca() {
        Vainilla Vai = new Vainilla();
        Wrives Rai = new Wrives();
        Rai.atacar(Vai);
        Rai.atacar(Vai);
        assertEquals(161, Vai.getSalud());
    }


    @Test
    public void WriveNoAtaca() {
        Vainilla Vai = new Vainilla();
        Wrives Rai = new Wrives();
        Rai.descansar();
        Rai.atacar(Vai);
        assertEquals(500,Vai.getSalud());
    }


    @Test
    public void RadaiteranDescansa() {
        Radaiteran Rai = new Radaiteran();
        Rai.descansar();
        assertEquals(176, Rai.getSalud());
    }

    @Test
    public void RadaiteranEsAtacado() {
        Radaiteran Rai = new Radaiteran();
        Vainilla Vai = new Vainilla();
        Vai.atacar(Rai);
        assertEquals(161, Rai.getSalud());
    }


    @Test
    public void RadaiteranAtaca() {
        Vainilla Vai = new Vainilla();
        Radaiteran Rai = new Radaiteran();
        Rai.atacar(Vai);
        Rai.atacar(Vai);
        assertEquals(385, Vai.getSalud());
    }
    
    
    @Test
    public void NortaichianDescansa() {
        Raza Rai = new Nortaichian();
        Rai.descansar();
        assertEquals(166, Rai.getSalud());
    }


}