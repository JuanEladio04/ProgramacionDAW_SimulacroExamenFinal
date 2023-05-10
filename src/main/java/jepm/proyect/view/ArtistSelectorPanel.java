package jepm.proyect.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import jepm.proyect.controller.ArtistaController;
import jepm.proyect.controller.MunicipioController;
import jepm.proyect.model.Artista;
import jepm.proyect.model.Municipio;
import jepm.proyect.model.Provincia;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class ArtistSelectorPanel extends JPanel {
	private static ArtistSelectorPanel instance = null;
	private JTextField jtf_inputArtistName;
	private static JComboBox jcb_allArtistSelector; 
	
	/**
	 * 
	 * @return
	 */
	public static ArtistSelectorPanel getInstance() {
		if (instance == null) {
			instance = new ArtistSelectorPanel();
		}
		return instance;
	}

	/**
	 * Create the panel.
	 */
	public ArtistSelectorPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestión artistas");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Búsqueda de artista:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtf_inputArtistName = new JTextField();
		GridBagConstraints gbc_jtf_inputArtistName = new GridBagConstraints();
		gbc_jtf_inputArtistName.insets = new Insets(0, 0, 5, 5);
		gbc_jtf_inputArtistName.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_inputArtistName.gridx = 1;
		gbc_jtf_inputArtistName.gridy = 1;
		add(jtf_inputArtistName, gbc_jtf_inputArtistName);
		jtf_inputArtistName.setColumns(10);
		
		JButton btn_search = new JButton("Buscar");
		btn_search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chargeAllArtistToCombo();
			}
		});
		GridBagConstraints gbc_btn_search = new GridBagConstraints();
		gbc_btn_search.insets = new Insets(0, 0, 5, 0);
		gbc_btn_search.gridx = 2;
		gbc_btn_search.gridy = 1;
		add(btn_search, gbc_btn_search);
		
		JLabel lblNewLabel_2 = new JLabel("Artistas encontrados:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcb_allArtistSelector = new JComboBox();
		GridBagConstraints gbc_jcb_allArtistSelector = new GridBagConstraints();
		gbc_jcb_allArtistSelector.insets = new Insets(0, 0, 0, 5);
		gbc_jcb_allArtistSelector.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_allArtistSelector.gridx = 1;
		gbc_jcb_allArtistSelector.gridy = 2;
		add(jcb_allArtistSelector, gbc_jcb_allArtistSelector);
		
		JButton btn_chagedata = new JButton("Cargar datos");
		btn_chagedata.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Artista artist = (Artista) jcb_allArtistSelector.getSelectedItem();
				
				FindArtistPane.getInstance().setArtistValues(artist);
			}
		});
		GridBagConstraints gbc_btn_chagedata = new GridBagConstraints();
		gbc_btn_chagedata.gridx = 2;
		gbc_btn_chagedata.gridy = 2;
		add(btn_chagedata, gbc_btn_chagedata);

	}
	
	public void chargeAllArtistToCombo() {
		jcb_allArtistSelector.removeAllItems();
		List<Artista> artistas = ArtistaController.getInstance().findByLikeDescription(jtf_inputArtistName.getText());
		
		for (Artista artista : artistas) {
			jcb_allArtistSelector.addItem(artista);
		}
	}
	
	
	public static Artista getSelectedArtista() {
		Artista a = (Artista) jcb_allArtistSelector.getSelectedItem();
		return a;
	}

}
