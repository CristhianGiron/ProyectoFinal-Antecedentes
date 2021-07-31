/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlAdminDatos;

import Modelo.Persona;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hp
 */
public interface Dao<T> {
    
    public abstract ArrayList<T>  findEntities(boolean all, int maxResult,int firstResult);
    
    public abstract void create(T object);

    public abstract void edit(T object);

    public abstract void destroy(Integer id);

    public abstract T find(Integer id);

    public abstract int getCount();
}
