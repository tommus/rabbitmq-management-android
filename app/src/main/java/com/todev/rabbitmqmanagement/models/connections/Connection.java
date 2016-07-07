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
package com.todev.rabbitmqmanagement.models.connections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todev.rabbitmqmanagement.models.Details;

@JsonIgnoreProperties(ignoreUnknown = true) @JsonInclude(JsonInclude.Include.NON_NULL)
public class Connection {

  @JsonProperty("auth_mechanism") protected String authMechanism;

  @JsonProperty("channel_max") protected int channelMax;

  @JsonProperty("channels") protected int channels;

  @JsonProperty("client_properties") protected ClientProperties clientProperties;

  @JsonProperty("connected_at") protected long connectedAt;

  @JsonProperty("frame_max") protected int frameMax;

  @JsonProperty("host") protected String host;

  @JsonProperty("name") protected String name;

  @JsonProperty("node") protected String node;

  @JsonProperty("peer_cert_issuer") protected Object peerCertIssuer;

  @JsonProperty("peer_cert_subject") protected Object peerCertSubject;

  @JsonProperty("peer_cert_validity") protected Object peerCertValidity;

  @JsonProperty("peer_host") protected String peerHost;

  @JsonProperty("peer_port") protected int peerPort;

  @JsonProperty("port") protected int port;

  @JsonProperty("protocol") protected String protocol;

  @JsonProperty("recv_cnt") protected int recvCnt;

  @JsonProperty("recv_oct") protected int recvOct;

  @JsonProperty("recv_oct_details") protected Details recvOctDetails;

  @JsonProperty("send_cnt") protected int sendCnt;

  @JsonProperty("send_oct") protected int sendOct;

  @JsonProperty("send_oct_details") protected Details sendOctDetails;

  @JsonProperty("send_pend") protected int sendPend;

  @JsonProperty("ssl") protected boolean ssl;

  @JsonProperty("ssl_cipher") protected Object sslCipher;

  @JsonProperty("ssl_hash") protected Object sslHash;

  @JsonProperty("ssl_key_exchange") protected Object sslKeyExchange;

  @JsonProperty("ssl_protocol") protected Object sslProtocol;

  @JsonProperty("state") protected String state;

  @JsonProperty("timeout") protected int timeout;

  @JsonProperty("type") protected String type;

  @JsonProperty("user") protected String user;

  @JsonProperty("vhost") protected String vhost;

  public String getAuthMechanism() {
    return authMechanism;
  }

  public int getChannelMax() {
    return channelMax;
  }

  public int getChannels() {
    return channels;
  }

  public ClientProperties getClientProperties() {
    return clientProperties;
  }

  public long getConnectedAt() {
    return connectedAt;
  }

  public int getFrameMax() {
    return frameMax;
  }

  public String getHost() {
    return host;
  }

  public String getName() {
    return name;
  }

  public String getNode() {
    return node;
  }

  public Object getPeerCertIssuer() {
    return peerCertIssuer;
  }

  public Object getPeerCertSubject() {
    return peerCertSubject;
  }

  public Object getPeerCertValidity() {
    return peerCertValidity;
  }

  public String getPeerHost() {
    return peerHost;
  }

  public int getPeerPort() {
    return peerPort;
  }

  public int getPort() {
    return port;
  }

  public String getProtocol() {
    return protocol;
  }

  public int getRecvCnt() {
    return recvCnt;
  }

  public int getRecvOct() {
    return recvOct;
  }

  public Details getRecvOctDetails() {
    return recvOctDetails;
  }

  public int getSendCnt() {
    return sendCnt;
  }

  public int getSendOct() {
    return sendOct;
  }

  public Details getSendOctDetails() {
    return sendOctDetails;
  }

  public int getSendPend() {
    return sendPend;
  }

  public boolean isSsl() {
    return ssl;
  }

  public Object getSslCipher() {
    return sslCipher;
  }

  public Object getSslHash() {
    return sslHash;
  }

  public Object getSslKeyExchange() {
    return sslKeyExchange;
  }

  public Object getSslProtocol() {
    return sslProtocol;
  }

  public String getState() {
    return state;
  }

  public int getTimeout() {
    return timeout;
  }

  public String getType() {
    return type;
  }

  public String getUser() {
    return user;
  }

  public String getVhost() {
    return vhost;
  }
}
