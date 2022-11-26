package id.taufiq.lomanagementapp.model

import jakarta.persistence.*

@Entity
data class Department(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    var id: Int? = null,

    var name: String? = null

)
