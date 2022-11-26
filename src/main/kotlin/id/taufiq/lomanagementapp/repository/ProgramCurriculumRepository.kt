package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.jointable.ProgramCurriculum
import org.springframework.data.jpa.repository.JpaRepository

interface ProgramCurriculumRepository : JpaRepository<ProgramCurriculum, Int> {
}