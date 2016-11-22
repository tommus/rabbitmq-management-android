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
package com.todev.rabbitmqmanagement.data.network;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.todev.rabbitmqmanagement.data.network.model.Check;
import com.todev.rabbitmqmanagement.data.network.model.binding.Binding;
import com.todev.rabbitmqmanagement.data.network.model.binding.ExtendedBinding;
import com.todev.rabbitmqmanagement.data.network.model.channel.Channel;
import com.todev.rabbitmqmanagement.data.network.model.cluster.Cluster;
import com.todev.rabbitmqmanagement.data.network.model.connection.Connection;
import com.todev.rabbitmqmanagement.data.network.model.consumer.Consumer;
import com.todev.rabbitmqmanagement.data.network.model.definition.Definitions;
import com.todev.rabbitmqmanagement.data.network.model.exchange.Exchange;
import com.todev.rabbitmqmanagement.data.network.model.exchange.ExtendedExchange;
import com.todev.rabbitmqmanagement.data.network.model.extension.Extension;
import com.todev.rabbitmqmanagement.data.network.model.message.Message;
import com.todev.rabbitmqmanagement.data.network.model.message.PublishBody;
import com.todev.rabbitmqmanagement.data.network.model.message.PublishResponse;
import com.todev.rabbitmqmanagement.data.network.model.message.Requirements;
import com.todev.rabbitmqmanagement.data.network.model.node.Node;
import com.todev.rabbitmqmanagement.data.network.model.overview.Overview;
import com.todev.rabbitmqmanagement.data.network.model.parameter.Parameter;
import com.todev.rabbitmqmanagement.data.network.model.parameter.PutParameter;
import com.todev.rabbitmqmanagement.data.network.model.permission.Permission;
import com.todev.rabbitmqmanagement.data.network.model.policy.Policy;
import com.todev.rabbitmqmanagement.data.network.model.queue.Action;
import com.todev.rabbitmqmanagement.data.network.model.queue.ExtendedQueue;
import com.todev.rabbitmqmanagement.data.network.model.queue.PutQueue;
import com.todev.rabbitmqmanagement.data.network.model.user.ExtendedUser;
import com.todev.rabbitmqmanagement.data.network.model.user.User;
import com.todev.rabbitmqmanagement.data.network.model.vhost.ExtendedVhost;
import io.reactivex.Observable;
import java.util.List;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RabbitMqService {

  @GET("api/overview")
  Observable<Overview> getOverview();

  @GET("api/cluster-name")
  Observable<Cluster> getClusterName();

  @PUT("api/cluster-name")
  Observable<Void> updateClusterName(@Body @NonNull Cluster cluster);

  @GET("api/nodes")
  Observable<List<Node>> getNodes();

  @GET("api/nodes/{name}")
  Observable<Node> getNode(@Path("name") @NonNull String name);

  @GET("api/extensions")
  Observable<List<Extension>> getExtensions();

  @GET("api/definitions")
  Observable<Definitions> getDefinitions();

  // TODO: Add POST /definitions.

  @GET("api/definitions/{vhost}")
  Observable<Definitions> getDefinitions(@Path("vhost") @NonNull String vhost);

  // TODO: Add POST /definitions/{vhost}.

  @GET("api/connections")
  Observable<List<Connection>> getConnections();

  @GET("api/vhosts/{vhost}/connections")
  Observable<List<Connection>> getConnections(@Path("vhost") @NonNull String vhost);

  @GET("api/connections/{name}")
  Observable<Connection> getConnection(@Path("name") @NonNull String name);

  @DELETE("api/connections/{name}")
  Observable<Void> deleteConnection(@Path("name") @NonNull String name,
      @Header(Headers.X_REASON) @Nullable String reason);

  @GET("api/connections/{name}/channels")
  Observable<List<Channel>> getConnectionChannels(@Path("name") @NonNull String connection);

  @GET("api/channels")
  Observable<List<Channel>> getChannels();

  @GET("api/vhosts/{vhost}/channels")
  Observable<List<Channel>> getChannels(@Path("vhost") @NonNull String vhost);

  @GET("api/channels/{name}")
  Observable<Channel> getChannel(@Path("name") @NonNull String name);

  @GET("api/consumers")
  Observable<List<Consumer>> getConsumers();

  @GET("api/consumers/{vhost}")
  Observable<List<Consumer>> getConsumers(@Path("vhost") @NonNull String vhost);

  @GET("api/exchanges")
  Observable<List<ExtendedExchange>> getExchanges();

  @GET("api/exchanges/{vhost}")
  Observable<List<ExtendedExchange>> getExchanges(@Path("vhost") @NonNull String vhost);

  @GET("api/exchanges/{vhost}/{exchange}")
  Observable<ExtendedExchange> getExchange(@Path("vhost") @NonNull String vhost,
      @Path("exchange") @NonNull String exchange);

  @PUT("api/exchanges/{vhost}/{exchange}")
  Observable<Void> putExchange(@Path("vhost") @NonNull String vhost,
      @Path("exchange") @NonNull String exchange, @Body @NonNull Exchange body);

  @DELETE("api/exchanges/{vhost}/{exchange}")
  Observable<Void> deleteExchange(@Path("vhost") @NonNull String vhost,
      @Path("exchange") @NonNull String exchange, @Query("if-unused") @Nullable Boolean ifUnused);

  @GET("api/exchanges/{vhost}/{exchange}/bindings/source")
  Observable<List<Binding>> getSourceBindings(@Path("vhost") @NonNull String vhost,
      @Path("exchange") @NonNull String exchange);

  @GET("api/exchanges/{vhost}/{exchange}/bindings/destination")
  Observable<List<Binding>> getDestinationBindings(@Path("vhost") @NonNull String vhost,
      @Path("exchange") @NonNull String exchange);

  @POST("api/exchanges/{vhost}/{exchange}/publish")
  Observable<PublishResponse> postExchangePublish(@Path("vhost") @NonNull String vhost,
      @Path("exchange") @NonNull String exchange, @Body @NonNull PublishBody body);

  @GET("api/queues")
  Observable<List<ExtendedQueue>> getQueues();

  @GET("api/queues/{vhost}")
  Observable<List<ExtendedQueue>> getQueues(@Path("vhost") @NonNull String vhost);

  @GET("api/queues/{vhost}/{queue}")
  Observable<ExtendedQueue> getQueue(@Path("vhost") @NonNull String vhost,
      @Path("queue") @NonNull String queue);

  @PUT("api/queues/{vhost}/{queue}")
  Observable<Void> putQueue(@Path("vhost") @NonNull String vhost,
      @Path("queue") @NonNull String queue, @Body @NonNull PutQueue body);

  @DELETE("api/queues/{vhost}/{queue}")
  Observable<Void> deleteQueue(@Path("vhost") @NonNull String vhost,
      @Path("queue") @NonNull String queue, @Query("if-empty") @Nullable Boolean ifEmpty,
      @Query("if-unused") @Nullable Boolean ifUnused);

  @GET("api/queues/{vhost}/{queue}/bindings")
  Observable<List<Binding>> getQueueBindings(@Path("vhost") @NonNull String vhost,
      @Path("queue") @NonNull String queue);

  @DELETE("api/queues/{vhost}/{queue}/contents")
  Observable<Void> purgeQueue(@Path("vhost") @NonNull String vhost,
      @Path("queue") @NonNull String queue);

  @POST("api/queues/{vhost}/{queue}/actions")
  Observable<Void> postAction(@Path("vhost") @NonNull String vhost,
      @Path("queue") @NonNull String queue, @Body @NonNull Action body);

  @POST("api/queues/{vhost}/{queue}/get")
  Observable<List<Message>> getMessages(@Path("vhost") @NonNull String vhost,
      @Path("queue") @NonNull String queue, @Body @NonNull Requirements body);

  @GET("api/bindings")
  Observable<List<Binding>> getBindings();

  @GET("api/bindings/{vhost}")
  Observable<List<Binding>> getBindings(@Path("vhost") @NonNull String vhost);

  @GET("api/bindings/{vhost}/e/{exchange}/q/{queue}")
  Observable<List<ExtendedBinding>> getBindingsBetweenExchangeAndQueue(
      @Path("vhost") @NonNull String vhost, @Path("exchange") @NonNull String exchange,
      @Path("queue") @NonNull String queue);

  @POST("api/bindings/{vhost}/e/{exchange}/q/{queue}")
  Observable<Void> postBindingsBetweenExchangeAndQueue(@Path("vhost") @NonNull String vhost,
      @Path("exchange") @NonNull String exchange, @Path("queue") @NonNull String queue,
      @Body @NonNull Binding body);

  @GET("api/bindings/{vhost}/e/{exchange}/q/{queue}/{props}")
  Observable<ExtendedBinding> getBindingsBetweenExchangeAndQueue(@Path("vhost") String vhost,
      @Path("exchange") @NonNull String exchange, @Path("queue") @NonNull String queue,
      @Path("props") @NonNull String propertiesKey);

  @DELETE("api/bindings/{vhost}/e/{exchange}/q/{queue}/{props}")
  Observable<ExtendedBinding> deleteBindingsBetweenExchangeAndQueue(@Path("vhost") String vhost,
      @Path("exchange") @NonNull String exchange, @Path("queue") @NonNull String queue,
      @Path("props") @NonNull String propertiesKey);

  @GET("api/bindings/{vhost}/e/{source}/e/{destination}")
  Observable<List<ExtendedBinding>> getBindingsBetweenExchanges(
      @Path("vhost") @NonNull String vhost, @Path("source") @NonNull String srcExchange,
      @Path("destination") @NonNull String dstExchange);

  @POST("api/bindings/{vhost}/e/{source}/e/{destination}")
  Observable<Void> postBindingsBetweenExchanges(@Path("vhost") @NonNull String vhost,
      @Path("source") @NonNull String source, @Path("destination") @NonNull String destination,
      @Body @NonNull Binding body);

  @GET("api/bindings/{vhost}/e/{source}/e/{destination}/{props}")
  Observable<ExtendedBinding> getBindingsBetweenExchanges(@Path("vhost") @NonNull String vhost,
      @Path("source") @NonNull String srcExchange, @Path("destination") @NonNull String dstExchange,
      @Path("props") @NonNull String propertiesKey);

  @DELETE("api/bindings/{vhost}/e/{source}/e/{destination}/{props}")
  Observable<Void> deleteBindingsBetweenExchanges(@Path("vhost") @NonNull String vhost,
      @Path("source") @NonNull String srcExchange, @Path("destination") @NonNull String dstExchange,
      @Path("props") @NonNull String propertiesKey);

  @GET("api/vhosts")
  Observable<List<ExtendedVhost>> getVhosts();

  @GET("api/vhosts/{name}")
  Observable<ExtendedVhost> getVhost(@Path("name") @NonNull String name);

  @PUT("api/vhosts/{name}")
  Observable<Void> putVhost(@Path("name") @NonNull String name);

  @DELETE("api/vhosts/{name}")
  Observable<Void> deleteHost(@Path("name") @NonNull String name);

  @GET("api/vhosts/{vhost}/permissions")
  Observable<List<Permission>> getVhostPermissions(@Path("vhost") @NonNull String vhost);

  @GET("api/users")
  Observable<List<ExtendedUser>> getUsers();

  @GET("api/users/{name}")
  Observable<ExtendedUser> getUser(@Path("name") @NonNull String name);

  @PUT("api/users/{name}")
  Observable<Void> putUser(@Path("name") @NonNull String name, @NonNull @Body ExtendedUser body);

  @DELETE("api/users/{name}")
  Observable<Void> deleteUser(@Path("name") @NonNull String name);

  @GET("api/users/{user}/permissions")
  Observable<List<Permission>> getUserPermissions(@Path("user") @NonNull String user);

  @GET("api/whoami")
  Observable<Response<User>> whoAmI();

  @GET("api/permissions")
  Observable<List<Permission>> getPermissions();

  @GET("api/permissions/{vhost}/{user}")
  Observable<Permission> getPermission(@Path("vhost") @NonNull String vhost,
      @Path("user") @NonNull String user);

  @PUT("api/permissions/{vhost}/{user}")
  Observable<Void> putPermission(@Path("vhost") @NonNull String vhost,
      @Path("user") @NonNull String user, @Body @NonNull Permission body);

  @DELETE("api/permissions/{vhost}/{user}")
  Observable<Void> deletePermission(@Path("vhost") @NonNull String vhost,
      @Path("user") @NonNull String user);

  @GET("api/parameters")
  Observable<List<Parameter>> getParameters();

  @GET("api/parameters/{component}")
  Observable<List<Parameter>> getParameters(@Path("component") @NonNull String component);

  @GET("api/parameters/{component}/{vhost}")
  Observable<List<Parameter>> getParameters(@Path("component") @NonNull String component,
      @Path("vhost") @NonNull String vhost);

  @GET("api/parameters/{component}/{vhost}/{parameter}")
  Observable<Parameter> getParameter(@Path("component") @NonNull String component,
      @Path("vhost") @NonNull String vhost, @Path("parameter") @NonNull String parameter);

  @PUT("api/parameters/{component}/{vhost}/{parameter}")
  Observable<Void> putParameter(@Path("component") @NonNull String component,
      @Path("vhost") @NonNull String vhost, @Path("parameter") @NonNull String parameter,
      @Body @NonNull PutParameter body);

  @DELETE("api/parameters/{component}/{vhost}/{parameter}")
  Observable<Void> deleteParameter(@Path("component") @NonNull String component,
      @Path("vhost") @NonNull String vhost, @Path("parameter") @NonNull String parameter);

  @GET("api/policies")
  Observable<List<Policy>> getPolicies();

  @GET("api/policies/{vhost}")
  Observable<List<Policy>> getPolicies(@Path("vhost") @NonNull String vhost);

  @GET("api/policies/{vhost}/{policy}")
  Observable<Policy> getPolicy(@Path("vhost") @NonNull String vhost,
      @Path("policy") @NonNull String policy);

  @PUT("api/policies/{vhost}/{policy}")
  Observable<Void> putPolicy(@Path("vhost") @NonNull String vhost,
      @Path("policy") @NonNull String policy, @Body @NonNull Policy body);

  @DELETE("api/policies/{vhost}/{policy}")
  Observable<Void> deletePolicy(@Path("vhost") @NonNull String vhost,
      @Path("policy") @NonNull String policy);

  @GET("api/aliveness-test/{vhost}")
  Observable<Check> checkAlive(@Path("vhost") @NonNull String vhost);

  @GET("api/healthchecks/node")
  Observable<Check> checkHealth();

  @GET("api/healthchecks/node/{node}")
  Observable<Check> checkHealth(@Path("node") @NonNull String node);

  class Headers {

    public static final String X_REASON = "X-Reason";

    public static final String LOCATION = "Location";
  }
}
