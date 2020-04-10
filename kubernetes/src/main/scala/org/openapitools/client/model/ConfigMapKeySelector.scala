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
package org.openapitools.client.model

import com.virtuslab.kubernetes.client.openapi.core.ApiModel

  /**
   * Selects a key from a ConfigMap.
   */
case class ConfigMapKeySelector(
  /* The key to select. */
  key: String,
  /* Name of the referent. More info: https://kubernetes.io/docs/concepts/overview/working-with-objects/names/#names */
  name: Option[String] = None,
  /* Specify whether the ConfigMap or its key must be defined */
  optional: Option[Boolean] = None
) extends ApiModel

