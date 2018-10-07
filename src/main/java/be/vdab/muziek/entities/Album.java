package be.vdab.muziek.entities;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import be.vdab.muziek.valueobjects.Track;

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
	
	@ElementCollection 
	@CollectionTable(name = "tracks", joinColumns = @JoinColumn(name = "albumid")) 
	@OrderBy("naam")
	private Set<Track> tracks;
	
	protected Album() {
	}
	
	public Album(String naam) {
		this.setNaam(naam);
		this.setArtiest(artiest);
		this.tracks = new LinkedHashSet<>();
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
			artiest.addAlbum(this);
		}
		this.artiest = artiest;
	}
	
	public Set<Track> getTracks() {
		return Collections.unmodifiableSet(tracks);
	}
	
	public boolean addTrack(Track track) {
		if(track == null) {
			throw new NullPointerException();
		}
		return tracks.add(track);
	}
	
	public boolean removeTrack(Track track) {
		return tracks.remove(track);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naam == null) ? 0 : naam.toUpperCase().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Album))
			return false;
		Album other = (Album) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equalsIgnoreCase(other.naam))
			return false;
		return true;
	}

}
