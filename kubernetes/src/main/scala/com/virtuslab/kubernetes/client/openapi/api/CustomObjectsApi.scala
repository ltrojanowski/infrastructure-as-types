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
package com.virtuslab.kubernetes.client.openapi.api

import com.virtuslab.kubernetes.client.openapi.model.DeleteOptions
import org.json4s.JObject
import com.virtuslab.kubernetes.client.openapi.core._
import alias._
import sttp.client._
import sttp.model.Method

object CustomObjectsApi {

  def apply(baseUrl: String = "http://localhost")(implicit serializer: SttpSerializer) = new CustomObjectsApi(baseUrl)
}

class CustomObjectsApi(baseUrl: String)(implicit serializer: SttpSerializer) {

  import Helpers._
  import serializer._

  /**
    * Creates a cluster scoped Custom object
    *
    * Expected answers:
    *   code 201 : JObject (Created)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param pretty If 'true', then the output is pretty printed.
    * @param group The custom resource's group name
    * @param version The custom resource's version
    * @param plural The custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param body The JSON schema of the Resource to create.
    */
  def createClusterCustomObject(
      pretty: Option[String] = None,
      group: String,
      version: String,
      plural: String,
      body: JObject
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.POST, uri"$baseUrl/apis/${group}/${version}/${plural}?pretty=$pretty")
      .contentType("application/json")
      .header("authorization", apiKey.value)
      .body(body)
      .response(asJson[JObject])

  /**
    * Creates a namespace scoped Custom object
    *
    * Expected answers:
    *   code 201 : JObject (Created)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param pretty If 'true', then the output is pretty printed.
    * @param group The custom resource's group name
    * @param version The custom resource's version
    * @param namespace The custom resource's namespace
    * @param plural The custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param body The JSON schema of the Resource to create.
    */
  def createNamespacedCustomObject(
      pretty: Option[String] = None,
      group: String,
      version: String,
      namespace: String,
      plural: String,
      body: JObject
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.POST, uri"$baseUrl/apis/${group}/${version}/namespaces/${namespace}/${plural}?pretty=$pretty")
      .contentType("application/json")
      .header("authorization", apiKey.value)
      .body(body)
      .response(asJson[JObject])

  /**
    * Deletes the specified cluster scoped custom object
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param plural the custom object's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    * @param gracePeriodSeconds The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
    * @param orphanDependents Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the \"orphan\" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
    * @param propagationPolicy Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy.
    * @param body
    */
  def deleteClusterCustomObject(
      group: String,
      version: String,
      plural: String,
      name: String,
      gracePeriodSeconds: Option[Int] = None,
      orphanDependents: Option[Boolean] = None,
      propagationPolicy: Option[String] = None,
      body: Option[DeleteOptions] = None
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(
        Method.DELETE,
        uri"$baseUrl/apis/${group}/${version}/${plural}/${name}?gracePeriodSeconds=$gracePeriodSeconds&orphanDependents=$orphanDependents&propagationPolicy=$propagationPolicy"
      )
      .contentType("application/json")
      .header("authorization", apiKey.value)
      .body(body)
      .response(asJson[JObject])

  /**
    * Deletes the specified namespace scoped custom object
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param namespace The custom resource's namespace
    * @param plural the custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    * @param gracePeriodSeconds The duration in seconds before the object should be deleted. Value must be non-negative integer. The value zero indicates delete immediately. If this value is nil, the default grace period for the specified type will be used. Defaults to a per object value if not specified. zero means delete immediately.
    * @param orphanDependents Deprecated: please use the PropagationPolicy, this field will be deprecated in 1.7. Should the dependent objects be orphaned. If true/false, the \"orphan\" finalizer will be added to/removed from the object's finalizers list. Either this field or PropagationPolicy may be set, but not both.
    * @param propagationPolicy Whether and how garbage collection will be performed. Either this field or OrphanDependents may be set, but not both. The default policy is decided by the existing finalizer set in the metadata.finalizers and the resource-specific default policy.
    * @param body
    */
  def deleteNamespacedCustomObject(
      group: String,
      version: String,
      namespace: String,
      plural: String,
      name: String,
      gracePeriodSeconds: Option[Int] = None,
      orphanDependents: Option[Boolean] = None,
      propagationPolicy: Option[String] = None,
      body: Option[DeleteOptions] = None
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(
        Method.DELETE,
        uri"$baseUrl/apis/${group}/${version}/namespaces/${namespace}/${plural}/${name}?gracePeriodSeconds=$gracePeriodSeconds&orphanDependents=$orphanDependents&propagationPolicy=$propagationPolicy"
      )
      .contentType("application/json")
      .header("authorization", apiKey.value)
      .body(body)
      .response(asJson[JObject])

  /**
    * Returns a cluster scoped custom object
    *
    * Expected answers:
    *   code 200 : JObject (A single Resource)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param plural the custom object's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    */
  def getClusterCustomObject(
      group: String,
      version: String,
      plural: String,
      name: String
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.GET, uri"$baseUrl/apis/${group}/${version}/${plural}/${name}")
      .contentType("application/json")
      .header("authorization", apiKey.value)
      .response(asJson[JObject])

  /**
    * read scale of the specified custom object
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param plural the custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    */
  def getClusterCustomObjectScale(
      group: String,
      version: String,
      plural: String,
      name: String
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.GET, uri"$baseUrl/apis/${group}/${version}/${plural}/${name}/scale")
      .contentType("application/json")
      .header("authorization", apiKey.value)
      .response(asJson[JObject])

  /**
    * read status of the specified cluster scoped custom object
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param plural the custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    */
  def getClusterCustomObjectStatus(
      group: String,
      version: String,
      plural: String,
      name: String
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.GET, uri"$baseUrl/apis/${group}/${version}/${plural}/${name}/status")
      .contentType("application/json")
      .header("authorization", apiKey.value)
      .response(asJson[JObject])

  /**
    * Returns a namespace scoped custom object
    *
    * Expected answers:
    *   code 200 : JObject (A single Resource)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param namespace The custom resource's namespace
    * @param plural the custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    */
  def getNamespacedCustomObject(
      group: String,
      version: String,
      namespace: String,
      plural: String,
      name: String
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.GET, uri"$baseUrl/apis/${group}/${version}/namespaces/${namespace}/${plural}/${name}")
      .contentType("application/json")
      .header("authorization", apiKey.value)
      .response(asJson[JObject])

  /**
    * read scale of the specified namespace scoped custom object
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param namespace The custom resource's namespace
    * @param plural the custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    */
  def getNamespacedCustomObjectScale(
      group: String,
      version: String,
      namespace: String,
      plural: String,
      name: String
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.GET, uri"$baseUrl/apis/${group}/${version}/namespaces/${namespace}/${plural}/${name}/scale")
      .contentType("application/json")
      .header("authorization", apiKey.value)
      .response(asJson[JObject])

  /**
    * read status of the specified namespace scoped custom object
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param namespace The custom resource's namespace
    * @param plural the custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    */
  def getNamespacedCustomObjectStatus(
      group: String,
      version: String,
      namespace: String,
      plural: String,
      name: String
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.GET, uri"$baseUrl/apis/${group}/${version}/namespaces/${namespace}/${plural}/${name}/status")
      .contentType("application/json")
      .header("authorization", apiKey.value)
      .response(asJson[JObject])

  /**
    * list or watch cluster scoped custom objects
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param pretty If 'true', then the output is pretty printed.
    * @param group The custom resource's group name
    * @param version The custom resource's version
    * @param plural The custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param continue The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the \"next key\".  This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
    * @param fieldSelector A selector to restrict the list of returned objects by their fields. Defaults to everything.
    * @param labelSelector A selector to restrict the list of returned objects by their labels. Defaults to everything.
    * @param limit limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.  The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
    * @param resourceVersion When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
    * @param timeoutSeconds Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
    * @param watch Watch for changes to the described resources and return them as a stream of add, update, and remove notifications.
    */
  def listClusterCustomObject(
      pretty: Option[String] = None,
      group: String,
      version: String,
      plural: String,
      continue: Option[String] = None,
      fieldSelector: Option[String] = None,
      labelSelector: Option[String] = None,
      limit: Option[Int] = None,
      resourceVersion: Option[String] = None,
      timeoutSeconds: Option[Int] = None,
      watch: Option[Boolean] = None
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(
        Method.GET,
        uri"$baseUrl/apis/${group}/${version}/${plural}?pretty=$pretty&continue=$continue&fieldSelector=$fieldSelector&labelSelector=$labelSelector&limit=$limit&resourceVersion=$resourceVersion&timeoutSeconds=$timeoutSeconds&watch=$watch"
      )
      .contentType("application/json")
      .header("authorization", apiKey.value)
      .response(asJson[JObject])

  /**
    * list or watch namespace scoped custom objects
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param pretty If 'true', then the output is pretty printed.
    * @param group The custom resource's group name
    * @param version The custom resource's version
    * @param namespace The custom resource's namespace
    * @param plural The custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param continue The continue option should be set when retrieving more results from the server. Since this value is server defined, clients may only use the continue value from a previous query result with identical query parameters (except for the value of continue) and the server may reject a continue value it does not recognize. If the specified continue value is no longer valid whether due to expiration (generally five to fifteen minutes) or a configuration change on the server, the server will respond with a 410 ResourceExpired error together with a continue token. If the client needs a consistent list, it must restart their list without the continue field. Otherwise, the client may send another list request with the token received with the 410 error, the server will respond with a list starting from the next key, but from the latest snapshot, which is inconsistent from the previous list results - objects that are created, modified, or deleted after the first list request will be included in the response, as long as their keys are after the \"next key\".  This field is not supported when watch is true. Clients may start a watch from the last resourceVersion value returned by the server and not miss any modifications.
    * @param fieldSelector A selector to restrict the list of returned objects by their fields. Defaults to everything.
    * @param labelSelector A selector to restrict the list of returned objects by their labels. Defaults to everything.
    * @param limit limit is a maximum number of responses to return for a list call. If more items exist, the server will set the `continue` field on the list metadata to a value that can be used with the same initial query to retrieve the next set of results. Setting a limit may return fewer than the requested amount of items (up to zero items) in the event all requested objects are filtered out and clients should only use the presence of the continue field to determine whether more results are available. Servers may choose not to support the limit argument and will return all of the available results. If limit is specified and the continue field is empty, clients may assume that no more results are available. This field is not supported if watch is true.  The server guarantees that the objects returned when using continue will be identical to issuing a single list call without a limit - that is, no objects created, modified, or deleted after the first request is issued will be included in any subsequent continued requests. This is sometimes referred to as a consistent snapshot, and ensures that a client that is using limit to receive smaller chunks of a very large result can ensure they see all possible objects. If objects are updated during a chunked list the version of the object that was present at the time the first list result was calculated is returned.
    * @param resourceVersion When specified with a watch call, shows changes that occur after that particular version of a resource. Defaults to changes from the beginning of history. When specified for list: - if unset, then the result is returned from remote storage based on quorum-read flag; - if it's 0, then we simply return what we currently have in cache, no guarantee; - if set to non zero, then the result is at least as fresh as given rv.
    * @param timeoutSeconds Timeout for the list/watch call. This limits the duration of the call, regardless of any activity or inactivity.
    * @param watch Watch for changes to the described resources and return them as a stream of add, update, and remove notifications.
    */
  def listNamespacedCustomObject(
      pretty: Option[String] = None,
      group: String,
      version: String,
      namespace: String,
      plural: String,
      continue: Option[String] = None,
      fieldSelector: Option[String] = None,
      labelSelector: Option[String] = None,
      limit: Option[Int] = None,
      resourceVersion: Option[String] = None,
      timeoutSeconds: Option[Int] = None,
      watch: Option[Boolean] = None
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(
        Method.GET,
        uri"$baseUrl/apis/${group}/${version}/namespaces/${namespace}/${plural}?pretty=$pretty&continue=$continue&fieldSelector=$fieldSelector&labelSelector=$labelSelector&limit=$limit&resourceVersion=$resourceVersion&timeoutSeconds=$timeoutSeconds&watch=$watch"
      )
      .contentType("application/json")
      .header("authorization", apiKey.value)
      .response(asJson[JObject])

  /**
    * patch the specified cluster scoped custom object
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param plural the custom object's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    * @param body The JSON schema of the Resource to patch.
    */
  def patchClusterCustomObject(
      group: String,
      version: String,
      plural: String,
      name: String,
      body: JObject
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.PATCH, uri"$baseUrl/apis/${group}/${version}/${plural}/${name}")
      .contentType("application/json-patch+json")
      .header("authorization", apiKey.value)
      .body(body)
      .response(asJson[JObject])

  /**
    * partially update scale of the specified cluster scoped custom object
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param plural the custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    * @param body
    */
  def patchClusterCustomObjectScale(
      group: String,
      version: String,
      plural: String,
      name: String,
      body: JObject
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.PATCH, uri"$baseUrl/apis/${group}/${version}/${plural}/${name}/scale")
      .contentType("application/json-patch+json")
      .header("authorization", apiKey.value)
      .body(body)
      .response(asJson[JObject])

  /**
    * partially update status of the specified cluster scoped custom object
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param plural the custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    * @param body
    */
  def patchClusterCustomObjectStatus(
      group: String,
      version: String,
      plural: String,
      name: String,
      body: JObject
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.PATCH, uri"$baseUrl/apis/${group}/${version}/${plural}/${name}/status")
      .contentType("application/json-patch+json")
      .header("authorization", apiKey.value)
      .body(body)
      .response(asJson[JObject])

  /**
    * patch the specified namespace scoped custom object
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param namespace The custom resource's namespace
    * @param plural the custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    * @param body The JSON schema of the Resource to patch.
    */
  def patchNamespacedCustomObject(
      group: String,
      version: String,
      namespace: String,
      plural: String,
      name: String,
      body: JObject
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.PATCH, uri"$baseUrl/apis/${group}/${version}/namespaces/${namespace}/${plural}/${name}")
      .contentType("application/json-patch+json")
      .header("authorization", apiKey.value)
      .body(body)
      .response(asJson[JObject])

  /**
    * partially update scale of the specified namespace scoped custom object
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param namespace The custom resource's namespace
    * @param plural the custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    * @param body
    */
  def patchNamespacedCustomObjectScale(
      group: String,
      version: String,
      namespace: String,
      plural: String,
      name: String,
      body: JObject
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.PATCH, uri"$baseUrl/apis/${group}/${version}/namespaces/${namespace}/${plural}/${name}/scale")
      .contentType("application/json-patch+json")
      .header("authorization", apiKey.value)
      .body(body)
      .response(asJson[JObject])

  /**
    * partially update status of the specified namespace scoped custom object
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param namespace The custom resource's namespace
    * @param plural the custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    * @param body
    */
  def patchNamespacedCustomObjectStatus(
      group: String,
      version: String,
      namespace: String,
      plural: String,
      name: String,
      body: JObject
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.PATCH, uri"$baseUrl/apis/${group}/${version}/namespaces/${namespace}/${plural}/${name}/status")
      .contentType("application/json-patch+json")
      .header("authorization", apiKey.value)
      .body(body)
      .response(asJson[JObject])

  /**
    * replace the specified cluster scoped custom object
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param plural the custom object's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    * @param body The JSON schema of the Resource to replace.
    */
  def replaceClusterCustomObject(
      group: String,
      version: String,
      plural: String,
      name: String,
      body: JObject
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.PUT, uri"$baseUrl/apis/${group}/${version}/${plural}/${name}")
      .contentType("application/json")
      .header("authorization", apiKey.value)
      .body(body)
      .response(asJson[JObject])

  /**
    * replace scale of the specified cluster scoped custom object
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 201 : JObject (Created)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param plural the custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    * @param body
    */
  def replaceClusterCustomObjectScale(
      group: String,
      version: String,
      plural: String,
      name: String,
      body: JObject
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.PUT, uri"$baseUrl/apis/${group}/${version}/${plural}/${name}/scale")
      .contentType("application/json")
      .header("authorization", apiKey.value)
      .body(body)
      .response(asJson[JObject])

  /**
    * replace status of the cluster scoped specified custom object
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 201 : JObject (Created)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param plural the custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    * @param body
    */
  def replaceClusterCustomObjectStatus(
      group: String,
      version: String,
      plural: String,
      name: String,
      body: JObject
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.PUT, uri"$baseUrl/apis/${group}/${version}/${plural}/${name}/status")
      .contentType("application/json")
      .header("authorization", apiKey.value)
      .body(body)
      .response(asJson[JObject])

  /**
    * replace the specified namespace scoped custom object
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param namespace The custom resource's namespace
    * @param plural the custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    * @param body The JSON schema of the Resource to replace.
    */
  def replaceNamespacedCustomObject(
      group: String,
      version: String,
      namespace: String,
      plural: String,
      name: String,
      body: JObject
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.PUT, uri"$baseUrl/apis/${group}/${version}/namespaces/${namespace}/${plural}/${name}")
      .contentType("application/json")
      .header("authorization", apiKey.value)
      .body(body)
      .response(asJson[JObject])

  /**
    * replace scale of the specified namespace scoped custom object
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 201 : JObject (Created)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param namespace The custom resource's namespace
    * @param plural the custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    * @param body
    */
  def replaceNamespacedCustomObjectScale(
      group: String,
      version: String,
      namespace: String,
      plural: String,
      name: String,
      body: JObject
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.PUT, uri"$baseUrl/apis/${group}/${version}/namespaces/${namespace}/${plural}/${name}/scale")
      .contentType("application/json")
      .header("authorization", apiKey.value)
      .body(body)
      .response(asJson[JObject])

  /**
    * replace status of the specified namespace scoped custom object
    *
    * Expected answers:
    *   code 200 : JObject (OK)
    *   code 201 : JObject (Created)
    *   code 401 :  (Unauthorized)
    *
    * Available security schemes:
    *   BearerToken (apiKey)
    *
    * @param group the custom resource's group
    * @param version the custom resource's version
    * @param namespace The custom resource's namespace
    * @param plural the custom resource's plural name. For TPRs this would be lowercase plural kind.
    * @param name the custom object's name
    * @param body
    */
  def replaceNamespacedCustomObjectStatus(
      group: String,
      version: String,
      namespace: String,
      plural: String,
      name: String,
      body: JObject
    )(implicit
      apiKey: ApiKeyValue
    ): ApiRequestT[JObject] =
    basicRequest
      .method(Method.PUT, uri"$baseUrl/apis/${group}/${version}/namespaces/${namespace}/${plural}/${name}/status")
      .contentType("application/json")
      .header("authorization", apiKey.value)
      .body(body)
      .response(asJson[JObject])

}
