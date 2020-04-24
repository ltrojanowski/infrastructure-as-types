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
package com.virtuslab.kubernetes.client.openapi.model

import com.virtuslab.kubernetes.client.custom.B64Encoded
import com.virtuslab.kubernetes.client.openapi.core.ApiModel

case class CertificateSigningRequestStatus(
    /* If request was approved, the controller will place the issued certificate here. */
    certificate: Option[B64Encoded] = None,
    /* Conditions applied to the request, such as approval or denial. */
    conditions: Option[Seq[CertificateSigningRequestCondition]] = None)
  extends ApiModel
