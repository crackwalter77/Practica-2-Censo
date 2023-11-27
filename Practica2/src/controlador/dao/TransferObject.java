package controlador.dao;

import controlador.sd.linkedlist.LinkedList;

public interface TransferObject<T> {

    public Boolean save(T data);

    public Boolean update(T data, Integer index);

    public LinkedList<T> listAll();

    public Boolean remove(Integer index);

}
