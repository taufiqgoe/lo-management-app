package id.taufiq.lomanagementapp.dto.lo

import java.io.Serializable

/**
 * A DTO for the {@link id.taufiq.lomanagementapp.model.CourseLearningOutcome} entity
 */
data class CourseLearningOutcomeDto(
    var id: Int? = null,
    var name: String? = null,
    var courseId: Int? = null
) : Serializable
