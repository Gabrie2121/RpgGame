package com.game.rpg.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.game.rpg.entity.itens.Item;
import com.game.rpg.enums.ItemType;
import com.game.rpg.enums.Rarity;
import com.game.rpg.enums.Reforja;

public class ItemRowMapper implements RowMapper<Item> {

    @Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
        Item item = new Item();
        item.setId(rs.getInt("id"));
        item.setNome(rs.getString("nome"));
        item.setDescricao(rs.getString("descricao"));
        item.setElemento(rs.getString("elemento"));
        item.setReforja(Reforja.valueOf(rs.getString("reforja")));
        item.setRaridade(Rarity.valueOf(rs.getString("raridade")));
        item.setTipoDePeca(ItemType.valueOf(rs.getString("tipo_de_peca")));
        item.setDanoFisico(rs.getInt("dano_fisico"));
        item.setDanoMagico(rs.getInt("dano_magico"));
        item.setDefesaFisica(rs.getInt("defesa_fisica"));
        item.setDefesaMagica(rs.getInt("defesa_magica"));

        return item;
    }
}
