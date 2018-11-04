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
package com.todev.rabbitmqmanagement.ui.drawer;

import com.todev.rabbitmqmanagement.R;
import lombok.Setter;

class DrawerPresenter implements DrawerContract.Presenter {
  @Setter DrawerContract.View view;

  @Override
  public void openDefaultMenuItem() {
    onOverviewMenuItemClicked();
  }

  @Override
  public void onOverviewMenuItemClicked() {
    view.showOverviewFragment();
    view.updateTitle(R.string.overview);
  }

  @Override
  public void onConnectionsMenuItemClicked() {
    view.showConnectionsFragment();
    view.updateTitle(R.string.connections);
  }

  @Override
  public void onChannelsMenuItemClicked() {
    view.showChannelsFragment();
    view.updateTitle(R.string.channels);
  }

  @Override
  public void onExchangesMenuItemClicked() {
    view.showExchangesFragment();
    view.updateTitle(R.string.exchanges);
  }

  @Override
  public void onQueuesMenuItemClicked() {
    view.showQueuesFragment();
    view.updateTitle(R.string.queues);
  }

  @Override
  public void onAdminMenuItemClicked() {
    view.showAdminFragment();
    view.updateTitle(R.string.admin);
  }
}
