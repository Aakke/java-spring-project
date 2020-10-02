package com.github.aakke.javaspringproject.service;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.aakke.javaspringproject.model.Reader;
import com.github.aakke.javaspringproject.repository.ReaderRepository;

@Service
public class ReaderServiceImpl implements ReaderService{

	@Autowired
	private ReaderRepository readerRepo;
	
	@Override
	public Reader findById(long id) {
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
	public void deleteById(Long id) {
		readerRepo.delete(findById(id));
	}

	@Override
	public Reader create(Reader newReader) {
		return readerRepo.save(newReader);
	}

	@Override
	public Reader update(int id, Reader readerData) {
		var reader = findById(id);
		
		reader.setAddress(readerData.getAddress());
		reader.setFirstName(readerData.getFirstName());
		reader.setLastName(readerData.getLastName());
		reader.setBirthYear(readerData.getBirthYear());
		
		return readerRepo.save(reader);
	}

}
