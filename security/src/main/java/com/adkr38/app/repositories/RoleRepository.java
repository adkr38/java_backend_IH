package com.adkr38.app.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.adkr38.app.models.*;

public interface RoleRepository extends JpaRepository<User,Long> {

  
}
