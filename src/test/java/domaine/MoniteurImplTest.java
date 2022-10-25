package domaine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoniteurImplTest {
    Stage stage;
    Sport sport;
    Moniteur moniteur;

    public MoniteurImplTest(Stage stage, Sport sport, Moniteur moniteur) {
        this.stage = stage;
        this.sport = sport;
        this.moniteur = moniteur;
    }

    @BeforeEach
    void setUp() {
    }

    @Test
    void ajouterStage() {
        moniteur.ajouterStage(new StageStub(moniteur,22,sport));

       // assertTrue(stage, stage);
    }

    @Test
    void supprimerStage() {
    }

    @Test
    void TestMoniteurTC1(){

    }

}