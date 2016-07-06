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
package com.todev.rabbitmqmanagement.models.exchanges;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todev.rabbitmqmanagement.models.Arguments;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Exchange {

    @JsonProperty("arguments")
    protected Arguments mArguments;

    @JsonProperty("auto_delete")
    protected boolean mAutoDelete;

    @JsonProperty("durable")
    protected boolean mDurable;

    @JsonProperty("internal")
    protected boolean mInternal;

    @JsonProperty("name")
    protected String mName;

    @JsonProperty("type")
    protected String mType;

    public Arguments getArguments() {

        return mArguments;
    }

    public boolean isAutoDelete() {

        return mAutoDelete;
    }

    public boolean isDurable() {

        return mDurable;
    }

    public boolean isInternal() {

        return mInternal;
    }

    public String getName() {

        return mName;
    }

    public String getType() {

        return mType;
    }
}
