/*
 * Copyright (c) 2016. to-dev.com.
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

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Connection {

    @JsonProperty("auth_mechanism")
    protected String mAuthMechanism;

    @JsonProperty("channel_max")
    protected int mChannelMax;

    @JsonProperty("channels")
    protected int mChannels;

    @JsonProperty("client_properties")
    protected ClientProperties mClientProperties;

    @JsonProperty("connected_at")
    protected long mConnectedAt;

    @JsonProperty("frame_max")
    protected int mFrameMax;

    @JsonProperty("host")
    protected String mHost;

    @JsonProperty("name")
    protected String mName;

    @JsonProperty("node")
    protected String mNode;

    @JsonProperty("peer_cert_issuer")
    protected Object mPeerCertIssuer;

    @JsonProperty("peer_cert_subject")
    protected Object mPeerCertSubject;

    @JsonProperty("peer_cert_validity")
    protected Object mPeerCertValidity;

    @JsonProperty("peer_host")
    protected String mPeerHost;

    @JsonProperty("peer_port")
    protected int mPeerPort;

    @JsonProperty("port")
    protected int mPort;

    @JsonProperty("protocol")
    protected String mProtocol;

    @JsonProperty("recv_cnt")
    protected int mRecvCnt;

    @JsonProperty("recv_oct")
    protected int mRecvOct;

    @JsonProperty("recv_oct_details")
    protected Details mRecvOctDetails;

    @JsonProperty("send_cnt")
    protected int mSendCnt;

    @JsonProperty("send_oct")
    protected int mSendOct;

    @JsonProperty("send_oct_details")
    protected Details mSendOctDetails;

    @JsonProperty("send_pend")
    protected int mSendPend;

    @JsonProperty("ssl")
    protected boolean mSsl;

    @JsonProperty("ssl_cipher")
    protected Object mSslCipher;

    @JsonProperty("ssl_hash")
    protected Object mSslHash;

    @JsonProperty("ssl_key_exchange")
    protected Object mSslKeyExchange;

    @JsonProperty("ssl_protocol")
    protected Object mSslProtocol;

    @JsonProperty("state")
    protected String mState;

    @JsonProperty("timeout")
    protected int mTimeout;

    @JsonProperty("type")
    protected String mType;

    @JsonProperty("user")
    protected String mUser;

    @JsonProperty("vhost")
    protected String mVhost;

    public String getAuthMechanism() {

        return mAuthMechanism;
    }

    public int getChannelMax() {

        return mChannelMax;
    }

    public int getChannels() {

        return mChannels;
    }

    public ClientProperties getClientProperties() {

        return mClientProperties;
    }

    public long getConnectedAt() {

        return mConnectedAt;
    }

    public int getFrameMax() {

        return mFrameMax;
    }

    public String getHost() {

        return mHost;
    }

    public String getName() {

        return mName;
    }

    public String getNode() {

        return mNode;
    }

    public Object getPeerCertIssuer() {

        return mPeerCertIssuer;
    }

    public Object getPeerCertSubject() {

        return mPeerCertSubject;
    }

    public Object getPeerCertValidity() {

        return mPeerCertValidity;
    }

    public String getPeerHost() {

        return mPeerHost;
    }

    public int getPeerPort() {

        return mPeerPort;
    }

    public int getPort() {

        return mPort;
    }

    public String getProtocol() {

        return mProtocol;
    }

    public int getRecvCnt() {

        return mRecvCnt;
    }

    public int getRecvOct() {

        return mRecvOct;
    }

    public Details getRecvOctDetails() {

        return mRecvOctDetails;
    }

    public int getSendCnt() {

        return mSendCnt;
    }

    public int getSendOct() {

        return mSendOct;
    }

    public Details getSendOctDetails() {

        return mSendOctDetails;
    }

    public int getSendPend() {

        return mSendPend;
    }

    public boolean isSsl() {

        return mSsl;
    }

    public Object getSslCipher() {

        return mSslCipher;
    }

    public Object getSslHash() {

        return mSslHash;
    }

    public Object getSslKeyExchange() {

        return mSslKeyExchange;
    }

    public Object getSslProtocol() {

        return mSslProtocol;
    }

    public String getState() {

        return mState;
    }

    public int getTimeout() {

        return mTimeout;
    }

    public String getType() {

        return mType;
    }

    public String getUser() {

        return mUser;
    }

    public String getVhost() {

        return mVhost;
    }
}
