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

import com.todev.rabbitmqmanagement.BaseTest;
import com.todev.rabbitmqmanagement.R;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class DrawerPresenterTest extends BaseTest {
  @Mock DrawerContract.View view;

  private DrawerPresenter presenter;

  @Override
  public void setup() {
    super.setup();
    presenter = spy(new DrawerPresenter());
    presenter.setView(view);
  }

  @Test
  public void should_show_overview_fragment_by_default() {
    // When
    presenter.openDefaultMenuItem();

    // Then
    verify(presenter).onOverviewMenuItemClicked();
  }

  @Test
  public void should_show_overview_fragment_and_update_toolbar_title_after_clicking_overview_menu_item() {
    // When
    presenter.onOverviewMenuItemClicked();

    // Then
    verify(view).showOverviewFragment();
    verify(view).updateTitle(R.string.overview);
  }

  @Test
  public void should_show_connections_fragment_and_update_toolbar_title_after_clicking_overview_menu_item() {
    // When
    presenter.onConnectionsMenuItemClicked();

    // Then
    verify(view).showConnectionsFragment();
    verify(view).updateTitle(R.string.connections);
  }

  @Test
  public void should_show_channels_fragment_and_update_toolbar_title_after_clicking_overview_menu_item() {
    // When
    presenter.onChannelsMenuItemClicked();

    // Then
    verify(view).showChannelsFragment();
    verify(view).updateTitle(R.string.channels);
  }

  @Test
  public void should_show_exchanges_fragment_and_update_toolbar_title_after_clicking_overview_menu_item() {
    // When
    presenter.onExchangesMenuItemClicked();

    // Then
    verify(view).showExchangesFragment();
    verify(view).updateTitle(R.string.exchanges);
  }

  @Test
  public void should_show_queues_fragment_and_update_toolbar_title_after_clicking_overview_menu_item() {
    // When
    presenter.onQueuesMenuItemClicked();

    // Then
    verify(view).showQueuesFragment();
    verify(view).updateTitle(R.string.queues);
  }

  @Test
  public void should_show_admin_fragment_and_update_toolbar_title_after_clicking_overview_menu_item() {
    // When
    presenter.onAdminMenuItemClicked();

    // Then
    verify(view).showAdminFragment();
    verify(view).updateTitle(R.string.admin);
  }
}
