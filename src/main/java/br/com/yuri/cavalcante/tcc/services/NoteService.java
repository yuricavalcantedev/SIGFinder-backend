package br.com.yuri.cavalcante.tcc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.yuri.cavalcante.tcc.controllers.exceptions.DataIntegrityException;
import br.com.yuri.cavalcante.tcc.controllers.exceptions.ObjectNotFoundException;
import br.com.yuri.cavalcante.tcc.domain.Note;
import br.com.yuri.cavalcante.tcc.repositories.NoteRepository;

@Service
public class NoteService {

	@Autowired
	private NoteRepository noteRepository;

	public Note insert(Note note) {

		note.setId(null);
		return noteRepository.save(note);
	}

	public List<Note> findAll(){

		return noteRepository.findAll();		
	}

	public Page<Note> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);		
		return noteRepository.findAll(pageRequest);
	}

	public Note find(Integer id){

		Optional<Note> note = noteRepository.findById(id); 
		return note.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + " - Type:" + Note.class.getName())); 
	}

	public Note update(Note note) {

		Note updatedNote = find(note.getId());
		updatedNote.setCatalog(note.getCatalog());
		updatedNote.setText(note.getText());
		
		return noteRepository.save(updatedNote);
	}

	public void delete(Integer id) {		 

		find(id);
		try {
			noteRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("It's not possible delete an note that has catalogs linked to it."); // in the truth, it's possible! Let see if this gonna work.
		}

	}

}
