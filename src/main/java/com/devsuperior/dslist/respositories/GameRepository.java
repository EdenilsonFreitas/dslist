package com.devsuperior.dslist.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

public interface GameRepository extends JpaRepository <Game, Long> {
	
	@Query(nativeQuery = true, value = """
			SELECT 
			tb_game.id,
			tb_game.title,
			tb_game.game_year AS "year",
			tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, 
			tb_belongin.position
			FROM 
			tb_game
			INNER JOIN tb_belongin ON tb_game.id = tb_belongin.game_id
			WHERE tb_belongin.list_id = :listId
			ORDER BY tb_belongin.position
				""")
	List<GameMinProjection> searchByList(Long listId);
	
	

}
