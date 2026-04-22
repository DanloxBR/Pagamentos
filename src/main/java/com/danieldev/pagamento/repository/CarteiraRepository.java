package com.danieldev.pagamento.repository;

import com.danieldev.pagamento.entity.Carteira;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarteiraRepository extends JpaRepository<Carteira, Long> {
}
