package be.vdab.muziek.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import be.vdab.muziek.entities.Album;
import be.vdab.muziek.repositories.AlbumRepository;

@Service
class DefaultAlbumService implements AlbumService{

	private final AlbumRepository albumRepository;
	
	DefaultAlbumService(AlbumRepository albumRepository) {
		this.albumRepository = albumRepository;
	}
	
	@Override
	public List<Album> findAll() {
		return albumRepository.findAll();
	}

	@Override
	public Optional<Album> read(long id) {
		return albumRepository.read(id);
	}

}
