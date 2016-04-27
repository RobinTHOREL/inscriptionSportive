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
	static Menu menuPrincipal = new Menu("Bienvenue \nFaites votre choix\n--------------------\n");
	static Menu menuPersonne = new Menu("\nMenu des personnes et equipes\n--------------------\n");
	static Menu menuCompet = new Menu("\nMenu des competitons\n--------------------\n");
	
//Renvoie la liste des personnes
	public static List<Personne> GetPers()
	{
		SortedSet<inscriptions.Candidat> candidats = inscription.getCandidats();
		List<Personne> personnes = new ArrayList<>();
		for (inscriptions.Candidat candidat	 : candidats)
			if(candidat instanceof Personne)
				personnes.add((Personne) candidat);
		return personnes;
	}
	
//Renvoie la liste des équipes
	public static List<Equipe> GetEquipe()
	{
		SortedSet<inscriptions.Candidat> candidats = inscription.getCandidats();
		List<Equipe> equipes = new ArrayList<>();
		for (inscriptions.Candidat candidat	 : candidats)
			if(candidat instanceof Equipe)
				equipes.add((Equipe) candidat);
		return equipes;
	}
		
//Renvoie la liste des compétitions
	public static List<Competition> GetCompet()
	{
		SortedSet<inscriptions.Competition> competitions = inscription.getCompetitions();
		List<Competition> Compet = new ArrayList<>();
		for (inscriptions.Competition competition	 : competitions)
				Compet.add((Competition) competition);
		return Compet;
	}

//Menu principal
	public static void getMenuPrincipal(){
		
		Action inscri = new Action()
		{
			@Override
			public void optionSelectionnee()
			{
				getMenuInscription();
			}			
		};
		
		Option inscrit = new Option("Personnes et equipes", "1", inscri);
		
		Action compet = new Action()
		{
			@Override
			public void optionSelectionnee()
			{
				getMenuCompet();	
			}
		};
		
		Option competi = new Option("Competitions", "2", compet);
		
		menuPrincipal.ajoute(inscrit);
		menuPrincipal.ajoute(competi);
		menuPrincipal.ajouteQuitter("q");
		menuPrincipal.start();
	}
	
//Menu personnes et equipes
	public static void getMenuInscription(){
		
		Action ajoutPers = new Action()
		{
			@Override
			public void optionSelectionnee()
			{
				String nom = utilitaires.EntreesSorties.getString("Saisir le nom : ");
				String prenom = utilitaires.EntreesSorties.getString("Saisir le prenom : ");
				String mail = utilitaires.EntreesSorties.getString("Saisir l'adresse mail : ");
				Personne pers = inscription.createPersonne(nom, prenom, mail);
				System.out.println("Le nom est : " + nom + ", le prenom : " + prenom + ", l'adresse mail : " + mail );
				SortedSet<Candidat> candidats = inscription.getCandidats();
				List<Personne> personnes = new ArrayList<>();
				for (Candidat candidat : candidats)
					if (candidat instanceof Personne)
						personnes.add((Personne)candidat);
				personnes.add(pers);
			}
		};
		
		Option ajouPers= new Option("Ajouter une personne", "1", ajoutPers);
		menuPersonne.ajoute(ajouPers);
		
       Action ajoutEquipe = new Action()
        {
        	@Override
        	public void optionSelectionnee()
        	{
        		String nomEquipe = utilitaires.EntreesSorties.getString("Saisir le nom de l'equipe : ");
        		Equipe team = inscription.createEquipe(nomEquipe);
        		System.out.println("Le nom de l'equipe est : " + nomEquipe );
    			SortedSet<Candidat> candidats = inscription.getCandidats();
    			List<Equipe> equipe = new ArrayList<>();
    			for (Candidat candidat : candidats)
    				if (candidat instanceof Equipe)
    					equipe.add((Equipe)candidat);
    			equipe.add(team);
        	}
        };
        
        Option ajouEquipe= new Option("Ajouter une equipe", "2", ajoutEquipe);
        menuPersonne.ajoute(ajouEquipe);
        
    	menuPersonne.ajoute(new Option("Liste des personnes", "3", new Action()
    	{	
    		public void optionSelectionnee() 
    		{
	    		SortedSet<Candidat> candidats = inscription.getCandidats();
	    		List<Personne> personnes = new ArrayList<>();
	    		for (Candidat candidat : candidats)
	    			if (candidat instanceof Personne)
	    				personnes.add((Personne)candidat);
	    			
				System.out.println(personnes);	    		
	    	}   		
    	}));
        
    	menuPersonne.ajoute(new Option("Liste des equipes", "4", new Action()
    	{	
    		@Override
    		public void optionSelectionnee()
    		{
	    		SortedSet<inscriptions.Candidat> candidats = inscription.getCandidats();
	    		List<Equipe> team = new ArrayList<>();
	    		for (inscriptions.Candidat candidat : candidats)
	    			if(candidat instanceof Equipe)
	    				team.add((Equipe) candidat);

    			System.out.println(team);
    		
    	}	
    		
    	}));
        
        Liste<Personne> ModifierPersonne = new Liste<Personne>("Modifier une personne","5", new ActionListe<Personne>()
    	{																	
 			public List<Personne> getListe()
 			{
 				return GetPers();
 			}
    																													
    		@Override
    		public void elementSelectionne(int indice, Personne element) 
    		{
    			String nom = utilitaires.EntreesSorties.getString("Saisissez le nom : ");
    			element.setNom(nom);
	    		String prenom = utilitaires.EntreesSorties.getString("Saisissez le prenom : ");
	   			element.setPrenom(prenom);
				String mail = utilitaires.EntreesSorties.getString("Saisissez l'adresse mail : ");
				element.setMail(mail);
	   			System.out.println("Les nouvelles informations sont :\nNom : " + nom +"\nPrenom : "+prenom+"\nMail : "+mail );
    		}
    		
   			});
    	 
        menuPersonne.ajoute(ModifierPersonne);
        
		Liste<Equipe> modifEquipe = new Liste<Equipe>("Modifier une equipe","6", new ActionListe<Equipe>()
		{
			public List<Equipe> getListe()
			{
				return GetEquipe();
			}
																			
			@Override
			public void elementSelectionne(int indice, Equipe element)
			{
				String nomEquipe = utilitaires.EntreesSorties.getString("Saisir le nom de l'equipe : ");
				element.setNom(nomEquipe);
				System.out.println("Le nouveau nom d'equipe est " + nomEquipe);
				}
		});
		
		menuPersonne.ajoute(modifEquipe);
		
		
		Liste<Personne> SupprPersonne = new Liste<Personne>("Supprimer une personne","7", new ActionListe<Personne>()
		{			
			public List<Personne> getListe()
			{
				return GetPers();
			}
				
			@Override
			public void elementSelectionne(int indice, Personne element)
			{
				element.delete();
			}
		});
		menuPersonne.ajoute(SupprPersonne);
		
		
		Liste<Equipe> SupprEquipe = new Liste<Equipe>("Supprimer une equipe","8", new ActionListe<Equipe>()
		{
			public List<Equipe> getListe()
			{
				return GetEquipe();
			}
			
			@Override
			public void elementSelectionne(int indice, Equipe element) 
			{
				element.delete();	
			}
		});
		menuPersonne.ajoute(SupprEquipe);
        menuPersonne.ajouteRevenir("r");
        menuPersonne.start();
	}

//Menu competitions
	public static void getMenuCompet()
	{
		 Action ajoutCompet = new Action()
		 {
			@Override
			public void optionSelectionnee() 
			{
				boolean enEquipe=false;
				String Statut = "competition en solo";
				String date = utilitaires.EntreesSorties.getString("Date de cloture (ex: 2011-12-03) : ");
				LocalDate dateCloture= LocalDate.parse(date, DateTimeFormatter.ISO_LOCAL_DATE);	
				String nomCompet = utilitaires.EntreesSorties.getString("Nom de la competition : ");
				String equipe = utilitaires.EntreesSorties.getString("Match en Equipe ? (O/N)");
					if(equipe == "O")
					{
						enEquipe=true;
						Statut = "competition en equipe";
					}
						
				Competition compet = inscription.createCompetition(nomCompet, dateCloture, enEquipe);		
				System.out.println("Le nom de la competition est : " + nomCompet + ", la date de cloture sera le : " + dateCloture + " \nIl s\'agit d'une " + Statut);
				List<Competition> comp = new ArrayList<>();
				comp.add(compet);		
			}
	      };
	      
	        Option ajouCompet= new Option("Ajouter une competition", "1", ajoutCompet);
	        menuCompet.ajoute(ajouCompet);
	        
	    	menuCompet.ajoute(new Option("Liste des competitions", "2", new Action()
	    	{

	    		@Override
	    		public void optionSelectionnee() {
	    			SortedSet<inscriptions.Competition> compet = inscription.getCompetitions();
	    			List<Competition> listCompet = new ArrayList<>();
	    			for (inscriptions.Competition competition : compet)
	    				if(competition instanceof Competition)
	    					listCompet.add((Competition) competition);
	    			for(int i = 0; i <= listCompet.size()-1; i++)
	    				{
	    				System.out.print("Le nom de la competition est : ");
	    				System.out.print(listCompet.get(i).getNom());
	    				System.out.println(", la date de cloture sera le : ");
	    				if(listCompet.get(i).getDateCloture() == null)
	    				System.out.println("Aucune date de cloture n'a ete prevu");
	    				else
	    				System.out.println(listCompet.get(i).getDateCloture());		
	    				}
	    		}
	    	}));	
	        
			Liste<Competition> ModifDateCloture = new Liste<Competition>("Modifier une competition","3", new ActionListe<Competition>()
			{
				public List<Competition> getListe()
				{
					return GetCompet();
				}
																					
				@Override
				public void elementSelectionne(int indice, Competition element) 
				{
					String dateCloture = utilitaires.EntreesSorties.getString("Saisissez la nouvelle date de cloture (ex: 2011-12-03) : ");
					LocalDate Cloture = LocalDate.parse(dateCloture);
					element.setDateCloture(Cloture);
					System.out.println("La nouvelle date de cloture est : " + Cloture );
				}
			});
			
			menuCompet.ajoute(ModifDateCloture);
			
			Liste<Competition> Competition = new Liste<Competition>("Supprimer une competition","4", new ActionListe<Competition>()
			{
				
				public List<Competition> getListe()
				{
					return GetCompet();
				}

				@Override
				public void elementSelectionne(int indice, Competition element) 
				{
					element.delete();
				}
			});
			
			menuCompet.ajoute(Competition);
	        menuCompet.ajouteRevenir("r");
	        menuCompet.start();
	}


}
