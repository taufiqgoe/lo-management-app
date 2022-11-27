package id.taufiq.lomanagementapp.dto

import java.io.Serializable

/**
 * A DTO for the {@link id.taufiq.lomanagementapp.model.Classroom} entity
 */
data class ClassroomDto(
    var id: Int? = null,
    var name: String? = null,
    var courseId: Int? = null
) : Serializable
