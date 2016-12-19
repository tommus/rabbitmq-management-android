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

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import butterknife.BindView;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.RabbitMqManagementApplication;
import com.todev.rabbitmqmanagement.ui.BaseActivity;
import com.todev.rabbitmqmanagement.ui.admin.AdminFragment;
import com.todev.rabbitmqmanagement.ui.channel.ChannelFragment;
import com.todev.rabbitmqmanagement.ui.connection.ConnectionFragment;
import com.todev.rabbitmqmanagement.ui.exchange.ExchangeFragment;
import com.todev.rabbitmqmanagement.ui.overview.OverviewFragment;
import com.todev.rabbitmqmanagement.ui.queue.QueueFragment;

public class DrawerActivity extends BaseActivity implements DrawerContract.View {
  @BindView(R.id.drawer_layout) DrawerLayout drawerLayoutView;
  @BindView(R.id.drawer_navigation) NavigationView drawerNavigationView;
  @BindView(R.id.toolbar) Toolbar toolbarView;

  private ActionBarDrawerToggle drawerToggle;
  private DrawerPresenter presenter;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    RabbitMqManagementApplication.get(this).getComponent().inject(this);

    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_drawer);

    setSupportActionBar(toolbarView);

    drawerToggle =
        new ActionBarDrawerToggle(this, drawerLayoutView, toolbarView, R.string.drawer_open, R.string.drawer_close);
    drawerLayoutView.addDrawerListener(drawerToggle);
    drawerNavigationView.setNavigationItemSelectedListener(this::onNavigationMenuItemSelected);
    drawerToggle.syncState();

    presenter = new DrawerPresenter();
    presenter.setView(this);
  }

  @Override
  protected void onPostCreate(@Nullable Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);

    if (savedInstanceState == null) {
      presenter.openDefaultMenuItem();
    }
  }

  @Override
  protected void onDestroy() {
    drawerLayoutView.removeDrawerListener(drawerToggle);
    super.onDestroy();
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    drawerToggle.onConfigurationChanged(newConfig);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (drawerToggle.onOptionsItemSelected(item)) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

  @Override
  public boolean onNavigationMenuItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case R.id.nav_overview:
        presenter.onOverviewMenuItemClicked();
        break;
      case R.id.nav_connections:
        presenter.onConnectionsMenuItemClicked();
        break;
      case R.id.nav_channels:
        presenter.onChannelsMenuItemClicked();
        break;
      case R.id.nav_exchanges:
        presenter.onExchangesMenuItemClicked();
        break;
      case R.id.nav_queues:
        presenter.onQueuesMenuItemClicked();
        break;
      case R.id.nav_admin:
        presenter.onAdminMenuItemClicked();
        break;
      default:
        presenter.onOverviewMenuItemClicked();
    }

    item.setChecked(true);
    drawerLayoutView.closeDrawer(GravityCompat.START);

    return true;
  }

  @Override
  public void showOverviewFragment() {
    OverviewFragment fragment = new OverviewFragment();

    fragment.setOnConnectionsRunnable(() ->{
      drawerNavigationView.getMenu().getItem(1).setChecked(true);
      presenter.onConnectionsMenuItemClicked();
    });

    fragment.setOnChannelsRunnable(() -> {
      drawerNavigationView.getMenu().getItem(2).setChecked(true);
      presenter.onChannelsMenuItemClicked();
    });

    fragment.setOnExchangesRunnable(() -> {
      drawerNavigationView.getMenu().getItem(3).setChecked(true);
      presenter.onExchangesMenuItemClicked();
    });

    fragment.setOnQueuesRunnable(() -> {
      drawerNavigationView.getMenu().getItem(4).setChecked(true);
      presenter.onQueuesMenuItemClicked();
    });

    showFragment(fragment);
  }

  @Override
  public void showConnectionsFragment() {
    showFragment(new ConnectionFragment());
  }

  @Override
  public void showChannelsFragment() {
    showFragment(new ChannelFragment());
  }

  @Override
  public void showExchangesFragment() {
    showFragment(new ExchangeFragment());
  }

  @Override
  public void showQueuesFragment() {
    showFragment(new QueueFragment());
  }

  @Override
  public void showAdminFragment() {
    showFragment(new AdminFragment());
  }

  @Override
  public void updateTitle(@StringRes int titleResId) {
    toolbarView.setTitle(titleResId);
  }

  protected void showFragment(Fragment fragment) {
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();
    transaction.replace(R.id.drawer_content, fragment);
    transaction.commit();
  }
}
