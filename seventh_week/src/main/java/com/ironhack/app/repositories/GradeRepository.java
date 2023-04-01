package com.ironhack.app.repositories;
import com.ironhack.app.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface GradeRepository extends JpaRepository<Grade,Integer>{
  List<Grade> findByScoreGreaterThan(int score);
  List<Grade> findByScoreGreaterThanOrderByStudentNameAsc(int score);
  List<Grade> findBySectionIdNot(String sectionId);
}
