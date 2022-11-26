package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.Assessment
import org.springframework.data.jpa.repository.JpaRepository

interface AssessmentRepository : JpaRepository<Assessment, Int> {
}