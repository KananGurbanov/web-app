package az.edu.turinghackaton.dao.repository;

import az.edu.turinghackaton.dao.entity.PostEntity;
import az.edu.turinghackaton.model.enums.Title;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
    List<PostEntity> findByTitle(Title title);
}
