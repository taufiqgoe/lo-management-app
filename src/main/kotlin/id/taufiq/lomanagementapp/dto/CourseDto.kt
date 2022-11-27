package id.taufiq.lomanagementapp.dto

import java.io.Serializable

/**
 * A DTO for the {@link id.taufiq.lomanagementapp.model.Course} entity
 */
data class CourseDto(
    var id: Int? = null,
    var name: String? = null,
    var programId: Int? = null
) : Serializable
