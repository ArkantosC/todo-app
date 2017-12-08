package co.devhack.todoapp.domain.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import java.util.Date;

import co.devhack.todoapp.database.TypeTransmogrifiers;

/**
 * Created by diegocortes on 12/6/17.
 */
@Entity
public class Todo {

    @PrimaryKey(autoGenerate = true)
    private Integer id;
    private String description;
    @ColumnInfo(name = "finish_date")
    @TypeConverters({TypeTransmogrifiers.class})
    private Date finishDate;
    private boolean isFinished;
    private String image;
    private int color;

    public Todo(String description, Date finishDate, boolean isFinished, String image, int color) {
        this.description = description;
        this.finishDate = finishDate;
        this.isFinished = isFinished;
        this.image = image;
        this.color = color;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
