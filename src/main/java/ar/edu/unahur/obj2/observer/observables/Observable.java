package ar.edu.unahur.obj2.observer.observables;

import ar.edu.unahur.obj2.observer.observadores.Subastador;

public interface Observable {

    void agregarObservador(Subastador Observador);
    void quitarObservador(Subastador Observador);
    void notificar();
}
