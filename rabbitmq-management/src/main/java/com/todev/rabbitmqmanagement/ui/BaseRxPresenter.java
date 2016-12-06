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

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class BaseRxPresenter {

  protected CompositeDisposable disposable = new CompositeDisposable();

  public void unsubscribe() {
    if (!disposable.isDisposed()) {
      disposable.clear();
    }
  }

  public Scheduler getSubscribeScheduler() {
    return Schedulers.io();
  }

  public Scheduler getObserveScheduler() {
    return AndroidSchedulers.mainThread();
  }
}
