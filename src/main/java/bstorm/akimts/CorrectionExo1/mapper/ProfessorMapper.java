package bstorm.akimts.CorrectionExo1.mapper;

import bstorm.akimts.CorrectionExo1.dto.ProfessorDTO;
import bstorm.akimts.CorrectionExo1.entities.Professor;
import bstorm.akimts.CorrectionExo1.repository.SectionRepository;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapper implements Mapper<ProfessorDTO, Professor> {

    private final SmallSectionMapper mapper;
    private final SectionRepository sectionRepo;

    public ProfessorMapper(SmallSectionMapper mapper, SectionRepository sectionRepo) {
        this.mapper = mapper;
        this.sectionRepo = sectionRepo;
    }

    @Override
    public ProfessorDTO toDTO(Professor p) {
        if( p == null )
            return null;

        return ProfessorDTO.builder()
                .id( p.getId() )
                .name( p.getName() )
                .surname( p.getSurname() )
                .office( p.getOffice() )
                .email( p.getEmail() )
                .section(  mapper.toDTO(p.getSection()) )
                .wage( p.getWage() )
                .hireDate( p.getHireDate() )
                .build();
    }

    @Override
    public Professor toEntity(ProfessorDTO dto) {
        if ( dto == null )
            return null;

        return Professor.builder()
                .id( dto.getId() )
                .name(dto.getName())
                .surname(dto.getSurname())
                .office(dto.getOffice())
                .email(dto.getEmail())
                .hireDate(dto.getHireDate())
                .wage(dto.getWage())
                .section( sectionRepo.getOne(dto.getSection().getId()) )
                .build();
    }
}
