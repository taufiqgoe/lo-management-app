package id.taufiq.lomanagementapp.dto

import java.io.Serializable

/**
 * A DTO for the {@link id.taufiq.lomanagementapp.model.Assessment} entity
 */
data class AssessmentDto(
    var id: Int? = null,
    var name: String? = null,
    var classroomId: Int? = null
) : Serializable
