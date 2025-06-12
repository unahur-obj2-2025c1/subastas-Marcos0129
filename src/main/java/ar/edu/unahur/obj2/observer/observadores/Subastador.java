package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;

public class Subastador implements Observer {
    //Cada subastador es un usuario que participarán en la subasta
    private final String nombreDelSubastador;
    private Oferta ultimaOferta;

    public Subastador(String nombreDelSubastador) {
        this.nombreDelSubastador = nombreDelSubastador;
        this.actualizar(new Oferta(this, 0));
    }

    @Override
    public void actualizar(Oferta oferta) {
        this.ultimaOferta = oferta;
    }

    public Oferta hacerOferta(){
        return new Oferta(this, ultimaOferta.getValorOfertado()+10);
    }

    public String getNombreDelSubastador() {
        return nombreDelSubastador;
    }

    public Oferta getUltimaOferta() {
        return ultimaOferta;
    }

    public void reiniciarSubastador(){
        this.actualizar(new Oferta(this,0));
    }
}
