package id.taufiq.lomanagementapp.model

import id.taufiq.lomanagementapp.model.jointable.AssessmentClo
import id.taufiq.lomanagementapp.model.jointable.PloClo
import jakarta.persistence.*

@Entity
data class CourseLearningOutcome(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    var name: String? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    var course: Course? = null

) {
    @OneToMany(mappedBy = "courseLearningOutcome", orphanRemoval = true)
    var ploCloes: MutableCollection<PloClo> = mutableListOf()

    @OneToMany(mappedBy = "courseLearningOutcome", orphanRemoval = true)
    var assessmentCloes: MutableCollection<AssessmentClo> = mutableListOf()
}
