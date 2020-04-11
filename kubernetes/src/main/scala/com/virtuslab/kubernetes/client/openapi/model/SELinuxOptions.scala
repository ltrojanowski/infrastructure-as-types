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
  * SELinuxOptions are the labels to be applied to the container
  */
case class SELinuxOptions(
    /* Level is SELinux level label that applies to the container. */
    level: Option[String] = None,
    /* Role is a SELinux role label that applies to the container. */
    role: Option[String] = None,
    /* Type is a SELinux type label that applies to the container. */
    `type`: Option[String] = None,
    /* User is a SELinux user label that applies to the container. */
    user: Option[String] = None)
  extends ApiModel