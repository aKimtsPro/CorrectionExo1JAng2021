package bstorm.akimts.CorrectionExo1.service;

import bstorm.akimts.CorrectionExo1.dto.CourseDTO;
import bstorm.akimts.CorrectionExo1.exceptions.ElementAlreadyExistsException;

import java.math.BigDecimal;
import java.util.List;

public interface CourseService {

    public CourseDTO insert(CourseDTO toInsert) throws ElementAlreadyExistsException;
    public List<CourseDTO> getAll();

    public List<CourseDTO> getByName(String name);
    public List<CourseDTO> getByMinECTS(BigDecimal minECTS);
    public List<CourseDTO> getByProfessor(int profId);

    public List<CourseDTO> getByNameLength(int length);
    public long deleteByFirstLetterInName(char caractere);

}
