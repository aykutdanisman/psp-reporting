package com.reporting.demo.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.reporting.demo.dto.transaction.TransactionRepResponse;
import com.reporting.demo.entity.Customer;
import com.reporting.demo.entity.Transactions;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {
	
	@Query("SELECT " +
	           "    new com.reporting.demo.dto.transaction.TransactionRepResponse(COUNT(t),sum(t.amount), t.currency) " +
	           "FROM " +
	           "    Transactions t where t.createdDate between :fromDate and :toDate " +
	           "GROUP BY " +
	           "    t.currency")
	List<TransactionRepResponse> getTransactionRepot(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);
	
	@Query("SELECT " +
	           "    t.customer " +
	           "FROM " +
	           "    Transactions t where t.refNo = :tid " )
	List<Customer> getCustomerInfo4Transaction(@Param("tid") String tid);
	
	
}
