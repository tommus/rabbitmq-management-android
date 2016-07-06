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
package com.todev.rabbitmqmanagement.models.vhosts;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todev.rabbitmqmanagement.models.Details;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExtendedVhost extends Vhost {

    @JsonProperty("messages")
    protected int mMessages;

    @JsonProperty("messages_details")
    protected Details mMessagesDetails;

    @JsonProperty("messages_ready")
    protected int mMessagesReady;

    @JsonProperty("messages_ready_details")
    protected Details mMessagesReadyDetails;

    @JsonProperty("messages_unacknowledged")
    protected int mMessagesUnacknowledged;

    @JsonProperty("messages_unacknowledged_details")
    protected Details mMessagesUnacknowledgedDetails;

    @JsonProperty("tracing")
    protected boolean mTracing;

    public int getMessages() {

        return mMessages;
    }

    public Details getMessagesDetails() {

        return mMessagesDetails;
    }

    public int getMessagesReady() {

        return mMessagesReady;
    }

    public Details getMessagesReadyDetails() {

        return mMessagesReadyDetails;
    }

    public int getMessagesUnacknowledged() {

        return mMessagesUnacknowledged;
    }

    public Details getMessagesUnacknowledgedDetails() {

        return mMessagesUnacknowledgedDetails;
    }

    public boolean isTracing() {

        return mTracing;
    }
}
