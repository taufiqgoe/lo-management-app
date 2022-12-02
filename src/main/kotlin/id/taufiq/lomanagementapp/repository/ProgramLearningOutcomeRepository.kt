package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.ProgramLearningOutcome
import org.springframework.data.jpa.repository.JpaRepository

interface ProgramLearningOutcomeRepository : JpaRepository<ProgramLearningOutcome, Int> {

    fun findByPloCloesCourseLearningOutcomeCourseId(courseID: Int): List<ProgramLearningOutcome>

}