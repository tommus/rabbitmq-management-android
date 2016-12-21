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
package com.todev.rabbitmqmanagement.ui.channel.list;

import com.todev.rabbitmqmanagement.BaseTest;
import com.todev.rabbitmqmanagement.data.network.model.Details;
import com.todev.rabbitmqmanagement.data.network.model.MessageStats;
import com.todev.rabbitmqmanagement.data.network.model.channel.Channel;
import com.todev.rabbitmqmanagement.data.network.model.channel.ChannelDetails;
import com.todev.rabbitmqmanagement.ui.channel.list.ChannelListEntryContract;
import com.todev.rabbitmqmanagement.ui.channel.list.ChannelListEntryPresenter;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class ChannelListEntryPresenterTest extends BaseTest {
  @Mock ChannelListEntryContract.View view;
  @Mock Channel channel;
  @Mock ChannelDetails channelDetails;
  @Mock MessageStats messageStats;
  @Mock Details details;

  private ChannelListEntryPresenter presenter;

  @Override
  public void setup() {
    super.setup();
    presenter = new ChannelListEntryPresenter();
    presenter.setView(view);
  }

  @Test
  public void should_display_all_values_on_bind() {
    // Given
    doReturn(channelDetails).when(channel).getChannelDetails();
    doReturn("172.17.0.1").when(channelDetails).getPeerHost();
    doReturn(35128).when(channelDetails).getPeerPort();
    doReturn(1).when(channel).getNumber();
    doReturn("test").when(channel).getUser();
    doReturn("running").when(channel).getState();
    doReturn(0).when(channel).getMessagesUnconfirmed();
    doReturn(16830).when(channel).getMessagesUnacknowledged();
    doReturn(0).when(channel).getMessagesUncommitted();
    doReturn(0).when(channel).getAcksUncommitted();
    doReturn(messageStats).when(channel).getMessageStats();
    doReturn(details).when(messageStats).getPublishDetails();
    doReturn(details).when(messageStats).getConfirmDetails();
    doReturn(details).when(messageStats).getReturnUnroutableDetails();
    doReturn(details).when(messageStats).getDeliverGetDetails();
    doReturn(details).when(messageStats).getRedeliverDetails();
    doReturn(details).when(messageStats).getAckDetails();
    doReturn(0.0f).when(details).getRate();

    // When
    presenter.bind(channel);

    // Then
    verify(view).displayName("172.17.0.1", 35128, 1);
    verify(view).displayUsername("test");
    verify(view).displayMode(StringUtils.EMPTY);
    verify(view).displayState("running");
    verify(view).displayUnconfirmed(0);
    verify(view).displayPrefetch(StringUtils.EMPTY);
    verify(view).displayUnacked(16830);
    verify(view).displayUncommittedMessages(0);
    verify(view).displayUncommittedAcks(0);
    verify(view).displayPublish(0.0f);
    verify(view).displayConfirm(0.0f);
    verify(view).displayReturnMandatory(0.0f);
    verify(view).displayDeliverGet(0.0f);
    verify(view).displayRedelivered(0.0f);
    verify(view).displayAck(0.0f);
  }
}
