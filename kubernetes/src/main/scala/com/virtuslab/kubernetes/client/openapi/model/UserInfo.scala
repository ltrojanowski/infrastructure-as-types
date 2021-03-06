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
  * UserInfo holds the information about the user needed to implement the user.Info interface.
  */
case class UserInfo(
    /* Any additional information provided by the authenticator. */
    extra: Option[Map[String, Seq[String]]] = None,
    /* The names of groups this user is a part of. */
    groups: Option[Seq[String]] = None,
    /* A unique value that identifies this user across time. If this user is deleted and another user by the same name is added, they will have different UIDs. */
    uid: Option[String] = None,
    /* The name that uniquely identifies this user among all active users. */
    username: Option[String] = None)
  extends ApiModel
