package bstorm.akimts.CorrectionExo1.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Section {

    @Id
    @Column(name = "section_id")
    private int id;

    @Column(name = "section_name")
    private String name;

    @Column(name = "delegate_id")
    private int delegateId;
}
