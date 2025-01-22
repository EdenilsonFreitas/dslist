package com.devsuperior.dslist.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_belongin")
public class Belonging {
	
	@EmbeddedId
	private BelonginPK id = new BelonginPK();
	
	private Integer position;
	
	public Belonging() {
	}

	public Belonging(Game game, GameList list, Integer position) {
		this.id.setGame(game);
		this.position = position;
	}
	
	
	

}
