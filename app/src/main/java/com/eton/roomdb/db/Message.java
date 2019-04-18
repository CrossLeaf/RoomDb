package com.eton.roomdb.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "message")
public class Message {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "message_id")
    private String messageId;
    @ColumnInfo(name = "user_id")
    private String uid;
    @ColumnInfo(name = "chat_id")
    private String chatId;
    @ColumnInfo(name = "time")
    private long time;
    @ColumnInfo(name = "from_user")
    private String fromUser;
    @ColumnInfo(name = "text")
    private String text;
    @ColumnInfo(name = "chat_p")
    private int chatP;
    @ColumnInfo(name = "msg_type")
    private int msgType;
    @ColumnInfo(name = "event")
    private String event;
    @ColumnInfo(name = "from_role")
    private int fromRole;
    @ColumnInfo(name = "from_nick_name")
    private String fromNickname;
    @ColumnInfo(name = "from_avatar")
    private String fromAvatar;
    @ColumnInfo(name = "file_id")
    private String fileId;
    @ColumnInfo(name = "image_local_url")
    private String imageLocalUrl;
    @ColumnInfo(name = "voice_local_url")
    private String voiceLocalUrl;
    @ColumnInfo(name = "file_duration")
    private int fileDuration;
    @ColumnInfo(name = "is_muted")
    private String isMuted;
    @ColumnInfo(name = "at")
    private String at;
    @ColumnInfo(name = "at_nick_name")
    private String atNickname;
    @ColumnInfo(name = "send_state")
    private int sendState;
    @ColumnInfo(name = "item_type")
    private int itemType;
    @ColumnInfo(name = "og_object")
    private String ogObject;

    public Message(@NonNull String messageId, String uid, String chatId, long time, String fromUser,
                   String text, int chatP, int msgType, String event, int fromRole, String fromNickname,
                   String fromAvatar, String fileId, String imageLocalUrl, String voiceLocalUrl,
                   int fileDuration, String isMuted, String at, String atNickname, int sendState,
                   int itemType, String ogObject) {
        this.messageId = messageId;
        this.uid = uid;
        this.chatId = chatId;
        this.time = time;
        this.fromUser = fromUser;
        this.text = text;
        this.chatP = chatP;
        this.msgType = msgType;
        this.event = event;
        this.fromRole = fromRole;
        this.fromNickname = fromNickname;
        this.fromAvatar = fromAvatar;
        this.fileId = fileId;
        this.imageLocalUrl = imageLocalUrl;
        this.voiceLocalUrl = voiceLocalUrl;
        this.fileDuration = fileDuration;
        this.isMuted = isMuted;
        this.at = at;
        this.atNickname = atNickname;
        this.sendState = sendState;
        this.itemType = itemType;
        this.ogObject = ogObject;
    }

    @Ignore
    public Message(@NonNull String messageId) {
        this.messageId = messageId;
    }

    @NonNull
    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(@NonNull String messageId) {
        this.messageId = messageId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getFromUser() {
        return fromUser;
    }

    public void setFromUser(String fromUser) {
        this.fromUser = fromUser;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getChatP() {
        return chatP;
    }

    public void setChatP(int chatP) {
        this.chatP = chatP;
    }

    public int getMsgType() {
        return msgType;
    }

    public void setMsgType(int msgType) {
        this.msgType = msgType;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    public int getFromRole() {
        return fromRole;
    }

    public void setFromRole(int fromRole) {
        this.fromRole = fromRole;
    }

    public String getFromNickname() {
        return fromNickname;
    }

    public void setFromNickname(String fromNickname) {
        this.fromNickname = fromNickname;
    }

    public String getFromAvatar() {
        return fromAvatar;
    }

    public void setFromAvatar(String fromAvatar) {
        this.fromAvatar = fromAvatar;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getImageLocalUrl() {
        return imageLocalUrl;
    }

    public void setImageLocalUrl(String imageLocalUrl) {
        this.imageLocalUrl = imageLocalUrl;
    }

    public String getVoiceLocalUrl() {
        return voiceLocalUrl;
    }

    public void setVoiceLocalUrl(String voiceLocalUrl) {
        this.voiceLocalUrl = voiceLocalUrl;
    }

    public int getFileDuration() {
        return fileDuration;
    }

    public void setFileDuration(int fileDuration) {
        this.fileDuration = fileDuration;
    }

    public String getIsMuted() {
        return isMuted;
    }

    public void setIsMuted(String isMuted) {
        this.isMuted = isMuted;
    }

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public String getAtNickname() {
        return atNickname;
    }

    public void setAtNickname(String atNickname) {
        this.atNickname = atNickname;
    }

    public int getSendState() {
        return sendState;
    }

    public void setSendState(int sendState) {
        this.sendState = sendState;
    }

    public int getItemType() {
        return itemType;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public String getOgObject() {
        return ogObject;
    }

    public void setOgObject(String ogObject) {
        this.ogObject = ogObject;
    }
}
