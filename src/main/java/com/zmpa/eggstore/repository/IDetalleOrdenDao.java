package com.zmpa.eggstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zmpa.eggstore.model.DetalleOrden;

@Repository
public interface IDetalleOrdenDao extends JpaRepository<DetalleOrden, Integer> {

}
