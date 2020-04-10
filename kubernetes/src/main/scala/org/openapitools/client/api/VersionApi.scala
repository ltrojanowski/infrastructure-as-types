/**
 * Kubernetes
 * No description provided (generated by Openapi Generator https://github.com/openapitools/openapi-generator)
 *
 * The version of the OpenAPI document: v1.15.10
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.client.api

import org.openapitools.client.model.Info
import com.virtuslab.kubernetes.client.openapi.core._
import alias._
import sttp.client._
import sttp.model.Method

object VersionApi {

  def apply(baseUrl: String = "http://localhost")(implicit serializer: SttpSerializer) = new VersionApi(baseUrl)
}

class VersionApi(baseUrl: String)(implicit serializer: SttpSerializer) {

  import Helpers._
  import serializer._

  /**
   * get the code version
   * 
   * Expected answers:
   *   code 200 : Info (OK)
   *   code 401 :  (Unauthorized)
   * 
   * Available security schemes:
   *   BearerToken (apiKey)
   */
  def getCode()(implicit apiKey: ApiKeyValue): ApiRequestT[Info] =
    basicRequest
      .method(Method.GET, uri"$baseUrl/version/")
      .contentType("application/json")
      .header("authorization", apiKey.value)
      .response(asJson[Info])

}

