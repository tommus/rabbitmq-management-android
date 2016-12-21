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

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.data.network.model.channel.Channel;
import java.util.ArrayList;
import java.util.List;

public class ChannelListAdapter extends RecyclerView.Adapter<ChannelListEntry> {
  private List<Channel> channels = new ArrayList<>();

  @Override
  public ChannelListEntry onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ChannelListEntry(parent, R.layout.item_channel);
  }

  @Override
  public void onBindViewHolder(ChannelListEntry holder, int position) {
    final Channel channel = channels.get(position);
    holder.bind(channel);
  }

  @Override
  public int getItemCount() {
    return channels.size();
  }

  public void setChannels(List<Channel> channels) {
    this.channels.clear();
    this.channels.addAll(channels);
    notifyDataSetChanged();
  }
}
