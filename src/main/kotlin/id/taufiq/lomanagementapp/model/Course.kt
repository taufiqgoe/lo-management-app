package id.taufiq.lomanagementapp.model

import jakarta.persistence.*

@Entity
data class Course(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    var name: String? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "program_id", nullable = false)
    var program: Program? = null

) {
    @OneToMany(mappedBy = "course", orphanRemoval = true)
    var classrooms: MutableCollection<Classroom> = mutableListOf()

    @OneToMany(mappedBy = "course", orphanRemoval = true)
    var courseLearningOutcomes: MutableCollection<CourseLearningOutcome> = mutableListOf()
}
