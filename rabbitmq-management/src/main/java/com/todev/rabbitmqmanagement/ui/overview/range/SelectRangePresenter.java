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
package com.todev.rabbitmqmanagement.ui.overview.range;

import com.todev.rabbitmqmanagement.ui.overview.widget.MessagesIndicator;
import java8.util.function.Supplier;
import lombok.Setter;

public class SelectRangePresenter implements SelectRangeContract.Presenter {
  @Setter SelectRangeContract.View view;

  @Override
  public void loadVisibleRanges(Supplier<String[]> supplier) {
    String[] visibleRanges = supplier.get();
    view.updateVisibleRanges(visibleRanges);
  }

  @Override
  public void onItemClicked(MessagesIndicator.VisibleRange visibleRange) {
    view.setVisibleRange(visibleRange);
    view.close();
  }
}
