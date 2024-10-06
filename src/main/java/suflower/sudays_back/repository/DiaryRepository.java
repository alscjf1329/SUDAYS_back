package suflower.sudays_back.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import suflower.sudays_back.entity.Diary;

@Repository
public interface DiaryRepository extends JpaRepository<Diary, Long> {

}
