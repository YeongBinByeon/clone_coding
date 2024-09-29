package studu.datajpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import studu.datajpa.entity.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
