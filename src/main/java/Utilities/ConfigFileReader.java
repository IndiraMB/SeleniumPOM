package Utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    Properties properties = new Properties();
    String configFilePath = "/resources/config.properties";
    BufferedReader bufferedReader;
    {
        try {
            bufferedReader = new BufferedReader(new FileReader(configFilePath));
            properties.load(bufferedReader);
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Configuration properties not found at specified path"+ configFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDriverPath(){
        String driverPath = properties.getProperty("driverPath");
        if (driverPath != null)
            return driverPath;
        else
            throw new RuntimeException("Driver path is not mentioned in the config properties");
    }

    public String getApplicationURL(){
        String applicationURL = properties.getProperty("applicationURL");
        if (applicationURL != null)
            return applicationURL;
        else
            throw new RuntimeException("Driver path is not mentioned in the config properties");
    }

    public String getUserName(){
        String UserName = properties.getProperty("UserName");
        if (UserName != null)
            return UserName;
        else
            throw new RuntimeException("UserName is not mentioned in the config properties");
    }

    public String getPassword(){
        String Password = properties.getProperty("Password");
        if (Password != null)
            return Password;
        else
            throw new RuntimeException("Password is not mentioned in the config properties");
    }

    public String getName(){
        String Name = properties.getProperty("Name");
        if (Name != null)
            return Name;
        else
            throw new RuntimeException("Name is not mentioned in the config properties");
    }

    public String getMobile(){
        String Mobile = properties.getProperty("Mobile");
        if (Mobile != null)
            return Mobile;
        else
            throw new RuntimeException("Mobile is not mentioned in the config properties");
    }

    public String getAddress(){
        String Address = properties.getProperty("Address");
        if (Address != null)
            return Address;
        else
            throw new RuntimeException("Address is not mentioned in the config properties");
    }
}
