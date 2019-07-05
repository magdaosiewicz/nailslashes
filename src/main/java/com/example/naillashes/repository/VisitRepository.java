package com.example.naillashes.repository;

import com.example.naillashes.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitRepository extends JpaRepository<Order, Long> {
}
