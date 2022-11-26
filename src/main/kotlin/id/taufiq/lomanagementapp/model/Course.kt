package id.taufiq.lomanagementapp.model

import jakarta.persistence.*

@Entity
data class Course(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    var name: String? = null

) {
    @OneToMany(mappedBy = "course", orphanRemoval = true)
    var courseLearningOutcomes: MutableCollection<CourseLearningOutcome> = mutableListOf()
}
