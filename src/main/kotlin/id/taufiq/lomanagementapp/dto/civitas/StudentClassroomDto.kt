package id.taufiq.lomanagementapp.dto.civitas

import java.io.Serializable

/**
 * A DTO for the {@link id.taufiq.lomanagementapp.model.jointable.StudentClassroom} entity
 */
data class StudentClassroomDto(
    var id: Int? = null,
    var studentId: String? = null,
    var classroomId: Int? = null
) : Serializable
