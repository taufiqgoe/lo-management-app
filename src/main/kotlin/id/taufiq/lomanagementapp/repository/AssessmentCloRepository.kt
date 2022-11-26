package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.jointable.AssessmentClo
import org.springframework.data.jpa.repository.JpaRepository

interface AssessmentCloRepository : JpaRepository<AssessmentClo, Int> {
}