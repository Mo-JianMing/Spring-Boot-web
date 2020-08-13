package com.mj.dao;

import com.mj.entity.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EmpDao {
    List<Emp> select(String id);
    void delete(String name);
    Emp alter(String name);
    void upData(Emp emp,String jn);
    void toSave(Emp emp);
}
