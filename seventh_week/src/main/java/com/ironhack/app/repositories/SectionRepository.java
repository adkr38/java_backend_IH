package com.ironhack.app.repositories;
import com.ironhack.app.models.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;


@Repository
public interface SectionRepository extends JpaRepository<Section,Integer>{
  @Query("""
  SELECT s.id, MAX(g.score) maxScore 
  FROM Section s 
  JOIN Grade g ON s.id= g.sectionId
  GROUP BY s.id
  """)
  List<Object[]>findMaxScoreBySection();
  
}
