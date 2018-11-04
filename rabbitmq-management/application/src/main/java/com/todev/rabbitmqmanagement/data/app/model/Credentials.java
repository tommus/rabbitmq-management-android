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
package com.todev.rabbitmqmanagement.data.app.model;

import android.content.SharedPreferences;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Credentials {
  private static final String KEY_USERNAME = "credentials_username";
  private static final String KEY_PASSWORD = "credentials_password";
  private static final String KEY_SERVICE = "credentials_service";
  private static final String KEY_REMEMBER = "credentials_remember";

  protected SharedPreferences sharedPreferences;
  private String username;
  private String password;
  private int service;
  private boolean remember;

  public Credentials(SharedPreferences sharedPreferences) {
    this.sharedPreferences = sharedPreferences;
    load();
  }

  public void save() {
    SharedPreferences.Editor editor = sharedPreferences.edit();
    saveUsername(editor, username);
    savePasssword(editor, password);
    saveService(editor, service);
    saveRemember(editor, remember);
    editor.apply();
  }

  public void clean() {
    SharedPreferences.Editor editor = sharedPreferences.edit();
    removeUsername(editor);
    removePassword(editor);
    removeService(editor);
    removeRemember(editor);
    editor.apply();
  }

  protected void load() {
    username = loadUsername(sharedPreferences);
    password = loadPassword(sharedPreferences);
    service = loadService(sharedPreferences);
    remember = loadRemember(sharedPreferences);
  }

  protected String loadUsername(SharedPreferences sharedPreferences) {
    return sharedPreferences.getString(KEY_USERNAME, "");
  }

  protected void removeUsername(SharedPreferences.Editor editor) {
    editor.remove(KEY_USERNAME);
  }

  protected void saveUsername(SharedPreferences.Editor editor, String username) {
    editor.putString(KEY_USERNAME, username);
  }

  protected String loadPassword(SharedPreferences sharedPreferences) {
    return sharedPreferences.getString(KEY_PASSWORD, "");
  }

  protected void removePassword(SharedPreferences.Editor editor) {
    editor.remove(KEY_PASSWORD);
  }

  protected void savePasssword(SharedPreferences.Editor editor, String password) {
    editor.putString(KEY_PASSWORD, password);
  }

  protected int loadService(SharedPreferences sharedPreferences) {
    return sharedPreferences.getInt(KEY_SERVICE, 0);
  }

  protected void removeService(SharedPreferences.Editor editor) {
    editor.remove(KEY_SERVICE);
  }

  protected void saveService(SharedPreferences.Editor editor, int service) {
    editor.putInt(KEY_SERVICE, service);
  }

  protected boolean loadRemember(SharedPreferences sharedPreferences) {
    return sharedPreferences.getBoolean(KEY_REMEMBER, false);
  }

  protected void removeRemember(SharedPreferences.Editor editor) {
    editor.remove(KEY_REMEMBER);
  }

  protected void saveRemember(SharedPreferences.Editor editor, boolean remember) {
    editor.putBoolean(KEY_REMEMBER, remember);
  }
}
