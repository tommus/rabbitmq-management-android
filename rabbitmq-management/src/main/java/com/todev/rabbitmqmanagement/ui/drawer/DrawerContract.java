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

import android.support.annotation.StringRes;
import android.view.MenuItem;

interface DrawerContract {
  interface View {
    boolean onNavigationMenuItemSelected(MenuItem item);

    void showOverviewFragment();

    void showConnectionsFragment();

    void showChannelsFragment();

    void showExchangesFragment();

    void showQueuesFragment();

    void showAdminFragment();

    void updateTitle(@StringRes int titleResId);
  }

  interface Presenter {
    void openDefaultMenuItem();

    void onOverviewMenuItemClicked();

    void onConnectionsMenuItemClicked();

    void onChannelsMenuItemClicked();

    void onExchangesMenuItemClicked();

    void onQueuesMenuItemClicked();

    void onAdminMenuItemClicked();
  }
}
