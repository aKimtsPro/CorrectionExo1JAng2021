package bstorm.akimts.CorrectionExo1.repository;

import bstorm.akimts.CorrectionExo1.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
}
