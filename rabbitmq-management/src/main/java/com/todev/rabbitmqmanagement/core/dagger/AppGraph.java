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
package com.todev.rabbitmqmanagement.core.dagger;

import com.todev.rabbitmqmanagement.ui.channel.ChannelFragment;
import com.todev.rabbitmqmanagement.ui.connection.ConnectionFragment;
import com.todev.rabbitmqmanagement.ui.drawer.DrawerActivity;
import com.todev.rabbitmqmanagement.ui.exchange.ExchangeFragment;
import com.todev.rabbitmqmanagement.ui.login.LoginActivity;
import com.todev.rabbitmqmanagement.ui.overview.OverviewFragment;
import com.todev.rabbitmqmanagement.ui.queue.QueueFragment;

public interface AppGraph {
  void inject(LoginActivity activity);

  void inject(DrawerActivity activity);

  void inject(OverviewFragment fragment);

  void inject(ConnectionFragment fragment);

  void inject(ChannelFragment fragment);

  void inject(ExchangeFragment fragment);

  void inject(QueueFragment fragment);
}
