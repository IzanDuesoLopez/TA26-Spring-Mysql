package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.dto.Asignado_a;
import com.example.demo.dto.Cientifico;
import com.example.demo.dto.Proyecto;

public interface IAsignado_aDAO extends JpaRepository<Asignado_a, Integer>{

}
