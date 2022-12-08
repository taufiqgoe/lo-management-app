package id.taufiq.lomanagementapp.model

import id.taufiq.lomanagementapp.model.jointable.AssessmentClo
import id.taufiq.lomanagementapp.model.jointable.PloClo
import jakarta.persistence.*
import org.hibernate.Hibernate

@Entity
data class CourseLearningOutcome(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @Column(nullable = false)
    var name: String? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    var course: Course? = null

) {
    @OneToMany(mappedBy = "courseLearningOutcome", orphanRemoval = true)
    var ploCloes: MutableCollection<PloClo> = mutableListOf()

    @OneToMany(mappedBy = "courseLearningOutcome", orphanRemoval = true)
    var assessmentCloes: MutableCollection<AssessmentClo> = mutableListOf()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as CourseLearningOutcome

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , course = $course )"
    }
}
