package com.example.backendicei.dao;




import com.example.backendicei.Entity.GuitarraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGuitarraDao extends JpaRepository<GuitarraEntity, Long> {

}