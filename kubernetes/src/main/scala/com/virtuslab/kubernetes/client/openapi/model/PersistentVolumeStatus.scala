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

import com.virtuslab.kubernetes.client.openapi.core.ApiModel

/**
  * PersistentVolumeStatus is the current status of a persistent volume.
  */
case class PersistentVolumeStatus(
    /* A human-readable message indicating details about why the volume is in this state. */
    message: Option[String] = None,
    /* Phase indicates if a volume is available, bound to a claim, or released by a claim. More info: https://kubernetes.io/docs/concepts/storage/persistent-volumes#phase */
    phase: Option[String] = None,
    /* Reason is a brief CamelCase string that describes any failure and is meant for machine parsing and tidy display in the CLI. */
    reason: Option[String] = None)
  extends ApiModel
