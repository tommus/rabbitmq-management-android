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
package com.todev.rabbitmqmanagement.fragment.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.widget.MessagesIndicator;

public class SelectRangeFragment extends DialogFragment {

  @BindView(R.id.ranges_list_view)
  ListView rangesListView;

  private MessagesIndicator messagesIndicator;

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

    String[] ranges = getResources().getStringArray(R.array.dialog_select_range_values);
    ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.dialog_select_range_item, android.R.id.text1, ranges);

    rangesListView.setAdapter(adapter);
    rangesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
      @Override
      public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        MessagesIndicator.VisibleRange range = MessagesIndicator.VisibleRange.fromRange(position);
        messagesIndicator.setVisibleRange(range);
        dismiss();
      }
    });
  }

  public void setMessagesIndicator(MessagesIndicator messagesIndicator) {
    this.messagesIndicator = messagesIndicator;
  }
}
