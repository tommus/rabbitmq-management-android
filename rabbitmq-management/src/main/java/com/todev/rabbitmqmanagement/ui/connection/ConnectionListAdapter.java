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
package com.todev.rabbitmqmanagement.ui.connection;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.data.network.model.connection.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionListAdapter extends RecyclerView.Adapter<ConnectionListEntry> {
  private List<Connection> connections = new ArrayList<>();

  @Override
  public ConnectionListEntry onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ConnectionListEntry(parent, R.layout.item_connection);
  }

  @Override
  public void onBindViewHolder(ConnectionListEntry holder, int position) {
    final Connection connection = connections.get(position);
    holder.bind(connection);
  }

  @Override
  public int getItemCount() {
    return connections.size();
  }

  public void setConnections(List<Connection> connections) {
    this.connections.clear();
    this.connections.addAll(connections);
    notifyDataSetChanged();
  }
}
