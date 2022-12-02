package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.CourseLearningOutcome
import org.springframework.data.jpa.repository.JpaRepository

interface CourseLearningOutcomeRepository : JpaRepository<CourseLearningOutcome, Int> {

    fun findByCourseId(courseId: Int): List<CourseLearningOutcome>

}