package id.taufiq.lomanagementapp.model

import id.taufiq.lomanagementapp.model.jointable.ProgramCurriculum
import jakarta.persistence.*

@Entity
data class Program(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    var name: String? = null

) {
    @OneToMany(mappedBy = "program", orphanRemoval = true)
    var programCurricula: MutableCollection<ProgramCurriculum> = mutableListOf()

    @OneToMany(mappedBy = "program", orphanRemoval = true)
    var students: MutableCollection<Student> = mutableListOf()

    @OneToMany(mappedBy = "program", orphanRemoval = true)
    var lecturers: MutableCollection<Lecturer> = mutableListOf()
}
