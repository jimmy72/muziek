package be.vdab.muziek.valueobjects;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

@Embeddable
public class Track implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String naam;
	private BigDecimal tijd;
	
	protected Track() {}
	
	public Track(String naam, BigDecimal tijd) {
		if(naam == null || naam.trim().isEmpty() || tijd.compareTo(BigDecimal.ZERO) <= 0) {
			throw new IllegalArgumentException();
		}
		this.naam = naam;
		this.tijd = tijd;
	}

	public String getNaam() {
		return naam;
	}

	public BigDecimal getTijd() {
		return tijd;
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
		if (!(obj instanceof Track))
			return false;
		Track other = (Track) obj;
		if (naam == null) {
			if (other.naam != null)
				return false;
		} else if (!naam.equalsIgnoreCase(other.naam))
			return false;
		return true;
	}
	
}
