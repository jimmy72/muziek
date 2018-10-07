package be.vdab.muziek.repositories;

import java.util.List;
import java.util.Optional;

import be.vdab.muziek.entities.Album;

public interface AlbumRepository {
	public abstract Optional<Album> read(long id);
	public abstract List<Album> findAll();
}
