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
package com.todev.rabbitmqmanagement.models.channels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todev.rabbitmqmanagement.models.MessageStats;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Channel {

    @JsonProperty("acks_uncommitted")
    protected int mAcksUncommitted;

    @JsonProperty("confirm")
    protected boolean mConfirm;

    @JsonProperty("connection_details")
    protected ChannelDetails mConnectionDetails;

    @JsonProperty("consumer_count")
    protected int mConsumerCount;

    @JsonProperty("global_prefetch_count")
    protected int mGlobalPrefetchCount;

    @JsonProperty("idle_since")
    protected String mIdleSince;

    @JsonProperty("message_stats")
    protected MessageStats mMessageStats;

    @JsonProperty("messages_unacknowledged")
    protected int mMessagesUnacknowledged;

    @JsonProperty("messages_uncommitted")
    protected int mMessagesUncommitted;

    @JsonProperty("messages_unconfirmed")
    protected int mMessagesUnconfirmed;

    @JsonProperty("name")
    protected String mName;

    @JsonProperty("node")
    protected String mNode;

    @JsonProperty("number")
    protected int mNumber;

    @JsonProperty("prefetch_count")
    protected int mPrefetchCount;

    @JsonProperty("state")
    protected String mState;

    @JsonProperty("transactional")
    protected boolean mTransactional;

    @JsonProperty("user")
    protected String mUser;

    @JsonProperty("vhost")
    protected String mVhost;

    public int getAcksUncommitted() {

        return mAcksUncommitted;
    }

    public boolean isConfirm() {

        return mConfirm;
    }

    public ChannelDetails getConnectionDetails() {

        return mConnectionDetails;
    }

    public int getConsumerCount() {

        return mConsumerCount;
    }

    public int getGlobalPrefetchCount() {

        return mGlobalPrefetchCount;
    }

    public String getIdleSince() {

        return mIdleSince;
    }

    public MessageStats getMessageStats() {

        return mMessageStats;
    }

    public int getMessagesUnacknowledged() {

        return mMessagesUnacknowledged;
    }

    public int getMessagesUncommitted() {

        return mMessagesUncommitted;
    }

    public int getMessagesUnconfirmed() {

        return mMessagesUnconfirmed;
    }

    public String getName() {

        return mName;
    }

    public String getNode() {

        return mNode;
    }

    public int getNumber() {

        return mNumber;
    }

    public int getPrefetchCount() {

        return mPrefetchCount;
    }

    public String getState() {

        return mState;
    }

    public boolean isTransactional() {

        return mTransactional;
    }

    public String getUser() {

        return mUser;
    }

    public String getVhost() {

        return mVhost;
    }
}
