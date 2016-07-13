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
package com.todev.rabbitmqmanagement.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.todev.rabbitmqmanagement.R;
import com.todev.rabbitmqmanagement.service.RabbitMqService;

public class TestActivity extends AppCompatActivity {

  protected static final String TAG = TestActivity.class.getSimpleName();

  protected RabbitMqService rabbitMqService = RabbitMqService.Json.createService();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_test);
  }
}
