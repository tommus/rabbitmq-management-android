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
package com.todev.rabbitmqmanagement.ui.exchange;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.ViewGroup;
import android.widget.TextView;
import butterknife.BindView;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.data.network.model.exchange.Exchange;
import com.todev.rabbitmqmanagement.ui.BaseViewHolder;
import org.apache.commons.lang3.StringUtils;

public class ExchangeListEntry extends BaseViewHolder {
  private static final String DEFAULT_EXCHANGE_NAME = "(AMQP default)";

  @BindView(R.id.name) TextView nameView;
  @BindView(R.id.type) TextView typeView;

  public ExchangeListEntry(ViewGroup parent, @LayoutRes int layoutRes) {
    super(parent, layoutRes);
  }

  public void bind(@NonNull Exchange exchange) {
    String name = StringUtils.defaultIfEmpty(exchange.getName(), DEFAULT_EXCHANGE_NAME);
    nameView.setText(name);
    typeView.setText(exchange.getType().toString().toLowerCase());
  }
}
