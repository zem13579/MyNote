package com.zem.designpattern.book.repo;

import com.zem.designpattern.book.pojo.ProductItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductItemRepository extends JpaRepository<ProductItem, Integer> {
    @Modifying
    @Query(value = "insert into product_item (id,name,pid) " +
            "values ((select max(id)+1 from product_item) , ?1,?2 )", nativeQuery = true)
    public void addItem(String name, int pid);

    @Modifying
    @Query(value = "delete from product_item where id = ?1 or pid = ?2 ", nativeQuery = true)
    public void delItem(int id,int pid);

    ProductItem findProductItemByNameAndPid(String name, int pid);
}
