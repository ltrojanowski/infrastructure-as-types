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
  * PodPresetSpec is a description of a pod preset.
  */
case class PodPresetSpec(
    /* Env defines the collection of EnvVar to inject into containers. */
    env: Option[Seq[EnvVar]] = None,
    /* EnvFrom defines the collection of EnvFromSource to inject into containers. */
    envFrom: Option[Seq[EnvFromSource]] = None,
    selector: Option[LabelSelector] = None,
    /* VolumeMounts defines the collection of VolumeMount to inject into containers. */
    volumeMounts: Option[Seq[VolumeMount]] = None,
    /* Volumes defines the collection of Volume to inject into the pod. */
    volumes: Option[Seq[Volume]] = None)
  extends ApiModel
