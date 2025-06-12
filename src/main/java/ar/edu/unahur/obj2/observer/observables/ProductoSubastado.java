package ar.edu.unahur.obj2.observer.observables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Observer;
import ar.edu.unahur.obj2.observer.observadores.Subastador;

public class ProductoSubastado implements Observable{

    private Set<Observer> subastadores = new HashSet<>();       //Los subastadores son los observadores
    private List<Oferta> ofertas = new ArrayList<>();           //Las ofertas las hacen los subastadores

    @Override
    public void agregarObservador(Subastador Observador) {
        subastadores.add(Observador);
    }

    @Override
    public void quitarObservador(Subastador Observador) {
        subastadores.remove(Observador);
    }

    @Override
    public void notificar() {
        subastadores.forEach(subastador -> subastador.actualizar(this.getUltimaOferta()));
    }

    public Oferta getUltimaOferta(){
        return ofertas.get(ofertas.size() - 1);
    }

    public void agregarOferta(Oferta oferta){
        if (!subastadores.contains(oferta.getSubastador())){
            throw new OfertaSubastadorException("El subastador no participa en al subasta");
        }
        ofertas.add(oferta);
        this.notificar();
    }

    public Set<Observer> getSubastadores() {
        return subastadores;
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void reiniciarSubasta(){
        ofertas.clear();
        subastadores.clear();
    }

}
