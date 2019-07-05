package com.example.naillashes.repository;

import com.example.naillashes.entity.Stylist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StylistRepository extends JpaRepository<Stylist, Long> {
}
