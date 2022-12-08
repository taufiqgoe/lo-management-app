package id.taufiq.lomanagementapp.model

import id.taufiq.lomanagementapp.model.jointable.ProgramCurriculum
import jakarta.persistence.*
import org.hibernate.Hibernate

@Entity
data class Program(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    @Column(nullable = false)
    var name: String? = null,

    @Column(nullable = false, unique = true)
    var code: String? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    var department: Department? = null

) {
    @OneToMany(mappedBy = "program", orphanRemoval = true)
    var courses: MutableCollection<Course> = mutableListOf()

    @OneToMany(mappedBy = "program", orphanRemoval = true)
    var programCurricula: MutableCollection<ProgramCurriculum> = mutableListOf()

    @OneToMany(mappedBy = "program", orphanRemoval = true)
    var students: MutableCollection<Student> = mutableListOf()

    @OneToMany(mappedBy = "program", orphanRemoval = true)
    var lecturers: MutableCollection<Lecturer> = mutableListOf()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as Program

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id , name = $name , code = $code , department = $department )"
    }
}
