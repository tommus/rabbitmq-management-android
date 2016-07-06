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
import com.todev.rabbitmqmanagement.models.Description;
import com.todev.rabbitmqmanagement.models.MessageStats;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Overview {

    @JsonProperty("cluster_name")
    protected String mClusterName;

    @JsonProperty("contexts")
    protected List<OverviewContext> mContexts = new ArrayList<>();

    @JsonProperty("erlang_full_version")
    protected String mErlangFullVersion;

    @JsonProperty("erlang_version")
    protected String mErlangVersion;

    @JsonProperty("exchange_types")
    protected List<Description> mExchangeTypes = new ArrayList<>();

    @JsonProperty("listeners")
    protected List<Listener> mListeners = new ArrayList<>();

    @JsonProperty("management_version")
    protected String mManagementVersion;

    @JsonProperty("message_stats")
    protected MessageStats mMessageStats;

    @JsonProperty("node")
    protected String mNode;

    @JsonProperty("object_totals")
    protected ObjectTotals mObjectTotals;

    @JsonProperty("queue_totals")
    protected QueueTotals mQueueTotals;

    @JsonProperty("rabbitmq_version")
    protected String mRabbitmqVersion;

    @JsonProperty("rates_mode")
    protected String mRatesMode;

    @JsonProperty("statistics_db_event_queue")
    protected int mStatisticsDbEventQueue;

    @JsonProperty("statistics_db_node")
    protected String mStatisticsDbNode;

    public String getClusterName() {

        return mClusterName;
    }

    public List<OverviewContext> getContexts() {

        return mContexts;
    }

    public String getErlangFullVersion() {

        return mErlangFullVersion;
    }

    public String getErlangVersion() {

        return mErlangVersion;
    }

    public List<Description> getExchangeTypes() {

        return mExchangeTypes;
    }

    public List<Listener> getListeners() {

        return mListeners;
    }

    public String getManagementVersion() {

        return mManagementVersion;
    }

    public MessageStats getMessageStats() {

        return mMessageStats;
    }

    public String getNode() {

        return mNode;
    }

    public ObjectTotals getObjectTotals() {

        return mObjectTotals;
    }

    public QueueTotals getQueueTotals() {

        return mQueueTotals;
    }

    public String getRabbitmqVersion() {

        return mRabbitmqVersion;
    }

    public String getRatesMode() {

        return mRatesMode;
    }

    public Integer getStatisticsDbEventQueue() {

        return mStatisticsDbEventQueue;
    }

    public String getStatisticsDbNode() {

        return mStatisticsDbNode;
    }
}
