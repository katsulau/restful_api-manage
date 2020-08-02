package org.openapitools.spring.models

import java.util.Objects
import com.fasterxml.jackson.annotation.JsonProperty
import org.openapitools.spring.models.ValidationInfo
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

/**
 * 
 * @param status 
 * @param message 
 * @param validationsInfos 
 */
data class Error(

    @get:NotNull 
    @JsonProperty("status") val status: kotlin.Int,

    @get:NotNull 
    @JsonProperty("message") val message: kotlin.String,

    @JsonProperty("validationsInfos") val validationsInfos: kotlin.collections.List<ValidationInfo>? = null
) {

}

