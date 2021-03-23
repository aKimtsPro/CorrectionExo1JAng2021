package bstorm.akimts.CorrectionExo1.mapper;

import bstorm.akimts.CorrectionExo1.dto.SectionDTO;
import bstorm.akimts.CorrectionExo1.entities.Section;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class SectionMapper implements Mapper<SectionDTO, Section> {

    @Override
    public SectionDTO toDTO(Section section) {
        if( section == null )
            throw new IllegalArgumentException();

        return SectionDTO.builder()
                .id(section.getId())
                .name(section.getName())
                .delegateId(section.getDelegateId())
                .build();
    }

    @Override
    public Section toEntity(SectionDTO sectionDTO) {
        if( sectionDTO == null )
            throw new IllegalArgumentException();

        return Section.builder()
                .id(sectionDTO.getId())
                .name(sectionDTO.getName())
                .delegateId(sectionDTO.getDelegateId())
                .build();
    }
}
