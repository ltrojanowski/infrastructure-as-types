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

case class V1CSIPersistentVolumeSource (
  controllerExpandSecretRef: Option[V1SecretReference] = None,
  controllerPublishSecretRef: Option[V1SecretReference] = None,
  /* Driver is the name of the driver to use for this volume. Required. */
  driver: String,
  /* Filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. \"ext4\", \"xfs\", \"ntfs\". */
  fsType: Option[String] = None,
  nodePublishSecretRef: Option[V1SecretReference] = None,
  nodeStageSecretRef: Option[V1SecretReference] = None,
  /* Optional: The value to pass to ControllerPublishVolumeRequest. Defaults to false (read/write). */
  readOnly: Option[Boolean] = None,
  /* Attributes of the volume to publish. */
  volumeAttributes: Option[Map[String, String]] = None,
  /* VolumeHandle is the unique volume name returned by the CSI volume plugin’s CreateVolume to refer to the volume on all subsequent calls. Required. */
  volumeHandle: String
) extends ApiModel

