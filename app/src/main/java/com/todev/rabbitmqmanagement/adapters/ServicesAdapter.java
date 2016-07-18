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
package com.todev.rabbitmqmanagement.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.database.Service;
import java.util.Collections;
import java.util.List;

public class ServicesAdapter extends ArrayAdapter<Service> {

  private List<Service> items = Service.all();

  public ServicesAdapter(Context context) {
    super(context, 0);

    Collections.sort(items);
  }

  @Override
  public int getCount() {
    return items.size();
  }

  @Override
  public Service getItem(int position) {
    return items.get(position);
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    Service service = items.get(position);

    if (convertView == null) {
      LayoutInflater inflater = LayoutInflater.from(getContext());
      convertView = inflater.inflate(R.layout.spinner_item, parent, false);
    }

    TextView label = (TextView) convertView.findViewById(R.id.spinner_item);
    label.setText(service.getLabel());

    return convertView;
  }

  @Override
  public View getDropDownView(int position, View convertView, ViewGroup parent) {
    Service service = items.get(position);

    if (convertView == null) {
      LayoutInflater inflater = LayoutInflater.from(getContext());
      convertView = inflater.inflate(R.layout.spinner_dropdown_item, parent, false);
    }

    CheckedTextView label = (CheckedTextView) convertView.findViewById(android.R.id.text1);
    label.setText(service.getLabel());

    return convertView;
  }

  public int getItemPosition(long id) {
    for (int i = 0; i < items.size(); ++i) {
      if (items.get(i).getId() == id) {
        return i;
      }
    }
    return -1;
  }
}
