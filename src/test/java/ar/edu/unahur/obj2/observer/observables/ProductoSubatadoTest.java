package ar.edu.unahur.obj2.observer.observables;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

class ProductoSubatadoTest {

    ProductoSubastado celular = new ProductoSubastado();

    Subastador gonzager = new Subastador("gonzager");
    Subastador diazdan = new Subastador("diazdan");
    Subastador martomau = new Subastador("martomau");

    @BeforeEach
    void resetearSubasta(){
        celular.reiniciarSubasta();
        gonzager.reiniciarSubastador();
        diazdan.reiniciarSubastador();
        martomau.reiniciarSubastador();

        celular.agregarObservador(gonzager);
        celular.agregarObservador(martomau);
    }

    void escenario1(){
        celular.agregarOferta(martomau.hacerOferta());
        celular.agregarOferta(gonzager.hacerOferta());
        celular.agregarOferta(martomau.hacerOferta());
    }

    @Test
    void gonzagerYMartomauRecibenCorrectamenteLaOfertaRealizada(){
        escenario1();
        assertEquals(martomau, gonzager.getUltimaOferta().getSubastador());
        assertEquals(martomau, martomau.getUltimaOferta().getSubastador());
    }

    @Test
    void seVerificaQueLaUltimaOfertaRegistradaPerteneceAlSubastadorMartomau(){
        escenario1();
        assertTrue(celular.getUltimaOferta().getSubastador() == martomau);
    }

    @Test
    void seVerificaQueElValorDeLaUltimaOfertaSea30(){
        escenario1();
        assertEquals(30, celular.getUltimaOferta().getValorOfertado());
    }

    @Test
    void seVerificaQueLaCantidadDeOfertasSea3(){
        escenario1();
        assertEquals(3,celular.getOfertas().size());
    }

    @Test 
    void queLanceUnaExcepcionCuandoOfertaAlguienQueNoParticipaEnLaSubasta(){
        escenario1();
        assertThrows(OfertaSubastadorException.class, () -> 
        {celular.agregarOferta(diazdan.hacerOferta());}, "El subastadador no participa en la subasta");
    }

}
