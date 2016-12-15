/*
 * Copyright (c) 2016 to-dev.com.
 *
 * Licensed under the GNU GPL, Version 3 (the "License").
 * You may not use this file except in compliance with the License.
 *
 * You may obtain a copy of the License at
 *
 *       https://www.gnu.org/licenses/gpl-3.0.html
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS
 * OF ANY KIND, either express or implied.
 *
 * See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.todev.rabbitmqmanagement.data.network.model.connection;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todev.rabbitmqmanagement.data.network.model.Details;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Getter
public class Connection {

  @JsonProperty(value = "auth_mechanism")
  protected String authMechanism;

  @JsonProperty(value = "channel_max")
  protected int channelMax;

  @JsonProperty(value = "channels")
  protected int channels;

  @JsonProperty(value = "client_properties")
  protected ClientProperties clientProperties;

  @JsonProperty(value = "connected_at")
  protected long connectedAt;

  @JsonProperty(value = "frame_max")
  protected int frameMax;

  @JsonProperty(value = "host")
  protected String host;

  @JsonProperty(value = "name")
  protected String name;

  @JsonProperty(value = "node")
  protected String node;

  @JsonProperty(value = "peer_cert_issuer")
  protected Object peerCertIssuer;

  @JsonProperty(value = "peer_cert_subject")
  protected Object peerCertSubject;

  @JsonProperty(value = "peer_cert_validity")
  protected Object peerCertValidity;

  @JsonProperty(value = "peer_host")
  protected String peerHost;

  @JsonProperty(value = "peer_port")
  protected int peerPort;

  @JsonProperty(value = "port")
  protected int port;

  @JsonProperty(value = "protocol")
  protected String protocol;

  @JsonProperty(value = "recv_cnt")
  protected int recvCnt;

  @JsonProperty(value = "recv_oct")
  protected int recvOct;

  @JsonProperty(value = "recv_oct_details")
  protected Details recvOctDetails;

  @JsonProperty(value = "send_cnt")
  protected int sendCnt;

  @JsonProperty(value = "send_oct")
  protected int sendOct;

  @JsonProperty(value = "send_oct_details")
  protected Details sendOctDetails;

  @JsonProperty(value = "send_pend")
  protected int sendPend;

  @JsonProperty(value = "ssl")
  protected boolean ssl;

  @JsonProperty(value = "ssl_cipher")
  protected Object sslCipher;

  @JsonProperty(value = "ssl_hash")
  protected Object sslHash;

  @JsonProperty(value = "ssl_key_exchange")
  protected Object sslKeyExchange;

  @JsonProperty(value = "ssl_protocol")
  protected Object sslProtocol;

  @JsonProperty(value = "state")
  protected String state;

  @JsonProperty(value = "timeout")
  protected int timeout;

  @JsonProperty(value = "type")
  protected String type;

  @JsonProperty(value = "user")
  protected String user;

  @JsonProperty(value = "vhost")
  protected String vhost;
}
