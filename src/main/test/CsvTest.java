package main.test;

import main.entity.Student;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/***
 *@author : Ray
 *@date :  2020/12/9 20:26
 *description: csv read and write test
 ***/
public class CsvTest {
    private static final String INPUT_PATH = "C:\\Users\\Administrator\\Desktop\\data.csv";
    private static final String OUTPUT_PATH = "C:\\Users\\Administrator\\Desktop\\out.csv";
    private static final String DELIMITER = ",";
    private static final String ENTER = "\n";

    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(CsvTest.class);


    private List<Student> readCsv() {
        List<Student> data = new ArrayList<>();
        try {
            // get file from C://
            File file = new File(INPUT_PATH);
            // data list
            data = new ArrayList<>();
            // new Reader
            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(new FileReader(file));
            // head
            bufferedReader.readLine();
            // lines
            String line ;
            // read
            while ((line = bufferedReader.readLine())!= null) {
                String [] studentString = line.split(",");
                Student s = new Student();
                s.setId(Integer.parseInt(studentString[0]) );
                s.setName(studentString[1]);
                s.setNum(Double.parseDouble(studentString[2]));
                data.add(s);
            }
            // save or print
//            data.forEach(student -> System.out.println(student.toString()));
            return data;
        } catch (FileNotFoundException e) {
            LOG.error("file not found!" + new Date().toString());
            return data;
        } catch (IOException e) {
            LOG.error("file data not format!" + new Date().toString());
            return data;
        }
    }

    @Test
    public void writeCsv() {
        // read
        List<Student> list = this.readCsv();
        FileOutputStream fileOutputStream;
        OutputStreamWriter outputStreamWriter;
        final BufferedWriter writer;
        // not null
        if (!CollectionUtils.isEmpty(list)) {
            try {
                fileOutputStream = new FileOutputStream(new File(OUTPUT_PATH));
                outputStreamWriter = new OutputStreamWriter(fileOutputStream);
                writer = new BufferedWriter(outputStreamWriter);
                // header
                try {
                    writer.write("id" + DELIMITER);
                    writer.write("name" + DELIMITER);
                    writer.write("number" + ENTER);
                    for (Student student : list) {
                        writer.write(student.getId() + DELIMITER);
                        writer.write(student.getName() + DELIMITER);
                        writer.write(student.getNum() + ENTER);
                    }
                    writer.flush();
                    writer.close();
                    LOG.info("write rows:"+list.size());
                    list.forEach(System.out::println);
                } catch (IOException e) {
                    LOG.error(e.getMessage());
                }
            } catch (FileNotFoundException e) {
                LOG.error("file not found!");
            }
        }
    }

}
