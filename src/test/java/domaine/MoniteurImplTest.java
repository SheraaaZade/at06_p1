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

    @DisplayName("test 1, passer de etat 0 à 1")
    @Test
    void testMoniteur1(){
        stage = new StageStub( moniteur,2,sport);
        assertTrue(moniteur.ajouterStage(stage));
        assertTrue(moniteur.contientStage(stage));
        assertEquals(1, moniteur.nombreDeStages());
    }

    @DisplayName("test 2, passer de etat 1 à 2")
    @Test
    void testMoniteur2(){
        amenerAlEtat(1,moniteur);
        stage = new StageStub( moniteur,3,sport);
        assertTrue(moniteur.ajouterStage(stage));
        assertTrue(moniteur.contientStage(stage));
        assertEquals(2, moniteur.nombreDeStages());
    }

    @DisplayName("test 3, passer de etat 2 à 3")
    @Test
    void testMoniteur3(){
        stage = new StageStub( moniteur,4,sport);
        amenerAlEtat(2, moniteur);
        assertTrue(moniteur.ajouterStage(stage));
        assertTrue(moniteur.contientStage(stage));
        assertEquals(3, moniteur.nombreDeStages());
    }

    @DisplayName("test 4, passer de etat 3 à 4")
    @Test
    void testMoniteur4(){
        stage = new StageStub( moniteur,1,sport);
        amenerAlEtat(3, moniteur);
        assertTrue(moniteur.ajouterStage(stage));
        assertTrue(moniteur.contientStage(stage));
        assertEquals(4, moniteur.nombreDeStages());
    }

    @DisplayName("test 5, supprimer Stage1")
    @Test
    void testSupprimerStage1(){
        stage = new StageStub( moniteur,1,sport);
        amenerAlEtat(3,moniteur);
        moniteur.ajouterStage(stage); // passe à l'état 4
        assertTrue(moniteur.supprimerStage(stage));
        assertEquals(3,moniteur.nombreDeStages());
    }

    @DisplayName("test 6, supprimer Stage2")
    @Test
    void testSupprimerStage2(){
        stage = new StageStub( moniteur,1,sport);
        amenerAlEtat(2,moniteur);
        moniteur.ajouterStage(stage); // passe à l'état 3
        assertTrue(moniteur.supprimerStage(stage));
        assertEquals(2,moniteur.nombreDeStages());
    }

    @DisplayName("test 7, supprimer Stage3")
    @Test
    void testSupprimerStage3(){
        stage = new StageStub( moniteur,1,sport);
        amenerAlEtat(1,moniteur);
        moniteur.ajouterStage(stage); // passe à l'état 2
        assertTrue(moniteur.supprimerStage(stage));
        assertEquals(1,moniteur.nombreDeStages());
    }

    @DisplayName("test 8, supprimer Stage4")
    @Test
    void testSupprimerStage4(){
        stage = new StageStub( moniteur,1,sport);
        moniteur.ajouterStage(stage); // passe à l'état 1
        assertTrue(moniteur.supprimerStage(stage));
        assertEquals(0,moniteur.nombreDeStages());
    }

    @DisplayName("test 9, ajouter stage déjà présent")
    @Test
    void testAjouterStage1(){
        amenerAlEtat(4, moniteur);
        var mesStages = moniteur.stages();
        var stageDejaLa = mesStages.get(0);

        assertFalse(moniteur.ajouterStage(stageDejaLa));
        assertEquals(4,moniteur.nombreDeStages());
    }

    @DisplayName("test 10, ajouter stage, semaine déjà prise")
    @Test
    void testAjouterStage2(){
        amenerAlEtat(4, moniteur);
        var mesStages = moniteur.stages();
        var stageDejaLa = mesStages.get(0);
        int numSemaine = stageDejaLa.getNumeroDeSemaine();

        Stage stage = new StageStub(moniteur, numSemaine, sport);
        assertFalse(moniteur.ajouterStage(stage));
        assertEquals(4,moniteur.nombreDeStages());
    }

    @DisplayName("test 11, ajouter stage non présent")
    @Test
    void testSupprimerStage5(){
        amenerAlEtat(4, moniteur);
        Stage stage = new StageStub(moniteur, 7, sport);
        assertFalse(moniteur.supprimerStage(stage));
        assertEquals(4,moniteur.nombreDeStages());
    }

    private void amenerAlEtat(int etat, Moniteur moniteur){
        int cntSemaine = 1;
        for (int i = 0; i < etat; i++) {
            moniteur.ajouterStage(new StageStub(moniteur,++cntSemaine,sport));
        }
    }

}