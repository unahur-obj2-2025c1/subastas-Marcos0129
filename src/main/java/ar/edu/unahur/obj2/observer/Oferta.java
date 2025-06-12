package ar.edu.unahur.obj2.observer;

import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class Oferta {
    
    private Subastador subastador;
    private Integer valorOfertado;

    public Oferta(Subastador subastador, Integer valorOfertado) {
        this.subastador = subastador;
        this.valorOfertado = valorOfertado;
    }

    public Subastador getSubastador() {
        return subastador;
    }

    public Integer getValorOfertado() {
        return valorOfertado;
    }
}
