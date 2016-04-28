package inscriptions;

import java.sql.*;

public class Connexion {
	/*j'ai bien push !
	faire tests interrupteur true/false dans la couch metier directement dans la fonction DELETE du prof*/
	private Connection connexion = null;
	private Statement statement;
	private boolean interrupteur = true;
	
	public boolean getInterrupteur()
    {
          return this.interrupteur;
    }
     
	
	public Connexion()
	{
		try
		{
			Connection connexion = DriverManager.getConnection("jdbc:mysql://localhost/inscription1", "root","");
			this.connexion = connexion;
			System.out.println("salut c'est cool !");
		}
		catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
		
	}
	public int RecupId(String nom, String mail)
	{
		int idPers = 0;
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "select idPers from personne WHERE nom = "+ nom +"AND mail = "+ mail);
	        
	        
	        while ( resultat.next())
	        {
	        	idPers = resultat.getInt("idPers");
	        	
	        }
	        
		}
	    catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		}
		return idPers;
	}
	
	public void AfficherLesCandidats()
	{
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "select * from candidat" );
        
	        while ( resultat.next() ) 
	        {
	        	int idCandidat = resultat.getInt("idCandidat");
	        	String Nom = resultat.getString("Nom");
	        	System.out.println(idCandidat + "---" + Nom + "---");
	        }
		}
		catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	public void AfficherCompetitions()
	{
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "select * from competition" );
        
	        while ( resultat.next() ) 
	        {
	        	int idCompet = resultat.getInt("idCompet");
	        	String Nom = resultat.getString("Nom");
	        	String date = resultat.getString("date_cloture");
	        	System.out.println(idCompet + "---" + Nom + "---"+ date + "---");
	        }
		}
		catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	
	
	public void AfficherPersonnes()
	{
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "select * from personne" );
	        System.out.println( "____Requête d'affichage des personnes effectuée!____" );
	        
	        while ( resultat.next())
	        {
	        	int idPers = resultat.getInt("idPers");
	        	String Nom = resultat.getString("Nom");
	        	String Mail = resultat.getString("Mail");
	        	System.out.println(idPers + "---" + Nom + "---" + Mail + "---");
	        }
		}
	    catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	    
	}
	public void AfficherEquipe()
	{
		try
		{
			Statement statement = null;
			ResultSet resultat = null;
			
			statement = connexion.createStatement();
			resultat = statement.executeQuery( "select * from equipe" );
	        System.out.println( "____Requete d'affichage des equipes effectuꥡ____" );
	        
	        while ( resultat.next())
	        {
	        	int idEquipe = resultat.getInt("idEquipe");
	        	String Nom = resultat.getString("Nom");
	        	
	        	System.out.println(idEquipe + "---" + Nom + "---");
	        }
		}
	    catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	    
	}
	
	public void AjouterPersonne(String Nom,String Mail)
	{
		try
		{
			Statement statement = null ;
			
			

			statement = connexion.createStatement();
			int ajoutCand = statement.executeUpdate( "INSERT INTO candidat (Nom) VALUES ('"+Nom+"')");
			int ajoutPers = statement.executeUpdate( "INSERT INTO personne (idPers ,Nom, Mail) VALUES (LAST_INSERT_ID(),'"+Nom+"','"+Mail+"');");
	        if ( ajoutCand == 1 && ajoutPers == 1) 
	        {
	        	System.out.println("____Vous avez bien ajoutez " );
	        }
	        else
	        {
	        	System.out.println("____L'ajout n'a pas été pris en compte____");
	        }
		}
		catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
		
	}
	public void AjouterEquipe(String Nom)
	{
		try
		{
			Statement statement = null ;
			
			

			statement = connexion.createStatement();
			int ajoutCand = statement.executeUpdate( "INSERT INTO candidat (Nom) VALUES ('"+Nom+"')");
			int ajoutEquipe = statement.executeUpdate( "INSERT INTO equipe (idEquipe , Nom) VALUES (LAST_INSERT_ID(),'"+Nom+"')");
	        if ( ajoutCand == 1 && ajoutEquipe == 1) {
	        	
	        	
	        	System.out.println("____Vous avez bien ajoutez " );
	        }
	        else{
	        	System.out.println("____L'ajout n'a pas été pris en compte____");
	        }
		}
		catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
		
	}
	public void AjouterCompetition(String NomCompet,Date dateCompet)
	{
		try
		{
			Statement statement = null ;
			
			

			statement = connexion.createStatement();
			int ajoutCompet = statement.executeUpdate( "INSERT INTO competition (Nom,date_cloture) VALUES ('"+NomCompet+"','"+dateCompet+"')");
			
	        if ( ajoutCompet == 1) {
	        	
	        	
	        	System.out.println("____Vous avez bien ajoutez " );
	        }
	        else{
	        	System.out.println("____L'ajout n'a pas été pris en compte____");
	        }
		}
		catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
		
	}
	public void modifierNomPersonne(int idCand, String nom)
	{
		try
		{
			Statement statement = null;
			/* int ModifDate = statement.executeUpdate( "UPDATE personne SET idPers = "+ date +" WHERE idCompet = "+ idCompet +"" );*/
			statement = connexion.createStatement();
			 
			 int ModifPers = statement.executeUpdate("UPDATE personne SET Nom = '"+ nom +"' WHERE idPers = "+ idCand +"");
			 
		        if(ModifPers == 1)
		        {
		        	System.out.println("____1ere etape de suppression____" );
		        	int ModifCand = statement.executeUpdate( "UPDATE candidat SET Nom = '"+ nom +"' WHERE idCandidat = "+ idCand +"" );
		        	if(ModifCand == 1)
		        	{
		        		System.out.println("____2eme etape La modification à bien été prise en compte____" );
		        	}	
		        }
		        else{
		        	System.out.println("____La modification n'a PAS bien été prise en compte____" );
		        }
		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	
	public void modifierPrenomPersonne(int idCand, String prenom)
	{
		try
		{
			Statement statement = null;
			/* int ModifDate = statement.executeUpdate( "UPDATE personne SET idPers = "+ date +" WHERE idCompet = "+ idCompet +"" );*/
			statement = connexion.createStatement();
			 
			 int ModifPers = statement.executeUpdate("UPDATE personne SET Prenom = '"+ prenom +"' WHERE idPers = "+ idCand +"");
			 
		        if(ModifPers == 1)
		        {
		        	System.out.println("____1ere etape de suppression____" );
		        	int ModifCand = statement.executeUpdate( "UPDATE candidat SET Nom = '"+ prenom +"' WHERE idCandidat = "+ idCand +"" );
		        	if(ModifCand == 1)
		        	{
		        		System.out.println("____2eme etape La modification à bien été prise en compte____" );
		        	}	
		        }
		        else{
		        	System.out.println("____La modification n'a PAS bien été prise en compte____" );
		        }
		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	
	public void modifierMailPersonne(int idCand, String mail)
	{
		try
		{
			Statement statement = null;
			/* int ModifDate = statement.executeUpdate( "UPDATE personne SET idPers = "+ date +" WHERE idCompet = "+ idCompet +"" );*/
			statement = connexion.createStatement();
			 
			 int ModifPers = statement.executeUpdate("UPDATE personne SET Mail = '"+ mail +"' WHERE idPers = "+ idCand +"");
			 
		        if(ModifPers == 1)
		        {
		        	
		        		System.out.println("____2eme etape La modification à bien été prise en compte____" );
		        	
		        }
		        else{
		        	System.out.println("____La modification n'a PAS bien été prise en compte____" );
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
			 int ModifDate = statement.executeUpdate( "UPDATE Competition SET date_cloture = "+ date +" WHERE idCompet = "+ idCompet +"" );
		        System.out.println( "____Requête d'affichage des candidats effectuée!____" );
		        
		        if(ModifDate == 1){
		        	System.out.println("____La modification à bien été prise en compte____" );
		        }
		        else{
		        	System.out.println("____La modification n'a PAS bien été prise en compte____" );
		        }
		}
		catch(Exception e)
		{
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	public void SupprimerCompetition(int idCompet)
	{
		
		try
		{
			statement = connexion.createStatement();
			 int SupprCompet = statement.executeUpdate( "DELETE FROM competition WHERE idCompet = "+ idCompet +"" );
		        if(SupprCompet == 1){
		        	System.out.println("____La suppression à bien été prise en compte____" );
		        }
		        else{
		        	System.out.println("____La suppression n'a PAS bien été prise en compte____" );
		        }
		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	
	public void SupprimerPersonne(int idCand)
	{
		try
		{
			statement = connexion.createStatement();
			 
			 int SupprPers = statement.executeUpdate("DELETE FROM personne WHERE idPers = "+ idCand +"");
			 
		        if(SupprPers == 1)
		        {
		        	System.out.println("____1ere etape de suppression____" );
		        	int SupprCand = statement.executeUpdate( "DELETE FROM candidat WHERE idCandidat = "+ idCand +"" );
		        	if(SupprCand == 1)
		        	{
		        		System.out.println("La suppression de l'equipe a bien été prise en compte" );
		        	}	
		        }
		        else{
		        	System.out.println("La suppression n'a PAS été prise en compte" );
		        }
		}
		catch(Exception e)
		{	
			 System.out.println( "Erreur lors de la connexion : "
		                + e.getMessage() );
		} 
	}
	public void SupprimerEquipe(int idCand)
	{
		try
		{
			statement = connexion.createStatement();
			 
			 int SupprEquipe = statement.executeUpdate("DELETE FROM equipe WHERE idEquipe = "+ idCand +"");
			 
		        if(SupprEquipe == 1)
		        {
		        	System.out.println("suppression..." );
		        	int SupprCandidat = statement.executeUpdate( "DELETE FROM candidat WHERE idCandidat = "+ idCand +"" );
		        	if(SupprCandidat == 1)
		        	{
		        		System.out.println("La suppression de l'equipe a bien été prise en compte" );
		        	}	
		        }
		        else{
		        	System.out.println("La suppression n'a PAS été prise en compte" );
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

		Connexion Connect = new Connexion();
		Connect.AfficherPersonnes(); 
		
	}


	
}