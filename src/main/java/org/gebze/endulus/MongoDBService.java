/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gebze.endulus;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import java.util.List;
import java.io.Serializable;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Ömer
 */

@ManagedBean
@ApplicationScoped
public class MongoDBService implements Serializable{
    private List<File> files;
    private File selectedFile;
    private DB db;
    private boolean connected=false;
     
    //@ManagedProperty("#{carService}")
    //private CarService service;
    

    public int buttonConnectDb() {
        try {
            db=connectToMongoDB("mydb",27017,"192.168.77.25","nico","nico");
            
            connected=true;
            files=new ArrayList<>();
            init();
            addMessage("Connected");
        } catch (Exception e) {
            addMessage("Connection Failed");
        }
        
        return 0;
    }
    
    public int buttonDownload() {
        try {
            connectToMongoDB("mydb",27017,"192.168.77.25","nico","nico");
            addMessage("Connected");
        } catch (Exception e) {
            addMessage("Connection Failed");
        }
        
        return 0;
    }
    public void buttonAction() {
        addMessage("button action!");
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /**
     *
     * @param dbName
     * @param port
     * @param ipAddress
     * @param userName
     * @param password
     * @return
     * @throws java.net.UnknownHostException
     */
    public DB connectToMongoDB(String dbName,int port,String ipAddress, 
                                     String userName , String password ) throws UnknownHostException {
        MongoClient client;
        DB database;

        client = new MongoClient(ipAddress, port);
        database = client.getDB(dbName);
        database.authenticate(userName, password.toCharArray());

        return database;
    }
    
     
    @PostConstruct
    public void init() {
        Set<String> collectionNameList = null;
        List<String> list = new ArrayList();
        File newFile;
        if(connected){
            collectionNameList = db.getCollectionNames();
            list.addAll(collectionNameList);
            for (String str : list) {
                newFile = new File(str);
                files.add(newFile);
            }
        }
    }
 
    public List<File> getFiles() {
        return files;
    }
 
    public File getSelectedFile() {
        return selectedFile;
    }
    
 
    public void setSelectedFile(File selectedFile) {
        this.selectedFile = selectedFile;
    }
    public void save() {
        addMessage("Success Data saved");
    }
     
    public void update() {
        addMessage("Data updated");
    }
     
    public void delete() {
        addMessage("Data deleted");
    }
    private String text1;  
    private String text2;
 
    public String getText1() {
        return text1;
    }
 
    public void setText1(String text1) {
        this.text1 = text1;
    }
 
    public String getText2() {
        return text2;
    }
 
    public void setText2(String text2) {
        this.text2 = text2;
    }
    
    
}
