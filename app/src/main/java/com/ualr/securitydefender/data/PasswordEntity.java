package com.ualr.securitydefender.data;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity(tableName = "password")
public class PasswordEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private int id;

    @ColumnInfo(name = "username")
    private String username = "";

    @ColumnInfo(name = "password")
    private String password = "";

    @ColumnInfo(name = "website")
    private String website = "";

    @Ignore
    private String websiteIconLetter = null;

    public PasswordEntity() {

    }

    @Ignore
    public PasswordEntity(String username, String password, String website) {
        this.username = username;
        this.password = password;
        this.website = website;
        websiteIconConverter(website);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
        websiteIconConverter(website);
    }

    public String getWebsiteIconLetter() { return this.websiteIconLetter; }

    public void setWebsiteIconLetter(String bm) {
        this.websiteIconLetter = bm;
    }

    @Ignore
    private void websiteIconConverter(String website) {
        final String regex = "(?<=\\.)(\\w)|(?<=\\/)(\\w)";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(website);
        String matched = "";
        while (matcher.find()) {
            matched += matcher.group(0);
        }
        this.websiteIconLetter = Character.toString(matched.charAt(0));
    }


}
