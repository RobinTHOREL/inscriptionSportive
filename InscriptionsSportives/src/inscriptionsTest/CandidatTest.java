package inscriptionsTest;

import static org.junit.Assert.*;

import org.junit.Test;
import inscriptions.*;

import java.time.LocalDate;
import java.util.Set;

public class CandidatTest {
	Inscriptions inscriptionTest = Inscriptions.getInscriptions();
	Equipe equipeTest = inscriptionTest.createEquipe("L'EQUIPE TEST");
	Personne personneTest = inscriptionTest.createPersonne("TEST", "test","tTEST@gmail.com");
	Competition competitionSoloTest = inscriptionTest.createCompetition("CompetSoloTest", null, false);
	
	
	@Test
	public void testGetNom() {
		assertTrue(equipeTest.getNom() == "L'EQUIPE TEST" && personneTest.getNom() == "TEST");
	}

	@Test
	public void testSetNom() {
		equipeTest.setNom("");
		personneTest.setNom("");
		assertTrue(equipeTest.getNom() == "" && personneTest.getNom() == "");
	}

	@Test
	public void testGetCompetitions() {
		competitionSoloTest.add(personneTest);
		Set<Competition>setCompetitionTest = personneTest.getCompetitions();
		assertTrue(setCompetitionTest.contains(competitionSoloTest));
	}

	@Test
	public void testAdd() {
		competitionSoloTest.add(personneTest);
		Set<Candidat>setCandidatTest = competitionSoloTest.getCandidats();
		assertTrue(setCandidatTest.contains(personneTest));
	}

	@Test
	public void testRemove() {
		competitionSoloTest.add(personneTest);
		Set<Candidat>setCandidatTest = competitionSoloTest.getCandidats();
		competitionSoloTest.remove(personneTest);
		assertFalse(setCandidatTest.contains(personneTest));
	}

	@Test
	public void testDelete() {
		Set<Candidat>setCandidatTest = inscriptionTest.getCandidats();
		personneTest.delete();
		assertFalse(setCandidatTest.contains(personneTest));
	}

	@Test
	public void testCompareTo() {
		Personne personneTest2 = inscriptionTest.createPersonne("TEST", "","TEST@gmail.com");
		assertTrue(personneTest.compareTo(personneTest2) == 0);
	}

	@Test
	public void testToString() {
		Competition competitionEquipeTest = inscriptionTest.createCompetition("CompetSoloTest", null, true);
		equipeTest.add(personneTest);
		competitionSoloTest.add(personneTest);
		competitionEquipeTest.add(equipeTest);
		System.out.println(personneTest.toString());
		fail("Not yet implemented");
	}

}