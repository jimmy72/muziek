package be.vdab.muziek.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-10-05T14:25:04.292+0200")
@StaticMetamodel(Album.class)
public class Album_ {
	public static volatile SingularAttribute<Album, Long> id;
	public static volatile SingularAttribute<Album, Artiest> artiest;
	public static volatile SingularAttribute<Album, String> naam;
}
