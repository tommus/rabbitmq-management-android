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

import android.support.annotation.NonNull;
import com.todev.rabbitmqmanagement.data.network.model.channel.Channel;

public interface ChannelListEntryContract {
  interface View {
    void displayName(String host, int port, int channel);

    void displayUsername(String type);
  }

  interface Presenter {
    void bind(@NonNull Channel channel);
  }
}
