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

    @Column(name = "launch_date", nullable = false, length = 10)
    var launchDate: Date? = Date(),

    @Column(name = "price", nullable = false, length = 10)
    var price: String = "",

    @Column(name = "title", nullable = false, length = 80)
    var title: String = ""
)