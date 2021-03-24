package bstorm.akimts.CorrectionExo1.mapper;

import bstorm.akimts.CorrectionExo1.dto.SectionStudentDTO;
import bstorm.akimts.CorrectionExo1.dto.StudentSectionDTO;
import bstorm.akimts.CorrectionExo1.entities.Section;
import bstorm.akimts.CorrectionExo1.entities.Student;
import org.springframework.stereotype.Component;

@Component
public class SectionStudentMapper {

    SectionStudentDTO toDTO(Section entity){
        if( entity == null )
            return null;

        return SectionStudentDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }
}
