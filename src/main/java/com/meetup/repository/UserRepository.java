package com.meetup.repository;

import com.meetup.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
}
