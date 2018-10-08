package be.vdab.muziek.repositories;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringRunner;

import be.vdab.muziek.entities.Album;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Import(JpaAlbumRepository.class)
@Sql("/insertArtiest.sql")
@Sql("/insertAlbum.sql")
public class JpaAlbumRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests{

	private static final String ALBUMS = "albums";
	@Autowired
	private JpaAlbumRepository repository;
	@Autowired
	private EntityManager manager;
	
	private long idVanTestAlbum() {
		return super.jdbcTemplate.queryForObject(
			"select id from albums where naam='testalbum'", Long.class);
	}
	@Test
	public void read() {
		Album album = repository.read(idVanTestAlbum()).get();
		assertEquals("testalbum", album.getNaam());
	}
	
	@Test
	public void findAll() {
		List<Album> albums = repository.findAll();
		manager.clear();
		assertEquals(albums.size(), super.countRowsInTable(ALBUMS));
		String[] vorigAlbum = {""};
		albums.forEach(album -> {
			System.out.println(album.getNaam() + " -> " + album.getArtiest().getNaam());
			assertTrue(vorigAlbum[0].compareTo(album.getNaam()) <= 0);
			vorigAlbum[0] = album.getNaam();
		});
	}

}
