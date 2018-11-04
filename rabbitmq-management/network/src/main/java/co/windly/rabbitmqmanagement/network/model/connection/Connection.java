package co.windly.rabbitmqmanagement.network.model.connection;

import co.windly.rabbitmqmanagement.network.model.Details;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Connection {

  //region Auth Mechanism

  @JsonProperty(value = "auth_mechanism")
  private String authMechanism;

  public String getAuthMechanism() {
    return authMechanism;
  }

  public void setAuthMechanism(String authMechanism) {
    this.authMechanism = authMechanism;
  }

  //endregion

  //region Channel Max

  @JsonProperty(value = "channel_max")
  private int channelMax;

  public int getChannelMax() {
    return channelMax;
  }

  public void setChannelMax(int channelMax) {
    this.channelMax = channelMax;
  }

  //endregion

  //region Channels

  @JsonProperty(value = "channels")
  private int channels;

  public int getChannels() {
    return channels;
  }

  public void setChannels(int channels) {
    this.channels = channels;
  }

  //endregion

  //region Client Properties

  @JsonProperty(value = "client_properties")
  private ClientProperties clientProperties;

  public ClientProperties getClientProperties() {
    return clientProperties;
  }

  public void setClientProperties(ClientProperties clientProperties) {
    this.clientProperties = clientProperties;
  }

  //endregion

  //region Connected At

  @JsonProperty(value = "connected_at")
  private long connectedAt;

  public long getConnectedAt() {
    return connectedAt;
  }

  public void setConnectedAt(long connectedAt) {
    this.connectedAt = connectedAt;
  }

  //endregion

  //region Frame Max

  @JsonProperty(value = "frame_max")
  private int frameMax;

  public int getFrameMax() {
    return frameMax;
  }

  public void setFrameMax(int frameMax) {
    this.frameMax = frameMax;
  }

  //endregion

  //region Host

  @JsonProperty(value = "host")
  private String host;

  public String getHost() {
    return host;
  }

  public void setHost(String host) {
    this.host = host;
  }

  //endregion

  //region Name

  @JsonProperty(value = "name")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  //endregion

  //region Node

  @JsonProperty(value = "node")
  private String node;

  public String getNode() {
    return node;
  }

  public void setNode(String node) {
    this.node = node;
  }

  //endregion

  //region Peer Cart Issuer

  @JsonProperty(value = "peer_cert_issuer")
  private Object peerCertIssuer;

  public Object getPeerCertIssuer() {
    return peerCertIssuer;
  }

  public void setPeerCertIssuer(Object peerCertIssuer) {
    this.peerCertIssuer = peerCertIssuer;
  }

  //endregion

  //region Peer Cert Subject

  @JsonProperty(value = "peer_cert_subject")
  private Object peerCertSubject;

  public Object getPeerCertSubject() {
    return peerCertSubject;
  }

  public void setPeerCertSubject(Object peerCertSubject) {
    this.peerCertSubject = peerCertSubject;
  }

  //endregion

  //region Peer Cert Validity

  @JsonProperty(value = "peer_cert_validity")
  private Object peerCertValidity;

  public Object getPeerCertValidity() {
    return peerCertValidity;
  }

  public void setPeerCertValidity(Object peerCertValidity) {
    this.peerCertValidity = peerCertValidity;
  }

  //endregion

  //region Peer Host

  @JsonProperty(value = "peer_host")
  private String peerHost;

  public String getPeerHost() {
    return peerHost;
  }

  public void setPeerHost(String peerHost) {
    this.peerHost = peerHost;
  }

  //endregion

  //region Peer Port

  @JsonProperty(value = "peer_port")
  private int peerPort;

  public int getPeerPort() {
    return peerPort;
  }

  public void setPeerPort(int peerPort) {
    this.peerPort = peerPort;
  }

  //endregion

  //region Port

  @JsonProperty(value = "port")
  private int port;

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  //endregion

  //region Protocol

  @JsonProperty(value = "protocol")
  private String protocol;

  public String getProtocol() {
    return protocol;
  }

  public void setProtocol(String protocol) {
    this.protocol = protocol;
  }

  //endregion

  //region Rect Cnt

  @JsonProperty(value = "recv_cnt")
  private int recvCnt;

  public int getRecvCnt() {
    return recvCnt;
  }

  public void setRecvCnt(int recvCnt) {
    this.recvCnt = recvCnt;
  }

  //endregion

  //region Rect Oct

  @JsonProperty(value = "recv_oct")
  private int recvOct;

  public int getRecvOct() {
    return recvOct;
  }

  public void setRecvOct(int recvOct) {
    this.recvOct = recvOct;
  }

  //endregion

  //region Rect Oct Details

  @JsonProperty(value = "recv_oct_details")
  private Details recvOctDetails;

  public Details getRecvOctDetails() {
    return recvOctDetails;
  }

  public void setRecvOctDetails(Details recvOctDetails) {
    this.recvOctDetails = recvOctDetails;
  }

  //endregion

  //region Reductions

  @JsonProperty(value = "reductions")
  private long reductions;

  public long getReductions() {
    return reductions;
  }

  public void setReductions(long reductions) {
    this.reductions = reductions;
  }

  //endregion

  //region Reductions Details

  @JsonProperty(value = "reductions_details")
  private Details reductionsDetails;

  public Details getReductionsDetails() {
    return reductionsDetails;
  }

  public void setReductionsDetails(Details reductionsDetails) {
    this.reductionsDetails = reductionsDetails;
  }

  //endregion

  //region Send Cnt

  @JsonProperty(value = "send_cnt")
  private int sendCnt;

  public int getSendCnt() {
    return sendCnt;
  }

  public void setSendCnt(int sendCnt) {
    this.sendCnt = sendCnt;
  }

  //endregion

  //region Send Oct

  @JsonProperty(value = "send_oct")
  private int sendOct;

  public int getSendOct() {
    return sendOct;
  }

  public void setSendOct(int sendOct) {
    this.sendOct = sendOct;
  }

  //endregion

  //region Send Oct Details

  @JsonProperty(value = "send_oct_details")
  private Details sendOctDetails;

  public Details getSendOctDetails() {
    return sendOctDetails;
  }

  public void setSendOctDetails(Details sendOctDetails) {
    this.sendOctDetails = sendOctDetails;
  }

  //endregion

  //region Send Pend

  @JsonProperty(value = "send_pend")
  private int sendPend;

  public int getSendPend() {
    return sendPend;
  }

  public void setSendPend(int sendPend) {
    this.sendPend = sendPend;
  }

  //endregion

  //region Ssl

  @JsonProperty(value = "ssl")
  private boolean ssl;

  public boolean isSsl() {
    return ssl;
  }

  public void setSsl(boolean ssl) {
    this.ssl = ssl;
  }

  //endregion

  //region Ssl Cipher

  @JsonProperty(value = "ssl_cipher")
  private Object sslCipher;

  public Object getSslCipher() {
    return sslCipher;
  }

  public void setSslCipher(Object sslCipher) {
    this.sslCipher = sslCipher;
  }

  //endregion

  //region Ssl Hash

  @JsonProperty(value = "ssl_hash")
  private Object sslHash;

  public Object getSslHash() {
    return sslHash;
  }

  public void setSslHash(Object sslHash) {
    this.sslHash = sslHash;
  }

  //endregion

  //region Ssl Key Exchange

  @JsonProperty(value = "ssl_key_exchange")
  private Object sslKeyExchange;

  public Object getSslKeyExchange() {
    return sslKeyExchange;
  }

  public void setSslKeyExchange(Object sslKeyExchange) {
    this.sslKeyExchange = sslKeyExchange;
  }

  //endregion

  //region Ssl Protocol

  @JsonProperty(value = "ssl_protocol")
  private Object sslProtocol;

  public Object getSslProtocol() {
    return sslProtocol;
  }

  public void setSslProtocol(Object sslProtocol) {
    this.sslProtocol = sslProtocol;
  }

  //endregion

  //region State

  @JsonProperty(value = "state")
  private String state;

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  //endregion

  //region Timeout

  @JsonProperty(value = "timeout")
  private int timeout;

  public int getTimeout() {
    return timeout;
  }

  public void setTimeout(int timeout) {
    this.timeout = timeout;
  }

  //endregion

  //region Type

  @JsonProperty(value = "type")
  private String type;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  //endregion

  //region UserDto

  @JsonProperty(value = "user")
  private String user;

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  //endregion

  //region Vhost

  @JsonProperty(value = "vhost")
  private String vhost;

  public String getVhost() {
    return vhost;
  }

  public void setVhost(String vhost) {
    this.vhost = vhost;
  }

  //endregion
}
