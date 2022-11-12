package cn.acdt.hwk.day23.tools;

import lombok.Data;

/**
 * @author 孟繁兴
 */
@Data
public class Config {
    public static final Config INSTANCE = new Config();
    private String name = "";
    private String password = "";
}
