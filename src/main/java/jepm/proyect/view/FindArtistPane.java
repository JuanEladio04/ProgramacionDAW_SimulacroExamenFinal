package jepm.proyect.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.List;

import javax.swing.JTextField;

import jepm.proyect.controller.ArtistaController;
import jepm.proyect.controller.DisciplinaController;
import jepm.proyect.controller.MunicipioController;
import jepm.proyect.controller.ProvinciaController;
import jepm.proyect.model.Artista;
import jepm.proyect.model.Municipio;
import jepm.proyect.model.Provincia;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FindArtistPane extends JPanel {
	
	private static FindArtistPane instance = null;

	private JTextField jtf_name;
	private JComboBox jcb_provincia;
	private JComboBox jcb_municipio;
	private ButtonGroup jrb_group;
	private JRadioButton jrb_magicRadio;
	private JRadioButton jrb_singerRadio;
	private JRadioButton jrb_danceRadio;
	
	/**
	 * 
	 * @return
	 */
	public static FindArtistPane getInstance() {
		if (instance == null) {
			instance = new FindArtistPane();
		}
		return instance;
	}

	/**
	 * Create the panel.
	 */
	public FindArtistPane() {
		setBackground(new Color(255, 255, 128));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Artista encontrado");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre artístico");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtf_name = new JTextField();
		GridBagConstraints gbc_jtf_name = new GridBagConstraints();
		gbc_jtf_name.insets = new Insets(0, 0, 5, 0);
		gbc_jtf_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtf_name.gridx = 1;
		gbc_jtf_name.gridy = 1;
		add(jtf_name, gbc_jtf_name);
		jtf_name.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Disciplina:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridheight = 3;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jrb_group = new ButtonGroup();
		
		jrb_singerRadio = new JRadioButton("Cantante");
		GridBagConstraints gbc_jrb_singerRadio = new GridBagConstraints();
		gbc_jrb_singerRadio.anchor = GridBagConstraints.WEST;
		gbc_jrb_singerRadio.insets = new Insets(0, 0, 5, 0);
		gbc_jrb_singerRadio.gridx = 1;
		gbc_jrb_singerRadio.gridy = 2;
		add(jrb_singerRadio, gbc_jrb_singerRadio);
		jrb_group.add(jrb_singerRadio);
		
		jrb_magicRadio = new JRadioButton("Magia");
		GridBagConstraints gbc_jrb_magicRadio = new GridBagConstraints();
		gbc_jrb_magicRadio.anchor = GridBagConstraints.WEST;
		gbc_jrb_magicRadio.insets = new Insets(0, 0, 5, 0);
		gbc_jrb_magicRadio.gridx = 1;
		gbc_jrb_magicRadio.gridy = 3;
		add(jrb_magicRadio, gbc_jrb_magicRadio);
		jrb_group.add(jrb_magicRadio);
		
		jrb_danceRadio = new JRadioButton("Danza");
		GridBagConstraints gbc_jrb_danceRadio = new GridBagConstraints();
		gbc_jrb_danceRadio.anchor = GridBagConstraints.WEST;
		gbc_jrb_danceRadio.insets = new Insets(0, 0, 5, 0);
		gbc_jrb_danceRadio.gridx = 1;
		gbc_jrb_danceRadio.gridy = 4;
		add(jrb_danceRadio, gbc_jrb_danceRadio);
		
		jrb_group.add(jrb_danceRadio);
		
		JLabel lblNewLabel_3 = new JLabel("Provincia:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 5;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		jcb_provincia = new JComboBox();
		jcb_provincia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jcb_municipio.removeAllItems();
				
				Provincia p = (Provincia) jcb_provincia.getSelectedItem();
				int provinciaId = p.getId();
				List<Municipio> municipios = MunicipioController.getInstance().findbyId(provinciaId);
				
				for (Municipio municipio : municipios) {
					jcb_municipio.addItem(municipio);
				}
			}
		});
		
		
		GridBagConstraints gbc_jcb_provincia = new GridBagConstraints();
		gbc_jcb_provincia.insets = new Insets(0, 0, 5, 0);
		gbc_jcb_provincia.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_provincia.gridx = 1;
		gbc_jcb_provincia.gridy = 5;
		add(jcb_provincia, gbc_jcb_provincia);
		
		JLabel lblNewLabel_4 = new JLabel("Municipio:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 6;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jcb_municipio = new JComboBox();
		GridBagConstraints gbc_jcb_municipio = new GridBagConstraints();
		gbc_jcb_municipio.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_municipio.gridx = 1;
		gbc_jcb_municipio.gridy = 6;
		add(jcb_municipio, gbc_jcb_municipio);

	}
	
	
	/**
	 * 
	 * @param artist
	 */
	public void setArtistValues(Artista artist) {
		addValuesToProvinciaCombo();
		addValuesToMunicipioCombo();

		jtf_name.setText(artist.getNombre());
		setCombosDefaultValues(artist);
		
		if(artist.getDisciplina().getId() == 1) {
			jrb_group.setSelected(jrb_singerRadio.getModel(), true);
		}
		else if(artist.getDisciplina().getId() == 2) {
			jrb_group.setSelected(jrb_magicRadio.getModel(), true);
		}
		else if(artist.getDisciplina().getId() == 3) {
			jrb_group.setSelected(jrb_danceRadio.getModel(), true);
		}
	}
	

	/**
	 * @param artist
	 */
	private void setCombosDefaultValues(Artista artist) {
		for (int i = 0; i < jcb_provincia.getItemCount(); i++) {
		    Provincia provincia = (Provincia) jcb_provincia.getItemAt(i);
		    if (provincia.getId() == artist.getMunicipio().getProvincia().getId()) {
		        jcb_provincia.setSelectedItem(provincia);
		        break;
		    }
		}
		
		for (int i = 0; i < jcb_municipio.getItemCount(); i++) {
		    Municipio municipio = (Municipio) jcb_municipio.getItemAt(i);
		    if (municipio.getId() == artist.getMunicipio().getId()) {
		        jcb_municipio.setSelectedItem(municipio);
		        break;
		    }
		}
	}
	
	
	/**
	 * 
	 */
	private void addValuesToProvinciaCombo() {
		jcb_provincia.removeAllItems();
		List<Provincia> p = ProvinciaController.getInstance().findAll();
		
		for (Provincia provincia : p) {
			jcb_provincia.addItem(provincia);
		}
	}
	
	
	/**
	 * 
	 */
	private void addValuesToMunicipioCombo() {
		jcb_municipio.removeAllItems();
		Provincia p = (Provincia) jcb_provincia.getSelectedItem();
		int provinciaId = p.getId();
		List<Municipio> municipios = MunicipioController.getInstance().findbyId(provinciaId);
		
		for (Municipio municipio : municipios) {
			jcb_municipio.addItem(municipio);
		}
		
	}
	
	
	/**
	 * @return 
	 * 
	 */
	public void updateArtista() {
		Artista a = ArtistSelectorPanel.getSelectedArtista();
		
		a.setMunicipio((Municipio) jcb_municipio.getSelectedItem());
		a.setNombre(jtf_name.getText());
		setUpdateDisciplina(a);
		
		ArtistaController.getInstance().realizeUpdate(a);
		
	}
	
	/**
	 * 
	 */
	private void setUpdateDisciplina(Artista artist) {
		if(jrb_singerRadio.isSelected()) {
			artist.setDisciplina(DisciplinaController.getInstance().findByLikeDescription("Cantante"));
		}
		else if(jrb_magicRadio.isSelected()) {
			artist.setDisciplina(DisciplinaController.getInstance().findByLikeDescription("Magia"));
		}
		else if(jrb_danceRadio.isSelected()) {
			artist.setDisciplina(DisciplinaController.getInstance().findByLikeDescription("Danza"));
		}
	}
}
