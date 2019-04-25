package com.eton.roomdb.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import static android.arch.persistence.room.ForeignKey.CASCADE;

@Entity(tableName = "chat",
        foreignKeys = @ForeignKey(entity = Contact.class, parentColumns = "user_id", childColumns = "from_id", onDelete = CASCADE),
        indices = @Index(value = {"from_id"}))
public class Chat {
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "chat_id")
    private String chatId;
    @ColumnInfo(name = "uid")
    private String uid;
    @ColumnInfo(name = "users")
    private String users;
    @ColumnInfo(name = "avatar")
    private String avatar;
    @ColumnInfo(name = "title")
    private String title;
    @ColumnInfo(name = "update_time")
    private long updateTime;
    @ColumnInfo(name = "unread")
    private long unread;
    @ColumnInfo(name = "current_position")
    private long currentPosition;
    @ColumnInfo(name = "is_private")
    private boolean isPrivate;
    @ColumnInfo(name = "from_id")
    private String fromId;
    @ColumnInfo(name = "text")
    private String text;
    @ColumnInfo(name = "chat_position")
    private long chatPosition;
    @ColumnInfo(name = "msg_type")
    private int msgType;
    @ColumnInfo(name = "event")
    private String event;
    @ColumnInfo(name = "file_id")
    private String fileId;
    @ColumnInfo(name = "file_duration")
    private long fileDuration;
    @ColumnInfo(name = "is_muted")
    private boolean isMuted;
    @ColumnInfo(name = "at")
    private String at;
    @ColumnInfo(name = "at_nickname")
    private String atNickname;

    public Chat(@NonNull String chatId, String uid, String users, String avatar, String title, long updateTime, long unread, long currentPosition, boolean isPrivate, String fromId, String text, long chatPosition, int msgType, String event, String fileId, long fileDuration, boolean isMuted, String at, String atNickname) {
        this.chatId = chatId;
        this.uid = uid;
        this.users = users;
        this.avatar = avatar;
        this.title = title;
        this.updateTime = updateTime;
        this.unread = unread;
        this.currentPosition = currentPosition;
        this.isPrivate = isPrivate;
        this.fromId = fromId;
        this.text = text;
        this.chatPosition = chatPosition;
        this.msgType = msgType;
        this.event = event;
        this.fileId = fileId;
        this.fileDuration = fileDuration;
        this.isMuted = isMuted;
        this.at = at;
        this.atNickname = atNickname;
    }

    @Ignore
    public Chat(@NonNull String chatId) {
        this.chatId = chatId;
    }

    @NonNull
    public String getChatId() {
        return chatId;
    }

    public void setChatId(@NonNull String chatId) {
        this.chatId = chatId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }

    public long getUnread() {
        return unread;
    }

    public void setUnread(long unread) {
        this.unread = unread;
    }

    public long getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(long currentPosition) {
        this.currentPosition = currentPosition;
    }

    public boolean getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(boolean isPrivate) {
        this.isPrivate = isPrivate;
    }

    public String getFromId() {
        return fromId;
    }

    public void setFromId(String fromId) {
        this.fromId = fromId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getChatPosition() {
        return chatPosition;
    }

    public void setChatPosition(long chatPosition) {
        this.chatPosition = chatPosition;
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

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public long getFileDuration() {
        return fileDuration;
    }

    public void setFileDuration(long fileDuration) {
        this.fileDuration = fileDuration;
    }

    public boolean getIsMuted() {
        return isMuted;
    }

    public void setIsMuted(boolean isMuted) {
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
}
