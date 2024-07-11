package com.github.aakke.javaspringproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.aakke.javaspringproject.persistence.model.Reader;
import com.github.aakke.javaspringproject.persistence.repository.ReaderRepository;

@Service
public class ReaderServiceImpl implements ReaderService{

	private final ReaderRepository readerRepo;
	
	@Autowired
	public ReaderServiceImpl(ReaderRepository readerRepo) {
		this.readerRepo = readerRepo;
	}
	
	@Override
	public Reader findById(final long id) {
		return readerRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("No reader found."));
	}

	@Override
	public List<Reader> findAll() {
		var allReaders = readerRepo.findAll();
		List<Reader> listOfReaders = new ArrayList<>();
		allReaders.forEach(listOfReaders::add);
		return listOfReaders;
	}

	@Override
	public void deleteById(final long id) {
		readerRepo.delete(findById(id));
	}

	@Override
	public Reader create(final Reader newReader) {
		return readerRepo.save(newReader);
	}

	@Override
	public List<Reader> createBatch(List<Reader> readers) {
		final List<Reader> toBeCreatedReaders = readers.stream()
				.filter(reader -> Objects.nonNull(reader))
				.toList();

		final List<Reader> createdReaders = (List<Reader>) readerRepo.saveAll(toBeCreatedReaders);
		return createdReaders;
	}

	@Override
	public Reader update(final long id, final Reader readerData) {
		return readerRepo.save(readerData);
	}

}
