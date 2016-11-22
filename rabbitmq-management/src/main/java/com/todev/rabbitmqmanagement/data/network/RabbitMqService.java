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
import com.todev.rabbitmqmanagement.data.network.interceptor.AuthorizationInterceptor;
import com.todev.rabbitmqmanagement.data.network.interceptor.ContentTypeInterceptor;
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
import java.util.List;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RabbitMqService {

  String CONTENT_TYPE = "application/json";

  String URL_FORMAT = "http://%s:%d/api/";

  String TEST_URL = "192.168.3.150";

  int TEST_PORT = 15672;

  String TEST_USERNAME = "tommus";

  String TEST_PASSWORD = "tommus";

  @GET("overview")
  Call<Overview> getOverview();

  @GET("cluster-name")
  Call<Cluster> getClusterName();

  @PUT("cluster-name")
  Call<Void> updateClusterName(@Body @NonNull Cluster cluster);

  @GET("nodes")
  Call<List<Node>> getNodes();

  @GET("nodes/{name}")
  Call<Node> getNode(@Path("name") @NonNull String name);

  @GET("extensions")
  Call<List<Extension>> getExtensions();

  @GET("definitions")
  Call<Definitions> getDefinitions();

  // TODO: Add POST /definitions.

  @GET("definitions/{vhost}")
  Call<Definitions> getDefinitions(@Path("vhost") @NonNull String vhost);

  // TODO: Add POST /definitions/{vhost}.

  @GET("connections")
  Call<List<Connection>> getConnections();

  @GET("vhosts/{vhost}/connections")
  Call<List<Connection>> getConnections(@Path("vhost") @NonNull String vhost);

  @GET("connections/{name}")
  Call<Connection> getConnection(@Path("name") @NonNull String name);

  @DELETE("connections/{name}")
  Call<Void> deleteConnection(@Path("name") @NonNull String name, @Header(Headers.X_REASON) @Nullable String reason);

  @GET("connections/{name}/channels")
  Call<List<Channel>> getConnectionChannels(@Path("name") @NonNull String connection);

  @GET("channels")
  Call<List<Channel>> getChannels();

  @GET("vhosts/{vhost}/channels")
  Call<List<Channel>> getChannels(@Path("vhost") @NonNull String vhost);

  @GET("channels/{name}")
  Call<Channel> getChannel(@Path("name") @NonNull String name);

  @GET("consumers")
  Call<List<Consumer>> getConsumers();

  @GET("consumers/{vhost}")
  Call<List<Consumer>> getConsumers(@Path("vhost") @NonNull String vhost);

  @GET("exchanges")
  Call<List<ExtendedExchange>> getExchanges();

  @GET("exchanges/{vhost}")
  Call<List<ExtendedExchange>> getExchanges(@Path("vhost") @NonNull String vhost);

  @GET("exchanges/{vhost}/{exchange}")
  Call<ExtendedExchange> getExchange(@Path("vhost") @NonNull String vhost, @Path("exchange") @NonNull String exchange);

  @PUT("exchanges/{vhost}/{exchange}")
  Call<Void> putExchange(@Path("vhost") @NonNull String vhost, @Path("exchange") @NonNull String exchange,
    @Body @NonNull Exchange body);

  @DELETE("exchanges/{vhost}/{exchange}")
  Call<Void> deleteExchange(@Path("vhost") @NonNull String vhost, @Path("exchange") @NonNull String exchange,
    @Query("if-unused") @Nullable Boolean ifUnused);

  @GET("exchanges/{vhost}/{exchange}/bindings/source")
  Call<List<Binding>> getSourceBindings(@Path("vhost") @NonNull String vhost,
    @Path("exchange") @NonNull String exchange);

  @GET("exchanges/{vhost}/{exchange}/bindings/destination")
  Call<List<Binding>> getDestinationBindings(@Path("vhost") @NonNull String vhost,
    @Path("exchange") @NonNull String exchange);

  @POST("exchanges/{vhost}/{exchange}/publish")
  Call<PublishResponse> postExchangePublish(@Path("vhost") @NonNull String vhost,
    @Path("exchange") @NonNull String exchange, @Body @NonNull PublishBody body);

  @GET("queues")
  Call<List<ExtendedQueue>> getQueues();

  @GET("queues/{vhost}")
  Call<List<ExtendedQueue>> getQueues(@Path("vhost") @NonNull String vhost);

  @GET("queues/{vhost}/{queue}")
  Call<ExtendedQueue> getQueue(@Path("vhost") @NonNull String vhost, @Path("queue") @NonNull String queue);

  @PUT("queues/{vhost}/{queue}")
  Call<Void> putQueue(@Path("vhost") @NonNull String vhost, @Path("queue") @NonNull String queue,
    @Body @NonNull PutQueue body);

  @DELETE("queues/{vhost}/{queue}")
  Call<Void> deleteQueue(@Path("vhost") @NonNull String vhost, @Path("queue") @NonNull String queue,
    @Query("if-empty") @Nullable Boolean ifEmpty, @Query("if-unused") @Nullable Boolean ifUnused);

  @GET("queues/{vhost}/{queue}/bindings")
  Call<List<Binding>> getQueueBindings(@Path("vhost") @NonNull String vhost, @Path("queue") @NonNull String queue);

  @DELETE("queues/{vhost}/{queue}/contents")
  Call<Void> purgeQueue(@Path("vhost") @NonNull String vhost, @Path("queue") @NonNull String queue);

  @POST("queues/{vhost}/{queue}/actions")
  Call<Void> postAction(@Path("vhost") @NonNull String vhost, @Path("queue") @NonNull String queue,
    @Body @NonNull Action body);

  @POST("queues/{vhost}/{queue}/get")
  Call<List<Message>> getMessages(@Path("vhost") @NonNull String vhost, @Path("queue") @NonNull String queue,
    @Body @NonNull Requirements body);

  @GET("bindings")
  Call<List<Binding>> getBindings();

  @GET("bindings/{vhost}")
  Call<List<Binding>> getBindings(@Path("vhost") @NonNull String vhost);

  @GET("bindings/{vhost}/e/{exchange}/q/{queue}")
  Call<List<ExtendedBinding>> getBindingsBetweenExchangeAndQueue(@Path("vhost") @NonNull String vhost,
    @Path("exchange") @NonNull String exchange, @Path("queue") @NonNull String queue);

  @POST("bindings/{vhost}/e/{exchange}/q/{queue}")
  Call<Void> postBindingsBetweenExchangeAndQueue(@Path("vhost") @NonNull String vhost,
    @Path("exchange") @NonNull String exchange, @Path("queue") @NonNull String queue, @Body @NonNull Binding body);

  @GET("bindings/{vhost}/e/{exchange}/q/{queue}/{props}")
  Call<ExtendedBinding> getBindingsBetweenExchangeAndQueue(@Path("vhost") String vhost,
    @Path("exchange") @NonNull String exchange, @Path("queue") @NonNull String queue,
    @Path("props") @NonNull String propertiesKey);

  @DELETE("bindings/{vhost}/e/{exchange}/q/{queue}/{props}")
  Call<ExtendedBinding> deleteBindingsBetweenExchangeAndQueue(@Path("vhost") String vhost,
    @Path("exchange") @NonNull String exchange, @Path("queue") @NonNull String queue,
    @Path("props") @NonNull String propertiesKey);

  @GET("bindings/{vhost}/e/{source}/e/{destination}")
  Call<List<ExtendedBinding>> getBindingsBetweenExchanges(@Path("vhost") @NonNull String vhost,
    @Path("source") @NonNull String srcExchange, @Path("destination") @NonNull String dstExchange);

  @POST("bindings/{vhost}/e/{source}/e/{destination}")
  Call<Void> postBindingsBetweenExchanges(@Path("vhost") @NonNull String vhost, @Path("source") @NonNull String source,
    @Path("destination") @NonNull String destination, @Body @NonNull Binding body);

  @GET("bindings/{vhost}/e/{source}/e/{destination}/{props}")
  Call<ExtendedBinding> getBindingsBetweenExchanges(@Path("vhost") @NonNull String vhost,
    @Path("source") @NonNull String srcExchange, @Path("destination") @NonNull String dstExchange,
    @Path("props") @NonNull String propertiesKey);

  @DELETE("bindings/{vhost}/e/{source}/e/{destination}/{props}")
  Call<Void> deleteBindingsBetweenExchanges(@Path("vhost") @NonNull String vhost,
    @Path("source") @NonNull String srcExchange, @Path("destination") @NonNull String dstExchange,
    @Path("props") @NonNull String propertiesKey);

  @GET("vhosts")
  Call<List<ExtendedVhost>> getVhosts();

  @GET("vhosts/{name}")
  Call<ExtendedVhost> getVhost(@Path("name") @NonNull String name);

  @PUT("vhosts/{name}")
  Call<Void> putVhost(@Path("name") @NonNull String name);

  @DELETE("vhosts/{name}")
  Call<Void> deleteHost(@Path("name") @NonNull String name);

  @GET("vhosts/{vhost}/permissions")
  Call<List<Permission>> getVhostPermissions(@Path("vhost") @NonNull String vhost);

  @GET("users")
  Call<List<ExtendedUser>> getUsers();

  @GET("users/{name}")
  Call<ExtendedUser> getUser(@Path("name") @NonNull String name);

  @PUT("users/{name}")
  Call<Void> putUser(@Path("name") @NonNull String name, @NonNull @Body ExtendedUser body);

  @DELETE("users/{name}")
  Call<Void> deleteUser(@Path("name") @NonNull String name);

  @GET("users/{user}/permissions")
  Call<List<Permission>> getUserPermissions(@Path("user") @NonNull String user);

  @GET("whoami")
  Call<User> whoAmI();

  @GET("permissions")
  Call<List<Permission>> getPermissions();

  @GET("permissions/{vhost}/{user}")
  Call<Permission> getPermission(@Path("vhost") @NonNull String vhost, @Path("user") @NonNull String user);

  @PUT("permissions/{vhost}/{user}")
  Call<Void> putPermission(@Path("vhost") @NonNull String vhost, @Path("user") @NonNull String user,
    @Body @NonNull Permission body);

  @DELETE("permissions/{vhost}/{user}")
  Call<Void> deletePermission(@Path("vhost") @NonNull String vhost, @Path("user") @NonNull String user);

  @GET("parameters")
  Call<List<Parameter>> getParameters();

  @GET("parameters/{component}")
  Call<List<Parameter>> getParameters(@Path("component") @NonNull String component);

  @GET("parameters/{component}/{vhost}")
  Call<List<Parameter>> getParameters(@Path("component") @NonNull String component,
    @Path("vhost") @NonNull String vhost);

  @GET("parameters/{component}/{vhost}/{parameter}")
  Call<Parameter> getParameter(@Path("component") @NonNull String component, @Path("vhost") @NonNull String vhost,
    @Path("parameter") @NonNull String parameter);

  @PUT("parameters/{component}/{vhost}/{parameter}")
  Call<Void> putParameter(@Path("component") @NonNull String component, @Path("vhost") @NonNull String vhost,
    @Path("parameter") @NonNull String parameter, @Body @NonNull PutParameter body);

  @DELETE("parameters/{component}/{vhost}/{parameter}")
  Call<Void> deleteParameter(@Path("component") @NonNull String component, @Path("vhost") @NonNull String vhost,
    @Path("parameter") @NonNull String parameter);

  @GET("policies")
  Call<List<Policy>> getPolicies();

  @GET("policies/{vhost}")
  Call<List<Policy>> getPolicies(@Path("vhost") @NonNull String vhost);

  @GET("policies/{vhost}/{policy}")
  Call<Policy> getPolicy(@Path("vhost") @NonNull String vhost, @Path("policy") @NonNull String policy);

  @PUT("policies/{vhost}/{policy}")
  Call<Void> putPolicy(@Path("vhost") @NonNull String vhost, @Path("policy") @NonNull String policy,
    @Body @NonNull Policy body);

  @DELETE("policies/{vhost}/{policy}")
  Call<Void> deletePolicy(@Path("vhost") @NonNull String vhost, @Path("policy") @NonNull String policy);

  @GET("aliveness-test/{vhost}")
  Call<Check> checkAlive(@Path("vhost") @NonNull String vhost);

  @GET("healthchecks/node")
  Call<Check> checkHealth();

  @GET("healthchecks/node/{node}")
  Call<Check> checkHealth(@Path("node") @NonNull String node);

  class Headers {

    public static final String X_REASON = "X-Reason";

    public static final String LOCATION = "Location";
  }

  class Json {
    public static RabbitMqService createService(String url, int port, String username, String password) {
      OkHttpClient httpClient =
        new OkHttpClient.Builder().addInterceptor(new AuthorizationInterceptor(username, password))
          .addInterceptor(new ContentTypeInterceptor(CONTENT_TYPE))
          .build();

      Retrofit retrofit = new Retrofit.Builder().baseUrl(String.format(URL_FORMAT, url, port))
        .addConverterFactory(JacksonConverterFactory.create())
        .client(httpClient)
        .build();

      return retrofit.create(RabbitMqService.class);
    }

    public static RabbitMqService createTestService() {
      return createService(TEST_URL, TEST_PORT, TEST_USERNAME, TEST_PASSWORD);
    }
  }
}
