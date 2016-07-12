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
package com.todev.rabbitmqmanagement.models.nodes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.todev.rabbitmqmanagement.models.Context;
import com.todev.rabbitmqmanagement.models.Description;
import com.todev.rabbitmqmanagement.models.Details;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Node {

  @JsonProperty("applications")
  protected List<Application> applications = new ArrayList<>();

  @JsonProperty("auth_mechanisms")
  protected List<Description> authMechanisms = new ArrayList<>();

  // TODO: Cluster links should be corrected.

  @JsonProperty("cluster_links")
  protected List<Object> clusterLinks = new ArrayList<>();

  @JsonProperty("config_files")
  protected List<String> configFiles = new ArrayList<>();

  @JsonProperty("contexts")
  protected List<Context> contexts = new ArrayList<>();

  @JsonProperty("db_dir")
  protected String dbDir;

  @JsonProperty("disk_free")
  protected long diskFree;

  @JsonProperty("disk_free_alarm")
  protected boolean diskFreeAlarm;

  @JsonProperty("disk_free_details")
  protected Details diskFreeDetails;

  @JsonProperty("disk_free_limit")
  protected long diskFreeLimit;

  @JsonProperty("enabled_plugins")
  protected List<String> enabledPlugins = new ArrayList<>();

  @JsonProperty("exchange_types")
  protected List<Description> exchangeTypes = new ArrayList<>();

  @JsonProperty("fd_total")
  protected int fdTotal;

  @JsonProperty("fd_used")
  protected int fdUsed;

  @JsonProperty("fd_used_details")
  protected Details fdUsedDetails;

  @JsonProperty("io_read_avg_time")
  protected float ioReadAvgTime;

  @JsonProperty("io_read_avg_time_details")
  protected Details ioReadAvgTimeDetails;

  @JsonProperty("io_read_bytes")
  protected int ioReadBytes;

  @JsonProperty("io_read_bytes_details")
  protected Details ioReadBytesDetails;

  @JsonProperty("io_read_count")
  protected int ioReadCount;

  @JsonProperty("io_read_count_details")
  protected Details ioReadCountDetails;

  @JsonProperty("io_reopen_count")
  protected int ioReopenCount;

  @JsonProperty("io_reopen_count_details")
  protected Details ioReopenCountDetails;

  @JsonProperty("io_seek_avg_time")
  protected float ioSeekAvgTime;

  @JsonProperty("io_seek_avg_time_details")
  protected Details ioSeekAvgTimeDetails;

  @JsonProperty("io_seek_count")
  protected int ioSeekCount;

  @JsonProperty("io_seek_count_details")
  protected Details ioSeekCountDetails;

  @JsonProperty("io_sync_avg_time")
  protected float ioSyncAvgTime;

  @JsonProperty("io_sync_avg_time_details")
  protected Details ioSyncAvgTimeDetails;

  @JsonProperty("io_sync_count")
  protected int ioSyncCount;

  @JsonProperty("io_sync_count_details")
  protected Details ioSyncCountDetails;

  @JsonProperty("io_write_avg_time")
  protected float ioWriteAvgTime;

  @JsonProperty("io_write_avg_time_details")
  protected Details ioWriteAvgTimeDetails;

  @JsonProperty("io_write_bytes")
  protected long ioWriteBytes;

  @JsonProperty("io_write_bytes_details")
  protected Details ioWriteBytesDetails;

  @JsonProperty("io_write_count")
  protected int ioWriteCount;

  @JsonProperty("io_write_count_details")
  protected Details ioWriteCountDetails;

  @JsonProperty("log_file")
  protected String logFile;

  @JsonProperty("mem_alarm")
  protected boolean memAlarm;

  @JsonProperty("mem_limit")
  protected long memLimit;

  @JsonProperty("mem_used")
  protected long memUsed;

  @JsonProperty("mem_used_details")
  protected Details memUsedDetails;

  @JsonProperty("mnesia_disk_tx_count")
  protected int mnesiaDiskTxCount;

  @JsonProperty("mnesia_disk_tx_count_details")
  protected Details mnesiaDiskTxCountDetails;

  @JsonProperty("mnesia_ram_tx_count")
  protected int mnesiaRamTxCount;

  @JsonProperty("mnesia_ram_tx_count_details")
  protected Details mnesiaRamTxCountDetails;

  @JsonProperty("msg_store_read_count")
  protected int msgStoreReadCount;

  @JsonProperty("msg_store_read_count_details")
  protected Details msgStoreReadCountDetails;

  @JsonProperty("msg_store_write_count")
  protected int msgStoreWriteCount;

  @JsonProperty("msg_store_write_count_details")
  protected Details msgStoreWriteCountDetails;

  @JsonProperty("name")
  protected String name;

  @JsonProperty("net_ticktime")
  protected int netTicktime;

  @JsonProperty("os_pid")
  protected String osPid;

  // TODO: Partitions should be corrected.

  @JsonProperty("partitions")
  protected List<Object> partitions = new ArrayList<>();

  @JsonProperty("proc_total")
  protected int procTotal;

  @JsonProperty("proc_used")
  protected int procUsed;

  @JsonProperty("proc_used_details")
  protected Details procUsedDetails;

  @JsonProperty("processors")
  protected int processors;

  @JsonProperty("queue_index_journal_write_count")
  protected int queueIndexJournalWriteCount;

  @JsonProperty("queue_index_journal_write_count_details")
  protected Details queueIndexJournalWriteCountDetails;

  @JsonProperty("queue_index_read_count")
  protected int queueIndexReadCount;

  @JsonProperty("queue_index_read_count_details")
  protected Details queueIndexReadCountDetails;

  @JsonProperty("queue_index_write_count")
  protected int queueIndexWriteCount;

  @JsonProperty("queue_index_write_count_details")
  protected Details queueIndexWriteCountDetails;

  @JsonProperty("rates_mode")
  protected String ratesMode;

  @JsonProperty("run_queue")
  protected int runQueue;

  @JsonProperty("running")
  protected boolean running;

  @JsonProperty("sasl_log_file")
  protected String saslLogFile;

  @JsonProperty("sockets_total")
  protected int socketsTotal;

  @JsonProperty("sockets_used")
  protected int socketsUsed;

  @JsonProperty("sockets_used_details")
  protected Details socketsUsedDetails;

  @JsonProperty("type")
  protected String type;

  @JsonProperty("uptime")
  protected int uptime;

  public List<Application> getApplications() {
    return applications;
  }

  public List<Description> getAuthMechanisms() {
    return authMechanisms;
  }

  public List<Object> getClusterLinks() {
    return clusterLinks;
  }

  public List<String> getConfigFiles() {
    return configFiles;
  }

  public List<Context> getContexts() {
    return contexts;
  }

  public String getDbDir() {
    return dbDir;
  }

  public long getDiskFree() {
    return diskFree;
  }

  public boolean isDiskFreeAlarm() {
    return diskFreeAlarm;
  }

  public Details getDiskFreeDetails() {
    return diskFreeDetails;
  }

  public long getDiskFreeLimit() {
    return diskFreeLimit;
  }

  public List<String> getEnabledPlugins() {
    return enabledPlugins;
  }

  public List<Description> getExchangeTypes() {
    return exchangeTypes;
  }

  public int getFdTotal() {
    return fdTotal;
  }

  public int getFdUsed() {
    return fdUsed;
  }

  public Details getFdUsedDetails() {
    return fdUsedDetails;
  }

  public float getIoReadAvgTime() {
    return ioReadAvgTime;
  }

  public Details getIoReadAvgTimeDetails() {
    return ioReadAvgTimeDetails;
  }

  public int getIoReadBytes() {
    return ioReadBytes;
  }

  public Details getIoReadBytesDetails() {
    return ioReadBytesDetails;
  }

  public int getIoReadCount() {
    return ioReadCount;
  }

  public Details getIoReadCountDetails() {
    return ioReadCountDetails;
  }

  public int getIoReopenCount() {
    return ioReopenCount;
  }

  public Details getIoReopenCountDetails() {
    return ioReopenCountDetails;
  }

  public float getIoSeekAvgTime() {
    return ioSeekAvgTime;
  }

  public Details getIoSeekAvgTimeDetails() {
    return ioSeekAvgTimeDetails;
  }

  public int getIoSeekCount() {
    return ioSeekCount;
  }

  public Details getIoSeekCountDetails() {
    return ioSeekCountDetails;
  }

  public float getIoSyncAvgTime() {
    return ioSyncAvgTime;
  }

  public Details getIoSyncAvgTimeDetails() {
    return ioSyncAvgTimeDetails;
  }

  public int getIoSyncCount() {
    return ioSyncCount;
  }

  public Details getIoSyncCountDetails() {
    return ioSyncCountDetails;
  }

  public float getIoWriteAvgTime() {
    return ioWriteAvgTime;
  }

  public Details getIoWriteAvgTimeDetails() {
    return ioWriteAvgTimeDetails;
  }

  public long getIoWriteBytes() {
    return ioWriteBytes;
  }

  public Details getIoWriteBytesDetails() {
    return ioWriteBytesDetails;
  }

  public int getIoWriteCount() {
    return ioWriteCount;
  }

  public Details getIoWriteCountDetails() {
    return ioWriteCountDetails;
  }

  public String getLogFile() {
    return logFile;
  }

  public boolean isMemAlarm() {
    return memAlarm;
  }

  public long getMemLimit() {
    return memLimit;
  }

  public long getMemUsed() {
    return memUsed;
  }

  public Details getMemUsedDetails() {
    return memUsedDetails;
  }

  public int getMnesiaDiskTxCount() {
    return mnesiaDiskTxCount;
  }

  public Details getMnesiaDiskTxCountDetails() {
    return mnesiaDiskTxCountDetails;
  }

  public int getMnesiaRamTxCount() {
    return mnesiaRamTxCount;
  }

  public Details getMnesiaRamTxCountDetails() {
    return mnesiaRamTxCountDetails;
  }

  public int getMsgStoreReadCount() {
    return msgStoreReadCount;
  }

  public Details getMsgStoreReadCountDetails() {
    return msgStoreReadCountDetails;
  }

  public int getMsgStoreWriteCount() {
    return msgStoreWriteCount;
  }

  public Details getMsgStoreWriteCountDetails() {
    return msgStoreWriteCountDetails;
  }

  public String getName() {
    return name;
  }

  public int getNetTicktime() {
    return netTicktime;
  }

  public String getOsPid() {
    return osPid;
  }

  public List<Object> getPartitions() {
    return partitions;
  }

  public int getProcTotal() {
    return procTotal;
  }

  public int getProcUsed() {
    return procUsed;
  }

  public Details getProcUsedDetails() {
    return procUsedDetails;
  }

  public int getProcessors() {
    return processors;
  }

  public int getQueueIndexJournalWriteCount() {
    return queueIndexJournalWriteCount;
  }

  public Details getQueueIndexJournalWriteCountDetails() {
    return queueIndexJournalWriteCountDetails;
  }

  public int getQueueIndexReadCount() {
    return queueIndexReadCount;
  }

  public Details getQueueIndexReadCountDetails() {
    return queueIndexReadCountDetails;
  }

  public int getQueueIndexWriteCount() {
    return queueIndexWriteCount;
  }

  public Details getQueueIndexWriteCountDetails() {
    return queueIndexWriteCountDetails;
  }

  public String getRatesMode() {
    return ratesMode;
  }

  public int getRunQueue() {
    return runQueue;
  }

  public boolean isRunning() {
    return running;
  }

  public String getSaslLogFile() {
    return saslLogFile;
  }

  public int getSocketsTotal() {
    return socketsTotal;
  }

  public int getSocketsUsed() {
    return socketsUsed;
  }

  public Details getSocketsUsedDetails() {
    return socketsUsedDetails;
  }

  public String getType() {
    return type;
  }

  public int getUptime() {
    return uptime;
  }
}
