package pe.edu.upc.micomedor.repositories;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.upc.micomedor.entities.Users;

@Repository
public interface IUserRepository extends JpaRepository<Users, Integer> {
    public Users findByUsername(String username);
    @Query("select count(u.username) from Users u where u.username =:username")
    public int buscarUsername(@Param("username") String nombre);

    @Query(value = "SELECT COUNT(u.id_user) AS Users\n" +
            "FROM user_web u \n" +
            "INNER JOIN public.role r ON r.user_id = u.id_user \n" +
            "WHERE r.name_role = ?1",nativeQuery = true)
    public int findByNameRole( String name_role);
    @Query(value = "SELECT COUNT(u.id_user) AS Users \n" +
            "FROM user_web u \n" +
            "INNER JOIN city ci ON u.city_id = ci.id_city \n" +
            "INNER JOIN country co ON ci.country_id = co.id_country \n" +
            "WHERE co.name_country = ?1 ",nativeQuery = true)
    public int findByNameCountry( String name_country);

    @Query(value = "SELECT id_user \n" +
            "FROM user_web \n" +
            "ORDER BY id_user DESC \n" +
            "LIMIT 1 \n", nativeQuery = true)
    public int findLastUserRegister();

    @Transactional
    @Modifying
    @Query(value = "insert into roles (rol, user_id) VALUES (:rol, :user_id)", nativeQuery = true)
    public void insRol(@Param("rol") String authority, @Param("user_id") Long user_id);


}
