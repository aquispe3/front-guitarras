package com.example.backendicei.dao;



import com.example.backendicei.Entity.ClienteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteDao extends JpaRepository<ClienteEntity, Long> {

}