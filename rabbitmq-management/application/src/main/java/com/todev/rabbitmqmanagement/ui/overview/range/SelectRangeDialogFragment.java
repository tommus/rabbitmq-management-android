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

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.ui.BaseDialogFragment;
import com.todev.rabbitmqmanagement.ui.overview.widget.MessagesIndicator;
import lombok.Setter;

public class SelectRangeDialogFragment extends BaseDialogFragment implements SelectRangeContract.View {
  @BindView(R.id.ranges_list_view) ListView rangesListView;

  @Setter MessagesIndicator messagesIndicator;

  private SelectRangePresenter presenter;

  public SelectRangeDialogFragment() {
    super();
    presenter = new SelectRangePresenter();
    presenter.setView(this);
  }

  @NonNull
  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    LayoutInflater inflater = getActivity().getLayoutInflater();
    View view = inflater.inflate(R.layout.dialog_select_range, null);
    ButterKnife.bind(this, view);
    builder.setView(view);
    return builder.create();
  }

  @Override
  public void onStart() {
    super.onStart();
    presenter.loadVisibleRanges(this::loadVisibleRangesFromResources);
  }

  @Override
  public void setVisibleRange(MessagesIndicator.VisibleRange visibleRange) {
    messagesIndicator.setVisibleRange(visibleRange);
  }

  @Override
  public void updateVisibleRanges(String[] visibleRanges) {
    ArrayAdapter<String> adapter =
        new ArrayAdapter<>(getContext(), R.layout.dialog_select_range_item, android.R.id.text1, visibleRanges);
    rangesListView.setAdapter(adapter);
    rangesListView.setOnItemClickListener((adapterView, view, position, id) -> {
      MessagesIndicator.VisibleRange visibleRange = MessagesIndicator.VisibleRange.fromRange(position);
      presenter.onItemClicked(visibleRange);
    });
  }

  @Override
  public void close() {
    dismiss();
  }

  protected String[] loadVisibleRangesFromResources() {
    return getResources().getStringArray(R.array.dialog_select_range_values);
  }
}
