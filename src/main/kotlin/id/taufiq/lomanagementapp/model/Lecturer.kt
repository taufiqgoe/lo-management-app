package id.taufiq.lomanagementapp.model

import id.taufiq.lomanagementapp.model.jointable.LecturerClassroom
import jakarta.persistence.*

@Entity
data class Lecturer(

    @Id
    @Column(name = "id", nullable = false)
    var id: String? = null,

    @Column(nullable = false)
    var nationalIdNumber: String? = null,

    @Column(nullable = false)
    var name: String? = null,

    @ManyToOne(optional = false)
    @JoinColumn(name = "program_id", nullable = false)
    var program: Program? = null

) {
    @OneToMany(mappedBy = "lecturer", orphanRemoval = true)
    open var lecturerClassrooms: MutableCollection<LecturerClassroom> = mutableListOf()
}
