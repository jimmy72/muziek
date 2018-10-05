package be.vdab.muziek.entities;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2018-10-05T15:41:25.403+0200")
@StaticMetamodel(Artiest.class)
public class Artiest_ {
	public static volatile SingularAttribute<Artiest, Long> id;
	public static volatile SingularAttribute<Artiest, String> naam;
	public static volatile SetAttribute<Artiest, Album> albums;
}
