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
package com.todev.rabbitmqmanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Tomasz Dzieniak
 * @since 09.06.16.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MessageStats {

    @JsonProperty("ack")
    protected int mAck;

    @JsonProperty("ack_details")
    protected Details mAckDetails;

    @JsonProperty("confirm")
    protected int mConfirm;

    @JsonProperty("confirm_details")
    protected Details mConfirmDetails;

    @JsonProperty("deliver_get")
    protected int mDeliverGet;

    @JsonProperty("deliver_get_details")
    protected Details mDeliverGetDetails;

    @JsonProperty("publish")
    protected int mPublish;

    @JsonProperty("publish_details")
    protected Details mPublishDetails;

    @JsonProperty("publish_in")
    protected int mPublishIn;

    @JsonProperty("publish_in_details")
    protected Details mPublishInDetails;

    @JsonProperty("publish_out")
    protected int mPublishOut;

    @JsonProperty("publish_out_details")
    protected Details mPublishOutDetails;

    @JsonProperty("redeliver")
    protected int mRedeliver;

    @JsonProperty("redeliver_details")
    protected Details mRedeliverDetails;

    @JsonProperty("return_unroutable")
    protected int mReturnUnroutable;

    @JsonProperty("return_unroutable_details")
    protected Details mReturnUnroutableDetails;

    public int getAck() {

        return mAck;
    }

    public Details getAckDetails() {

        return mAckDetails;
    }

    public int getConfirm() {

        return mConfirm;
    }

    public Details getConfirmDetails() {

        return mConfirmDetails;
    }

    public int getDeliverGet() {

        return mDeliverGet;
    }

    public Details getDeliverGetDetails() {

        return mDeliverGetDetails;
    }

    public int getPublish() {

        return mPublish;
    }

    public Details getPublishDetails() {

        return mPublishDetails;
    }

    public int getPublishIn() {

        return mPublishIn;
    }

    public Details getPublishInDetails() {

        return mPublishInDetails;
    }

    public int getPublishOut() {

        return mPublishOut;
    }

    public Details getPublishOutDetails() {

        return mPublishOutDetails;
    }

    public int getRedeliver() {

        return mRedeliver;
    }

    public Details getRedeliverDetails() {

        return mRedeliverDetails;
    }

    public int getReturnUnroutable() {

        return mReturnUnroutable;
    }

    public Details getReturnUnroutableDetails() {

        return mReturnUnroutableDetails;
    }
}
