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

import org.joda.time.DateTime
import com.virtuslab.kubernetes.client.openapi.core.ApiModel

case class V1beta1VolumeError (
  /* String detailing the error encountered during Attach or Detach operation. This string may be logged, so it should not contain sensitive information. */
  message: Option[String] = None,
  /* Time the error was encountered. */
  time: Option[DateTime] = None
) extends ApiModel

