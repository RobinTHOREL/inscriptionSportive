package mainInscription;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import inscriptions.*;
import utilitaires.ligneDeCommande.Action;
import utilitaires.ligneDeCommande.ActionListe;
import utilitaires.ligneDeCommande.Liste;
import utilitaires.ligneDeCommande.Menu;
import utilitaires.ligneDeCommande.Option;

public class menu {
	
	static Inscriptions inscription = Inscriptions.getInscriptions();
	static Menu menu = new Menu("Bienvenue");
	static Menu menuInscription = new Menu("Inscription");
	static Menu menuCompet = new Menu("Competiton");
	public static void listPers(){
		SortedSet<inscriptions.Candidat> candidats = inscription.getCandidats();
		List<String> personnes = new ArrayList<>();
		for (inscriptions.Candidat candidat	 : candidats)
			if(candidat instanceof Personne)
				personnes.add((String) candidat.getNom());
		ListePers(personnes);
	}
	public static void ListePers(final List<String> pers){
		Liste<String> menu = new Liste<String>("Liste des Personnes", 
				new ActionListe<String>()
		{
			// Retourne la liste des personnes formant le menu
			public List<String> getListe()
			{
				return pers;
			}
			// Exécutée automatiquement lorsqu'un élément de liste est sélectionné
		    public void elementSelectionne(int indice, String element)
		    {
			System.out.println("Vous avez sélectionné "+ element+ ", qui a l'indice " + indice);
			}

		});
		menu.start();
	}
	public static void listEquipe(){
		SortedSet<inscriptions.Candidat> candidats = inscription.getCandidats();
		List<String> equipes = new ArrayList<>();
		for (inscriptions.Candidat candidat	 : candidats)
			if(candidat instanceof Equipe)
				equipes.add((String) candidat.getNom());
		ListeEquipe(equipes);
	}
	public static void ListeEquipe(final List<String> team){
		Liste<String> menu = new Liste<String>("Liste des Equipes", 
				new ActionListe<String>()
		{
			// Retourne la liste des personnes formant le menu
			public List<String> getListe()
			{
				return team;
			}

			// Exécutée automatiquement lorsqu'un élément de liste est sélectionné
			public void elementSelectionne(int indice, String element)
			{
				System.out.println("Vous avez sélectionné "+ element+ ", qui a l'indice " + indice);
			}

		});
		menu.start();
	}
	public static void listCompet(){
		SortedSet<inscriptions.Competition> competitions = inscription.getCompetitions();
		List<String> Compet = new ArrayList<>();
		for (inscriptions.Competition competition	 : competitions)
				Compet.add((String) competition.getNom());
		ListePers(Compet);
	}
	public static void ListeCompet(final List<String> compet){
		Liste<String> menu = new Liste<String>("Liste des Competitions", 
				new ActionListe<String>()
		{
			// Retourne la liste des personnes formant le menu
			public List<String> getListe()
			{
				return compet;
			}
	// Exécutée automatiquement lorsqu'un élément de liste est sélectionné
		    public void elementSelectionne(int indice, String element)
		    {
			    System.out.println("Vous avez sélectionné "+ element+ ", qui a l'indice " + indice);
		    }

		});
		menu.start();
	}
	public static void getMenu(){
		Action inscri = new Action(){
			@Override
			public void optionSelectionnee() {
				getMenuInscription();
			}			
		};
		Option inscrit = new Option("Inscription", "1", inscri);
		Action compet = new Action(){
			@Override
			public void optionSelectionnee() {
				getMenuCompet();
				
			}
		};
		Option competi = new Option("Competition", "2", compet);
		
		menu.ajoute(inscrit);
		menu.ajoute(competi);
		menu.ajouteQuitter("3");
		menu.start();
	}
	public static void getMenuInscription(){
		Action ajoutPers = new Action(){
			@Override
			public void optionSelectionnee(){
			String nom = utilitaires.EntreesSorties.getString("Saisir nom : ");
			String prenom = utilitaires.EntreesSorties.getString("Saisir prenom : ");
			String mail = utilitaires.EntreesSorties.getString("Saisir mail : ");
			inscription.createPersonne(prenom, nom, mail);
			}
		};
		Option ajouPers= new Option("Ajouter Personne", "1", ajoutPers);
		menuInscription.ajoute(ajouPers);
		
        Action ajoutEquipe = new Action(){
        	@Override
        	public void optionSelectionnee(){
        		String nomEquipe = utilitaires.EntreesSorties.getString("Saisir nom Equipe : ");
        		inscription.createEquipe(nomEquipe);
        	}
        };
        Option ajouEquipe= new Option("Ajouter Equipe", "2", ajoutEquipe);
        menuInscription.ajoute(ajouEquipe);
        
        Action listePerso = new Action(){
			@Override
			public void optionSelectionnee() {
				listPers();
			}        	
        };
        Option ajoutListPers = new Option("Liste des Personnes", "3", listePerso);
        menuInscription.ajoute(ajoutListPers);
        
        Action listeEquipe = new Action(){
			@Override
			public void optionSelectionnee() {
				listEquipe();
			}        	
        };
        
        Option ajoutListEquipe = new Option("Liste des Equipes", "4", listeEquipe);
        menuInscription.ajoute(ajoutListEquipe);
        menuInscription.ajouteRevenir("5");
        menuInscription.start();
	}
	public static void getMenuCompet(){
		 Action ajoutCompet = new Action(){
				@Override
				public void optionSelectionnee() {
					String date = utilitaires.EntreesSorties.getString("Date de cloture (ex: 2011-12-03) : ");
					LocalDate dateCloture= LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);	
					String nomCompet = utilitaires.EntreesSorties.getString("Nom Competition : ");
					String equipe = utilitaires.EntreesSorties.getString(" Match en Equipe ? (O/N) ");
					boolean Equipe=false;
					if(equipe =="O" || equipe=="o")
						Equipe=true;
					else if(equipe =="N" || equipe=="n")
						Equipe=false;
					else
						System.out.println("Une erreur de saisi a eu lieu, par defaut le match n'est pas par Equipe.");
					inscription.createCompetition(nomCompet, dateCloture, Equipe);
				}
	        };
	        Option ajouCompet= new Option("Ajouter Competition", "1", ajoutCompet);
	        menuCompet.ajoute(ajouCompet);
	        
	        Action ajouListCompet = new Action(){
				@Override
				public void optionSelectionnee() {
					listCompet();
				}
	        	
	        };
	        Option ajoutListCompet = new Option("Liste des Competitions", "2", ajouListCompet);
	        menuCompet.ajoute(ajoutListCompet);
	        menuCompet.ajouteRevenir("3");
	        menuCompet.start();
	}


}
