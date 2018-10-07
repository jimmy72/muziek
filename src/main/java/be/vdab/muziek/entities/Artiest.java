package be.vdab.muziek.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "artiesten")
public class Artiest implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String naam;
	
	@OneToMany(mappedBy = "artiest") 
	@OrderBy("naam") 
	private Set<Album> albums;
	
	protected Artiest() {
	}
	
	public Artiest(String naam) {
		this.setNaam(naam);
		this.albums = new LinkedHashSet<>();
	}

	public Set<Album> getAlbums() {
		return Collections.unmodifiableSet(albums);
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		if(naam.trim().isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.naam = naam;
	}
	
	public boolean addAlbum(Album album) {
		if(album == null) {
			throw new NullPointerException();
		}
		boolean added = this.albums.add(album);
		Artiest vorigeArtiest = album.getArtiest();
		if(vorigeArtiest != null && vorigeArtiest != this) {
			vorigeArtiest.removeAlbum(album);
		}
		if(vorigeArtiest != this) {
			album.setArtiest(this);
		}
		return added;
	}
	
	public boolean removeAlbum(Album album) {
		return this.albums.remove(album);
	}
}
