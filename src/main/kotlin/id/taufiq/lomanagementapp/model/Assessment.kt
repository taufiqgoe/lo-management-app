package id.taufiq.lomanagementapp.model

import id.taufiq.lomanagementapp.model.jointable.AssessmentClo
import jakarta.persistence.*

@Entity
data class Assessment(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    var name: String? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "classroom_id", nullable = false)
    var classroom: Classroom? = null

) {
    @OneToMany(mappedBy = "assessment", orphanRemoval = true)
    var assignments: MutableCollection<Assignment> = mutableListOf()

    @OneToMany(mappedBy = "assessment", orphanRemoval = true)
    var assessmentCloes: MutableCollection<AssessmentClo> = mutableListOf()
}
