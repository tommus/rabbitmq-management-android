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
import com.todev.rabbitmqmanagement.models.bindings.Binding;
import com.todev.rabbitmqmanagement.models.exchanges.Exchange;
import com.todev.rabbitmqmanagement.models.queues.Queue;
import com.todev.rabbitmqmanagement.models.vhosts.Vhost;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Definitions {

    @JsonProperty("bindings")
    protected List<Binding> mBindings = new ArrayList<>();

    @JsonProperty("exchanges")
    protected List<Exchange> mExchanges = new ArrayList<>();

    // TODO: Parameters should be corrected.

    @JsonProperty("parameters")
    protected List<Object> mParameters = new ArrayList<>();

    @JsonProperty("permissions")
    protected List<Permission> mPermissions = new ArrayList<>();

    @JsonProperty("policies")
    protected List<Policy> mPolicies = new ArrayList<>();

    @JsonProperty("queues")
    protected List<Queue> mQueues = new ArrayList<>();

    @JsonProperty("rabbit_version")
    protected String mRabbitVersion;

    @JsonProperty("users")
    protected List<User> mUsers = new ArrayList<>();

    @JsonProperty("vhosts")
    protected List<Vhost> mVhosts = new ArrayList<>();

    public List<Binding> getBindings() {

        return mBindings;
    }

    public List<Exchange> getExchanges() {

        return mExchanges;
    }

    public List<Object> getParameters() {

        return mParameters;
    }

    public List<Permission> getPermissions() {

        return mPermissions;
    }

    public List<Policy> getPolicies() {

        return mPolicies;
    }

    public List<Queue> getQueues() {

        return mQueues;
    }

    public String getRabbitVersion() {

        return mRabbitVersion;
    }

    public List<User> getUsers() {

        return mUsers;
    }

    public List<Vhost> getVhosts() {

        return mVhosts;
    }
}
