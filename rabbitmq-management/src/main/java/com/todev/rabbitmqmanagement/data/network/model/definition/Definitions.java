/*
 * Copyright (c) 2016 to-dev.com.
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
package com.todev.rabbitmqmanagement.data.network.model.definition;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todev.rabbitmqmanagement.data.network.model.binding.Binding;
import com.todev.rabbitmqmanagement.data.network.model.exchange.Exchange;
import com.todev.rabbitmqmanagement.data.network.model.permission.Permission;
import com.todev.rabbitmqmanagement.data.network.model.policy.Policy;
import com.todev.rabbitmqmanagement.data.network.model.queue.Queue;
import com.todev.rabbitmqmanagement.data.network.model.user.ExtendedUser;
import com.todev.rabbitmqmanagement.data.network.model.vhost.Vhost;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Getter
public class Definitions {

  @JsonProperty(value = "bindings")
  protected List<Binding> bindings = new ArrayList<>();

  @JsonProperty(value = "exchanges")
  protected List<Exchange> exchanges = new ArrayList<>();

  // TODO: Parameters should be corrected.

  @JsonProperty(value = "parameters")
  protected List<Object> parameters = new ArrayList<>();

  @JsonProperty(value = "permissions")
  protected List<Permission> permissions = new ArrayList<>();

  @JsonProperty(value = "policies")
  protected List<Policy> policies = new ArrayList<>();

  @JsonProperty(value = "queues")
  protected List<Queue> queues = new ArrayList<>();

  @JsonProperty(value = "rabbit_version")
  protected String rabbitVersion;

  @JsonProperty(value = "users")
  protected List<ExtendedUser> users = new ArrayList<>();

  @JsonProperty(value = "vhosts")
  protected List<Vhost> vhosts = new ArrayList<>();
}
