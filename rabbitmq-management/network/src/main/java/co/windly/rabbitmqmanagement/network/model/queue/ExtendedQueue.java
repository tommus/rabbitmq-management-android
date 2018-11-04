package co.windly.rabbitmqmanagement.network.model.queue;

import co.windly.rabbitmqmanagement.network.model.Details;
import co.windly.rabbitmqmanagement.network.model.MessageStats;
import co.windly.rabbitmqmanagement.network.model.policy.Policy;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ExtendedQueue extends Queue {

  //region Backing Queue Status

  @JsonProperty(value = "backing_queue_status")
  private BackingQueueStatus backingQueueStatus;

  public BackingQueueStatus getBackingQueueStatus() {
    return backingQueueStatus;
  }

  public void setBackingQueueStatus(BackingQueueStatus backingQueueStatus) {
    this.backingQueueStatus = backingQueueStatus;
  }

  //endregion

  //region Consumer Utilisation

  @JsonProperty(value = "consumer_utilisation")
  private Object consumerUtilisation;

  public Object getConsumerUtilisation() {
    return consumerUtilisation;
  }

  public void setConsumerUtilisation(Object consumerUtilisation) {
    this.consumerUtilisation = consumerUtilisation;
  }

  //endregion

  //region Consumers

  @JsonProperty(value = "consumers")
  private int consumers;

  public int getConsumers() {
    return consumers;
  }

  public void setConsumers(int consumers) {
    this.consumers = consumers;
  }

  //endregion

  //region Disk Reads

  @JsonProperty(value = "disk_reads")
  private int diskReads;

  public int getDiskReads() {
    return diskReads;
  }

  public void setDiskReads(int diskReads) {
    this.diskReads = diskReads;
  }

  //endregion

  //region Disk Writes

  @JsonProperty(value = "disk_writes")
  private int diskWrites;

  public int getDiskWrites() {
    return diskWrites;
  }

  public void setDiskWrites(int diskWrites) {
    this.diskWrites = diskWrites;
  }

  //endregion

  //region Exclusive

  @JsonProperty(value = "exclusive")
  private boolean exclusive;

  public boolean isExclusive() {
    return exclusive;
  }

  public void setExclusive(boolean exclusive) {
    this.exclusive = exclusive;
  }

  //endregion

  //region Exclusive Consumer Tag

  @JsonProperty(value = "exclusive_consumer_tag")
  private Object exclusiveConsumerTag;

  public Object getExclusiveConsumerTag() {
    return exclusiveConsumerTag;
  }

  public void setExclusiveConsumerTag(Object exclusiveConsumerTag) {
    this.exclusiveConsumerTag = exclusiveConsumerTag;
  }

  //endregion

  //region Head Message Timestamp

  @JsonProperty(value = "head_message_timestamp")
  private Object headMessageTimestamp;

  public Object getHeadMessageTimestamp() {
    return headMessageTimestamp;
  }

  public void setHeadMessageTimestamp(Object headMessageTimestamp) {
    this.headMessageTimestamp = headMessageTimestamp;
  }

  //endregion

  //region Idle Since

  @JsonProperty(value = "idle_since")
  private String idleSince;

  public String getIdleSince() {
    return idleSince;
  }

  public void setIdleSince(String idleSince) {
    this.idleSince = idleSince;
  }

  //endregion

  //region Memory

  @JsonProperty(value = "memory")
  private long memory;

  public long getMemory() {
    return memory;
  }

  public void setMemory(long memory) {
    this.memory = memory;
  }

  //endregion

  //region Message Bytes

  @JsonProperty(value = "message_bytes")
  private long messageBytes;

  public long getMessageBytes() {
    return messageBytes;
  }

  public void setMessageBytes(long messageBytes) {
    this.messageBytes = messageBytes;
  }

  //endregion

  //region Message Bytes Persistent

  @JsonProperty(value = "message_bytes_persistent")
  private long messageBytesPersistent;

  public long getMessageBytesPersistent() {
    return messageBytesPersistent;
  }

  public void setMessageBytesPersistent(long messageBytesPersistent) {
    this.messageBytesPersistent = messageBytesPersistent;
  }

  //endregion

  //region Message Bytes Ram

  @JsonProperty(value = "message_bytes_ram")
  private long messageBytesRam;

  public long getMessageBytesRam() {
    return messageBytesRam;
  }

  public void setMessageBytesRam(long messageBytesRam) {
    this.messageBytesRam = messageBytesRam;
  }

  //endregion

  //region Message Bytes Ready

  @JsonProperty(value = "message_bytes_ready")
  private long messageBytesReady;

  public long getMessageBytesReady() {
    return messageBytesReady;
  }

  public void setMessageBytesReady(long messageBytesReady) {
    this.messageBytesReady = messageBytesReady;
  }

  //endregion

  //region Message Bytes Unacknowledged

  @JsonProperty(value = "message_bytes_unacknowledged")
  private long messageBytesUnacknowledged;

  public long getMessageBytesUnacknowledged() {
    return messageBytesUnacknowledged;
  }

  public void setMessageBytesUnacknowledged(long messageBytesUnacknowledged) {
    this.messageBytesUnacknowledged = messageBytesUnacknowledged;
  }

  //endregion

  //region Message Stats

  @JsonProperty(value = "message_stats")
  private MessageStats messageStats;

  public MessageStats getMessageStats() {
    return messageStats;
  }

  public void setMessageStats(MessageStats messageStats) {
    this.messageStats = messageStats;
  }

  //endregion

  //region Messages

  @JsonProperty(value = "messages")
  private int messages;

  public int getMessages() {
    return messages;
  }

  public void setMessages(int messages) {
    this.messages = messages;
  }

  //endregion

  //region Messages Details

  @JsonProperty(value = "messages_details")
  private Details messagesDetails;

  public Details getMessagesDetails() {
    return messagesDetails;
  }

  public void setMessagesDetails(Details messagesDetails) {
    this.messagesDetails = messagesDetails;
  }

  //endregion

  //region Messages Persistent

  @JsonProperty(value = "messages_persistent")
  private int messagesPersistent;

  public int getMessagesPersistent() {
    return messagesPersistent;
  }

  public void setMessagesPersistent(int messagesPersistent) {
    this.messagesPersistent = messagesPersistent;
  }

  //endregion

  //region Messages Ram

  @JsonProperty(value = "messages_ram")
  private long messagesRam;

  public long getMessagesRam() {
    return messagesRam;
  }

  public void setMessagesRam(long messagesRam) {
    this.messagesRam = messagesRam;
  }

  //endregion

  //region Messages Ready

  @JsonProperty(value = "messages_ready")
  private int messagesReady;

  public int getMessagesReady() {
    return messagesReady;
  }

  public void setMessagesReady(int messagesReady) {
    this.messagesReady = messagesReady;
  }

  //endregion

  //region Messages Ready Details

  @JsonProperty(value = "messages_ready_details")
  private Details messagesReadyDetails;

  public Details getMessagesReadyDetails() {
    return messagesReadyDetails;
  }

  public void setMessagesReadyDetails(Details messagesReadyDetails) {
    this.messagesReadyDetails = messagesReadyDetails;
  }

  //endregion

  //region Messages Ready Ram

  @JsonProperty(value = "messages_ready_ram")
  private long messagesReadyRam;

  public long getMessagesReadyRam() {
    return messagesReadyRam;
  }

  public void setMessagesReadyRam(long messagesReadyRam) {
    this.messagesReadyRam = messagesReadyRam;
  }

  //endregion

  //region Messages Unacknowledged

  @JsonProperty(value = "messages_unacknowledged")
  private int messagesUnacknowledged;

  public int getMessagesUnacknowledged() {
    return messagesUnacknowledged;
  }

  public void setMessagesUnacknowledged(int messagesUnacknowledged) {
    this.messagesUnacknowledged = messagesUnacknowledged;
  }

  //endregion

  //region Messages Unacknowledged Details

  @JsonProperty(value = "messages_unacknowledged_details")
  private Details messagesUnacknowledgedDetails;

  public Details getMessagesUnacknowledgedDetails() {
    return messagesUnacknowledgedDetails;
  }

  public void setMessagesUnacknowledgedDetails(
    Details messagesUnacknowledgedDetails) {
    this.messagesUnacknowledgedDetails = messagesUnacknowledgedDetails;
  }

  //endregion

  //region Messages Unacknowledged Ram

  @JsonProperty(value = "messages_unacknowledged_ram")
  private long messagesUnacknowledgedRam;

  public long getMessagesUnacknowledgedRam() {
    return messagesUnacknowledgedRam;
  }

  public void setMessagesUnacknowledgedRam(long messagesUnacknowledgedRam) {
    this.messagesUnacknowledgedRam = messagesUnacknowledgedRam;
  }

  //endregion

  //region Node

  @JsonProperty(value = "node")
  private String node;

  public String getNode() {
    return node;
  }

  public void setNode(String node) {
    this.node = node;
  }

  //endregion

  //region Policy

  @JsonProperty(value = "policy")
  private Policy policy;

  public Policy getPolicy() {
    return policy;
  }

  public void setPolicy(Policy policy) {
    this.policy = policy;
  }

  //endregion

  //region Recoverable Slaves

  @JsonProperty(value = "recoverable_slaves")
  private Object recoverableSlaves;

  public Object getRecoverableSlaves() {
    return recoverableSlaves;
  }

  public void setRecoverableSlaves(Object recoverableSlaves) {
    this.recoverableSlaves = recoverableSlaves;
  }

  //endregion

  //region State

  @JsonProperty(value = "state")
  private String state;

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  //endregion

  //region Vhost

  @JsonProperty(value = "vhost")
  private String vhost;

  public String getVhost() {
    return vhost;
  }

  public void setVhost(String vhost) {
    this.vhost = vhost;
  }

  //endregion
}
