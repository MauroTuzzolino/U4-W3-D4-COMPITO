package maurotuzzolino.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

@Entity
public class Concerto extends Evento {

    @Column
    @Enumerated(EnumType.STRING)
    private GenereConcerto genere;

    @Column
    private boolean inStreaming;

    public Concerto() {
    }

    public Concerto(String titolo, LocalDate data, String descrizione, TipoEvento tipo, int max, Location location,
                    GenereConcerto genere, boolean inStreaming) {
        super(titolo, data, descrizione, tipo, max, location);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public GenereConcerto getGenere() {
        return genere;
    }

    public void setGenere(GenereConcerto genere) {
        this.genere = genere;
    }

    public boolean isInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(boolean inStreaming) {
        this.inStreaming = inStreaming;
    }
}
