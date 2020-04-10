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
   * ResourceQuotaStatus defines the enforced hard limits and observed use.
   */
case class ResourceQuotaStatus(
  /* Hard is the set of enforced hard limits for each named resource. More info: https://kubernetes.io/docs/concepts/policy/resource-quotas/ */
  hard: Option[Map[String, String]] = None,
  /* Used is the current observed total usage of the resource in the namespace. */
  used: Option[Map[String, String]] = None
) extends ApiModel

