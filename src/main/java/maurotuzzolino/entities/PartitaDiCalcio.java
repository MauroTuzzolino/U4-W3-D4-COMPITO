package maurotuzzolino.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class PartitaDiCalcio extends Evento {

    @Column(nullable = false)
    private String squadraDiCasa;

    @Column(nullable = false)
    private String squadraOspite;

    private String squadraVincente;

    private int numeroGoalSquadraCasa;
    private int numeroGoalSquadraOspite;

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String titolo, LocalDate data, String descrizione, TipoEvento tipo, int max, Location location, String squadraDiCasa, String squadraOspite, String squadraVincente, int goalCasa, int goalOspite) {
        super(titolo, data, descrizione, tipo, max, location);
        this.squadraDiCasa = squadraDiCasa;
        this.squadraOspite = squadraOspite;
        this.squadraVincente = squadraVincente;
        this.numeroGoalSquadraCasa = goalCasa;
        this.numeroGoalSquadraOspite = goalOspite;
    }

    public String getSquadraDiCasa() {
        return squadraDiCasa;
    }

    public void setSquadraDiCasa(String squadraDiCasa) {
        this.squadraDiCasa = squadraDiCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public int getNumeroGoalSquadraCasa() {
        return numeroGoalSquadraCasa;
    }

    public void setNumeroGoalSquadraCasa(int numeroGoalSquadraCasa) {
        this.numeroGoalSquadraCasa = numeroGoalSquadraCasa;
    }

    public int getNumeroGoalSquadraOspite() {
        return numeroGoalSquadraOspite;
    }

    public void setNumeroGoalSquadraOspite(int numeroGoalSquadraOspite) {
        this.numeroGoalSquadraOspite = numeroGoalSquadraOspite;
    }
}
