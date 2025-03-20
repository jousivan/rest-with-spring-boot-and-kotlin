package br.com.ajss.project.data.vo.v1

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import com.github.dozermapper.core.Mapping
import org.springframework.hateoas.RepresentationModel
import java.util.*


@JsonPropertyOrder("id", "author", "launchDate", "price", "title")
data class BooksVO(

    @Mapping("id")
    @field:JsonProperty("id")
    var key: Long = 0,
    var author: String = "",
    var launchDate: Date? = null,
    var price: String = "",
    var title: String = ""
) : RepresentationModel<BooksVO>()