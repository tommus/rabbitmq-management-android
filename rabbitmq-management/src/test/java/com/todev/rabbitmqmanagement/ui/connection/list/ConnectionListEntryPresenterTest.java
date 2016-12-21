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
package com.todev.rabbitmqmanagement.ui.connection.list;

import com.todev.rabbitmqmanagement.BaseTest;
import com.todev.rabbitmqmanagement.data.network.model.Details;
import com.todev.rabbitmqmanagement.data.network.model.connection.ClientProperties;
import com.todev.rabbitmqmanagement.data.network.model.connection.Connection;
import com.todev.rabbitmqmanagement.ui.connection.list.ConnectionListEntryContract;
import com.todev.rabbitmqmanagement.ui.connection.list.ConnectionListEntryPresenter;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class ConnectionListEntryPresenterTest extends BaseTest {
  @Mock ConnectionListEntryContract.View view;
  @Mock Connection connection;
  @Mock ClientProperties clientProperties;
  @Mock Details details;

  private ConnectionListEntryPresenter presenter;

  @Override
  public void setup() {
    super.setup();
    presenter = new ConnectionListEntryPresenter();
    presenter.setView(view);
  }

  @Test
  public void should_display_all_values_on_bind() {
    // Given
    doReturn("172.17.0.1").when(connection).getPeerHost();
    doReturn(35128).when(connection).getPeerPort();
    doReturn("test").when(connection).getUser();
    doReturn("running").when(connection).getState();
    doReturn(false).when(connection).isSsl();
    doReturn("AMQP 0-9-1").when(connection).getProtocol();
    doReturn(1).when(connection).getChannels();
    doReturn(65535).when(connection).getChannelMax();
    doReturn(131072).when(connection).getFrameMax();
    doReturn("PLAIN").when(connection).getAuthMechanism();
    doReturn(clientProperties).when(connection).getClientProperties();
    doReturn("rabbitpy").when(clientProperties).getProduct();
    doReturn("Python 3.5.2").when(clientProperties).getPlatform();
    doReturn("1.0.0").when(clientProperties).getVersion();
    doReturn(135.0f).when(details).getRate();
    doReturn(details).when(connection).getRecvOctDetails();
    doReturn(details).when(connection).getSendOctDetails();
    doReturn(60).when(connection).getTimeout();
    doReturn(1482317490720L).when(connection).getConnectedAt();

    // When
    presenter.bind(connection);

    // Then
    verify(view).displayName("172.17.0.1", 35128);
    verify(view).displayUsername("test");
    verify(view).displayState("running");
    verify(view).displaySslTls(false);
    verify(view).displaySslDetails(StringUtils.EMPTY);
    verify(view).displayProtocol("AMQP 0-9-1");
    verify(view).displayChannels(1);
    verify(view).displayChannelMax(65535);
    verify(view).displayFrameMax(131072);
    verify(view).displayAuthMechanism("PLAIN");
    verify(view).displayClient(clientProperties);
    verify(view).displayClientFromRate(135.0f);
    verify(view).displayClientToRate(135.0f);
    verify(view).displayHeartbeat(60);
    verify(view).displayConnectedAt(1482317490720L);
  }
}
