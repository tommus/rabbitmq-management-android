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
package com.todev.rabbitmqmanagement.ui.exchange.list;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.data.network.model.exchange.ExtendedExchange;
import java.util.ArrayList;
import java.util.List;

class ExchangeListAdapter extends RecyclerView.Adapter<ExchangeListEntry> {
  private List<ExtendedExchange> exchanges = new ArrayList<>();

  @Override
  public ExchangeListEntry onCreateViewHolder(ViewGroup parent, int viewType) {
    return new ExchangeListEntry(parent, R.layout.item_exchange);
  }

  @Override
  public void onBindViewHolder(ExchangeListEntry holder, int position) {
    final ExtendedExchange exchange = exchanges.get(position);
    holder.bind(exchange);
  }

  @Override
  public int getItemCount() {
    return exchanges.size();
  }

  public void setExchanges(List<ExtendedExchange> exchanges) {
    this.exchanges.clear();
    this.exchanges.addAll(exchanges);
    notifyDataSetChanged();
  }
}
