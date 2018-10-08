package be.vdab.muziek.entities;

import be.vdab.muziek.valueobjects.Track;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-10-08T08:46:53.382+0200")
@StaticMetamodel(Album.class)
public class Album_ {
	public static volatile SingularAttribute<Album, Long> id;
	public static volatile SingularAttribute<Album, String> naam;
	public static volatile SingularAttribute<Album, Artiest> artiest;
	public static volatile SetAttribute<Album, Track> tracks;
}
