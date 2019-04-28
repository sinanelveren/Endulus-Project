/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gebze.endulus;

import java.util.UUID;

/**
 *
 * @author Omer
 */
public class File {
    
    public String id;
    public String fileName;
    public String uploaDate;
    public String table;
    public String fileType;
    public int recordedUserId;

    public String getFileName() {
        return fileName;
    }

    public String getUploaDate() {
        return uploaDate;
    }

    public String getTable() {
        return table;
    }

    public String getFileType() {
        return fileType;
    }

    public int getRecordedUserId() {
        return recordedUserId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setUploaDate(String uploaDate) {
        this.uploaDate = uploaDate;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setRecordedUserId(int recordedUserId) {
        this.recordedUserId = recordedUserId;
    }
    
    public File(){
        
    }
    
    
    public File(String fileName,  String uploaDate,String table,String fileType,int recordedUserId) {
        this.id = getRandomId();
        this.fileName = fileName;
        this.uploaDate = uploaDate;
        this.table = table;
        this.fileType = fileType;
        this.recordedUserId = recordedUserId;
    }
    public File( String fileName ) {
        this.id = getRandomId();
        this.fileName = fileName;
    }
    
    private String getRandomId() {
        return UUID.randomUUID().toString().substring(0, 8);
    }
    public String getId(){
        return id;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.id != null ? this.id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final File other = (File) obj;
        if ((this.id == null) ? (other.id != null) : !this.id.equals(other.id)) {
            return false;
        }
        return true;
    }
    
    
}
