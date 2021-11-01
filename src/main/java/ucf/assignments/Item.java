/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Gianni Angelone
 */

package ucf.assignments;

public class Item {
    private String description;
    private String dueDate;
    private boolean status;

    public Item() {
        this.description = "description";
        this.dueDate = "YYYY-MM-DD";
        this.status = false;
    }

    public void setDescription(String description) {
        if (description.length() < 1) {
            this.description = "description";
        } else if (description.length() > 256) { //Description length in Assignment 4: Part 2 is 256
            this.description = "must be less than 256 characters";
        }
        else {
            this.description = description; //Else set the current description
        }
    }
    public String getDescription() {
        return description; //Return description
    }
    public void setDueDate(String dueDate) {
        if (dueDate.matches("[0-9]{4}-[0-9]{2}-[0-9]{2}")) { //If date exists in proper format, it sets item DueDate
            if (DateParser.isDate(dueDate)) {
                this.dueDate = dueDate;
            } else {
                this.dueDate = "YYYY-MM-DD"; //Else it sets the date
            }
        }
    }
    public String getDueDate() {
        return dueDate; //Return current DueDate
    }
    public void setStatus(boolean status) {

        this.status = status; //Current item -> Given item
    }
    public boolean isStatus() {
        return status; //Return current status
    }

}
