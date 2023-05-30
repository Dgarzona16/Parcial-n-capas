package com.code_of_duty.parcialncapas.repositories;

import com.code_of_duty.parcialncapas.entities.User;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface UserRepository extends ListCrudRepository<User, UUID> {
    @Nullable
    User findByUsername(String username);
    @Nullable
    User findByEmail(String email);

}
