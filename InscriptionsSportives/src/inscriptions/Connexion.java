package inscriptions;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;

public class Connexion {

	private static Connection connexion = null;
	private static Statement statement;
	private boolean interrupteur = true;
	
	public boolean getInterrupteur()
    {
          return this.interrupteur;
    }
     
	
	public Connexion()
	{
		try
		{
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/inscriptionssportives", "root","");
			//Connection connexion = DriverManager.getConnection("jdbc:mysql://mysql.m2l.local/dmerigou", "dmerigou","GP2dC3US");
			this.connexion = connexion;

			

			System.out.println("Connexion etablie");


		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
		
	}
		
	public static HashMap<String, Integer>  AfficherLesCandidats()
	{
		HashMap<String, Integer> maliste = new LinkedHashMap<String, Integer>();
		//utilisation d'une hashMap car elle est tri par ordre d'insertion dans la bdd
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "select * from candidat,equipe where id_equipe = id_cand" );
			
			
	       while (resultat.next()) 
	       {
	    	   String Nom = resultat.getString("cand_nom");
	        	int idCandidat = resultat.getInt("id_cand");
		       
		        maliste.put(Nom, idCandidat);
		        System.out.println( "bonjour test !");
	       }     
		}
		catch(Exception e)
		{
			 System.out.println( "Erreur lors de l'affichage de la liste des candidats : "
		                + e.getMessage() );
		}
		return maliste;
	}
	
	
	public static HashMap<String, Integer> AfficherCompetitions()
	{
		HashMap<String, Integer> malisteCompet = new LinkedHashMap<String, Integer>();
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			Competition compet;
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "select * from competition" );
        
	        while (resultat.next()) 
	        {
	        	int idCompet = resultat.getInt("id_compet");
	        	String Nom = resultat.getString("compet_nom");
	        	malisteCompet.put(Nom, idCompet);
	        	

	        } 

	        	
	    }
		catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		}
		return malisteCompet; 
	}
	
	public static HashMap<Integer, String> AfficherCompetitionsID()
	{
		HashMap<Integer, String> malisteCompetID = new LinkedHashMap<Integer, String>();
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			Competition compet;
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "select * from competition" );
        
	        while ( resultat.next() ) 
	        {
	        	int idCompet = resultat.getInt("id_compet");
	        	String Nom = resultat.getString("compet_nom");
	        	malisteCompetID.put(idCompet, Nom);
	        	

	        } 

	        	
	    }
		catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		}
		return malisteCompetID; 
	}
	
	public static HashMap<String, Integer> AfficherCompetitionsDate()
	{
		HashMap<String, Integer> malisteCompetDate = new LinkedHashMap<String, Integer>();
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			Competition compet;
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "select * from competition" );
        
	        while ( resultat.next() ) 
	        {
	        	int idCompet = resultat.getInt("id_compet");
	        	java.sql.Date Nom = resultat.getDate("compet_dateCloture");
	        	SimpleDateFormat formatDateJour = new SimpleDateFormat("dd/MM/yyyy"); 
	        	String dateFormatee = formatDateJour.format(Nom);
	        	malisteCompetDate.put(dateFormatee, idCompet);
	        	

	        } 

	        	
	    }
		catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		}
		return malisteCompetDate; 
	}
	
	
	
	public static HashMap<String, Integer> AfficherPersonnes()
	{
		HashMap<String, Integer> malistePers = new LinkedHashMap<String, Integer>();
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "select * from candidat,personne where id_cand = id_personne" );
	        
	        while ( resultat.next())
	        {
	        			String Nom = resultat.getString("cand_nom");
			        	int idPers = resultat.getInt("id_cand");
			        	malistePers.put(Nom, idPers);
			        	
	        }
	        
		}
	    catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		}
		return malistePers;
		
		
		
	    
	}
	
	public static HashMap<Integer, String> AfficherPersonnesEquipe()
	{
		HashMap<Integer, String> malistePersEquipe = new LinkedHashMap<Integer, String>();
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "SELECT * from equipe,personne,personne_has_equipe where id_personne = Personne_id_personne and Equipe_id_equipe = id_equipe" );
	        
	        while ( resultat.next())
	        {
	        			String Nom = resultat.getString("pers_prenom");
			        	int idPersEquipe = resultat.getInt("Equipe_id_equipe");
			        	malistePersEquipe.put(idPersEquipe, Nom);
			        	
	        }
	        
		}
	    catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		}
		return malistePersEquipe;
		
		
		
	    
	}
	
	public static HashMap<Integer, String> AfficherPersonnesHasEquipeID()
	{
		HashMap<Integer, String> malistePersEquipe = new LinkedHashMap<Integer, String>();
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "SELECT * from equipe,personne,personne_has_equipe where id_personne = Personne_id_personne and Equipe_id_equipe = id_equipe" );
	        
	        while ( resultat.next())
	        {
	        			String Nom = resultat.getString("pers_prenom");
			        	int idPersEquipe = resultat.getInt("Personne_id_Personne");
			        	malistePersEquipe.put(idPersEquipe, Nom);
			        	
	        }
	        
		}
	    catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		}
		return malistePersEquipe;
		
		
		
	    
	}
	
	public static HashMap<Integer, String> AfficherPersonnesCompet()
	{
		HashMap<Integer, String> malistePersCompet = new LinkedHashMap<Integer, String>();
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "SELECT * from candidat,candidat_has_competition,competition, personne where Candidat_id_candidat = id_cand and Competition_id_compet = id_compet and id_cand = id_personne" );
	        
	        while ( resultat.next())
	        {
	        			String Nom = resultat.getString("cand_nom");
			        	int idPersCompet = resultat.getInt("Competition_id_compet");
			        	malistePersCompet.put(idPersCompet, Nom);
			        	
	        }
	        
		}
	    catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		}
		return malistePersCompet;
		
		
		
	    
	}

	public static HashMap<Integer, String> AfficherPersonnesCompetID()
	{
		HashMap<Integer, String> malistePersCompetID = new LinkedHashMap<Integer, String>();
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "SELECT * from candidat,candidat_has_competition,competition, personne where Candidat_id_candidat = id_cand and Competition_id_compet = id_compet and id_cand = id_personne" );
	        
	        while ( resultat.next())
	        {
	        			String Nom = resultat.getString("cand_nom");
			        	int idPersCompetID = resultat.getInt("Candidat_id_Candidat");
			        	malistePersCompetID.put(idPersCompetID, Nom);
			        	
	        }
	        
		}
	    catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		}
		return malistePersCompetID;
		
		
		
	    
	}
	
	public static HashMap<Integer, String> AfficherEquipeCompetID()
	{
		HashMap<Integer, String> malistePersCompetID = new LinkedHashMap<Integer, String>();
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "SELECT * from candidat,candidat_has_competition,competition, equipe where Candidat_id_candidat = id_cand and Competition_id_compet = id_compet and id_cand = id_equipe" );
	        
	        while ( resultat.next())
	        {
	        			String Nom = resultat.getString("cand_nom");
			        	int idPersCompetID = resultat.getInt("Candidat_id_Candidat");
			        	malistePersCompetID.put(idPersCompetID, Nom);
			        	
	        }
	        
		}
	    catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		}
		return malistePersCompetID;
		
		
		
	    
	}
	
	public static HashMap<Integer, String> AfficherPersonnesPersonneID()
	{
		HashMap<Integer, String> malistePersCompet = new LinkedHashMap<Integer, String>();
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "SELECT * from candidat,candidat_has_competition,competition, equipe where Candidat_id_candidat = id_cand and Competition_id_compet = id_compet and id_cand = id_equipe" );
	        
	        while ( resultat.next())
	        {
	        			String Nom = resultat.getString("cand_nom");
			        	int idPersCompet = resultat.getInt("Competition_id_compet");
			        	malistePersCompet.put(idPersCompet, Nom);
			        	
	        }
	        
		}
	    catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		}
		return malistePersCompet;
		
		
		
	    
	}

	public static HashMap<Integer, String> AfficherPersonnesID()
	{
		HashMap<Integer, String> malistePersID = new LinkedHashMap<Integer, String>();
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "select * from candidat,personne where id_cand = id_personne order by id_cand" );
	        
	        while ( resultat.next())
	        {
	        			String Nom = resultat.getString("cand_nom");
			        	int idPers = resultat.getInt("id_cand");
			        	malistePersID.put(idPers, Nom);
			        	
	        }
	        
		}
	    catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		}
		return malistePersID;
		
	}
		
		public static HashMap<String, Integer> AfficherPersonnesPrenom()
		{
			HashMap<String, Integer> malistePersPrenom = new LinkedHashMap<String, Integer>();
			try
			{
				Statement statement = null;
				ResultSet resultat = null;
				
				statement = connexion.createStatement();
				resultat = statement.executeQuery( "select * from candidat,personne where id_cand = id_personne" );
		        
		        while ( resultat.next())
		        {
		        			String Prenom = resultat.getString("pers_prenom");
				        	int idPers = resultat.getInt("id_cand");
				        	malistePersPrenom.put(Prenom, idPers);
				        	
		        }
		        
			}
		    catch(Exception e)
			{
				 System.out.println( "Erreur lors de la connexion : "
			                + e.getMessage() );
			}
			return malistePersPrenom;
			
		
	    
	}
		public static HashMap<String, Integer> AfficherPersonnesMail()
		{
			HashMap<String, Integer> malistePersMail = new LinkedHashMap<String, Integer>();
			try
			{
				Statement statement = null;
				ResultSet resultat = null;
				
				statement = connexion.createStatement();
				resultat = statement.executeQuery( "select * from candidat,personne where id_cand = id_personne" );
		        
		        while ( resultat.next())
		        {
		        			String Prenom = resultat.getString("pers_mail");
				        	int idPers = resultat.getInt("id_cand");
				        	malistePersMail.put(Prenom, idPers);
				        	
		        }
		        
			}
		    catch(Exception e)
			{
				 System.out.println( "Erreur lors de la connexion : "
			                + e.getMessage() );
			}
			return malistePersMail;
			
		
	    
	}
	public static HashMap<String, Integer> AfficherLesEquipes()
	{
		HashMap<String, Integer> maliste = new LinkedHashMap<String, Integer>();
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "SELECT cand_nom, id_equipe FROM Candidat C, Equipe E WHERE E.id_equipe = C.id_Cand" );
	       
	        
	        while ( resultat.next())
	        {
	        	int idEquipe = resultat.getInt("id_equipe");
	        	String Nom = resultat.getString("cand_nom");

	        	 maliste.put(Nom, idEquipe);
	        	


	        }
		}
	    catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		}
		
		return maliste; 
	    //a
	}
	public static HashMap<Integer, String> AfficherLesEquipesID()
	{
		HashMap<Integer, String> malisteEquipeID = new LinkedHashMap<Integer, String>();
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "SELECT cand_nom, id_equipe FROM Candidat C, Equipe E WHERE E.id_equipe = C.id_Cand" );
	       
	        
	        while ( resultat.next())
	        {
	        	int idEquipe = resultat.getInt("id_equipe");
	        	String Nom = resultat.getString("cand_nom");

	        	malisteEquipeID.put(idEquipe, Nom);
	        	


	        }
		}
	    catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		}
		
		return malisteEquipeID; 
	    
	}
	
	public static void ajouterCandidat(String nom)
	{
		try
		{
			Statement statement = null ;
			
			statement = connexion.createStatement();
			int ajoutCand = statement.executeUpdate( "INSERT INTO `candidat`(`cand_nom`) VALUES ('"+nom+"') ");
			if(ajoutCand == 1)
			{
				System.out.println( "ajout candidat rï¿½ussi..");
			}
			else
			{
				System.out.println( "ajout candidat echoue");
			}
		
		}
		catch(Exception e)
		{
			 System.out.println( "Erreur ajout candidat : "
		                + e.getMessage() );
		} 
	}
	/*>>>>>>> branch 'master' of https://github.com/David95330/Projet_Java.git*/
	/*public static void AjouterPersonne(String Nom,String Mail)*/
	public static void AjouterPersonne(String nom, String prenom, String mail)
	{
		/*ajouterCandidat(nom);*/
		
		try
		{
			ajouterCandidat(nom);
			Statement statement = null ;
			statement = connexion.createStatement();
			int ajoutPers = statement.executeUpdate( "INSERT INTO `personne`(`id_personne`, `pers_prenom`, `pers_mail`) VALUES (LAST_INSERT_ID(),'"+prenom+"' ,'"+mail+"')");
			if ( ajoutPers == 1) {
	        	
	        	
	        	System.out.println("Ajout d'une personne" );
	        }
	        else{
	        	System.out.println("Echec de l'ajout d'une personne");
	        }
		}
		catch(Exception e)
		{
			 System.out.println( "Erreur ajout personne : "
		                + e.getMessage());
		} 
		
	}
	
	
	public static void AjouterEquipe(String Nom)
	{
		try
		{
			ajouterCandidat(Nom);
			
			Statement statement = null ;
			
			statement = connexion.createStatement();
			
			int ajoutEquipe = statement.executeUpdate( "INSERT INTO equipe (id_equipe) VALUES (LAST_INSERT_ID())");
	        if ( ajoutEquipe == 1) {
	        	
	        	
	        	System.out.println("Ajout d'une equipe" );
	        }
	        else{
	        	System.out.println("Echec de l'ajout d'une equipe");
	        }
		}
		catch(Exception e)
		{
			 System.out.println( "Erreur de conection : "
		                + e.getMessage() );
		} 
		
	}

	
	public void AjouterCompetition(String NomCompet,java.util.Date dateCompet,boolean enEquipe)
	{
		try
		{
			Statement statement = null ;
			
			

			statement = connexion.createStatement();
			int ajoutCompet = statement.executeUpdate( "INSERT INTO competition (compet_nom,compet_dateCloture,compet_enEquipe) VALUES ('"+NomCompet+"','"+dateCompet+"',"+enEquipe+")");
			
	        if ( ajoutCompet == 1) {
	        	
	        	
	        	System.out.println("Ajout d'une competition" );
	        }
	        else{
	        	System.out.println("Echec de l'ajout de la competition");
	        }
		}
		catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
		
	}
	public static void modifierNomPersonne(String ancienNom, String nouveauNom)
	{
		try
		{
			Statement statement = null;
			
			statement = connexion.createStatement();
			 
			 
		        	int ModifCand = statement.executeUpdate( "UPDATE candidat SET cand_nom = '"+ nouveauNom +"' WHERE cand_nom='"+ ancienNom +"'" );
		        	if(ModifCand == 1)
		        	{
		        		System.out.println("Modification du candidat" );
		        	}	
		        
		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	
	public static void modifierPrenomPersonne(String ancienPrenom, String nouveauPrenom)
	{
		try
		{
			Statement statement = null;
			/* int ModifDate = statement.executeUpdate( "UPDATE personne SET idPers = "+ date +" WHERE idCompet = "+ idCompet +"" );*/
			statement = connexion.createStatement();
			 
			 int ModifPers = statement.executeUpdate("UPDATE personne SET pers_prenom = '"+ nouveauPrenom +"' WHERE pers_prenom = '"+ ancienPrenom +"'");
			 
		        if(ModifPers == 1)
		        {
		        	System.out.println("La modification a bien ete prise en compte" );
		        }
		        else{
		        	System.out.println("La modification n'a PAS bien ete prise en compte" );
		        }
		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	
	public static void modifierMailPersonne(String ancienMail, String nouveauMail)
	{
		try
		{
			Statement statement = null;
			
			statement = connexion.createStatement();
			 
			 int ModifPers = statement.executeUpdate("UPDATE personne SET pers_mail = '"+ nouveauMail +"' WHERE pers_mail = '"+ ancienMail +"'");
			 
		        if(ModifPers == 1)
		        {
		        	
		        		System.out.println("La personne a ete modifiée" );
		        	
		        }
		        else{
		        	System.out.println("Echec de la modification de la personne" );
		        }
		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	//MODIFIER NOM D'UNE COMPETITION v1
	public static void modifierNomCompet(String ancienNom, String nouveauNom)
	{
		try
		{
			Statement statement = null;
			
			statement = connexion.createStatement();
			 
			 
		        	int ModifCand = statement.executeUpdate( "UPDATE competition SET compet_nom = '"+ nouveauNom +"' WHERE compet_nom='"+ ancienNom +"'" );
		        	if(ModifCand == 1)
		        	{
		        		System.out.println("La modification du nom de la competition a ï¿½tï¿½ prise en compte" );
		        	}	
		        
		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	
	//MODIFIER NOM D'UNE EQUIPE v1
	public static void modifierNomEquipe(String ancienNom, String nouveauNom)
	{
		try
		{
			Statement statement = null;
			
			statement = connexion.createStatement();
			 
			 
		    int ModifCand = statement.executeUpdate( "UPDATE candidat SET cand_nom = '"+ nouveauNom +"' WHERE cand_nom='"+ ancienNom +"'" );
		    if(ModifCand == 1)
		    {
		        System.out.println("La modification du nom de l'ï¿½quipe a ï¿½tï¿½ prise en compte" );
		    }	
		        
		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	
	public void MofidierDateCloture(Date date, int idCompet)
	{
		try
		{
			 Statement statement = null;
			 statement = connexion.createStatement();
			 int ModifDate = statement.executeUpdate( "UPDATE competition SET compet_dateCloture = "+ date +" WHERE id_compet = "+ idCompet +"" );
		        System.out.println( "Requï¿½te d'affichage des candidats effectuee!" );
		        
		        if(ModifDate == 1){
		        	System.out.println("La modification competition a bien ete prise en compte" );
		        }
		        else{
		        	System.out.println("La modification competition n'a pas bien ete prise en compte" );
		        }
		}
		catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	
	public static int recupID(String Nom)
	{
		int id = 0;
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "SELECT id_cand,cand_nom FROM candidat WHERE cand_nom = '"+Nom+"'");
												
	        while ( resultat.next())
	        {
	        	id = resultat.getInt("id_cand");
	        	System.out.println(id);
	        }
			
		}
		catch(Exception e)
		{	
				 System.out.println( "Erreur lors de la recuperation de l'id : "
			                + e.getMessage() );
		}
		return id; 
		
	}
	
	public static int recupIDCompet(String Nom)
	{
		int id = 0;
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "SELECT id_compet,compet_nom FROM competition WHERE compet_nom = '"+Nom+"'");
												
	        while ( resultat.next())
	        {
	        	id = resultat.getInt("id_compet");
	        	System.out.println(id);
	        }
			
		}
		catch(Exception e)
		{	
				 System.out.println( "Erreur lors de la recuperation de l'id : "
			                + e.getMessage() );
		}
		return id; 
		
	}
	
	
	
	public static void SupprimerCandidat(String nomCand)
	{
		
		try
		{
			int id = recupID(nomCand);
			statement = connexion.createStatement();
			
			int SupprCandidat = statement.executeUpdate( "DELETE FROM candidat WHERE id_cand = "+id+"" );
			int SupprCandidatInscr = statement.executeUpdate( "DELETE FROM `candidat_has_competition` WHERE `Candidat_id_candidat`= "+id+"");
			
			if(verifCand(id) == 1)
			{
				int supprEquipe = statement.executeUpdate("DELETE FROM equipe WHERE id_equipe = "+ id +"");
				if(supprEquipe == 1)
				{
					System.out.println("L'equipe a bien ï¿½tï¿½ supprimee" );
				}
				else
				{
		        	System.out.println("La suppression de l'equipe n'a PAS  ete prise en compte" );
		        }
			}
			else
			{
				int supprPers = statement.executeUpdate("DELETE FROM personne WHERE id_personne ="+id+"");
				if(supprPers == 1)
				{
					System.out.println("La personne a bien ete supprimee" );
				}
				else
				{
		        	System.out.println("La suppression de la personne n'a PAS  ete prise en compte" );
		        }
			}
			
		}
		catch(Exception e)
		{	
				 System.out.println( "Erreur lors de la connexion : "
			                + e.getMessage() );
		} 
	}	
	
	public static void InscriptionCandidatCompetition(int idCand, int idCompet)
	{
		try
		{
			statement = connexion.createStatement();
			ResultSet verifCandCompet = null;
			verifCandCompet = statement.executeQuery("SELECT Candidat_id_candidat,Competition_id_compet FROM candidat_has_competition WHERE Candidat_id_candidat ="+idCand+" AND Competition_id_compet ="+idCompet+"");
			if(verifCandCompet.next())
			{
				 ResultSet VerifNomCompet = null;
				 VerifNomCompet = statement.executeQuery( "SELECT compet_nom FROM competition C, candidat_has_competition CC WHERE C.id_compet = CC.Competition_id_compet AND id_compet ="+idCompet+"" );
				 while(VerifNomCompet.next())
			     {
					 
					 System.out.println("le candidat nï¿½"+idCand+" est deja inscrit a la competition nï¿½"+idCompet+" - "+ VerifNomCompet.getString("compet_nom") );
			     }

			}
			else
			{
				int cand = verifCand(idCand);
				if(cand == 1)
				{
					ResultSet verifEnEquipe = null;
					verifEnEquipe = statement.executeQuery("SELECT * FROM competition WHERE compet_enEquipe = 1 AND id_compet = "+idCompet+"");
					if(verifEnEquipe.next())
					{
						int insertCandCompet = statement.executeUpdate( "INSERT INTO candidat_has_competition (Candidat_id_candidat,Competition_id_compet) VALUES ("+idCand+","+idCompet+")");
						if(insertCandCompet == 1)
						{
							System.out.println("Vous vous etes bien inscrit pour participer a la competition nï¿½"+idCompet+"");
						}
						else
						{
				        	System.out.println("L'inscription n'a pas ete prise en compte" );
				        }
					}
					else
					{
						System.out.println("Vous ne pouvez pas vous inscrire car cette competition se dï¿½roule en individuelle");
					}
				}
				else
				{

					ResultSet verifEnEquipe = null;
					verifEnEquipe = statement.executeQuery("SELECT * FROM competition WHERE compet_enEquipe = 0 AND id_compet = "+idCompet+"");
					if(verifEnEquipe.next())
					{
						int insertCandCompet = statement.executeUpdate( "INSERT INTO candidat_has_competition (Candidat_id_candidat,Competition_id_compet) VALUES ("+idCand+","+idCompet+")");
						if(insertCandCompet == 1)
						{
							System.out.println("Vous vous etes bien inscrit pour participer a la competition nï¿½"+idCompet+"");
						}
						else
						{
				        	System.out.println("L'inscription n'a pas ete prise en compte" );
				        }
					
					}
					else
					{
						System.out.println("Vous ne pouvez pas vous inscrire car cette competition se joue en equipe");
					}
				}
				
			}
			
			
		}
		catch(Exception e)
		{	
				 System.out.println( "Erreur lors de la connexion : "
			                + e.getMessage());
		} 
	}
	
	public static void inscriptionPersonneDansEquipe(int idPers, int idEquipe)
	{
		try
		{
			statement = connexion.createStatement();
			ResultSet verifPersEquipe = null;
			verifPersEquipe = statement.executeQuery("SELECT Personne_id_personne, Equipe_id_equipe FROM personne_has_equipe WHERE Personne_id_personne ="+idPers+" AND Equipe_id_equipe ="+idEquipe+"");
			if(verifPersEquipe.next())
			{
				System.out.println("Vous etes deja inscrit dans l'equipe n "+idEquipe+"");
			}
			else
			{
				ResultSet verifPers = null;
				verifPers = statement.executeQuery("SELECT id_personne, pers_prenom FROM personne WHERE id_personne = "+idPers+"");
				if(verifPers.next())
				{
					int insertPersEquipe = statement.executeUpdate( "INSERT INTO personne_has_equipe (Personne_id_personne,Equipe_id_equipe) VALUES ("+idPers+","+idEquipe+")");
						
					if(insertPersEquipe == 1)
					{
						System.out.println("Vous vous ï¿½tes bien inscrit dans l'equipe nï¿½"+idEquipe+"");
					}
					else
					{
				        System.out.println("L'inscription n'a pas ete prise en compte" );
				    }
				}
				else
				{
					System.out.println("Il faut d'abord vous inscrire en tant que personne pour vous inscrire dans une equipe");
				}
			}
			
		}
		catch(Exception e)
		{	
				 System.out.println( "Erreur lors de la connexion : "
			                + e.getMessage());
		} 
	}
	
	public static int verifCand(int idCand)
	{
		int result = 0;
		try
		{
			
			
			ResultSet verifPers = null;
			statement = connexion.createStatement();
			
			
			verifPers = statement.executeQuery( "SELECT * FROM equipe" );
			  while( verifPers.next())
		        {
				  if(idCand == verifPers.getInt("id_equipe"))
				  {
					  result = 1; //si le candidat est une equipe
				  }
				  
		        }
			
		}
		catch(Exception e)
		{	
				 System.out.println( "Erreur lors de la connexion : "
			                + e.getMessage() );
		} 
		return result;
	}
	
	
	
	public static HashMap<String, Integer> MajListeEquipe()
	{
		HashMap<String, Integer> maliste = new LinkedHashMap<String, Integer>();
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "SELECT cand_nom, id_equipe FROM Candidat C, Equipe E WHERE E.id_equipe = C.id_Cand" );
	        
	        while ( resultat.next())
	        {
	        	int idEquipe = resultat.getInt("id_equipe");
	        	String Nom = resultat.getString("cand_nom");

	        	 maliste.put(Nom, idEquipe);
	        	System.out.println("Equipe nï¿½"+ idEquipe + " - " + Nom);


	        }
		}
	    catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		}
		return maliste; 
	    
	

	}


	
	



	public static void SupprimerCompetition(String NomCompet)
	{
		
		try
		{
				int id = recupIDCompet(NomCompet);
				statement = connexion.createStatement();

				int SupprCompet = statement.executeUpdate( "DELETE FROM competition WHERE id_compet = "+ id  +"" );

		        if(SupprCompet == 1){
		        	System.out.println("La suppression a bien ete prise en compte" );
		        }
		        else{
		        	System.out.println("La suppression n'a PAS ï¿½tï¿½ prise en compte" );
		        }
		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	
	public static void SupprimerPersonne(String nomCand)
	{
		try
		{
			int id = recupID(nomCand);
			statement = connexion.createStatement();
			System.out.println(id);
			 int SupprPers = statement.executeUpdate("DELETE FROM personne WHERE id_personne = "+ id +"");
			 
		        if(SupprPers == 1)
		        {
		        	System.out.println("1ere etape de suppression" );
		        	int SupprCand = statement.executeUpdate( "DELETE FROM candidat WHERE id_cand = "+ id +"" );
		        	if(SupprCand == 1)
		        	{
		        		System.out.println("La suppression de l'equipe a bien ete prise en compte" );
		        	}	
		        }
		        else{
		        	System.out.println("La suppression n'a PAS ete prise en compte" );
		        }
		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	
	
	public static void main(String[] args) 
	{

		/*Connexion connect = new Connexion();
		connect.ajouterCandidat("garnier");*/
		
	}


	
}