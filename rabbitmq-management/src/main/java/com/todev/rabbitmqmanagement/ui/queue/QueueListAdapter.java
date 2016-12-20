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
package com.todev.rabbitmqmanagement.ui.queue;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.data.network.model.queue.ExtendedQueue;
import java.util.ArrayList;
import java.util.List;

public class QueueListAdapter extends RecyclerView.Adapter<QueueListEntry> {
  private List<ExtendedQueue> queues = new ArrayList<>();

  @Override
  public QueueListEntry onCreateViewHolder(ViewGroup parent, int viewType) {
    return new QueueListEntry(parent, R.layout.queue_item);
  }

  @Override
  public void onBindViewHolder(QueueListEntry holder, int position) {
    final ExtendedQueue queue = queues.get(position);
    holder.bind(queue);
  }

  @Override
  public int getItemCount() {
    return queues.size();
  }

  public void setQueues(List<ExtendedQueue> queues) {
    this.queues.clear();
    this.queues.addAll(queues);
    notifyDataSetChanged();
  }
}
