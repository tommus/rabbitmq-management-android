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
package com.todev.rabbitmqmanagement.models.overview;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ObjectTotals {

    @JsonProperty("channels")
    protected int mChannels;

    @JsonProperty("connections")
    protected int mConnections;

    @JsonProperty("consumers")
    protected int mConsumers;

    @JsonProperty("exchanges")
    protected int mExchanges;

    @JsonProperty("queues")
    protected int mQueues;

    public int getChannels() {

        return mChannels;
    }

    public int getConnections() {

        return mConnections;
    }

    public int getConsumers() {

        return mConsumers;
    }

    public int getExchanges() {

        return mExchanges;
    }

    public int getQueues() {

        return mQueues;
    }
}
