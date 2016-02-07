package com.meetup.service;

import com.meetup.domain.User;

/**
 * The interface User service.
 */
public interface UserService {
    /**
     * Gets all.
     *
     * @return the all
     */
    Iterable<User> getAll();

    /**
     * Save user.
     *
     * @param user the user
     * @return the user
     */
    User save(User user);

    /**
     * Find one user.
     *
     * @param id the id
     * @return the user
     */
    User findOne(Long id);
}
