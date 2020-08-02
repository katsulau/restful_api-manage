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
 * アップロードした商品画像の情報
 * @param productImageUrl 
 */
data class UploadedProductImage(

    @JsonProperty("productImageUrl") val productImageUrl: kotlin.String? = null
) {

}

