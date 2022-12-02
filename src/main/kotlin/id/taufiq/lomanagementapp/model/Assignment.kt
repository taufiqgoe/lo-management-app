package id.taufiq.lomanagementapp.model

import id.taufiq.lomanagementapp.model.jointable.StudentClassroom
import jakarta.persistence.*

@Entity
data class Assignment(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "student_classroom_id", nullable = false)
    var studentClassroom: StudentClassroom? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "assessment_id", nullable = false)
    var assessment: Assessment? = null,

    @Column(nullable = false)
    var score: Double? = null

)
