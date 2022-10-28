package domaine;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MoniteurImplTest {
    Stage stage;
    Sport sport;
    Moniteur moniteur;

//    public MoniteurImplTest(Stage stage, Sport sport, Moniteur moniteur) {
//        this.stage = stage;
//        this.sport = sport;
//        this.moniteur = moniteur;
//    }

    @BeforeEach
    void setUp() {
        moniteur = new MoniteurImpl("John");
        sport = new SportStub(true);
    }

    @DisplayName("test de 1 à 4")
    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    void testMoniteur1a4(int numStage){
        amenerAlEtat(numStage-1, moniteur);
        stage = new StageStub( moniteur,numStage,sport);
        assertTrue(moniteur.ajouterStage(stage));
        assertEquals(numStage, moniteur.nombreDeStages());
        assertTrue(moniteur.contientStage(stage));
    }
//    @DisplayName("test 1")
//    @Test
//    void testMoniteur1(){
//        amenerAlEtat(numStage-1, moniteur);
//        stage = new StageStub( moniteur,numStage,sport);
//        assertTrue(moniteur.ajouterStage(stage));
//    }


    @Test
    void ajouterStage() {
        moniteur.ajouterStage(new StageStub(moniteur,22,sport));

       // assertTrue(stage, stage);
    }

    @Test
    void supprimerStage() {
    }

    private void amenerAlEtat(int etat, Moniteur moniteur){
        for (Stage stage : moniteur.stages()) {
            moniteur.supprimerStage(stage);
        }
        int cntSemaine = 1;
        for (int i = 0; i < etat; i++) {
            moniteur.ajouterStage(new StageStub(moniteur,cntSemaine,sport));
        }
    }

}