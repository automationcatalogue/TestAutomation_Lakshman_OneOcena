package utilities;

import org.yaml.snakeyaml.Yaml;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.HashMap;

public class YAMLUtils {

    public static String getData_Yaml(String columnName)throws Exception{
        FileInputStream fis_yaml = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\TestConfig.yaml");
        Yaml yaml_config=new Yaml();
        HashMap<String, String> map_config=yaml_config.load(fis_yaml);
        String data=map_config.get(columnName);
        return data;
    }

    public static void setData_Yaml(String columnName, String newValue)throws Exception{
        FileInputStream fis_yaml = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\TestConfig.yaml");
        Yaml yaml_config=new Yaml();
        HashMap<String, String> map_config=yaml_config.load(fis_yaml);
        FileWriter fw_yaml = new FileWriter(System.getProperty("user.dir")+"\\src\\main\\resources\\TestConfig.yaml");
        map_config.put(columnName, newValue);
        yaml_config.dump(map_config,fw_yaml);
        fw_yaml.close();
    }

}
