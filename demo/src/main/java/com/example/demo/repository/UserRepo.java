package com.example.demo.repository;


import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(value = "select b.name from User u inner join u.invoice iv" +
            " inner join iv.invoiceBook ib  " +
            " join ib.book b  where(u.id =:id)" +
            " group by (b.name)"
           )
    List<Integer> findBookName(@Param("id") int id);
    @Query(value = "select  r.name from User u join u.roles r")
    List<String> findRoleName();

}
