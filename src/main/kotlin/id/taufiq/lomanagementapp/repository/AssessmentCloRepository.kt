package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.jointable.AssessmentClo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface AssessmentCloRepository : JpaRepository<AssessmentClo, Int> {

    fun findByAssessmentId(assessmentId: Int, pageable: Pageable): Page<AssessmentClo>

}