package csu.web.mypetstore.domain;

import java.io.Serializable;

public class Journal  implements Serializable {
    String username;
    String action;
    String url;
    String time;

    public Journal(){}

    public Journal(String username, String action, String url,String time) {
        this.username = username;
        this.action = action;
        this.url = url;
        this.time=time;
    }
    public String getTime() {
        return time;
    }

    public void setTime(String time){
        this.time=time;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
