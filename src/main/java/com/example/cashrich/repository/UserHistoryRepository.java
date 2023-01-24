package com.example.cashrich.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cashrich.entity.UserHistory;

public interface UserHistoryRepository extends JpaRepository<UserHistory, Integer> {

}
