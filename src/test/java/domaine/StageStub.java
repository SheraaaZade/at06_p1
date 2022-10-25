package domaine;

import java.util.Set;

public class StageStub implements Stage {
    Moniteur moniteur;
    int numeroSemaine;
    Sport sport;

    public StageStub(Moniteur moniteur, int numeroSemaine, Sport sport) {
        this.moniteur = moniteur;
        this.numeroSemaine = numeroSemaine;
        this.sport = sport;
    }

    @Override
    public String getIntitule() {
        return null;
    }

    @Override
    public String getLieu() {
        return null;
    }

    @Override
    public int getNumeroDeSemaine() {
        return numeroSemaine;
    }

    @Override
    public Sport getSport() {
        return sport;
    }

    @Override
    public boolean enregistrerMoniteur(Moniteur moniteur) {
        return false;
    }

    @Override
    public boolean supprimerMoniteur() {
        return false;
    }

    @Override
    public Moniteur getMoniteur() {
        return moniteur;
    }

    @Override
    public boolean ajouterEnfant(Enfant enfant) {
        return false;
    }

    @Override
    public boolean supprimerEnfant(Enfant enfant) {
        return false;
    }

    @Override
    public boolean contientEnfant(Enfant enfant) {
        return false;
    }

    @Override
    public int nombreDEnfants() {
        return 0;
    }

    @Override
    public Set<Enfant> enfants() {
        return null;
    }
}
