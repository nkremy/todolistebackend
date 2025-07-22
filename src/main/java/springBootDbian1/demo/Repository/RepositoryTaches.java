package springBootDbian1.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
    
// import springBootDbian1.demo.model.Chats;

import springBootDbian1.demo.model.Taches;

public interface RepositoryTaches extends JpaRepository<Taches, Integer>{
    @Modifying
    @Query(value="update taches set status=true where id=:id",nativeQuery=true)
    public int finirTache(@Param("id") int id); 
}
