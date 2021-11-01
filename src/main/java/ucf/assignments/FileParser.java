/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Gianni Angelone
 */

package ucf.assignments;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileParser {
    private String filePath;
    private String fileName;
    private void createFile(File file) {
        //Updating filepath if created
        try {
            if (file.createNewFile()) {
                this.filePath = file.getPath();
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    private void writeToFile(String data) {
        try {
            FileWriter writeToFile = new FileWriter(getFilePath()); //Creating a file writer
            writeToFile.write(data); //Write data to file
            writeToFile.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    private ToDoList jsonToJava() {
        //ToDoList
        ToDoList savedList = new ToDoList();
        Gson gson = new Gson();
        try {
            Reader reader = Files.newBufferedReader(Paths.get(getFilePath())); //Creating a file reader
            savedList = gson.fromJson(reader, ToDoList.class); //Reading the file
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return savedList; //return json object
    }

    private String javaToJson(ToDoList list) {
        GsonBuilder builder = new GsonBuilder(); //Gson builder
        Gson gson = builder.create(); //Build and return syntax
        return gson.toJson(list);
    }
    private boolean isFile(File file) {
        return file.exists(); //Check if the file exists
    }
    public void setFilePath(String filePath) {
        this.filePath = filePath; //Set variable to filepath
    }
    public String getFilePath() {
        return filePath;
    }
    public void setFileName(String title) {
        this.fileName = title; //Set variable to filename
    }
    public void saveToDoList(ToDoList list, File file) {
        String jsonList = javaToJson(list); //Convert list to Json
        setFileName(file.getName()); //Check if file exists
        if (isFile(file)) {
            setFilePath(file.getPath());
        } else {
            createFile(file); //Creates file if it does not previously exist
        }
        writeToFile(jsonList); //Json object to file
    }
    public ToDoList loadToDoList(File file) {
        setFileName(file.getName()); //Setting the file name
        setFilePath(file.getPath()); //Setting the path
        return jsonToJava(); //Return the list
    }

}
