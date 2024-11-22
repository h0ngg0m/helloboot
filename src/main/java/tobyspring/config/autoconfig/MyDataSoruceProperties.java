package tobyspring.config.autoconfig;

import tobyspring.config.MyConfigurationProperties;

@MyConfigurationProperties(prefix = "data")
public class MyDataSoruceProperties {
    private String dirverClassName;
    private String url;
    private String username;
    private String password;

    public String getDirverClassName() {
        return dirverClassName;
    }

    public void setDirverClassName(String dirverClassName) {
        this.dirverClassName = dirverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}
