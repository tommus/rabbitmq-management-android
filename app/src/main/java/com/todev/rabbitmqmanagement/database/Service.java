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
package com.todev.rabbitmqmanagement.database;

import android.support.annotation.NonNull;
import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;
import java.util.List;

@Table(name = "Services")
public class Service extends Model implements Comparable<Service> {

  @Column(name = "Label", index = true)
  private String label;

  @Column(name = "Address")
  private String address;

  @Column(name = "Port")
  private int port;

  public Service() {
    super();
  }

  public Service(String label, String address, int port) {
    super();
    this.label = label;
    this.address = address;
    this.port = port;
  }

  @Override
  public int compareTo(@NonNull Service service) {
    return getLabel().compareTo(service.getLabel());
  }

  public String getLabel() {
    return label;
  }

  public String getAddress() {
    return address;
  }

  public int getPort() {
    return port;
  }

  public static List<Service> all() {
    return new Select().from(Service.class).execute();
  }

  public static Service singleByLabel(String label) {
    return new Select().from(Service.class).where("Label = ?", label).executeSingle();
  }

  public static List<Service> listByLabel(String label) {
    return new Select().from(Service.class).where("Label = ?", label).execute();
  }

  public static boolean exists(String label) {
    return new Select().from(Service.class).where("Label = ?").exists();
  }
}
