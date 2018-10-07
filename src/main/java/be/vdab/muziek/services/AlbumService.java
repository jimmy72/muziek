package be.vdab.muziek.services;

import java.util.List;
import java.util.Optional;

import be.vdab.muziek.entities.Album;

public interface AlbumService {
	public abstract List<Album> findAll();
	public abstract Optional<Album> read(long id);
}
