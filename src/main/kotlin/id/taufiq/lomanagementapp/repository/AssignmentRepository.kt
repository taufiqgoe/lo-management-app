package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.Assignment
import org.springframework.data.jpa.repository.JpaRepository

interface AssignmentRepository : JpaRepository<Assignment, Int> {

    fun findByAssessmentAssessmentCloesCourseLearningOutcomePloCloesProgramLearningOutcomeId(ploId: Int): List<Assignment>

    fun findByAssessmentAssessmentCloesCourseLearningOutcomeId(cloId: Int): List<Assignment>

}