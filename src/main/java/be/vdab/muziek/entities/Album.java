package be.vdab.muziek.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "albums")
public class Album implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String naam;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = false) 
	@JoinColumn(name = "artiestid") 
	private Artiest artiest;
	
	protected Album() {
	}
	
	public Album(String naam) {
		this.setNaam(naam);
		this.setArtiest(artiest);
		
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Artiest getArtiest() {
		return artiest;
	}

	public void setArtiest(Artiest artiest) {
		if(artiest == null) {
			throw new NullPointerException();
		}
		if(!artiest.getAlbums().contains(this)) {
			artiest.add(this);
		}
		this.artiest = artiest;
	}
	
	
	
}
