package hello;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

  List<User> findByName(String name);

  @Query("select u from User u where u.id = ?1 and u.name = ?2 and email = ?3")
  List<User> findByNameAndEmailAndId(Integer id, String name, String email);

  @Modifying
  @Query("update User u set u.name = ?1 where u.id = ?2")
  Integer setUserNameById(String name, Integer id);

  @Query(value = "select u from User u where u.name = :name AND u.email=:email AND u.id=:id")
  List<User> findByMultiParam(@Param("name") String name, @Param("email") String email,
                              @Param("id") Integer id);
}