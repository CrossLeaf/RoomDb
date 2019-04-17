package com.eton.roomdb.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import java.sql.Date;

@Entity(tableName = "group")
public class Group {
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
    private int unread;
    @ColumnInfo(name = "current_position")
    private int currentPosition;
    @ColumnInfo(name = "is_private")
    private String isPrivate;
    @ColumnInfo(name = "from_id")
    private String fromId;
    @ColumnInfo(name = "text")
    private String text;
    @ColumnInfo(name = "chat_position")
    private int chatPosition;
    @ColumnInfo(name = "msg_type")
    private int msgType;
    @ColumnInfo(name = "event")
    private String event;
    @ColumnInfo(name = "from_role")
    private int fromRole;
    @ColumnInfo(name = "from_nickname")
    private String fromNickname;
    @ColumnInfo(name = "from_avatar")
    private String fromAvatar;
    @ColumnInfo(name = "file_id")
    private String fileId;
    @ColumnInfo(name = "file_duration")
    private int fileDuration;
    @ColumnInfo(name = "is_muted")
    private String isMuted;
    @ColumnInfo(name = "at")
    private String at;
    @ColumnInfo(name = "at_nickname")
    private String atNickname;

    public Group(@NonNull String chatId, String uid, String users, String avatar, String title, long updateTime, int unread, int currentPosition, String isPrivate, String fromId, String text, int chatPosition, int msgType, String event, int fromRole, String fromNickname, String fromAvatar, String fileId, int fileDuration, String isMuted, String at, String atNickname) {
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
        this.fromRole = fromRole;
        this.fromNickname = fromNickname;
        this.fromAvatar = fromAvatar;
        this.fileId = fileId;
        this.fileDuration = fileDuration;
        this.isMuted = isMuted;
        this.at = at;
        this.atNickname = atNickname;
    }
    @Ignore
    public Group(@NonNull String chatId) {
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

    public int getUnread() {
        return unread;
    }

    public void setUnread(int unread) {
        this.unread = unread;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getIsPrivate() {
        return isPrivate;
    }

    public void setIsPrivate(String isPrivate) {
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

    public int getChatPosition() {
        return chatPosition;
    }

    public void setChatPosition(int chatPosition) {
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
}