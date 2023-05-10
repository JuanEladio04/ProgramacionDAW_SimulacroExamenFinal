package jepm.proyect.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the municipio database table.
 * 
 */
@Entity
@Table(name="municipio")
@NamedQuery(name="Municipio.findAll", query="SELECT m FROM Municipio m")
public class Municipio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String nombre;

	//bi-directional many-to-one association to Artista
	@OneToMany(mappedBy="municipio")
	private List<Artista> artistas;

	//bi-directional many-to-one association to Provincia
	@ManyToOne
	@JoinColumn(name="idProvincia")
	private Provincia provincia;

	public Municipio() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Artista> getArtistas() {
		return this.artistas;
	}

	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}

	public Artista addArtista(Artista artista) {
		getArtistas().add(artista);
		artista.setMunicipio(this);

		return artista;
	}

	public Artista removeArtista(Artista artista) {
		getArtistas().remove(artista);
		artista.setMunicipio(null);

		return artista;
	}

	public Provincia getProvincia() {
		return this.provincia;
	}

	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	

}