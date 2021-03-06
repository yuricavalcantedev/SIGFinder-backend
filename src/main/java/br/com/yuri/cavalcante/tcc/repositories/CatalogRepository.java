package br.com.yuri.cavalcante.tcc.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.yuri.cavalcante.tcc.domain.ApplicationDomain;
import br.com.yuri.cavalcante.tcc.domain.Area;
import br.com.yuri.cavalcante.tcc.domain.Catalog;

@Repository
public interface CatalogRepository extends JpaRepository<Catalog, Integer> {

}
