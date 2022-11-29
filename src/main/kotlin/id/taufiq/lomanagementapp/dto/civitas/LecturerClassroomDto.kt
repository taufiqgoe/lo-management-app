package id.taufiq.lomanagementapp.dto.civitas

import id.taufiq.lomanagementapp.model.jointable.LecturerClassroom
import java.io.Serializable

/**
 * A DTO for the {@link id.taufiq.lomanagementapp.model.jointable.LecturerClassroom} entity
 */
data class LecturerClassroomDto(
    var id: Int? = null,
    var lecturerId: String? = null,
    var classroomId: Int? = null,
    var totalMeeting: Int? = null,
    var totalMeetingHours: Int? = null,
    var lecturerStatus: LecturerClassroom.Companion.LecturerStatus? = null
) : Serializable
