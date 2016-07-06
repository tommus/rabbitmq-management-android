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
package com.todev.rabbitmqmanagement.models.queues;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todev.rabbitmqmanagement.models.Details;
import com.todev.rabbitmqmanagement.models.MessageStats;
import com.todev.rabbitmqmanagement.models.definitions.Policy;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtendedQueue extends Queue {

    @JsonProperty("backing_queue_status")
    protected BackingQueueStatus mBackingQueueStatus;

    @JsonProperty("consumer_utilisation")
    protected Object mConsumerUtilisation;

    @JsonProperty("consumers")
    protected int mConsumers;

    @JsonProperty("disk_reads")
    protected int mDiskReads;

    @JsonProperty("disk_writes")
    protected int mDiskWrites;

    @JsonProperty("exclusive")
    protected boolean mExclusive;

    @JsonProperty("exclusive_consumer_tag")
    protected Object mExclusiveConsumerTag;

    @JsonProperty("head_message_timestamp")
    protected Object mHeadMessageTimestamp;

    @JsonProperty("idle_since")
    protected String mIdleSince;

    @JsonProperty("memory")
    protected long mMemory;

    @JsonProperty("message_bytes")
    protected long mMessageBytes;

    @JsonProperty("message_bytes_persistent")
    protected long mMessageBytesPersistent;

    @JsonProperty("message_bytes_ram")
    protected long mMessageBytesRam;

    @JsonProperty("message_bytes_ready")
    protected long mMessageBytesReady;

    @JsonProperty("message_bytes_unacknowledged")
    protected long mMessageBytesUnacknowledged;

    @JsonProperty("message_stats")
    protected MessageStats mMessageStats;

    @JsonProperty("messages")
    protected int mMessages;

    @JsonProperty("messages_details")
    protected Details mMessagesDetails;

    @JsonProperty("messages_persistent")
    protected int mMessagesPersistent;

    @JsonProperty("messages_ram")
    protected long mMessagesRam;

    @JsonProperty("messages_ready")
    protected int mMessagesReady;

    @JsonProperty("messages_ready_details")
    protected Details mMessagesReadyDetails;

    @JsonProperty("messages_ready_ram")
    protected long mMessagesReadyRam;

    @JsonProperty("messages_unacknowledged")
    protected int mMessagesUnacknowledged;

    @JsonProperty("messages_unacknowledged_details")
    protected Details mMessagesUnacknowledgedDetails;

    @JsonProperty("messages_unacknowledged_ram")
    protected long mMessagesUnacknowledgedRam;

    @JsonProperty("node")
    protected String mNode;

    @JsonProperty("policy")
    protected Policy mPolicy;

    @JsonProperty("recoverable_slaves")
    protected Object mRecoverableSlaves;

    @JsonProperty("state")
    protected String mState;

    @JsonProperty("vhost")
    protected String mVhost;

    public BackingQueueStatus getBackingQueueStatus() {

        return mBackingQueueStatus;
    }

    public Object getConsumerUtilisation() {

        return mConsumerUtilisation;
    }

    public int getConsumers() {

        return mConsumers;
    }

    public int getDiskReads() {

        return mDiskReads;
    }

    public int getDiskWrites() {

        return mDiskWrites;
    }

    public boolean isExclusive() {

        return mExclusive;
    }

    public Object getExclusiveConsumerTag() {

        return mExclusiveConsumerTag;
    }

    public Object getHeadMessageTimestamp() {

        return mHeadMessageTimestamp;
    }

    public String getIdleSince() {

        return mIdleSince;
    }

    public long getMemory() {

        return mMemory;
    }

    public long getMessageBytes() {

        return mMessageBytes;
    }

    public long getMessageBytesPersistent() {

        return mMessageBytesPersistent;
    }

    public long getMessageBytesRam() {

        return mMessageBytesRam;
    }

    public long getMessageBytesReady() {

        return mMessageBytesReady;
    }

    public long getMessageBytesUnacknowledged() {

        return mMessageBytesUnacknowledged;
    }

    public MessageStats getMessageStats() {

        return mMessageStats;
    }

    public int getMessages() {

        return mMessages;
    }

    public Details getMessagesDetails() {

        return mMessagesDetails;
    }

    public int getMessagesPersistent() {

        return mMessagesPersistent;
    }

    public long getMessagesRam() {

        return mMessagesRam;
    }

    public int getMessagesReady() {

        return mMessagesReady;
    }

    public Details getMessagesReadyDetails() {

        return mMessagesReadyDetails;
    }

    public long getMessagesReadyRam() {

        return mMessagesReadyRam;
    }

    public int getMessagesUnacknowledged() {

        return mMessagesUnacknowledged;
    }

    public Details getMessagesUnacknowledgedDetails() {

        return mMessagesUnacknowledgedDetails;
    }

    public long getMessagesUnacknowledgedRam() {

        return mMessagesUnacknowledgedRam;
    }

    public String getNode() {

        return mNode;
    }

    public Policy getPolicy() {

        return mPolicy;
    }

    public Object getRecoverableSlaves() {

        return mRecoverableSlaves;
    }

    public String getState() {

        return mState;
    }

    public String getVhost() {

        return mVhost;
    }
}
