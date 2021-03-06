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
  * LoadBalancerStatus represents the status of a load-balancer.
  */
case class LoadBalancerStatus(
    /* Ingress is a list containing ingress points for the load-balancer. Traffic intended for the service should be sent to these ingress points. */
    ingress: Option[Seq[LoadBalancerIngress]] = None)
  extends ApiModel
