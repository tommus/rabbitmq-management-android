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

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.data.network.model.channel.Channel;
import com.todev.rabbitmqmanagement.ui.BaseViewHolder;

public class ChannelListEntry extends BaseViewHolder {
  @BindView(R.id.name) TextView nameView;
  @BindView(R.id.user) TextView userView;

  public ChannelListEntry(ViewGroup parent, @LayoutRes int layoutRes) {
    super(parent, layoutRes);
  }

  public void bind(@NonNull Channel channel) {
    nameView.setText(channel.getConnectionDetails().getPeerHost()
        + ":"
        + channel.getConnectionDetails().getPeerPort()
        + " ("
        + channel.getNumber()
        + ")");
    userView.setText(channel.getUser());
  }
}
