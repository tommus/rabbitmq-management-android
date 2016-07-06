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
package com.todev.rabbitmqmanagement.models.definitions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Permission {

    @JsonProperty("configure")
    protected String mConfigure;

    @JsonProperty("read")
    protected String mRead;

    @JsonProperty("user")
    protected String mUser;

    @JsonProperty("vhost")
    protected String mVhost;

    @JsonProperty("write")
    protected String mWrite;

    public String getConfigure() {

        return mConfigure;
    }

    public String getRead() {

        return mRead;
    }

    public String getUser() {

        return mUser;
    }

    public String getVhost() {

        return mVhost;
    }

    public String getWrite() {

        return mWrite;
    }
}
