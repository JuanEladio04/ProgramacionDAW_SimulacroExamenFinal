package jepm.proyect.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainWindow extends JFrame {

	private JPanel contentPane;
	
	private static MainWindow instance = null;
	
	/**
	 * 
	 * @return
	 */
	public static MainWindow getInstance() {
		if (instance == null) {
			instance = new MainWindow();
		}
		return instance;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = getInstance();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 563, 371);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 29, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		ArtistSelectorPanel artistSelector = ArtistSelectorPanel.getInstance();
		GridBagConstraints gbc_artistSelectorPanel = new GridBagConstraints();
		gbc_artistSelectorPanel.insets = new Insets(0, 0, 5, 0);
		gbc_artistSelectorPanel.fill = GridBagConstraints.BOTH;
		gbc_artistSelectorPanel.gridx = 0;
		gbc_artistSelectorPanel.gridy = 0;
		contentPane.add(artistSelector, gbc_artistSelectorPanel);
		
		FindArtistPane artistPane = FindArtistPane.getInstance();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(artistPane, gbc_panel_1);
		
		JPanel savePanel = new JPanel();
		savePanel.setBackground(new Color(128, 255, 255));
		GridBagConstraints gbc_savePanel = new GridBagConstraints();
		gbc_savePanel.gridx = 0;
		gbc_savePanel.gridy = 2;	
		contentPane.add(savePanel, gbc_savePanel);
		GridBagLayout gbl_savePanel = new GridBagLayout();
		gbl_savePanel.columnWidths = new int[]{0, 0};
		gbl_savePanel.rowHeights = new int[]{0, 0};
		gbl_savePanel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_savePanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		savePanel.setLayout(gbl_savePanel);
		
		JButton btn_Save = new JButton("Guardar");
		btn_Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindArtistPane.getInstance().updateArtista();
				ArtistSelectorPanel.getInstance().chargeAllArtistToCombo();
			}
		});
		GridBagConstraints gbc_btn_Save = new GridBagConstraints();
		gbc_btn_Save.gridx = 0;
		gbc_btn_Save.gridy = 0;
		savePanel.add(btn_Save, gbc_btn_Save);
	}

}
