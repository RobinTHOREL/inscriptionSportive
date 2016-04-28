package SwingIHM;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.Window.Type;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;

public class IHM {

	private JFrame frmTest;
	private JTextField txtNomEquipe;
	private JTextField txtNomCompet;
	private JTextField txtDateEquipe;
	private JTextField txtNomCompet2;
	private JTextField txtDateCompet2;
	private JTextField txtNomPersonne;
	private JTextField txtMailPersonne;
	private JTextField txtNomPersonne2;
	private JTextField txtMailPersonne2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IHM window = new IHM();
					window.frmTest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IHM() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTest = new JFrame();
		frmTest.getContentPane().setBackground(new Color(255, 255, 255));
		frmTest.getContentPane().setForeground(new Color(0, 255, 255));
		frmTest.setFont(new Font("Verdana", Font.BOLD, 12));
		frmTest.setType(Type.POPUP);
		frmTest.setTitle("Inscription Sportives");
		frmTest.setForeground(new Color(0, 0, 0));
		frmTest.setBackground(new Color(0, 0, 0));
		frmTest.setBounds(100, 100, 776, 477);
		frmTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTest.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 755, 453);
		frmTest.getContentPane().add(panel);
		panel.setBackground(new Color(25, 25, 112));
		panel.setForeground(new Color(0, 0, 0));
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 245, 442);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		Label labelEquipe = new Label("Equipe");
		labelEquipe.setFont(new Font("Verdana", Font.BOLD, 15));
		labelEquipe.setBounds(95, 10, 132, 22);
		panel_1.add(labelEquipe);
		
		JList listEquipe = new JList();
		listEquipe.setToolTipText("");
		listEquipe.setBackground(new Color(128, 0, 0));
		listEquipe.setModel(new AbstractListModel() {
			String[] values = new String[] {"list"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listEquipe.setBounds(0, 321, 245, 121);
		panel_1.add(listEquipe);
		
		txtNomEquipe = new JTextField();
		txtNomEquipe.setText("Nom");
		txtNomEquipe.setBounds(113, 88, 100, 20);
		panel_1.add(txtNomEquipe);
		txtNomEquipe.setColumns(10);
		
		
		JLabel lblNewLabel_2 = new JLabel("Creer une equipe :");
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblNewLabel_2.setBounds(7, 63, 178, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblRentrerLes = new JLabel("Nom de l'equipe");
		lblRentrerLes.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblRentrerLes.setBounds(7, 88, 202, 20);
		panel_1.add(lblRentrerLes);
		
		JButton btnAjouterUnequipe = new JButton("Ajouter");
		btnAjouterUnequipe.setBounds(75, 112, 100, 23);
		panel_1.add(btnAjouterUnequipe);
		
		/*JLabel lblPuisAppuyerSur = new JLabel("2. Bouton \"Ajouter\"");
		lblPuisAppuyerSur.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblPuisAppuyerSur.setBounds(7, 113, 138, 14);
		panel_1.add(lblPuisAppuyerSur);*/
		
		JLabel lblPourSupprimerUne = new JLabel("Supprimer une equipe :");
		lblPourSupprimerUne.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPourSupprimerUne.setBounds(7, 140, 187, 14);
		panel_1.add(lblPourSupprimerUne);
		
		JLabel lblSelectionnerUne = new JLabel("<LISTE DES EQUIPES>");
		lblSelectionnerUne.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSelectionnerUne.setBounds(60, 162, 202, 20);
		panel_1.add(lblSelectionnerUne);
		
		JButton btnSupprimerUnequipe = new JButton("Supprimer");
		btnSupprimerUnequipe.setBounds(75, 190, 100, 23);
		panel_1.add(btnSupprimerUnequipe);
		
		JLabel lbltitle_updateequip = new JLabel("Modifier une equipe :");
		lbltitle_updateequip.setFont(new Font("Verdana", Font.BOLD, 12));
		lbltitle_updateequip.setBounds(7, 220, 187, 14);
		panel_1.add(lbltitle_updateequip);
		
		JLabel lb1descr_updateequip = new JLabel("<LISTE DES EQUIPES>");
		lb1descr_updateequip.setFont(new Font("Tahoma", Font.BOLD, 11));
		lb1descr_updateequip.setBounds(60, 240, 202, 20);
		panel_1.add(lb1descr_updateequip);
		
		JButton lb1button_updateequip = new JButton("Modifier");
		lb1button_updateequip.setBounds(75, 260, 100, 23);
		panel_1.add(lb1button_updateequip);
		
		JLabel lblPourAfficherLes = new JLabel("Afficher les equipes");
		lblPourAfficherLes.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPourAfficherLes.setBounds(7, 290, 187, 14);
		panel_1.add(lblPourAfficherLes);
		
		JLabel lblBoutonafficher = new JLabel("1. Bouton \"Afficher");
		lblBoutonafficher.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblBoutonafficher.setBounds(7, 310, 138, 14);
		panel_1.add(lblBoutonafficher);
		
		// Passage au deuxieme onglet
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(255, 0, 245, 442);
		panel.add(panel_2);
		
		Label labelCompet = new Label("Competition");
		labelCompet.setFont(new Font("Verdana", Font.BOLD, 15));
		labelCompet.setBounds(32, 10, 166, 22);
		panel_2.add(labelCompet);
		
		JButton btnSupprimerUneCompet = new JButton("Supprimer");
		btnSupprimerUneCompet.setBounds(120, 157, 97, 23);
		panel_2.add(btnSupprimerUneCompet);
		
		JList listCompet = new JList();
		listCompet.setBackground(new Color(128, 0, 0));
		listCompet.setBounds(0, 321, 245, 121);
		panel_2.add(listCompet);
		
		JLabel lblPourAjouterUne = new JLabel("Pour ajouter une competition :");
		lblPourAjouterUne.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPourAjouterUne.setBounds(10, 38, 207, 14);
		panel_2.add(lblPourAjouterUne);
		
		JLabel label_3 = new JLabel("1. Champ(s) requi(s)");
		label_3.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label_3.setBounds(10, 52, 202, 20);
		panel_2.add(label_3);
		
		txtNomCompet = new JTextField();
		txtNomCompet.setText("Nom");
		txtNomCompet.setColumns(10);
		txtNomCompet.setBounds(10, 70, 100, 20);
		panel_2.add(txtNomCompet);
		
		txtDateEquipe = new JTextField();
		txtDateEquipe.setText("Date(dd/mm/yyyy)");
		txtDateEquipe.setColumns(10);
		txtDateEquipe.setBounds(117, 70, 100, 20);
		panel_2.add(txtDateEquipe);
		
		JLabel label_4 = new JLabel("2. Bouton \"Ajouter\"");
		label_4.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label_4.setBounds(10, 98, 138, 14);
		panel_2.add(label_4);
		
		JLabel lblPourSupprimerUne_1 = new JLabel("Pour supprimer une competition");
		lblPourSupprimerUne_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPourSupprimerUne_1.setBounds(10, 126, 225, 14);
		panel_2.add(lblPourSupprimerUne_1);
		
		JLabel label_6 = new JLabel("1. Selectionner une equipe dans la liste");
		label_6.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label_6.setBounds(10, 142, 202, 20);
		panel_2.add(label_6);
		
		JLabel label_7 = new JLabel("2. Bouton \"Supprimer\"");
		label_7.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label_7.setBounds(10, 161, 138, 14);
		panel_2.add(label_7);
		
		JLabel lblPourModifierUne = new JLabel("Pour modifier une competition");
		lblPourModifierUne.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPourModifierUne.setBounds(10, 185, 225, 14);
		panel_2.add(lblPourModifierUne);
		
		txtNomCompet2 = new JTextField();
		txtNomCompet2.setText("Nom");
		txtNomCompet2.setColumns(10);
		txtNomCompet2.setBounds(135, 204, 100, 20);
		panel_2.add(txtNomCompet2);
		
		JLabel lblNouveauNom = new JLabel("1. Nouveau nom");
		lblNouveauNom.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblNouveauNom.setBounds(10, 204, 202, 20);
		panel_2.add(lblNouveauNom);
		
		JLabel lblbNouvelleDatecloture = new JLabel("1. Nouvelle DateCloture");
		lblbNouvelleDatecloture.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblbNouvelleDatecloture.setBounds(10, 224, 122, 20);
		panel_2.add(lblbNouvelleDatecloture);
		
		txtDateCompet2 = new JTextField();
		txtDateCompet2.setText("(DD/MM/YYYY)");
		txtDateCompet2.setColumns(10);
		txtDateCompet2.setBounds(135, 224, 100, 20);
		panel_2.add(txtDateCompet2);
		
		JLabel lblBoutonmodifier = new JLabel("2. Bouton \"Modifier\"");
		lblBoutonmodifier.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblBoutonmodifier.setBounds(10, 245, 138, 14);
		panel_2.add(lblBoutonmodifier);
		
		JButton btnModifierUneCompet = new JButton("Modifier");
		btnModifierUneCompet.setBounds(135, 244, 102, 20);
		panel_2.add(btnModifierUneCompet);
		
		JLabel label_5 = new JLabel("Pour afficher les equipes");
		label_5.setFont(new Font("Verdana", Font.BOLD, 12));
		label_5.setBounds(10, 267, 187, 14);
		panel_2.add(label_5);
		
		
		JButton buttonAfficherCompet = new JButton("---");
		buttonAfficherCompet.setBounds(135, 287, 100, 23);
		panel_2.add(buttonAfficherCompet);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(510, 0, 245, 442);
		panel.add(panel_3);
		
		JButton btnAjouterUnePersonne = new JButton("Ajouter");
		btnAjouterUnePersonne.setBounds(117, 95, 100, 20);
		panel_3.add(btnAjouterUnePersonne);
		
		//Passage au troisieme onglet
		Label labelPersonne = new Label("Personne");
		labelPersonne.setFont(new Font("Verdana", Font.BOLD, 15));
		labelPersonne.setBounds(32, 10, 166, 22);
		panel_3.add(labelPersonne);
		
		JButton btnSupprimerUnePersonne = new JButton("Supprimer");
		btnSupprimerUnePersonne.setBounds(120, 157, 97, 23);
		panel_3.add(btnSupprimerUnePersonne);
		
		JList listPersonne = new JList();
		listPersonne.setBackground(new Color(128, 0, 0));
		listPersonne.setBounds(0, 321, 245, 121);
		panel_3.add(listPersonne);
		
		JLabel lblPourAjouterUne_1 = new JLabel("Pour ajouter une personne :");
		lblPourAjouterUne_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPourAjouterUne_1.setBounds(10, 38, 207, 14);
		panel_3.add(lblPourAjouterUne_1);
		
		JLabel label_2 = new JLabel("1. Champ(s) requi(s)");
		label_2.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label_2.setBounds(10, 52, 202, 20);
		panel_3.add(label_2);
		
		txtNomPersonne = new JTextField();
		txtNomPersonne.setText("Nom");
		txtNomPersonne.setColumns(10);
		txtNomPersonne.setBounds(10, 70, 100, 20);
		panel_3.add(txtNomPersonne);
		
		txtMailPersonne = new JTextField();
		txtMailPersonne.setText("Mail");
		txtMailPersonne.setColumns(10);
		txtMailPersonne.setBounds(117, 70, 100, 20);
		panel_3.add(txtMailPersonne);
		
		JLabel label_9 = new JLabel("2. Bouton \"Ajouter\"");
		label_9.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label_9.setBounds(10, 98, 138, 14);
		panel_3.add(label_9);
		
		JLabel lblPourSupprimerUne_2 = new JLabel("Pour supprimer une personne");
		lblPourSupprimerUne_2.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPourSupprimerUne_2.setBounds(10, 126, 225, 14);
		panel_3.add(lblPourSupprimerUne_2);
		
		JLabel lblSelectionnerUne_1 = new JLabel("1. Selectionner une personne dans la liste");
		lblSelectionnerUne_1.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblSelectionnerUne_1.setBounds(10, 142, 202, 20);
		panel_3.add(lblSelectionnerUne_1);
		
		JLabel label_12 = new JLabel("2. Bouton \"Supprimer\"");
		label_12.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label_12.setBounds(10, 161, 138, 14);
		panel_3.add(label_12);
		
		JLabel lblPourModifierUne_1 = new JLabel("Pour modifier une personne");
		lblPourModifierUne_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPourModifierUne_1.setBounds(10, 185, 225, 14);
		panel_3.add(lblPourModifierUne_1);
		
		txtNomPersonne2 = new JTextField();
		txtNomPersonne2.setText("Nom");
		txtNomPersonne2.setColumns(10);
		txtNomPersonne2.setBounds(135, 204, 100, 20);
		panel_3.add(txtNomPersonne2);
		
		JLabel label_14 = new JLabel("1. Nouveau nom");
		label_14.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label_14.setBounds(10, 204, 202, 20);
		panel_3.add(label_14);
		
		JLabel lblbNouvelleMail = new JLabel("1. Nouvelle mail");
		lblbNouvelleMail.setFont(new Font("Tahoma", Font.ITALIC, 11));
		lblbNouvelleMail.setBounds(10, 224, 122, 20);
		panel_3.add(lblbNouvelleMail);
		
		txtMailPersonne2 = new JTextField();
		txtMailPersonne2.setText("Mail");
		txtMailPersonne2.setColumns(10);
		txtMailPersonne2.setBounds(135, 224, 100, 20);
		panel_3.add(txtMailPersonne2);
		
		JLabel label_16 = new JLabel("2. Bouton \"Modifier\"");
		label_16.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label_16.setBounds(10, 245, 138, 14);
		panel_3.add(label_16);
		
		JButton btnModifierUnePersonne = new JButton("Modifier");
		btnModifierUnePersonne.setBounds(135, 244, 102, 20);
		panel_3.add(btnModifierUnePersonne);
		
		JLabel lblPourAfficherLes_1 = new JLabel("Pour afficher les personnes");
		lblPourAfficherLes_1.setFont(new Font("Verdana", Font.BOLD, 12));
		lblPourAfficherLes_1.setBounds(10, 267, 187, 14);
		panel_3.add(lblPourAfficherLes_1);
		
		JLabel label_18 = new JLabel("1. Bouton \"Afficher");
		label_18.setFont(new Font("Tahoma", Font.ITALIC, 11));
		label_18.setBounds(10, 292, 122, 14);
		panel_3.add(label_18);
		
		JButton btnAfficherUnePersonne = new JButton("Afficher");
		btnAfficherUnePersonne.setBounds(135, 287, 100, 23);
		panel_3.add(btnAfficherUnePersonne);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
	}
}
