package id.taufiq.lomanagementapp.dto.civitas

import java.io.Serializable

/**
 * A DTO for the {@link id.taufiq.lomanagementapp.model.Student} entity
 */
data class StudentDto(
    var id: String? = null,
    var name: String? = null,
    var gender: String? = null,
    var programId: Int? = null
) : Serializable
