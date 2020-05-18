package br.com.strawhat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.strawhat.model.Mensalidade;

@Repository
public interface MensalidadeRepository extends JpaRepository<Mensalidade, Integer> {

	@Query(value = "SELECT * FROM MENSALIDADE WHERE DATA BETWEEN :startDate AND :endDate", nativeQuery = true)
	List<Mensalidade> findBetweenDates(String startDate, String endDate);
}