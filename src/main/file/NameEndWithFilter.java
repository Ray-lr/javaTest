package main.file;


import java.io.File;
import java.io.FilenameFilter;
/***
 *@author : Ray
 *@date :  2020/6/29 0:27
 * description: filter test for file
 ***/
public class NameEndWithFilter implements FilenameFilter {

    private String endWith;

    public NameEndWithFilter(String endWith) {
        this.endWith = endWith;
    }

    public String getEndWith() {
        return endWith;
    }

    public void setEndWith(String endWith) {
        this.endWith = endWith;
    }

    @Override
    public boolean accept(File dir, String name) {
        return name.endsWith(this.endWith);
    }
}
