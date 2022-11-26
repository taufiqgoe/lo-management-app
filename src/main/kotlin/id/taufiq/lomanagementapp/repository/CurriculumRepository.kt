package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.Curriculum
import org.springframework.data.jpa.repository.JpaRepository

interface CurriculumRepository : JpaRepository<Curriculum, Int> {
}