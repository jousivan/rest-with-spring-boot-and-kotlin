package br.com.ajss.project.model

import jakarta.persistence.*
import java.util.Date

@Entity
@Table(name = "books")
data class Books(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column(name = "author", nullable = false, length = 80)
    var author: String = "",

    @Column(name = "launch_date", nullable = false)
    @Temporal(TemporalType.DATE)
    var launchDate: Date? = null,

    @Column(name = "price", nullable = false, length = 100)
    var price: Double = 0.0,

    @Column(name = "title", nullable = false, length = 250)
    var title: String = "",

    @Transient
    var currency: String = "",

    @Transient
    var environment: String = ""
)