package id.taufiq.lomanagementapp.model

import id.taufiq.lomanagementapp.model.jointable.LecturerClassroom
import jakarta.persistence.*
import org.hibernate.Hibernate

@Entity
data class Lecturer(

    @Id
    @Column(name = "id", nullable = false)
    var id: String? = null,

    @Column(nullable = false)
    var name: String? = null,

    @Column(nullable = false)
    var nationalIdNumber: String? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "program_id", nullable = false)
    var program: Program? = null

) {
    @OneToMany(mappedBy = "lecturer", orphanRemoval = true)
    var lecturerClassrooms: MutableCollection<LecturerClassroom> = mutableListOf()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Lecturer

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , nationalIdNumber = $nationalIdNumber , program = $program )"
    }
}
