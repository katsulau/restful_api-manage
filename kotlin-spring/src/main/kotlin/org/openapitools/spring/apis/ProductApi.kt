package org.openapitools.spring.apis

import org.openapitools.spring.models.Error
import org.openapitools.spring.models.ProductParameter
import org.openapitools.spring.models.Products
import org.openapitools.spring.models.UploadedProductImage
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.validation.annotation.Validated
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.beans.factory.annotation.Autowired

import javax.validation.Valid
import javax.validation.constraints.DecimalMax
import javax.validation.constraints.DecimalMin
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

import kotlin.collections.List
import kotlin.collections.Map

@RestController
@Validated
@RequestMapping("\${api.base-path:}")
class ProductApiController() {


    @RequestMapping(
        value = ["/api/v1/product/{productId}"],
        produces = ["application/json"], 
        method = [RequestMethod.DELETE])
    fun apiV1ProductProductIdDelete( @PathVariable("productId") productId: kotlin.String
): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }


    @RequestMapping(
        value = ["/api/v1/product/{productId}"],
        produces = ["application/json"], 
        method = [RequestMethod.GET])
    fun apiV1ProductProductIdGet( @PathVariable("productId") productId: kotlin.String
): ResponseEntity<Products> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }


    @RequestMapping(
        value = ["/api/v1/product/{productId}"],
        produces = ["application/json"], 
        consumes = ["application/json"],
        method = [RequestMethod.PUT])
    fun apiV1ProductProductIdPut( @PathVariable("productId") productId: kotlin.String
, @Valid @RequestBody productParameter: ProductParameter?
): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }


    @RequestMapping(
        value = ["/api/v1/products"],
        produces = ["application/json"], 
        method = [RequestMethod.GET])
    fun apiV1ProductsGet(): ResponseEntity<Products> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }


    @RequestMapping(
        value = ["/api/v1/products/image"],
        produces = ["application/json"], 
        consumes = ["image/_*"],
        method = [RequestMethod.POST])
    fun apiV1ProductsImagePost( @Valid @RequestBody body: kotlin.String?
): ResponseEntity<UploadedProductImage> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }


    @RequestMapping(
        value = ["/api/v1/products"],
        produces = ["application/json"], 
        consumes = ["application/json"],
        method = [RequestMethod.POST])
    fun apiV1ProductsPost( @Valid @RequestBody productParameter: ProductParameter?
): ResponseEntity<Unit> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }


    @RequestMapping(
        value = ["/api/v1/products/search"],
        produces = ["application/json"], 
        method = [RequestMethod.GET])
    fun apiV1ProductsSearchGet(@NotNull @Size(min=1,max=128)  @RequestParam(value = "keyword", required = true) keyword: kotlin.String
): ResponseEntity<Products> {
        return ResponseEntity(HttpStatus.NOT_IMPLEMENTED)
    }
}
