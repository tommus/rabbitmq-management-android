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
package com.todev.rabbitmqmanagement.ui;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import butterknife.ButterKnife;
import icepick.Icepick;

public class BaseActivity extends AppCompatActivity {

  @Override
  protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    Icepick.saveInstanceState(this, outState);
  }

  @Override
  protected void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    Icepick.restoreInstanceState(this, savedInstanceState);
  }

  @Override
  public void setContentView(@LayoutRes int layoutResID) {
    super.setContentView(layoutResID);
    ButterKnife.bind(this);
  }
}
