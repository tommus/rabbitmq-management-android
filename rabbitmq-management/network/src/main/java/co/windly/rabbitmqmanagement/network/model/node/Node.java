package co.windly.rabbitmqmanagement.network.model.node;

import co.windly.rabbitmqmanagement.network.model.Context;
import co.windly.rabbitmqmanagement.network.model.Description;
import co.windly.rabbitmqmanagement.network.model.Details;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class Node {

  //region Applications

  @JsonProperty(value = "applications")
  private List<Application> applications = new ArrayList<>();

  public List<Application> getApplications() {
    return applications;
  }

  public void setApplications(List<Application> applications) {
    this.applications = applications;
  }

  //endregion

  //region Auth Mechanisms

  @JsonProperty(value = "auth_mechanisms")
  private List<Description> authMechanisms = new ArrayList<>();

  public List<Description> getAuthMechanisms() {
    return authMechanisms;
  }

  public void setAuthMechanisms(List<Description> authMechanisms) {
    this.authMechanisms = authMechanisms;
  }

  //endregion

  //region Cluster Links

  // TODO: Cluster links should be corrected.

  @JsonProperty(value = "cluster_links")
  private List<Object> clusterLinks = new ArrayList<>();

  public List<Object> getClusterLinks() {
    return clusterLinks;
  }

  public void setClusterLinks(List<Object> clusterLinks) {
    this.clusterLinks = clusterLinks;
  }

  //endregion

  //region Config Files

  @JsonProperty(value = "config_files")
  private List<String> configFiles = new ArrayList<>();

  public List<String> getConfigFiles() {
    return configFiles;
  }

  public void setConfigFiles(List<String> configFiles) {
    this.configFiles = configFiles;
  }

  //endregion

  //region Contexts

  @JsonProperty(value = "contexts")
  private List<Context> contexts = new ArrayList<>();

  public List<Context> getContexts() {
    return contexts;
  }

  public void setContexts(List<Context> contexts) {
    this.contexts = contexts;
  }

  //endregion

  //region Db Dir

  @JsonProperty(value = "db_dir")
  private String dbDir;

  public String getDbDir() {
    return dbDir;
  }

  public void setDbDir(String dbDir) {
    this.dbDir = dbDir;
  }

  //endregion

  //region Disk Free

  @JsonProperty(value = "disk_free")
  private long diskFree;

  public long getDiskFree() {
    return diskFree;
  }

  public void setDiskFree(long diskFree) {
    this.diskFree = diskFree;
  }

  //endregion

  //region Disk Free Alarm

  @JsonProperty(value = "disk_free_alarm")
  private boolean diskFreeAlarm;

  public boolean isDiskFreeAlarm() {
    return diskFreeAlarm;
  }

  public void setDiskFreeAlarm(boolean diskFreeAlarm) {
    this.diskFreeAlarm = diskFreeAlarm;
  }

  //endregion

  //region Disk Free Details

  @JsonProperty(value = "disk_free_details")
  private Details diskFreeDetails;

  public Details getDiskFreeDetails() {
    return diskFreeDetails;
  }

  public void setDiskFreeDetails(Details diskFreeDetails) {
    this.diskFreeDetails = diskFreeDetails;
  }

  //endregion

  //region Disk Free Limit

  @JsonProperty(value = "disk_free_limit")
  private long diskFreeLimit;

  public long getDiskFreeLimit() {
    return diskFreeLimit;
  }

  public void setDiskFreeLimit(long diskFreeLimit) {
    this.diskFreeLimit = diskFreeLimit;
  }

  //endregion

  //region Enabled Plugins

  @JsonProperty(value = "enabled_plugins")
  private List<String> enabledPlugins = new ArrayList<>();

  public List<String> getEnabledPlugins() {
    return enabledPlugins;
  }

  public void setEnabledPlugins(List<String> enabledPlugins) {
    this.enabledPlugins = enabledPlugins;
  }

  //endregion

  //region Exchange Types

  @JsonProperty(value = "exchange_types")
  private List<Description> exchangeTypes = new ArrayList<>();

  public List<Description> getExchangeTypes() {
    return exchangeTypes;
  }

  public void setExchangeTypes(List<Description> exchangeTypes) {
    this.exchangeTypes = exchangeTypes;
  }

  //endregion

  //region Fd Total

  @JsonProperty(value = "fd_total")
  private int fdTotal;

  public int getFdTotal() {
    return fdTotal;
  }

  public void setFdTotal(int fdTotal) {
    this.fdTotal = fdTotal;
  }

  //endregion

  //region Fd Used

  @JsonProperty(value = "fd_used")
  private int fdUsed;

  public int getFdUsed() {
    return fdUsed;
  }

  public void setFdUsed(int fdUsed) {
    this.fdUsed = fdUsed;
  }

  //endregion

  //region Fd Used Details

  @JsonProperty(value = "fd_used_details")
  private Details fdUsedDetails;

  public Details getFdUsedDetails() {
    return fdUsedDetails;
  }

  public void setFdUsedDetails(Details fdUsedDetails) {
    this.fdUsedDetails = fdUsedDetails;
  }

  //endregion

  //region I/O Read Avg Time

  @JsonProperty(value = "io_read_avg_time")
  private float ioReadAvgTime;

  public float getIoReadAvgTime() {
    return ioReadAvgTime;
  }

  public void setIoReadAvgTime(float ioReadAvgTime) {
    this.ioReadAvgTime = ioReadAvgTime;
  }

  //endregion

  //region I/O Read Avg Time Details

  @JsonProperty(value = "io_read_avg_time_details")
  private Details ioReadAvgTimeDetails;

  public Details getIoReadAvgTimeDetails() {
    return ioReadAvgTimeDetails;
  }

  public void setIoReadAvgTimeDetails(Details ioReadAvgTimeDetails) {
    this.ioReadAvgTimeDetails = ioReadAvgTimeDetails;
  }

  //endregion

  //region I/O Read Bytes

  @JsonProperty(value = "io_read_bytes")
  private int ioReadBytes;

  public int getIoReadBytes() {
    return ioReadBytes;
  }

  public void setIoReadBytes(int ioReadBytes) {
    this.ioReadBytes = ioReadBytes;
  }

  //endregion

  //region I/O Read Bytes Details

  @JsonProperty(value = "io_read_bytes_details")
  private Details ioReadBytesDetails;

  public Details getIoReadBytesDetails() {
    return ioReadBytesDetails;
  }

  public void setIoReadBytesDetails(Details ioReadBytesDetails) {
    this.ioReadBytesDetails = ioReadBytesDetails;
  }

  //endregion

  //region I/O Read Count

  @JsonProperty(value = "io_read_count")
  private int ioReadCount;

  public int getIoReadCount() {
    return ioReadCount;
  }

  public void setIoReadCount(int ioReadCount) {
    this.ioReadCount = ioReadCount;
  }

  //endregion

  //region I/O Read Count Details

  @JsonProperty(value = "io_read_count_details")
  private Details ioReadCountDetails;

  public Details getIoReadCountDetails() {
    return ioReadCountDetails;
  }

  public void setIoReadCountDetails(Details ioReadCountDetails) {
    this.ioReadCountDetails = ioReadCountDetails;
  }

  //endregion

  //region I/O Reopen Count

  @JsonProperty(value = "io_reopen_count")
  private int ioReopenCount;

  public int getIoReopenCount() {
    return ioReopenCount;
  }

  public void setIoReopenCount(int ioReopenCount) {
    this.ioReopenCount = ioReopenCount;
  }

  //endregion

  //region I/O Reopen Count Details

  @JsonProperty(value = "io_reopen_count_details")
  private Details ioReopenCountDetails;

  public Details getIoReopenCountDetails() {
    return ioReopenCountDetails;
  }

  public void setIoReopenCountDetails(Details ioReopenCountDetails) {
    this.ioReopenCountDetails = ioReopenCountDetails;
  }

  //endregion

  //region I/O Seek Avg Time

  @JsonProperty(value = "io_seek_avg_time")
  private float ioSeekAvgTime;

  public float getIoSeekAvgTime() {
    return ioSeekAvgTime;
  }

  public void setIoSeekAvgTime(float ioSeekAvgTime) {
    this.ioSeekAvgTime = ioSeekAvgTime;
  }

  //endregion

  //region I/O Seek Avg Time Details

  @JsonProperty(value = "io_seek_avg_time_details")
  private Details ioSeekAvgTimeDetails;

  public Details getIoSeekAvgTimeDetails() {
    return ioSeekAvgTimeDetails;
  }

  public void setIoSeekAvgTimeDetails(Details ioSeekAvgTimeDetails) {
    this.ioSeekAvgTimeDetails = ioSeekAvgTimeDetails;
  }

  //endregion

  //region I/O Seek Count

  @JsonProperty(value = "io_seek_count")
  private int ioSeekCount;

  public int getIoSeekCount() {
    return ioSeekCount;
  }

  public void setIoSeekCount(int ioSeekCount) {
    this.ioSeekCount = ioSeekCount;
  }

  //endregion

  //region I/O Seek Count Details

  @JsonProperty(value = "io_seek_count_details")
  private Details ioSeekCountDetails;

  public Details getIoSeekCountDetails() {
    return ioSeekCountDetails;
  }

  public void setIoSeekCountDetails(Details ioSeekCountDetails) {
    this.ioSeekCountDetails = ioSeekCountDetails;
  }

  //endregion

  //region I/O Sync Avg Time

  @JsonProperty(value = "io_sync_avg_time")
  private float ioSyncAvgTime;

  public float getIoSyncAvgTime() {
    return ioSyncAvgTime;
  }

  public void setIoSyncAvgTime(float ioSyncAvgTime) {
    this.ioSyncAvgTime = ioSyncAvgTime;
  }

  //endregion

  //region I/O Sync Avg Time Details

  @JsonProperty(value = "io_sync_avg_time_details")
  private Details ioSyncAvgTimeDetails;

  public Details getIoSyncAvgTimeDetails() {
    return ioSyncAvgTimeDetails;
  }

  public void setIoSyncAvgTimeDetails(Details ioSyncAvgTimeDetails) {
    this.ioSyncAvgTimeDetails = ioSyncAvgTimeDetails;
  }

  //endregion

  //region I/O Sync Count

  @JsonProperty(value = "io_sync_count")
  private int ioSyncCount;

  public int getIoSyncCount() {
    return ioSyncCount;
  }

  public void setIoSyncCount(int ioSyncCount) {
    this.ioSyncCount = ioSyncCount;
  }

  //endregion

  //region I/O Sync Count Details

  @JsonProperty(value = "io_sync_count_details")
  private Details ioSyncCountDetails;

  public Details getIoSyncCountDetails() {
    return ioSyncCountDetails;
  }

  public void setIoSyncCountDetails(Details ioSyncCountDetails) {
    this.ioSyncCountDetails = ioSyncCountDetails;
  }

  //endregion

  //region I/O Write Avg Time

  @JsonProperty(value = "io_write_avg_time")
  private float ioWriteAvgTime;

  public float getIoWriteAvgTime() {
    return ioWriteAvgTime;
  }

  public void setIoWriteAvgTime(float ioWriteAvgTime) {
    this.ioWriteAvgTime = ioWriteAvgTime;
  }

  //endregion

  //region I/O Write Avg Time Details

  @JsonProperty(value = "io_write_avg_time_details")
  private Details ioWriteAvgTimeDetails;

  public Details getIoWriteAvgTimeDetails() {
    return ioWriteAvgTimeDetails;
  }

  public void setIoWriteAvgTimeDetails(Details ioWriteAvgTimeDetails) {
    this.ioWriteAvgTimeDetails = ioWriteAvgTimeDetails;
  }

  //endregion

  //region I/O Write Bytes

  @JsonProperty(value = "io_write_bytes")
  private long ioWriteBytes;

  public long getIoWriteBytes() {
    return ioWriteBytes;
  }

  public void setIoWriteBytes(long ioWriteBytes) {
    this.ioWriteBytes = ioWriteBytes;
  }

  //endregion

  //region I/O Write Bytes Details

  @JsonProperty(value = "io_write_bytes_details")
  private Details ioWriteBytesDetails;

  public Details getIoWriteBytesDetails() {
    return ioWriteBytesDetails;
  }

  public void setIoWriteBytesDetails(Details ioWriteBytesDetails) {
    this.ioWriteBytesDetails = ioWriteBytesDetails;
  }

  //endregion

  //region I/O Write Count

  @JsonProperty(value = "io_write_count")
  private int ioWriteCount;

  public int getIoWriteCount() {
    return ioWriteCount;
  }

  public void setIoWriteCount(int ioWriteCount) {
    this.ioWriteCount = ioWriteCount;
  }

  //endregion

  //region I/O Write Count Details

  @JsonProperty(value = "io_write_count_details")
  private Details ioWriteCountDetails;

  public Details getIoWriteCountDetails() {
    return ioWriteCountDetails;
  }

  public void setIoWriteCountDetails(Details ioWriteCountDetails) {
    this.ioWriteCountDetails = ioWriteCountDetails;
  }

  //endregion

  //region Log File

  @JsonProperty(value = "log_file")
  private String logFile;

  public String getLogFile() {
    return logFile;
  }

  public void setLogFile(String logFile) {
    this.logFile = logFile;
  }

  //endregion

  //region Mem Alarm

  @JsonProperty(value = "mem_alarm")
  private boolean memAlarm;

  public boolean isMemAlarm() {
    return memAlarm;
  }

  public void setMemAlarm(boolean memAlarm) {
    this.memAlarm = memAlarm;
  }

  //endregion

  //region Mem Limit

  @JsonProperty(value = "mem_limit")
  private long memLimit;

  public long getMemLimit() {
    return memLimit;
  }

  public void setMemLimit(long memLimit) {
    this.memLimit = memLimit;
  }

  //endregion

  //region Mem Used

  @JsonProperty(value = "mem_used")
  private long memUsed;

  public long getMemUsed() {
    return memUsed;
  }

  public void setMemUsed(long memUsed) {
    this.memUsed = memUsed;
  }

  //endregion

  //region Mem Used Details

  @JsonProperty(value = "mem_used_details")
  private Details memUsedDetails;

  public Details getMemUsedDetails() {
    return memUsedDetails;
  }

  public void setMemUsedDetails(Details memUsedDetails) {
    this.memUsedDetails = memUsedDetails;
  }

  //endregion

  //region Mnesia Disk TX Count

  @JsonProperty(value = "mnesia_disk_tx_count")
  private int mnesiaDiskTxCount;

  public int getMnesiaDiskTxCount() {
    return mnesiaDiskTxCount;
  }

  public void setMnesiaDiskTxCount(int mnesiaDiskTxCount) {
    this.mnesiaDiskTxCount = mnesiaDiskTxCount;
  }

  //endregion

  //region Mnesia Disk TX Count Details

  @JsonProperty(value = "mnesia_disk_tx_count_details")
  private Details mnesiaDiskTxCountDetails;

  public Details getMnesiaDiskTxCountDetails() {
    return mnesiaDiskTxCountDetails;
  }

  public void setMnesiaDiskTxCountDetails(Details mnesiaDiskTxCountDetails) {
    this.mnesiaDiskTxCountDetails = mnesiaDiskTxCountDetails;
  }

  //endregion

  //region Mnesia Ram TX Count

  @JsonProperty(value = "mnesia_ram_tx_count")
  private int mnesiaRamTxCount;

  public int getMnesiaRamTxCount() {
    return mnesiaRamTxCount;
  }

  public void setMnesiaRamTxCount(int mnesiaRamTxCount) {
    this.mnesiaRamTxCount = mnesiaRamTxCount;
  }

  //endregion

  //region Mnesia Ram TX Count Details

  @JsonProperty(value = "mnesia_ram_tx_count_details")
  private Details mnesiaRamTxCountDetails;

  public Details getMnesiaRamTxCountDetails() {
    return mnesiaRamTxCountDetails;
  }

  public void setMnesiaRamTxCountDetails(Details mnesiaRamTxCountDetails) {
    this.mnesiaRamTxCountDetails = mnesiaRamTxCountDetails;
  }

  //endregion

  //region Msg Store Read Count

  @JsonProperty(value = "msg_store_read_count")
  private int msgStoreReadCount;

  public int getMsgStoreReadCount() {
    return msgStoreReadCount;
  }

  public void setMsgStoreReadCount(int msgStoreReadCount) {
    this.msgStoreReadCount = msgStoreReadCount;
  }

  //endregion

  //region Msg Store Read Count Details

  @JsonProperty(value = "msg_store_read_count_details")
  private Details msgStoreReadCountDetails;

  public Details getMsgStoreReadCountDetails() {
    return msgStoreReadCountDetails;
  }

  public void setMsgStoreReadCountDetails(Details msgStoreReadCountDetails) {
    this.msgStoreReadCountDetails = msgStoreReadCountDetails;
  }

  //endregion

  //region Msg Store Write Count

  @JsonProperty(value = "msg_store_write_count")
  private int msgStoreWriteCount;

  public int getMsgStoreWriteCount() {
    return msgStoreWriteCount;
  }

  public void setMsgStoreWriteCount(int msgStoreWriteCount) {
    this.msgStoreWriteCount = msgStoreWriteCount;
  }

  //endregion

  //region Msg Store Write Count Details

  @JsonProperty(value = "msg_store_write_count_details")
  private Details msgStoreWriteCountDetails;

  public Details getMsgStoreWriteCountDetails() {
    return msgStoreWriteCountDetails;
  }

  public void setMsgStoreWriteCountDetails(Details msgStoreWriteCountDetails) {
    this.msgStoreWriteCountDetails = msgStoreWriteCountDetails;
  }

  //endregion

  //region Name

  @JsonProperty(value = "name")
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  //endregion

  //region Net Ticktime

  @JsonProperty(value = "net_ticktime")
  private int netTicktime;

  public int getNetTicktime() {
    return netTicktime;
  }

  public void setNetTicktime(int netTicktime) {
    this.netTicktime = netTicktime;
  }

  //endregion

  //region OS Pid

  @JsonProperty(value = "os_pid")
  private String osPid;

  public String getOsPid() {
    return osPid;
  }

  public void setOsPid(String osPid) {
    this.osPid = osPid;
  }

  //endregion

  //region Partitions

  // TODO: Partitions should be corrected.

  @JsonProperty(value = "partitions")
  private List<Object> partitions = new ArrayList<>();

  public List<Object> getPartitions() {
    return partitions;
  }

  public void setPartitions(List<Object> partitions) {
    this.partitions = partitions;
  }

  //endregion

  //region Proc Total

  @JsonProperty(value = "proc_total")
  private int procTotal;

  public int getProcTotal() {
    return procTotal;
  }

  public void setProcTotal(int procTotal) {
    this.procTotal = procTotal;
  }

  //endregion

  //region Proc Used

  @JsonProperty(value = "proc_used")
  private int procUsed;

  public int getProcUsed() {
    return procUsed;
  }

  public void setProcUsed(int procUsed) {
    this.procUsed = procUsed;
  }

  //endregion

  //region Proc Used Details

  @JsonProperty(value = "proc_used_details")
  private Details procUsedDetails;

  public Details getProcUsedDetails() {
    return procUsedDetails;
  }

  public void setProcUsedDetails(Details procUsedDetails) {
    this.procUsedDetails = procUsedDetails;
  }

  //endregion

  //region Processors

  @JsonProperty(value = "processors")
  private int processors;

  public int getProcessors() {
    return processors;
  }

  public void setProcessors(int processors) {
    this.processors = processors;
  }

  //endregion

  //region Queue Index Journal Write Count

  @JsonProperty(value = "queue_index_journal_write_count")
  private int queueIndexJournalWriteCount;

  public int getQueueIndexJournalWriteCount() {
    return queueIndexJournalWriteCount;
  }

  public void setQueueIndexJournalWriteCount(int queueIndexJournalWriteCount) {
    this.queueIndexJournalWriteCount = queueIndexJournalWriteCount;
  }

  //endregion

  //region Queue Index Journal Write Count Details

  @JsonProperty(value = "queue_index_journal_write_count_details")
  private Details queueIndexJournalWriteCountDetails;

  public Details getQueueIndexJournalWriteCountDetails() {
    return queueIndexJournalWriteCountDetails;
  }

  public void setQueueIndexJournalWriteCountDetails(
    Details queueIndexJournalWriteCountDetails) {
    this.queueIndexJournalWriteCountDetails = queueIndexJournalWriteCountDetails;
  }

  //endregion

  //region Queue Index Read Count

  @JsonProperty(value = "queue_index_read_count")
  private int queueIndexReadCount;

  public int getQueueIndexReadCount() {
    return queueIndexReadCount;
  }

  public void setQueueIndexReadCount(int queueIndexReadCount) {
    this.queueIndexReadCount = queueIndexReadCount;
  }

  //endregion

  //region Queue Index Read Count Details

  @JsonProperty(value = "queue_index_read_count_details")
  private Details queueIndexReadCountDetails;

  public Details getQueueIndexReadCountDetails() {
    return queueIndexReadCountDetails;
  }

  public void setQueueIndexReadCountDetails(Details queueIndexReadCountDetails) {
    this.queueIndexReadCountDetails = queueIndexReadCountDetails;
  }

  //endregion

  //region Queue Index Write Count

  @JsonProperty(value = "queue_index_write_count")
  private int queueIndexWriteCount;

  public int getQueueIndexWriteCount() {
    return queueIndexWriteCount;
  }

  public void setQueueIndexWriteCount(int queueIndexWriteCount) {
    this.queueIndexWriteCount = queueIndexWriteCount;
  }

  //endregion

  //region Queue Index Write Count Details

  @JsonProperty(value = "queue_index_write_count_details")
  private Details queueIndexWriteCountDetails;

  public Details getQueueIndexWriteCountDetails() {
    return queueIndexWriteCountDetails;
  }

  public void setQueueIndexWriteCountDetails(Details queueIndexWriteCountDetails) {
    this.queueIndexWriteCountDetails = queueIndexWriteCountDetails;
  }

  //endregion

  //region Rates Mode

  @JsonProperty(value = "rates_mode")
  private String ratesMode;

  public String getRatesMode() {
    return ratesMode;
  }

  public void setRatesMode(String ratesMode) {
    this.ratesMode = ratesMode;
  }

  //endregion

  //region Run Queue

  @JsonProperty(value = "run_queue")
  private int runQueue;

  public int getRunQueue() {
    return runQueue;
  }

  public void setRunQueue(int runQueue) {
    this.runQueue = runQueue;
  }

  //endregion

  //region Running

  @JsonProperty(value = "running")
  private boolean running;

  public boolean isRunning() {
    return running;
  }

  public void setRunning(boolean running) {
    this.running = running;
  }

  //endregion

  //region Sasl Log File

  @JsonProperty(value = "sasl_log_file")
  private String saslLogFile;

  public String getSaslLogFile() {
    return saslLogFile;
  }

  public void setSaslLogFile(String saslLogFile) {
    this.saslLogFile = saslLogFile;
  }

  //endregion

  //region Sockets Total

  @JsonProperty(value = "sockets_total")
  private int socketsTotal;

  public int getSocketsTotal() {
    return socketsTotal;
  }

  public void setSocketsTotal(int socketsTotal) {
    this.socketsTotal = socketsTotal;
  }

  //endregion

  //region Sockets Used

  @JsonProperty(value = "sockets_used")
  private int socketsUsed;

  public int getSocketsUsed() {
    return socketsUsed;
  }

  public void setSocketsUsed(int socketsUsed) {
    this.socketsUsed = socketsUsed;
  }

  //endregion

  //region Sockets Used Details

  @JsonProperty(value = "sockets_used_details")
  private Details socketsUsedDetails;

  public Details getSocketsUsedDetails() {
    return socketsUsedDetails;
  }

  public void setSocketsUsedDetails(Details socketsUsedDetails) {
    this.socketsUsedDetails = socketsUsedDetails;
  }

  //endregion

  //region Type

  @JsonProperty(value = "type")
  private String type;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  //endregion

  //region Uptime

  @JsonProperty(value = "uptime")
  private int uptime;

  public int getUptime() {
    return uptime;
  }

  public void setUptime(int uptime) {
    this.uptime = uptime;
  }

  //endregion
}
