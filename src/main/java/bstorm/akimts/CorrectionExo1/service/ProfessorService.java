package bstorm.akimts.CorrectionExo1.service;

import bstorm.akimts.CorrectionExo1.dto.ProfessorDTO;
import bstorm.akimts.CorrectionExo1.entities.Professor;
import bstorm.akimts.CorrectionExo1.exceptions.ElementAlreadyExistsException;
import bstorm.akimts.CorrectionExo1.exceptions.ElementNotFoundException;
import bstorm.akimts.CorrectionExo1.mapper.Mapper;
import bstorm.akimts.CorrectionExo1.repository.ProfessorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorService implements CrudService<ProfessorDTO, Integer> {

    private final Mapper<ProfessorDTO, Professor> mapper;
    private final ProfessorRepository repo;

    public ProfessorService(Mapper<ProfessorDTO, Professor> mapper, ProfessorRepository repo) {
        this.mapper = mapper;
        this.repo = repo;
    }

    @Override
    public void insert(ProfessorDTO toInsert) throws ElementAlreadyExistsException {
        if( toInsert == null )
            throw new IllegalArgumentException();
        if( repo.existsById(toInsert.getId()) )
            throw new ElementAlreadyExistsException();

        repo.save(mapper.toEntity(toInsert));
    }

    @Override
    public ProfessorDTO getOne(Integer id) throws ElementNotFoundException {
        if( id == null )
            throw new IllegalArgumentException();

        return repo.findById(id)
                .map(mapper::toDTO)
                .orElseThrow(() -> new ElementNotFoundException(id));
    }

    @Override
    public List<ProfessorDTO> getAll() {
        return repo.findAll().stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(ProfessorDTO toUpdate, Integer integer) throws ElementNotFoundException {
        if(toUpdate == null || integer == null)
            throw new IllegalArgumentException();

        Professor p = mapper.toEntity(toUpdate);
        Professor prof = repo.findById(integer)
                .orElseThrow(()->new ElementNotFoundException(integer));

        prof.setEmail(p.getEmail());
        prof.setHireDate(p.getHireDate());
        prof.setName(p.getName());
        prof.setSection(p.getSection());
        prof.setOffice(p.getOffice());
        prof.setSurname(p.getSurname());
        prof.setWage(p.getWage());

        repo.save(prof);
    }

    @Override
    public void delete(Integer integer) throws ElementNotFoundException {
        if( integer == null )
            throw new IllegalArgumentException();
        if( !repo.existsById(integer) )
            throw new ElementNotFoundException(integer);

        repo.deleteById(integer);
    }
}
