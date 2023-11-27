package controlador.dao;

import com.thoughtworks.xstream.XStream;
import controlador.sd.linkedlist.LinkedList;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class DataAccessObject<T> implements TransferObject<T> {

    private XStream xstream;
    private Class<T> clazz;
    private String URL;

    public DataAccessObject(Class<T> clazz) {
        xstream = Connection.getXstream();

        this.clazz = clazz;

        URL = Connection.getURL() + this.clazz.getSimpleName() + ".json";

    }

    @Override
    public Boolean save(T data) {

        LinkedList<T> list = listAll();

        list.add(data);

        try {

            xstream.toXML(list, new FileOutputStream(URL)); //This porsiaca

        } catch (FileNotFoundException ex) {
            return false;
        }

        return true;
    }

    @Override
    public Boolean update(T data, Integer idx) {

        LinkedList<T> list = listAll();

        try {

            list.update(data, idx);

            xstream.toXML(list, new FileOutputStream(URL));

        } catch (FileNotFoundException ex) {
            return false;
        }

        return true;

    }

    @Override
    public LinkedList<T> listAll() {

        LinkedList<T> list = new LinkedList<>();

        try {

            list = (LinkedList<T>) xstream.fromXML(new FileReader(URL));

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        return list;

    }

    @Override
    public Boolean remove(Integer index) {

        LinkedList<T> list = listAll();

        try {

            list.remove(index);

            xstream.toXML(list, new FileOutputStream(URL));

        } catch (FileNotFoundException ex) {
            return false;
        }

        return true;
    }

    public Integer generated_id() {
        return listAll().getSize() + 1;
    }

    public String getURL() {
        return URL;
    }

    public XStream getXStream() {
        return xstream;
    }

}
