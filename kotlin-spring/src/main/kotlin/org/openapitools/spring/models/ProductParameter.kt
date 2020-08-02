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
 * 商品作成パラメータ
 * @param name 商品名
 * @param price 値段
 * @param explanation 商品説明
 */
data class ProductParameter(

    @get:NotNull @get:Size(min=1,max=128) 
    @JsonProperty("name") val name: kotlin.String,

    @get:NotNull 
    @JsonProperty("price") val price: kotlin.Int,

    @get:NotNull 
    @JsonProperty("explanation") val explanation: kotlin.String
) {

}

