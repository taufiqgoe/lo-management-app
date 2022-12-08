package id.taufiq.lomanagementapp.model

import id.taufiq.lomanagementapp.model.jointable.StudentClassroom
import jakarta.persistence.*
import org.hibernate.Hibernate

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

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Assignment

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , studentClassroom = $studentClassroom , assessment = $assessment , score = $score )"
    }
}
