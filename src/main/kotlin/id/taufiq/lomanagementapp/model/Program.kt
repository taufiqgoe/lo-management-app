package id.taufiq.lomanagementapp.model

import id.taufiq.lomanagementapp.model.jointable.ProgramCurriculum
import jakarta.persistence.*

@Entity
data class Program(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    var name: String? = null,

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
}
