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

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BackingQueueStatus {

    @JsonProperty("avg_ack_egress_rate")
    protected float mAvgAckEgressRate;

    @JsonProperty("avg_ack_ingress_rate")
    protected float mAvgAckIngressRate;

    @JsonProperty("avg_egress_rate")
    protected float mAvgEgressRate;

    @JsonProperty("avg_ingress_rate")
    protected float mAvgIngressRate;

    @JsonProperty("delta")
    protected List<String> mDelta = new ArrayList<>();

    @JsonProperty("len")
    protected int mLen;

    @JsonProperty("mode")
    protected String mMode;

    @JsonProperty("next_seq_id")
    protected int mNextSeqId;

    @JsonProperty("q1")
    protected int mQ1;

    @JsonProperty("q2")
    protected int mQ2;

    @JsonProperty("q3")
    protected int mQ3;

    @JsonProperty("q4")
    protected int mQ4;

    @JsonProperty("target_ram_count")
    protected String mTargetRamCount;

    public float getAvgAckEgressRate() {

        return mAvgAckEgressRate;
    }

    public float getAvgAckIngressRate() {

        return mAvgAckIngressRate;
    }

    public float getAvgEgressRate() {

        return mAvgEgressRate;
    }

    public float getAvgIngressRate() {

        return mAvgIngressRate;
    }

    public List<String> getDelta() {

        return mDelta;
    }

    public int getLen() {

        return mLen;
    }

    public String getMode() {

        return mMode;
    }

    public int getNextSeqId() {

        return mNextSeqId;
    }

    public int getQ1() {

        return mQ1;
    }

    public int getQ2() {

        return mQ2;
    }

    public int getQ3() {

        return mQ3;
    }

    public int getQ4() {

        return mQ4;
    }

    public String getTargetRamCount() {

        return mTargetRamCount;
    }
}
