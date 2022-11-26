package id.taufiq.lomanagementapp.model.jointable

import id.taufiq.lomanagementapp.model.Classroom
import id.taufiq.lomanagementapp.model.Lecturer
import jakarta.persistence.*

@Entity
data class LecturerClassroom(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "lecturer_id", nullable = false)
    var lecturer: Lecturer? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "classroom_id", nullable = false)
    var classroom: Classroom? = null,

    var totalMeeting: Int? = null,

    var totalMeetingHours: Int? = null,

    @Enumerated(EnumType.STRING)
    @Column(name = "lecturer_status", nullable = false)
    var lecturerStatus: LecturerStatus? = null

) {
    companion object {
        enum class LecturerStatus {
            MEMBER, COORDINATOR
        }
    }
}
