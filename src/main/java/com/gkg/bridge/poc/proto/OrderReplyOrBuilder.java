// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: OrderService.proto

package com.gkg.bridge.poc.proto;

public interface OrderReplyOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.gkg.bridge.poc.proto.OrderReply)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string replyId = 1;</code>
   * @return The replyId.
   */
  java.lang.String getReplyId();
  /**
   * <code>string replyId = 1;</code>
   * @return The bytes for replyId.
   */
  com.google.protobuf.ByteString
      getReplyIdBytes();

  /**
   * <code>string requestId = 2;</code>
   * @return The requestId.
   */
  java.lang.String getRequestId();
  /**
   * <code>string requestId = 2;</code>
   * @return The bytes for requestId.
   */
  com.google.protobuf.ByteString
      getRequestIdBytes();

  /**
   * <code>string order = 3;</code>
   * @return The order.
   */
  java.lang.String getOrder();
  /**
   * <code>string order = 3;</code>
   * @return The bytes for order.
   */
  com.google.protobuf.ByteString
      getOrderBytes();

  /**
   * <code>string login = 4;</code>
   * @return The login.
   */
  java.lang.String getLogin();
  /**
   * <code>string login = 4;</code>
   * @return The bytes for login.
   */
  com.google.protobuf.ByteString
      getLoginBytes();

  /**
   * <code>int32 serverId = 5;</code>
   * @return The serverId.
   */
  int getServerId();

  /**
   * <code>double requestAmount = 6;</code>
   * @return The requestAmount.
   */
  double getRequestAmount();

  /**
   * <code>double executionAmount = 7;</code>
   * @return The executionAmount.
   */
  double getExecutionAmount();

  /**
   * <code>string platformSymbol = 8;</code>
   * @return The platformSymbol.
   */
  java.lang.String getPlatformSymbol();
  /**
   * <code>string platformSymbol = 8;</code>
   * @return The bytes for platformSymbol.
   */
  com.google.protobuf.ByteString
      getPlatformSymbolBytes();

  /**
   * <code>double executionPrice = 9;</code>
   * @return The executionPrice.
   */
  double getExecutionPrice();

  /**
   * <code>.com.gkg.bridge.poc.proto.OrderReply.OrderReplyStatusType replyStatus = 10;</code>
   * @return The enum numeric value on the wire for replyStatus.
   */
  int getReplyStatusValue();
  /**
   * <code>.com.gkg.bridge.poc.proto.OrderReply.OrderReplyStatusType replyStatus = 10;</code>
   * @return The replyStatus.
   */
  com.gkg.bridge.poc.proto.OrderReply.OrderReplyStatusType getReplyStatus();

  /**
   * <code>string replyReason = 11;</code>
   * @return The replyReason.
   */
  java.lang.String getReplyReason();
  /**
   * <code>string replyReason = 11;</code>
   * @return The bytes for replyReason.
   */
  com.google.protobuf.ByteString
      getReplyReasonBytes();

  /**
   * <code>int64 executionTimeStamp = 12;</code>
   * @return The executionTimeStamp.
   */
  long getExecutionTimeStamp();
}
