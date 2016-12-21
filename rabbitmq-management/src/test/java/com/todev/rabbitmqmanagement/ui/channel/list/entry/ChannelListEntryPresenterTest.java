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
package com.todev.rabbitmqmanagement.ui.channel.list.entry;

import com.todev.rabbitmqmanagement.BaseTest;
import com.todev.rabbitmqmanagement.data.network.model.channel.Channel;
import com.todev.rabbitmqmanagement.data.network.model.channel.ChannelDetails;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

public class ChannelListEntryPresenterTest extends BaseTest {
  @Mock ChannelListEntryContract.View view;
  @Mock Channel channel;
  @Mock ChannelDetails channelDetails;

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

    // When
    presenter.bind(channel);

    // Then
    verify(view).displayName("172.17.0.1", 35128, 1);
    verify(view).displayUsername("test");
  }
}
