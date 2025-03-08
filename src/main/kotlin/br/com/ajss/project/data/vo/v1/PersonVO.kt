package br.com.ajss.project.data.vo.v1

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonPropertyOrder
import org.springframework.hateoas.RepresentationModel
import com.github.dozermapper.core.Mapping


@JsonPropertyOrder("id", "first_name", "last_name", "address", "gender")
data class PersonVO(

    @Mapping("id")
    @field:JsonProperty("id")
    var key: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var address: String = "",
    var gender: String = ""
) : RepresentationModel<PersonVO>()