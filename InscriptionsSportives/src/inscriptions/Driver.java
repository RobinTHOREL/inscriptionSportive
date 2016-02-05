package inscriptions;
import java.sql.*;

public class Driver {

	public static void main(String[] args) {
		try
		{
			//1.Connect to database
			Connection myConnect= DriverManager.getConnection("jdbc:mysql://localhost:8889/Inscription","root","root");
			
			//2.Create a statement
			Statement MyState=myConnect.createStatement();
			
			//3.Execute SQL query
			ResultSet MyRS=MyState.executeQuery("select * from Competition");
			
			
			//4.Process the result set
			
			while((MyRS).next()){
				System.out.println(MyRS.getString("Nom")+" ,"+MyRS.getString("DateCloture"));
			}
			
			
			ResultSet MyRS1=MyState.executeQuery("select * from Personne");
				while((MyRS1).next()){
					System.out.println(MyRS1.getString("Prenom")+" ,"+MyRS1.getString("Mail"));	
				
			}
				//MyState.executeUpdate("INSERT INTO Equipe values('2')");
				//MyState.executeUpdate("INSERT INTO Personne values('','Prenom','Mail')");
				//MyState.executeUpdate("INSERT INTO Competition(IdCompet,Nom,DateCloture) values('4','RolandGarros','2016-05-29')");
				
				
				ResultSet MyRS3=MyState.executeQuery("select * from Equipe");
				while((MyRS3).next()){
					System.out.println(MyRS3.getString("IdCandidat"));	
				
			}	
				ResultSet MyRS4=MyState.executeQuery("select * from Personne p inner join Equipe e on e.IdCandidat=p.IdCandidat");
				while((MyRS4).next()){
					System.out.println(MyRS4.getString("Prenom")+MyRS4.getString("Mail"));	
				
			}	
	
		}
		catch(Exception exc){
			exc.printStackTrace();
		}

	}

}
//ajout une pers
//ajout une equipe
//ajout une personne dans une equipe
//afficher la liste des personnes 
//afficher la liste des personnes presentes dans une equipe
//ajouter une compet
//ajouter pers ou equipe dans une compet
