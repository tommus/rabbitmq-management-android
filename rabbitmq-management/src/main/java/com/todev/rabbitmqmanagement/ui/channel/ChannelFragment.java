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
package com.todev.rabbitmqmanagement.ui.channel;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.BindView;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.RabbitMqManagementApplication;
import com.todev.rabbitmqmanagement.data.network.RabbitMqService;
import com.todev.rabbitmqmanagement.data.network.model.channel.Channel;
import com.todev.rabbitmqmanagement.ui.BaseFragment;
import java.util.List;
import javax.inject.Inject;

public class ChannelFragment extends BaseFragment implements ChannelContract.View {
  @Inject RabbitMqService rabbitMqService;

  @BindView(R.id.channels_list) RecyclerView channelsView;

  private ChannelPresenter presenter;
  private ChannelListAdapter adapter;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    RabbitMqManagementApplication.get(getContext()).getComponent().inject(this);
    super.onCreate(savedInstanceState);
    presenter = new ChannelPresenter(rabbitMqService);
    presenter.setView(this);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_channel, container, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    adapter = new ChannelListAdapter();
    channelsView.setLayoutManager(new LinearLayoutManager(getContext()));
    channelsView.setAdapter(adapter);
  }

  @Override
  public void onStart() {
    super.onStart();
    presenter.loadChannels();
  }

  @Override
  public void onStop() {
    super.onStop();
    presenter.unsubscribe();
  }

  @Override
  public void updateChannels(List<Channel> channels) {
    adapter.setChannels(channels);
  }

  @Override
  public void showNetworkError() {
    // TODO: 20.12.16 Display an error.
  }
}
