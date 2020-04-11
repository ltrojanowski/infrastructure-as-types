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
  * FlexPersistentVolumeSource represents a generic persistent volume resource that is provisioned/attached using an exec based plugin.
  */
case class FlexPersistentVolumeSource(
    /* Driver is the name of the driver to use for this volume. */
    driver: String,
    /* Filesystem type to mount. Must be a filesystem type supported by the host operating system. Ex. \"ext4\", \"xfs\", \"ntfs\". The default filesystem depends on FlexVolume script. */
    fsType: Option[String] = None,
    /* Optional: Extra command options if any. */
    options: Option[Map[String, String]] = None,
    /* Optional: Defaults to false (read/write). ReadOnly here will force the ReadOnly setting in VolumeMounts. */
    readOnly: Option[Boolean] = None,
    secretRef: Option[SecretReference] = None)
  extends ApiModel