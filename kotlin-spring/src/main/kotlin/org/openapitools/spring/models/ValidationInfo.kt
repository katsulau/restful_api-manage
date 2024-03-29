package org.openapitools.spring.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

/**
 * 
 * @param field 
 * @param rejectedValue 
 * @param message 
 */
data class ValidationInfo(

    @get:NotNull 
    @JsonProperty("field") val field: kotlin.String,

    @get:NotNull 
    @JsonProperty("rejectedValue") val rejectedValue: kotlin.String,

    @get:NotNull 
    @JsonProperty("message") val message: kotlin.String
) {

}

