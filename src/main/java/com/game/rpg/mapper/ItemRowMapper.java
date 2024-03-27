package com.game.rpg.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.game.rpg.entity.itens.Item;
import com.game.rpg.enums.Elements;
import com.game.rpg.enums.ItemType;
import com.game.rpg.enums.Rarity;

public class ItemRowMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();
        item.setId(rs.getLong("id"));
        item.setNome(rs.getString("nome"));
        item.setDescricao(rs.getString("descricao"));
        item.setElemento(rs.getString("elemento"));
        System.out.println(rs.getString("raridade"));
        item.setRaridade(rs.getString("raridade"));
        item.setTipoDePeca(rs.getString("tipo_de_peca"));
        item.setForca(rs.getDouble("forca"));
        item.setDestreza(rs.getDouble("destreza"));
        item.setInteligencia(rs.getDouble("inteligencia"));
        item.setConstituicao(rs.getDouble("constituicao"));
        item.setSorte(rs.getDouble("sorte"));

        return item;
    }
}
