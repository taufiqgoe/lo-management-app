package id.taufiq.lomanagementapp.dto.civitas

import java.io.Serializable

/**
 * A DTO for the {@link id.taufiq.lomanagementapp.model.Assignment} entity
 */
data class AssignmentDto(
    var id: Int? = null,
    var studentClassroomId: Int? = null,
    var assessmentId: Int? = null,
    var score: Double? = null
) : Serializable