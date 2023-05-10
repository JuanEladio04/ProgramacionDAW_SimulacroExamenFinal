package jepm.proyect.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the disciplina database table.
 * 
 */
@Entity
@Table(name="disciplina")
@NamedQuery(name="Disciplina.findAll", query="SELECT d FROM Disciplina d")
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String descripcion;

	//bi-directional many-to-one association to Artista
	@OneToMany(mappedBy="disciplina")
	private List<Artista> artistas;

	public Disciplina() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Artista> getArtistas() {
		return this.artistas;
	}

	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}

	public Artista addArtista(Artista artista) {
		getArtistas().add(artista);
		artista.setDisciplina(this);

		return artista;
	}

	public Artista removeArtista(Artista artista) {
		getArtistas().remove(artista);
		artista.setDisciplina(null);

		return artista;
	}

	@Override
	public String toString() {
		return descripcion;
	}
	
	

}