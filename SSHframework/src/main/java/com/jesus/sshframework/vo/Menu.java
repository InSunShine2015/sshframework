package com.jesus.sshframework.vo;
/**
 * 菜单
 * @author sUN
 *
 */
public class Menu implements java.io.Serializable{
    
    private static final long serialVersionUID = 1674516844734077081L;
    private String name;
    private String url;

    public Menu(String name,String url) {
        super();
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
