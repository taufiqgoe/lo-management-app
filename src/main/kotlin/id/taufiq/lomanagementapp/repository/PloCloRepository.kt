package id.taufiq.lomanagementapp.repository

import id.taufiq.lomanagementapp.model.jointable.PloClo
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface PloCloRepository : JpaRepository<PloClo, Int> {

    fun findByCourseLearningOutcomeCourseId(courseId: Int, pageable: Pageable): Page<PloClo>

}