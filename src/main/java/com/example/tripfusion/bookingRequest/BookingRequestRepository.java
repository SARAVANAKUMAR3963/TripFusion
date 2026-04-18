package com.example.tripfusion.bookingRequest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;

public interface BookingRequestRepository extends JpaRepository<BookingRequest, Long>{

	@Query("SELECT b FROM BookingRequest b WHERE b.bus.id = :busId AND b.status = 'CONFIRMED' AND b.fromDate <= :toDate AND b.toDate >= :fromDate")
	List<BookingRequest> findConfirmedBookingsForBusBetween(@Param("busId") Long busId, @Param("fromDate") LocalDateTime fromDate, @Param("toDate") LocalDateTime toDate);


}
