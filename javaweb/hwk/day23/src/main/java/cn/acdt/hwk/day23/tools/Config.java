package cn.acdt.hwk.day23.tools;

/**
 * @author 孟繁兴
 */
public class Config {
    public static final Config INSTANCE = new Config();
    private String name = "";
    private String password = "";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
