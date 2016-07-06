/*
 * Copyright (c) 2016. to-dev.com.
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
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Node {

    @JsonProperty("applications")
    protected List<Application> mApplications = new ArrayList<>();

    @JsonProperty("auth_mechanisms")
    protected List<Description> mAuthMechanisms = new ArrayList<>();

    // TODO: Cluster links should be corrected.

    @JsonProperty("cluster_links")
    protected List<Object> mClusterLinks = new ArrayList<>();

    @JsonProperty("config_files")
    protected List<String> mConfigFiles = new ArrayList<>();

    @JsonProperty("contexts")
    protected List<Context> mContexts = new ArrayList<>();

    @JsonProperty("db_dir")
    protected String mDbDir;

    @JsonProperty("disk_free")
    protected long mDiskFree;

    @JsonProperty("disk_free_alarm")
    protected boolean mDiskFreeAlarm;

    @JsonProperty("disk_free_details")
    protected Details mDiskFreeDetails;

    @JsonProperty("disk_free_limit")
    protected long mDiskFreeLimit;

    @JsonProperty("enabled_plugins")
    protected List<String> mEnabledPlugins = new ArrayList<>();

    @JsonProperty("exchange_types")
    protected List<Description> mExchangeTypes = new ArrayList<>();

    @JsonProperty("fd_total")
    protected int mFdTotal;

    @JsonProperty("fd_used")
    protected int mFdUsed;

    @JsonProperty("fd_used_details")
    protected Details mFdUsedDetails;

    @JsonProperty("io_read_avg_time")
    protected float mIoReadAvgTime;

    @JsonProperty("io_read_avg_time_details")
    protected Details mIoReadAvgTimeDetails;

    @JsonProperty("io_read_bytes")
    protected int mIoReadBytes;

    @JsonProperty("io_read_bytes_details")
    protected Details mIoReadBytesDetails;

    @JsonProperty("io_read_count")
    protected int mIoReadCount;

    @JsonProperty("io_read_count_details")
    protected Details mIoReadCountDetails;

    @JsonProperty("io_reopen_count")
    protected int mIoReopenCount;

    @JsonProperty("io_reopen_count_details")
    protected Details mIoReopenCountDetails;

    @JsonProperty("io_seek_avg_time")
    protected float mIoSeekAvgTime;

    @JsonProperty("io_seek_avg_time_details")
    protected Details mIoSeekAvgTimeDetails;

    @JsonProperty("io_seek_count")
    protected int mIoSeekCount;

    @JsonProperty("io_seek_count_details")
    protected Details mIoSeekCountDetails;

    @JsonProperty("io_sync_avg_time")
    protected float mIoSyncAvgTime;

    @JsonProperty("io_sync_avg_time_details")
    protected Details mIoSyncAvgTimeDetails;

    @JsonProperty("io_sync_count")
    protected int mIoSyncCount;

    @JsonProperty("io_sync_count_details")
    protected Details mIoSyncCountDetails;

    @JsonProperty("io_write_avg_time")
    protected float mIoWriteAvgTime;

    @JsonProperty("io_write_avg_time_details")
    protected Details mIoWriteAvgTimeDetails;

    @JsonProperty("io_write_bytes")
    protected long mIoWriteBytes;

    @JsonProperty("io_write_bytes_details")
    protected Details mIoWriteBytesDetails;

    @JsonProperty("io_write_count")
    protected int mIoWriteCount;

    @JsonProperty("io_write_count_details")
    protected Details mIoWriteCountDetails;

    @JsonProperty("log_file")
    protected String mLogFile;

    @JsonProperty("mem_alarm")
    protected boolean mMemAlarm;

    @JsonProperty("mem_limit")
    protected long mMemLimit;

    @JsonProperty("mem_used")
    protected long mMemUsed;

    @JsonProperty("mem_used_details")
    protected Details mMemUsedDetails;

    @JsonProperty("mnesia_disk_tx_count")
    protected int mMnesiaDiskTxCount;

    @JsonProperty("mnesia_disk_tx_count_details")
    protected Details mMnesiaDiskTxCountDetails;

    @JsonProperty("mnesia_ram_tx_count")
    protected int mMnesiaRamTxCount;

    @JsonProperty("mnesia_ram_tx_count_details")
    protected Details mMnesiaRamTxCountDetails;

    @JsonProperty("msg_store_read_count")
    protected int mMsgStoreReadCount;

    @JsonProperty("msg_store_read_count_details")
    protected Details mMsgStoreReadCountDetails;

    @JsonProperty("msg_store_write_count")
    protected int mMsgStoreWriteCount;

    @JsonProperty("msg_store_write_count_details")
    protected Details mMsgStoreWriteCountDetails;

    @JsonProperty("name")
    protected String mName;

    @JsonProperty("net_ticktime")
    protected int mNetTicktime;

    @JsonProperty("os_pid")
    protected String mOsPid;

    // TODO: Partitions should be corrected.

    @JsonProperty("partitions")
    protected List<Object> mPartitions = new ArrayList<>();

    @JsonProperty("proc_total")
    protected int mProcTotal;

    @JsonProperty("proc_used")
    protected int mProcUsed;

    @JsonProperty("proc_used_details")
    protected Details mProcUsedDetails;

    @JsonProperty("processors")
    protected int mProcessors;

    @JsonProperty("queue_index_journal_write_count")
    protected int mQueueIndexJournalWriteCount;

    @JsonProperty("queue_index_journal_write_count_details")
    protected Details mQueueIndexJournalWriteCountDetails;

    @JsonProperty("queue_index_read_count")
    protected int mQueueIndexReadCount;

    @JsonProperty("queue_index_read_count_details")
    protected Details mQueueIndexReadCountDetails;

    @JsonProperty("queue_index_write_count")
    protected int mQueueIndexWriteCount;

    @JsonProperty("queue_index_write_count_details")
    protected Details mQueueIndexWriteCountDetails;

    @JsonProperty("rates_mode")
    protected String mRatesMode;

    @JsonProperty("run_queue")
    protected int mRunQueue;

    @JsonProperty("running")
    protected boolean mRunning;

    @JsonProperty("sasl_log_file")
    protected String mSaslLogFile;

    @JsonProperty("sockets_total")
    protected int mSocketsTotal;

    @JsonProperty("sockets_used")
    protected int mSocketsUsed;

    @JsonProperty("sockets_used_details")
    protected Details mSocketsUsedDetails;

    @JsonProperty("type")
    protected String mType;

    @JsonProperty("uptime")
    protected int mUptime;

    public List<Application> getApplications() {

        return mApplications;
    }

    public List<Description> getAuthMechanisms() {

        return mAuthMechanisms;
    }

    public List<Object> getClusterLinks() {

        return mClusterLinks;
    }

    public List<String> getConfigFiles() {

        return mConfigFiles;
    }

    public List<Context> getContexts() {

        return mContexts;
    }

    public String getDbDir() {

        return mDbDir;
    }

    public long getDiskFree() {

        return mDiskFree;
    }

    public boolean isDiskFreeAlarm() {

        return mDiskFreeAlarm;
    }

    public Details getDiskFreeDetails() {

        return mDiskFreeDetails;
    }

    public long getDiskFreeLimit() {

        return mDiskFreeLimit;
    }

    public List<String> getEnabledPlugins() {

        return mEnabledPlugins;
    }

    public List<Description> getExchangeTypes() {

        return mExchangeTypes;
    }

    public int getFdTotal() {

        return mFdTotal;
    }

    public int getFdUsed() {

        return mFdUsed;
    }

    public Details getFdUsedDetails() {

        return mFdUsedDetails;
    }

    public float getIoReadAvgTime() {

        return mIoReadAvgTime;
    }

    public Details getIoReadAvgTimeDetails() {

        return mIoReadAvgTimeDetails;
    }

    public int getIoReadBytes() {

        return mIoReadBytes;
    }

    public Details getIoReadBytesDetails() {

        return mIoReadBytesDetails;
    }

    public int getIoReadCount() {

        return mIoReadCount;
    }

    public Details getIoReadCountDetails() {

        return mIoReadCountDetails;
    }

    public int getIoReopenCount() {

        return mIoReopenCount;
    }

    public Details getIoReopenCountDetails() {

        return mIoReopenCountDetails;
    }

    public float getIoSeekAvgTime() {

        return mIoSeekAvgTime;
    }

    public Details getIoSeekAvgTimeDetails() {

        return mIoSeekAvgTimeDetails;
    }

    public int getIoSeekCount() {

        return mIoSeekCount;
    }

    public Details getIoSeekCountDetails() {

        return mIoSeekCountDetails;
    }

    public float getIoSyncAvgTime() {

        return mIoSyncAvgTime;
    }

    public Details getIoSyncAvgTimeDetails() {

        return mIoSyncAvgTimeDetails;
    }

    public int getIoSyncCount() {

        return mIoSyncCount;
    }

    public Details getIoSyncCountDetails() {

        return mIoSyncCountDetails;
    }

    public float getIoWriteAvgTime() {

        return mIoWriteAvgTime;
    }

    public Details getIoWriteAvgTimeDetails() {

        return mIoWriteAvgTimeDetails;
    }

    public long getIoWriteBytes() {

        return mIoWriteBytes;
    }

    public Details getIoWriteBytesDetails() {

        return mIoWriteBytesDetails;
    }

    public int getIoWriteCount() {

        return mIoWriteCount;
    }

    public Details getIoWriteCountDetails() {

        return mIoWriteCountDetails;
    }

    public String getLogFile() {

        return mLogFile;
    }

    public boolean isMemAlarm() {

        return mMemAlarm;
    }

    public long getMemLimit() {

        return mMemLimit;
    }

    public long getMemUsed() {

        return mMemUsed;
    }

    public Details getMemUsedDetails() {

        return mMemUsedDetails;
    }

    public int getMnesiaDiskTxCount() {

        return mMnesiaDiskTxCount;
    }

    public Details getMnesiaDiskTxCountDetails() {

        return mMnesiaDiskTxCountDetails;
    }

    public int getMnesiaRamTxCount() {

        return mMnesiaRamTxCount;
    }

    public Details getMnesiaRamTxCountDetails() {

        return mMnesiaRamTxCountDetails;
    }

    public int getMsgStoreReadCount() {

        return mMsgStoreReadCount;
    }

    public Details getMsgStoreReadCountDetails() {

        return mMsgStoreReadCountDetails;
    }

    public int getMsgStoreWriteCount() {

        return mMsgStoreWriteCount;
    }

    public Details getMsgStoreWriteCountDetails() {

        return mMsgStoreWriteCountDetails;
    }

    public String getName() {

        return mName;
    }

    public int getNetTicktime() {

        return mNetTicktime;
    }

    public String getOsPid() {

        return mOsPid;
    }

    public List<Object> getPartitions() {

        return mPartitions;
    }

    public int getProcTotal() {

        return mProcTotal;
    }

    public int getProcUsed() {

        return mProcUsed;
    }

    public Details getProcUsedDetails() {

        return mProcUsedDetails;
    }

    public int getProcessors() {

        return mProcessors;
    }

    public int getQueueIndexJournalWriteCount() {

        return mQueueIndexJournalWriteCount;
    }

    public Details getQueueIndexJournalWriteCountDetails() {

        return mQueueIndexJournalWriteCountDetails;
    }

    public int getQueueIndexReadCount() {

        return mQueueIndexReadCount;
    }

    public Details getQueueIndexReadCountDetails() {

        return mQueueIndexReadCountDetails;
    }

    public int getQueueIndexWriteCount() {

        return mQueueIndexWriteCount;
    }

    public Details getQueueIndexWriteCountDetails() {

        return mQueueIndexWriteCountDetails;
    }

    public String getRatesMode() {

        return mRatesMode;
    }

    public int getRunQueue() {

        return mRunQueue;
    }

    public boolean isRunning() {

        return mRunning;
    }

    public String getSaslLogFile() {

        return mSaslLogFile;
    }

    public int getSocketsTotal() {

        return mSocketsTotal;
    }

    public int getSocketsUsed() {

        return mSocketsUsed;
    }

    public Details getSocketsUsedDetails() {

        return mSocketsUsedDetails;
    }

    public String getType() {

        return mType;
    }

    public int getUptime() {

        return mUptime;
    }
}
