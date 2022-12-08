package id.taufiq.lomanagementapp.model

import id.taufiq.lomanagementapp.model.jointable.AssessmentClo
import jakarta.persistence.*
import org.hibernate.Hibernate

@Entity
data class Assessment(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @Column(nullable = false)
    var name: String? = null,

    var percentage: Double? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "classroom_id", nullable = false)
    var classroom: Classroom? = null

) {
    @OneToMany(mappedBy = "assessment", orphanRemoval = true)
    var assignments: MutableCollection<Assignment> = mutableListOf()

    @OneToMany(mappedBy = "assessment", orphanRemoval = true)
    var assessmentCloes: MutableCollection<AssessmentClo> = mutableListOf()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Assessment

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , percentage = $percentage , classroom = $classroom )"
    }
}
